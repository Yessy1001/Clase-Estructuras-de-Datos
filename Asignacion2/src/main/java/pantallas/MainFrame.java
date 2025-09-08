package pantallas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;

    
    private static final Color COLOR_FONDO = new Color(245, 245, 245);
    private static final Color COLOR_BOTON = new Color(70, 130, 180);
    private static final Color COLOR_BOTON_HOVER = new Color(100, 149, 237);
    private static final Color COLOR_TEXTO = Color.BLACK;
    private static final Font FUENTE_TITULO = new Font("Segoe UI", Font.BOLD, 24);
    private static final Font FUENTE_BOTON = new Font("Segoe UI", Font.BOLD, 14);

    public MainFrame() {
        setTitle("Gestión de Cilindro y Bolsa");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(600, 400));

        // CardLayout para manejar pantallas
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(COLOR_FONDO);

        JPanel menuPanel = new JPanel(new BorderLayout(20, 20));
        menuPanel.setBorder(new EmptyBorder(30, 50, 30, 50));
        menuPanel.setBackground(COLOR_FONDO);

        JLabel lblTitulo = new JLabel("Menú Principal", SwingConstants.CENTER);
        lblTitulo.setFont(FUENTE_TITULO);
        lblTitulo.setForeground(new Color(50, 50, 50));
        menuPanel.add(lblTitulo, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(COLOR_FONDO);

        JButton btnCilindro = crearBotonEstilizado("Gestión de Cilindro");
        JButton btnBolsa = crearBotonEstilizado("Gestión de Bolsa");
        JButton btnSalir = crearBotonEstilizado("Salir");

        panelBotones.add(btnCilindro);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 15)));
        panelBotones.add(btnBolsa);
        panelBotones.add(Box.createRigidArea(new Dimension(0, 40)));
        panelBotones.add(btnSalir);
        
        JPanel contenedorCentral = new JPanel(new GridBagLayout());
        contenedorCentral.setBackground(COLOR_FONDO);
        contenedorCentral.add(panelBotones);
        menuPanel.add(contenedorCentral, BorderLayout.CENTER);


        btnCilindro.addActionListener(e -> cardLayout.show(mainPanel, "cilindro"));
        btnBolsa.addActionListener(e -> cardLayout.show(mainPanel, "bolsa"));
        btnSalir.addActionListener(e -> System.exit(0));

        CilindroFrame cilindroPanel = new CilindroFrame(this);
        BolsaFrame bolsaPanel = new BolsaFrame(this);

        mainPanel.add(menuPanel, "menu");
        mainPanel.add(cilindroPanel, "cilindro");
        mainPanel.add(bolsaPanel, "bolsa");

        add(mainPanel);
        cardLayout.show(mainPanel, "menu");

        setVisible(true);
    }

    private JButton crearBotonEstilizado(String texto) {
        JButton boton = new JButton(texto);
        boton.setFont(FUENTE_BOTON);
        boton.setBackground(COLOR_BOTON);
        boton.setForeground(COLOR_TEXTO);
        boton.setFocusPainted(false);
        boton.setBorder(new EmptyBorder(15, 30, 15, 30));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                boton.setBackground(COLOR_BOTON_HOVER);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                boton.setBackground(COLOR_BOTON);
            }
        });

        return boton;
    }

    public void mostrarMenu() {
        cardLayout.show(mainPanel, "menu");
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(MainFrame::new);
    }
}