package App.UserAdministrador;

import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserAdministradorController {
    private UserAdministradorView vista;
    private UserAdministradorModel model;

    public UserAdministradorController(UserAdministradorView vista, UserAdministradorModel model) {
        this.vista = vista;
        this.model = model;
    }

    class ListenerBotoEntrar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {



            /*try {


            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }*/
        }
    }
}
