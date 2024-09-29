package App.UserEspia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EspiaView {
    private JFrame frame;
    private JButton botoEnviarMissatge, botoCerrarSesion;
    private JButton fitxarEntrada, fitxarSortida;
    private JLabel fichaUsuari, labelMissatge, labelMensajeEncriptado;
    private JTextField entradaMissatge;

    EspiaView() {
        frame = new JFrame("Espia");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(213, 21, 21));

        botoCerrarSesion = new JButton("Tanca sessió");
        panelSuperior.add(botoCerrarSesion, BorderLayout.WEST);

        JPanel panelCentral = new JPanel(new GridBagLayout());
        panelCentral.setBackground(new Color(213, 21, 21));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel labelTitol = new JLabel("Espia", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        panelCentral.add(labelTitol, gbc);


        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        JLabel etiquetaFicha = new JLabel("Fitxa usuari:");
        etiquetaFicha.setForeground(Color.WHITE);
        panelCentral.add(etiquetaFicha, gbc);


        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        fichaUsuari = new JLabel();
        fichaUsuari.setPreferredSize(new Dimension(200, 30));
        fichaUsuari.setForeground(Color.WHITE);
        panelCentral.add(fichaUsuari, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.EAST;
        labelMissatge = new JLabel("Enviar Missatge:");
        labelMissatge.setForeground(Color.WHITE);
        panelCentral.add(labelMissatge, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;

        entradaMissatge = new JTextField();
        entradaMissatge.setPreferredSize(new Dimension(200, 30)); // Ajustar el tamaño del campo de texto
        entradaMissatge.setColumns(20);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        panelCentral.add(entradaMissatge, gbc);

        gbc.gridy++;
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        botoEnviarMissatge = new JButton("Enviar Missatge");
        panelCentral.add(botoEnviarMissatge, gbc);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        labelMensajeEncriptado = new JLabel();
        labelMensajeEncriptado.setForeground(Color.WHITE);
        panelCentral.add(labelMensajeEncriptado, gbc);

        JPanel panelBotonsFitxar = new JPanel();
        panelBotonsFitxar.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panelBotonsFitxar.setBackground(new Color(213, 21, 21));

        fitxarEntrada = new JButton("Entrada");
        fitxarSortida = new JButton("Sortida");
        panelBotonsFitxar.add(fitxarEntrada);
        panelBotonsFitxar.add(fitxarSortida);

        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelCentral.add(panelBotonsFitxar, gbc);

        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void actualitzarFitxa(String ficha) {
        fichaUsuari.setText("<html>" + ficha.replaceAll(", ", "<br>") + "</html>");
    }

    public String getEntradaMissatge() {
        return entradaMissatge.getText();
    }

    public void setMensajeEncriptado(String missatgeEncriptat) {
        labelMensajeEncriptado.setText("Mensaje Encriptado: " + missatgeEncriptat);
    }

    public void actionListenerBotoEnviarMensatge(ActionListener listener) {
        botoEnviarMissatge.addActionListener(listener);
    }

    public void actionListenerBotoCerrarSesion(ActionListener listener) {
        botoCerrarSesion.addActionListener(listener);
    }

    public void actionListenerFitxarEntrada(ActionListener listener) {
        fitxarEntrada.addActionListener(listener);
    }

    public void actionListenerFitxarSortida(ActionListener listener) {
        fitxarSortida.addActionListener(listener);
    }
}
