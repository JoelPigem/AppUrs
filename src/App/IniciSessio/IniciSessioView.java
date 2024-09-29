package App.IniciSessio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class IniciSessioView {
    private JFrame frame;
    private JButton botoIniciSessio;
    private JTextField entradaUsuari, entradaContrasenya;

    public IniciSessioView(){
        frame = new JFrame("Inici Sessio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
       // frame.setBounds(600,400,400,400);
        frame.setSize(450, 400);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);


        BackgroundPanel backgroundPanel = new BackgroundPanel();
        backgroundPanel.setLayout(new BoxLayout(backgroundPanel, BoxLayout.Y_AXIS));

        entradaUsuari = new JTextField(10);
        entradaContrasenya = new JPasswordField(10);
        botoIniciSessio = new JButton("Entrar");

        JLabel labelTitol = new JLabel("Benvingut a la APP de la URS", JLabel.CENTER);
        labelTitol.setForeground(Color.WHITE);
        labelTitol.setFont(new Font("Arial", Font.BOLD, 18));
        labelTitol.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(labelTitol);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 30)));


        JLabel etiquetaUsuari = new JLabel("Usuari:");
        etiquetaUsuari.setForeground(Color.WHITE);
        etiquetaUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(etiquetaUsuari);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        entradaUsuari.setMaximumSize(new Dimension(200, 30));
        entradaUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(entradaUsuari);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 20)));


        JLabel etiquetaContrasenya = new JLabel("Contrasenya:");
        etiquetaContrasenya.setForeground(Color.WHITE);
        etiquetaContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(etiquetaContrasenya);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        entradaContrasenya.setMaximumSize(new Dimension(200, 30));
        entradaContrasenya.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(entradaContrasenya);
        backgroundPanel.add(Box.createRigidArea(new Dimension(0, 30)));


        botoIniciSessio.setAlignmentX(Component.CENTER_ALIGNMENT);
        backgroundPanel.add(botoIniciSessio);

        frame.add(backgroundPanel,BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
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

    private class BackgroundPanel extends JPanel {
        private Image backgroundImage;

        public BackgroundPanel() {

            backgroundImage = new ImageIcon("src/Assets/img.jpg").getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
