package App.IniciSessio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
                    model.obtenirRol(usuari, contrasenya);
                } else {
                    JOptionPane.showMessageDialog(null, "Usuari o contrasenya incorrectes.");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
