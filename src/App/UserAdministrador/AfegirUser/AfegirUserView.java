package App.UserAdministrador.AfegirUser;
import javax.swing.*;
import java.awt.*;

public class AfegirUserView {
    private JFrame frame;
    private JTextField nomField;
    private JPasswordField passwordField;
    private JComboBox<String> rolComboBox;
    private JButton botoAfegir;
    private JButton botoEnrere;

    public AfegirUserView() {

        frame = new JFrame("Afegir Usuari");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(70, 103, 144));


        JPanel panelTop = new JPanel(new FlowLayout(FlowLayout.LEFT));
        botoEnrere = new JButton("<");
        panelTop.add(botoEnrere);
        panelTop.setBackground(new Color(70, 103, 144));


        JPanel panelCentral = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        panelCentral.setBackground(new Color(70, 103, 144));


        JLabel usernameLabel = new JLabel("Nom:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(usernameLabel, constraints);

        nomField = new JTextField(15);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(nomField, constraints);


        JLabel passwordLabel = new JLabel("Contrassenya:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(passwordLabel, constraints);

        passwordField = new JPasswordField(15);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(passwordField, constraints);


        JLabel roleLabel = new JLabel("Rol:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_END;
        panelCentral.add(roleLabel, constraints);

        rolComboBox = new JComboBox<>(new String[]{"Admin", "Mecànic", "Astronauta", "Físic", "Espia"});
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.anchor = GridBagConstraints.LINE_START;
        panelCentral.add(rolComboBox, constraints);


        JPanel botoPanell = new JPanel(new FlowLayout(FlowLayout.CENTER));
        botoAfegir = new JButton("Afegir Usuari");
        botoPanell.add(botoAfegir);
        botoPanell.setBackground(new Color(70, 103, 144));


        frame.add(panelTop, BorderLayout.NORTH);
        frame.add(panelCentral, BorderLayout.CENTER);
        frame.add(botoPanell, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public JButton getBotoEnrere(){return botoEnrere; }
    public String getNom() {
        return nomField.getText();
    }

    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    public String getRol() {
        return (String) rolComboBox.getSelectedItem();
    }

    public JButton getBotoAfegir() {
        return botoAfegir;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void netejarTexts() {
        nomField.setText("");
        passwordField.setText("");
        rolComboBox.setSelectedIndex(0);
    }
}
