package App.UserAstronauta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AstronautaView {
    private JFrame frame;
    private JButton botoEnviar, botoEnviarMissatge, botoCerrarSesion;
    private JButton fitxarEntrada, fitxarSortida;  // Añadir los botones de Entrada y Sortida
    private JEditorPane fichaUsuari;
    private JLabel labelCoordenades, labelMissatge, labelTitol;
    private JTextField entradaCoordenades, entradaMissatge;

    public AstronautaView() {
        frame = new JFrame("Astronauta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Crear un panel para la parte superior
        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(70, 103, 144));

        botoCerrarSesion = new JButton("Cerrar Sesión");
        panelSuperior.add(botoCerrarSesion, BorderLayout.WEST);

        // Título con nombre del usuario
        labelTitol = new JLabel("Astronauta", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        panelSuperior.add(labelTitol, BorderLayout.CENTER);

        // Crear un panel central para centrar los elementos restantes
        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(70, 103, 144));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Ficha de usuario
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel etiquetaFicha = new JLabel("Ficha:");
        etiquetaFicha.setForeground(Color.WHITE);
        panelCentral.add(etiquetaFicha, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        fichaUsuari = new JEditorPane();
        fichaUsuari.setContentType("text/html");
        fichaUsuari.setEditable(false);
        fichaUsuari.setPreferredSize(new Dimension(200, 150));
        fichaUsuari.setBackground(new Color(70, 103, 144));
        fichaUsuari.setForeground(Color.WHITE);
        fichaUsuari.setFont(new Font("Arial", Font.PLAIN, 12));
        panelCentral.add(fichaUsuari, gbc);

        // Sección de envío de coordenadas
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        labelCoordenades = new JLabel("Enviar Coordenades:");
        labelCoordenades.setForeground(Color.WHITE);
        panelCentral.add(labelCoordenades, gbc);

        JPanel panelCoordenades = new JPanel();
        panelCoordenades.setBackground(new Color(70, 103, 144));
        panelCoordenades.setLayout(new FlowLayout(FlowLayout.LEFT));
        entradaCoordenades = new JTextField(10);
        panelCoordenades.add(entradaCoordenades);
        botoEnviar = new JButton("Enviar");
        panelCoordenades.add(botoEnviar);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panelCentral.add(panelCoordenades, gbc);

        // Sección de envío de mensajes
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        labelMissatge = new JLabel("Enviar Missatge Encriptat:");
        labelMissatge.setForeground(Color.WHITE);
        panelCentral.add(labelMissatge, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        JPanel panelMensajeYBoton = new JPanel();
        panelMensajeYBoton.setBackground(new Color(70, 103, 144));
        panelMensajeYBoton.setLayout(new BoxLayout(panelMensajeYBoton, BoxLayout.LINE_AXIS));
        entradaMissatge = new JTextField(10);
        panelMensajeYBoton.add(entradaMissatge);
        botoEnviarMissatge = new JButton("Enviar Missatge");
        panelMensajeYBoton.add(Box.createRigidArea(new Dimension(5, 0)));
        panelMensajeYBoton.add(botoEnviarMissatge);
        panelCentral.add(panelMensajeYBoton, gbc);

        // Añadir botones de Entrada y Sortida
        JPanel panelBotonsFitxar = new JPanel();
        panelBotonsFitxar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelBotonsFitxar.setBackground(new Color(70, 103, 144));

        fitxarEntrada = new JButton("Entrada");
        fitxarSortida = new JButton("Sortida");
        panelBotonsFitxar.add(fitxarEntrada);
        panelBotonsFitxar.add(fitxarSortida);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        panelCentral.add(panelBotonsFitxar, gbc); // Agregar los botones al panel

        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    // Listeners para los nuevos botones de Entrada y Sortida
    public void actionListenerFitxarEntrada(ActionListener listener) {
        fitxarEntrada.addActionListener(listener);
    }

    public void actionListenerFitxarSortida(ActionListener listener) {
        fitxarSortida.addActionListener(listener);
    }

    public void actionListenerBotoCerrarSesion(ActionListener listener) {
        botoCerrarSesion.addActionListener(listener);
    }

    public void actionListenerBotoEnviarMissatge(ActionListener listener) {
        botoEnviarMissatge.addActionListener(listener);
    }

    public void actionListenerBotoEntrar(ActionListener listener) {
        botoEnviar.addActionListener(listener);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void actualitzarFitxa(String ficha) {
        String htmlFicha = "<html><span style='color:white; font-family: Arial;'>" + ficha.replace("\n", "<br>") + "</span></html>";
        fichaUsuari.setText(htmlFicha);
    }

    public String getEntradaCoordenades() {
        return entradaCoordenades.getText();
    }

    public String getEntradaMissatge() {
        return entradaMissatge.getText();
    }
}
