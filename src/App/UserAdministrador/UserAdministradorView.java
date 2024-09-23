package App.UserAdministrador;

import javax.swing.*;
import java.awt.*;

public class UserAdministradorView {
    private JFrame frame;
    private JButton botoModificar, botoBorrar, botoAfegir;
    private JTextField buscarUsuari;
    private JComboBox<String> desplegableRol;

    private JLabel labelRolUsuari;

    UserAdministradorView () {
        frame = new JFrame("Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        // frame.setBounds(600,400,400,400);
        frame.setSize(650, 650);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(70, 103, 144));


        JPanel panelTop = new JPanel();
        panelTop.setLayout(new BoxLayout(panelTop, BoxLayout.Y_AXIS));
        panelTop.setBackground(new Color(70, 103, 144));

        labelRolUsuari = new JLabel("Administrador");
        labelRolUsuari.setAlignmentX(Component.CENTER_ALIGNMENT);
        labelRolUsuari.setForeground(Color.WHITE);
        labelRolUsuari.setFont(new Font("Arial", Font.BOLD, 16));

        desplegableRol = new JComboBox<>(new String[]{"Administrador", "Mecànic", "Físic", "Astronauta", "Espia"});
        desplegableRol.setMaximumSize(new Dimension(200, 30));
        desplegableRol.setAlignmentX(Component.CENTER_ALIGNMENT);

        panelTop.add(labelRolUsuari);
        panelTop.add(Box.createRigidArea(new Dimension(0, 10)));
        panelTop.add(desplegableRol);

        buscarUsuari = new JTextField(15);
        buscarUsuari.setMaximumSize(new Dimension(200, 30));

        JPanel panelSuperior = new JPanel(new BorderLayout());
        panelSuperior.setBackground(new Color(70, 103, 144));
        panelSuperior.add(panelTop, BorderLayout.CENTER);
        panelSuperior.add(buscarUsuari, BorderLayout.LINE_END);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JPanel panelDreta = new JPanel();
        panelDreta.setLayout(new BoxLayout(panelDreta, BoxLayout.Y_AXIS));
        panelDreta.setBackground(new Color(70, 103, 144));
        panelDreta.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        botoModificar = new JButton("Modificar");
        botoBorrar = new JButton("Borrar");
        botoAfegir = new JButton("Afegir");

        botoModificar.setMaximumSize(new Dimension(200, 30));
        botoBorrar.setMaximumSize(new Dimension(200, 30));
        botoAfegir.setMaximumSize(new Dimension(200, 30));


        panelDreta.add(botoModificar);
        panelDreta.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDreta.add(botoBorrar);
        panelDreta.add(Box.createRigidArea(new Dimension(0, 10)));
        panelDreta.add(botoAfegir);

        frame.add(panelSuperior, BorderLayout.PAGE_START);
        frame.add(panelDreta, BorderLayout.EAST);
        frame.setVisible(true);


    }

}
