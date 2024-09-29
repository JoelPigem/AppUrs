package App.UserAdministrador.ModificarUser;

import javax.swing.*;
import java.awt.*;

public class ModificarUserView {
    private JFrame frame;
    private JTextField idField, nomField;
    private JPasswordField passwordField;
    private JComboBox<String> rolComboBox;
    private JButton botoModificar, botoEnrere, botoBuscar;

    public ModificarUserView() {

        frame = new JFrame("Modificar Usuari");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 350);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());


        frame.getContentPane().setBackground(new Color(213, 21, 21));


        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BoxLayout(panelSuperior, BoxLayout.Y_AXIS));
        panelSuperior.setBackground(new Color(213, 21, 21));



        JPanel panelEnrere = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoEnrere = new JButton("<");
        botoEnrere.setForeground(Color.WHITE);
        botoEnrere.setBackground(new Color(100, 15, 15));
        panelEnrere.add(botoEnrere);
        panelEnrere.setBackground(new Color(213, 21, 21));
        panelSuperior.add(panelEnrere);


        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        panelCentral.setBackground(new Color(213, 21, 21));


        JLabel idLabel = new JLabel("ID del Usuari:");
        idLabel.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        panelCentral.add(idLabel, constraints);

        idField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(idField, constraints);


        botoBuscar = new JButton("Buscar");
        botoBuscar.setForeground(Color.WHITE);
        botoBuscar.setBackground(new Color(100, 15, 15));
        constraints.gridx = 2;
        constraints.gridy = 0;
        panelCentral.add(botoBuscar, constraints);


        JLabel usernameLabel = new JLabel("Nom:");
        usernameLabel.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(usernameLabel, constraints);

        nomField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(nomField, constraints);


        JLabel passwordLabel = new JLabel("Contrasenya:");
        passwordLabel.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(passwordLabel, constraints);

        passwordField = new JPasswordField(15);
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(passwordField, constraints);


        JLabel roleLabel = new JLabel("Rol:");
        roleLabel.setForeground(Color.WHITE);
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(roleLabel, constraints);

        rolComboBox = new JComboBox<>(new String[]{"Admin", "Mecànic", "Astronauta", "Físic", "Espia"});
        constraints.gridx = 1;
        constraints.gridy = 3;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(rolComboBox, constraints);


        JPanel botoPanell = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoModificar = new JButton("Modificar Usuari");
        botoModificar.setForeground(Color.WHITE);
        botoModificar.setBackground(new Color(100, 15, 15)); // Un rojo más oscuro
        botoModificar.setEnabled(false);
        botoPanell.add(botoModificar);
        botoPanell.setBackground(new Color(213, 21, 21));


        frame.add(panelSuperior, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(botoPanell, BorderLayout.SOUTH);


        frame.setVisible(true);
    }

    public void habilitarBotoModificar(boolean habilitar) {
        botoModificar.setEnabled(habilitar);
    }

    public String getIdUsuari() {
        return idField.getText();
    }

    public String getNom() {
        return nomField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getRol() {
        return (String) rolComboBox.getSelectedItem();
    }

    public void setNom(String nom) {
        nomField.setText(nom);
    }

    public void setPassword(String password) {
        passwordField.setText(password);
    }

    public void setRol(String rol) {
        rolComboBox.setSelectedItem(rol);
    }

    public JButton getBotoBuscar() {
        return botoBuscar;
    }

    public JButton getBotoModificar() {
        return botoModificar;
    }

    public JButton getBotoEnrere() {
        return botoEnrere;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void netejarTexts() {
        idField.setText("");
        nomField.setText("");
        passwordField.setText("");
        rolComboBox.setSelectedIndex(0);
    }
}
