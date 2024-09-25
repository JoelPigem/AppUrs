package App.UserEspia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class EspiaView {
    private JFrame frame;
    private JButton botoEnviarMissatge;
    private JLabel fichaUsuari; // Para mostrar los datos del Espía
    private JTextField entradaMissatge; // Para ingresar el mensaje encriptado
    private JLabel labelMissatgeEncriptat; // Label para mostrar el mensaje encriptado

    public EspiaView() {
        frame = new JFrame("Espía");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        fichaUsuari = new JLabel();
        entradaMissatge = new JTextField(10);
        botoEnviarMissatge = new JButton("Enviar Mensaje Encriptado");
        labelMissatgeEncriptat = new JLabel("Mensaje Encriptado: "); // Label para mostrar el mensaje encriptado

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(70, 103, 144));

        // Título con nombre del usuario
        JLabel labelTitol = new JLabel("Espía", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitol.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitol);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Mostrar los datos del espía
        panel.add(fichaUsuari);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Sección de envío de mensajes
        JLabel labelMissatge = new JLabel("Enviar Mensaje Encriptado:");
        labelMissatge.setForeground(Color.WHITE);
        labelMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelMissatge);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        entradaMissatge.setMaximumSize(new Dimension(200, 30));
        entradaMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(entradaMissatge);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        botoEnviarMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botoEnviarMissatge);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Añadir label para mostrar mensaje encriptado
        panel.add(labelMissatgeEncriptat);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame; //a totes les vistes porfa
    }

    // Método para actualizar la ficha del usuario
    public void actualitzarFitxa(String ficha) {
        fichaUsuari.setText("Datos del Espía: " + ficha); // Mostrar datos del Espía
    }

    // Obtener el mensaje ingresado por el usuario
    public String getEntradaMissatge() {
        return entradaMissatge.getText();
    }

    // Actualizar el mensaje encriptado
    public void setMensajeEncriptado(String mensaje) {
        labelMissatgeEncriptat.setText("Mensaje Encriptado: " + mensaje);
    }

    // Métodos para agregar ActionListener a los botones
    public void actionListenerBotoEnviarMensatge(ActionListener listener) {
        botoEnviarMissatge.addActionListener(listener);
    }
}
