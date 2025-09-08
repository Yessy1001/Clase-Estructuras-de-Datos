package pantallas;

import implementaciones.CilindroImp;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CilindroFrame extends JPanel {
    private JTextField txtRadio, txtAltura;
    private JTextArea areaResultados;

    private static final Color COLOR_FONDO = new Color(245, 245, 245);
    private static final Color COLOR_PRIMARIO = new Color(70, 130, 180);
    private static final Color COLOR_PRIMARIO_HOVER = new Color(100, 149, 237);
    private static final Color COLOR_SECUNDARIO = new Color(108, 117, 125);
    private static final Color COLOR_SECUNDARIO_HOVER = new Color(134, 142, 150);
    private static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 22);
    private static final Font FUENTE_ETIQUETA = new Font("Segoe UI", Font.BOLD, 14);
    private static final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 12);
    private static final Font FUENTE_TEXTO = new Font("Segoe UI", Font.PLAIN, 14);

    public CilindroFrame(MainFrame frame) {
        setLayout(new BorderLayout(10, 10));
        setBackground(COLOR_FONDO);
        setBorder(new EmptyBorder(20, 30, 20, 30));

        JLabel lblTitulo = new JLabel("Cálculo de Cilindro", SwingConstants.CENTER);
        lblTitulo.setFont(FUENTE_TITULO);
        lblTitulo.setBorder(new EmptyBorder(0, 0, 20, 0));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel(new GridBagLayout());
        contentPanel.setBackground(COLOR_FONDO);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblRadio = new JLabel("Radio:");
        lblRadio.setFont(FUENTE_ETIQUETA);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(lblRadio, gbc);

        txtRadio = new JTextField(15);
        txtRadio.setFont(FUENTE_TEXTO);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        contentPanel.add(txtRadio, gbc);

        JLabel lblAltura = new JLabel("Altura:");
        lblAltura.setFont(FUENTE_ETIQUETA);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        contentPanel.add(lblAltura, gbc);
        
        txtAltura = new JTextField(15);
        txtAltura.setFont(FUENTE_TEXTO);
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPanel.add(txtAltura, gbc);

        areaResultados = new JTextArea(8, 30);
        areaResultados.setFont(FUENTE_TEXTO);
        areaResultados.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultados);
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Resultados");
        titledBorder.setTitleFont(FUENTE_ETIQUETA);
        scroll.setBorder(titledBorder);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1.0;
        gbc.insets = new Insets(15, 5, 5, 5);
        contentPanel.add(scroll, gbc);

        add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new BorderLayout(10,10));
        buttonPanel.setBackground(COLOR_FONDO);

        JButton btnRegresar = crearBotonSecundario("Regresar");
        buttonPanel.add(btnRegresar, BorderLayout.WEST);

        JPanel panelAcciones = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        panelAcciones.setBackground(COLOR_FONDO);
        JButton btnArea = crearBotonPrimario("Calcular Área");
        JButton btnVolumen = crearBotonPrimario("Calcular Volumen");
        panelAcciones.add(btnArea);
        panelAcciones.add(btnVolumen);

        buttonPanel.add(panelAcciones, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);

        btnArea.addActionListener(e -> calcular("area"));
        btnVolumen.addActionListener(e -> calcular("volumen"));
        btnRegresar.addActionListener(e -> frame.mostrarMenu());
    }

    private void calcular(String tipo) {
        try {
            if (txtRadio.getText().trim().isEmpty() || txtAltura.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese valores para el radio y la altura.", "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
                return;
            }
            double radio = Double.parseDouble(txtRadio.getText());
            double altura = Double.parseDouble(txtAltura.getText());
            CilindroImp c = new CilindroImp(radio, altura);
            
            String resultado = String.format(tipo.equals("area") ? "Área: %.4f" : "Volumen: %.4f", tipo.equals("area") ? c.area() : c.volumen());
            areaResultados.append(resultado + "\n");

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Ingrese solo números válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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
        boton.setBorder(new EmptyBorder(10, 20, 10, 20));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(bgHover);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(bg);
            }
        });
        return boton;
    }
}
