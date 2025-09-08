package pantallas;

import implementaciones.BolsaImp;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BolsaFrame extends JPanel {
    private BolsaImp bolsa;
    private JTextField txtValor, txtTamano;
    private JTextArea areaResultados;

    private JButton btnAgregar, btnRemoverAzar, btnRemoverValor,
                    btnContar, btnMostrar, btnLimpiar, btnCrear;

    private static final Color COLOR_FONDO = new Color(245, 245, 245);
    private static final Color COLOR_PRIMARIO = new Color(70, 130, 180);
    private static final Color COLOR_PRIMARIO_HOVER = new Color(100, 149, 237);
    private static final Color COLOR_SECUNDARIO = new Color(108, 117, 125);
    private static final Color COLOR_SECUNDARIO_HOVER = new Color(134, 142, 150);
    private static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 22);
    private static final Font FUENTE_ETIQUETA = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 12);
    private static final Font FUENTE_TEXTO = new Font("Segoe UI", Font.PLAIN, 14);

    public BolsaFrame(MainFrame frame) {
        setLayout(new BorderLayout(20, 10));
        setBackground(COLOR_FONDO);
        setBorder(new EmptyBorder(20, 30, 20, 30));

        JLabel lblTitulo = new JLabel("Gestión de Bolsa", SwingConstants.CENTER);
        lblTitulo.setFont(FUENTE_TITULO);
        lblTitulo.setBorder(new EmptyBorder(0, 0, 20, 0));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel panelAcciones = new JPanel();
        panelAcciones.setLayout(new BoxLayout(panelAcciones, BoxLayout.Y_AXIS));
        panelAcciones.setBackground(COLOR_FONDO);

        JPanel panelCreacion = crearPanelSeccion("1. Configuración de la Bolsa");
        panelCreacion.setLayout(new GridLayout(2, 2, 10, 10));
        panelCreacion.add(new JLabel("Tamaño:"));
        txtTamano = new JTextField();
        txtTamano.setFont(FUENTE_TEXTO);
        panelCreacion.add(txtTamano);
        panelCreacion.add(new JLabel());
        btnCrear = crearBotonPrimario("Crear Bolsa");
        panelCreacion.add(btnCrear);
        
        JPanel panelOperaciones = crearPanelSeccion("2. Operaciones");
        panelOperaciones.setLayout(new GridLayout(4, 2, 10, 10));
        panelOperaciones.add(new JLabel("Valor:"));
        txtValor = new JTextField();
        txtValor.setFont(FUENTE_TEXTO);
        panelOperaciones.add(txtValor);

        btnAgregar = crearBotonPrimario("Agregar");
        btnRemoverValor = crearBotonPrimario("Remover por Valor");
        btnContar = crearBotonPrimario("Contar Valor");
        btnRemoverAzar = crearBotonPrimario("Remover al Azar");
        btnMostrar = crearBotonPrimario("Mostrar Bolsa");
        btnLimpiar = crearBotonPrimario("Limpiar Bolsa");

        panelOperaciones.add(btnAgregar);
        panelOperaciones.add(btnRemoverValor);
        panelOperaciones.add(btnContar);
        panelOperaciones.add(btnRemoverAzar);
        panelOperaciones.add(btnMostrar);
        panelOperaciones.add(btnLimpiar);

        panelAcciones.add(panelCreacion);
        panelAcciones.add(Box.createRigidArea(new Dimension(0, 20)));
        panelAcciones.add(panelOperaciones);
        panelAcciones.add(Box.createVerticalGlue());

        add(panelAcciones, BorderLayout.WEST);

        areaResultados = new JTextArea();
        areaResultados.setFont(FUENTE_TEXTO);
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Consola de Resultados");
        titledBorder.setTitleFont(FUENTE_ETIQUETA);
        scroll.setBorder(titledBorder);
        add(scroll, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(COLOR_FONDO);
        bottomPanel.setBorder(new EmptyBorder(10, 0, 0, 0));
        JButton btnRegresar = crearBotonSecundario("Regresar al Menú");
        bottomPanel.add(btnRegresar, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
        
        habilitarAcciones(false);

        btnCrear.addActionListener(e -> crearBolsa());
        btnAgregar.addActionListener(e -> agregarValor());
        btnRemoverAzar.addActionListener(e -> removerAlAzar());
        btnRemoverValor.addActionListener(e -> removerPorValor());
        btnContar.addActionListener(e -> contarValor());
        btnMostrar.addActionListener(e -> mostrar(bolsa.toString()));
        btnLimpiar.addActionListener(e -> {
            bolsa.limpia();
            mostrar("Bolsa vaciada.");
        });
        btnRegresar.addActionListener(e -> {
            limpiarInterfaz();
            frame.mostrarMenu();
        });
    }

    private void crearBolsa() {
        try {
            int tam = Integer.parseInt(txtTamano.getText());
            bolsa = new BolsaImp(tam);
            mostrar("Bolsa creada con tamaño " + tam);
            habilitarAcciones(true);
            btnCrear.setEnabled(false);
            txtTamano.setEditable(false);
        } catch (NumberFormatException ex) {
            mostrar("Error: El tamaño debe ser un número entero.");
        } catch (Exception ex) {
            mostrar("Error: " + ex.getMessage());
        }
    }
    
    private void agregarValor() {
        try {
            bolsa.agrega(Integer.parseInt(txtValor.getText()));
            mostrar("Valor '" + txtValor.getText() + "' agregado correctamente.");
            txtValor.setText("");
        } catch (NumberFormatException ex) {
            mostrar("Error: El valor a agregar debe ser un número.");
        } catch (Exception ex) {
            mostrar("Error: " + ex.getMessage());
        }
    }
    
    private void removerAlAzar() {
        try {
            mostrar("Removido al azar: " + bolsa.remueve());
        } catch (Exception ex) {
            mostrar("Error: " + ex.getMessage());
        }
    }
    
    private void removerPorValor() {
        try {
            int valor = Integer.parseInt(txtValor.getText());
            Integer eliminado = bolsa.remueve(valor);
            mostrar("Elemento '" + eliminado + "' removido.");
        } catch (NumberFormatException ex) {
            mostrar("Error: El valor a remover debe ser un número.");
        } catch (Exception ex) {
            mostrar("Error: " + ex.getMessage());
        }
    }

    private void contarValor() {
        try {
            int valor = Integer.parseInt(txtValor.getText());
            int c = bolsa.cuenta(valor);
            mostrar("El valor '" + valor + "' aparece " + c + " veces.");
        } catch (NumberFormatException ex) {
            mostrar("Error: El valor a contar debe ser un número.");
        } catch (Exception ex) {
            mostrar("Error: " + ex.getMessage());
        }
    }

    private void limpiarInterfaz() {
        habilitarAcciones(false);
        btnCrear.setEnabled(true);
        txtTamano.setEditable(true);
        txtTamano.setText("");
        txtValor.setText("");
        areaResultados.setText("");
        bolsa = null;
    }

    private void mostrar(String mensaje) {
        areaResultados.append(">> " + mensaje + "\n");
    }

    private void habilitarAcciones(boolean habilitado) {
        btnAgregar.setEnabled(habilitado);
        btnRemoverAzar.setEnabled(habilitado);
        btnRemoverValor.setEnabled(habilitado);
        btnContar.setEnabled(habilitado);
        btnMostrar.setEnabled(habilitado);
        btnLimpiar.setEnabled(habilitado);
        txtValor.setEnabled(habilitado);
    }
    
    private JPanel crearPanelSeccion(String titulo) {
        JPanel panel = new JPanel();
        panel.setBackground(COLOR_FONDO);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(titulo);
        titledBorder.setTitleFont(FUENTE_ETIQUETA);
        panel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 5, 5, 5), titledBorder));
        return panel;
    }

    private JButton crearBotonPrimario(String texto) {
        return crearBotonBase(texto, COLOR_PRIMARIO, COLOR_PRIMARIO_HOVER);
    }

    private JButton crearBotonSecundario(String texto) {
        return crearBotonBase(texto, COLOR_SECUNDARIO, COLOR_SECUNDARIO_HOVER);
    }
    
    private JButton crearBotonBase(String texto, Color bg, Color bgHover) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTON);
        boton.setBackground(bg);
        boton.setForeground(Color.BLACK);
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(10, 15, 10, 15));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) { boton.setBackground(bgHover); }
            @Override
            public void mouseExited(MouseEvent e) { boton.setBackground(bg); }
        });
        return boton;
    }
}