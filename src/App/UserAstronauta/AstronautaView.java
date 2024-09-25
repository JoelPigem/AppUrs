package App.UserAstronauta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import App.IniciSessio.*;

public class AstronautaView {
    private JFrame frame;
    private JButton botoEnviar, botoEnviarMissatge;
    private JLabel fichaUsuari, labelCoordenades, labelMissatge;
    private JTextField entradaCoordenades, entradaMissatge;
    private IniciSessioView usuari;

    AstronautaView(){
        frame = new JFrame("Astronauta");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        fichaUsuari = new JLabel();
        labelCoordenades = new JLabel("Enviar Coordenades:");
        entradaCoordenades = new JTextField(10);
        botoEnviar = new JButton("Enviar");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(70, 103, 144));

        // Título con nombre del usuario
        JLabel labelTitol = new JLabel("Astronauta", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitol.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitol);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Sección Ficha con botones "ENT" y "SAL"
        JPanel panelFicha = new JPanel();
        panelFicha.setLayout(new BoxLayout(panelFicha, BoxLayout.X_AXIS));
        panelFicha.setBackground(new Color(70, 103, 144));

        JLabel etiquetaFicha = new JLabel("Ficha");
        etiquetaFicha.setForeground(Color.WHITE);
        panelFicha.add(etiquetaFicha);
        panelFicha.add(Box.createRigidArea(new Dimension(10, 0)));

        fichaUsuari.setPreferredSize(new Dimension(200, 30));
        panelFicha.add(fichaUsuari);


        panel.add(panelFicha);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));

        // Sección de envío de coordenadas
        panel.add(labelCoordenades);
        labelCoordenades.setForeground(Color.WHITE);
        labelCoordenades.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        entradaCoordenades.setMaximumSize(new Dimension(200, 30));
        entradaCoordenades.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(entradaCoordenades);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        botoEnviar.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botoEnviar);

        labelMissatge = new JLabel("Enviar Missatge Encriptat:");
        labelMissatge.setForeground(Color.WHITE);
        labelMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelMissatge);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        entradaMissatge = new JTextField(10);
        entradaMissatge.setMaximumSize(new Dimension(200, 30));
        entradaMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(entradaMissatge);

        panel.add(Box.createRigidArea(new Dimension(0, 10)));

        botoEnviarMissatge = new JButton("Enviar Missatge");
        botoEnviarMissatge.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botoEnviarMissatge);


        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame; //a totes les vistes porfa
    }

    // Método para actualizar la ficha del usuario
    public void actualitzarFitxa(String ficha) {
        fichaUsuari.setText(ficha);
    }

    // Obtener las coordenadas introducidas por el usuario
    public String getEntradaCoordenades() {
        return entradaCoordenades.getText();
    }

    public String getEntradaMissatge() {
        return entradaMissatge.getText();
    }

    // Métodos para agregar ActionListener a los botones
    public void actionListenerBotoEnviarMissatge(ActionListener listener) {
        botoEnviarMissatge.addActionListener(listener);
    }


    // Métodos para agregar ActionListener a los botones
    public void actionListenerBotoEntrar(ActionListener listener) {
        botoEnviar.addActionListener(listener);
    }
}
