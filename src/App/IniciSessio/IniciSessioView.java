package App.IniciSessio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IniciSessioView {
    private JFrame frame;
    private JButton botoIniciSessio;
    private JTextField entradaUsuari, entradaContrasenya;

    IniciSessioView(){
        frame = new JFrame("Inici Sessio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
       // frame.setBounds(600,400,400,400);
        frame.setSize(800, 450);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        entradaUsuari = new JTextField(10);
        entradaContrasenya = new JPasswordField(10);
        botoIniciSessio = new JButton("Entrar");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(new Color(44, 62, 80));


        JLabel labelTitol = new JLabel("Benvingut a la URS, VISCA EL COMUNISME!", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitol.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(labelTitol);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));


        JLabel etiquetaUsuari = new JLabel("Usuari:");
        etiquetaUsuari.setForeground(Color.WHITE);
        etiquetaUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaUsuari);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        entradaUsuari.setMaximumSize(new Dimension(200, 30));
        entradaUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(entradaUsuari);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));


        JLabel etiquetaContrasenya = new JLabel("Contrasenya:");
        etiquetaContrasenya.setForeground(Color.WHITE);
        etiquetaContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(etiquetaContrasenya);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        entradaContrasenya.setMaximumSize(new Dimension(200, 30));
        entradaContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(entradaContrasenya);
        panel.add(Box.createRigidArea(new Dimension(0, 30)));


        botoIniciSessio.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(botoIniciSessio);

        frame.add(panel,BorderLayout.NORTH);
        frame.setVisible(true);
    }

    public JTextField getEntradaUsuari() {
        return entradaUsuari;
    }

    public JTextField getEntradaContrasenya() {
        return entradaContrasenya;
    }

    public void setEntradaUsuari(JTextField entradaUsuari) {
        this.entradaUsuari = entradaUsuari;
    }

    public void setEntradaContrasenya(JTextField entradaContrasenya) {
        this.entradaContrasenya = entradaContrasenya;
    }

    public void actionListenerBotoEntrar(ActionListener listener) { botoIniciSessio.addActionListener(listener);}

}
