package App.UserAdministrador.AfegirUser;
import App.UserAdministrador.AppUserAdministrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
public class AfegirUserController {
    private AfegirUserView vista;
    private AfegirUserModel model;

    public AfegirUserController(AfegirUserView vista, AfegirUserModel model) {
        this.vista = vista;
        this.model = model;
        this.vista.getBotoAfegir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afegirUsuari();
            }
        });

        this.vista.getBotoEnrere().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tornarAdminView();
            }
        });
    }
    private void tornarAdminView(){
        vista.getFrame().dispose();
        AppUserAdministrador.main(new String[]{});
    }

    private void afegirUsuari(){
        String username = vista.getNom();
        String password = vista.getPassword();
        String role = vista.getRol();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(vista.getFrame(), "Completa els camps obligatoris.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            model.afegirUsuari(username, password, role);
            JOptionPane.showMessageDialog(vista.getFrame(), "Usuari afegit correctament");
            vista.netejarTexts();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista.getFrame(), "Error al afegir l'usuari: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
