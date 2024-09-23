package App.IniciSessio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import App.UserAdministrador.AppUserAdministrador;
import App.UserAdministrador.UserAdministradorModel;
import App.UserAdministrador.UserAdministradorView;

public class IniciSessioController {
    private IniciSessioView vista;
    private IniciSessioModel model;
    public IniciSessioController(IniciSessioView vista, IniciSessioModel model) {
        this.vista = vista;
        this.model = model;

        this.vista.actionListenerBotoEntrar(new ListenerBotoEntrar());

    }

    class ListenerBotoEntrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuari = vista.getEntradaUsuari().getText();
            String contrasenya = vista.getEntradaContrasenya().getText();


            try {
                if (model.validarUsuari(usuari, contrasenya)) {
                    JOptionPane.showMessageDialog(null, "Inici de sessió correcte!");
                    String rol = model.obtenirRol(usuari, contrasenya);
                    switch (rol) {
                        case "admin":
                            vista.getFrame().dispose();
                            AppUserAdministrador.main(new String[]{});
                            break;
                      /*  case "mecanic":
                            vista.getFrame().dispose();
                            new UserMecanicView();
                            break;*/
                        default:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Usuari o contrasenya incorrectes.");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
