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

        this.vista.getBotoLlistar().addActionListener(new ListenerLlistarUsuari());
    }

    class ListenerLlistarUsuari implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String textID = vista.getBuscarUsuari().getText().trim();
            if (!textID.isEmpty()) {
                int idUsuari = Integer.parseInt(textID);
                try {
                    Object[] usuari = model.obtenirUsuariPerID(idUsuari);
                    Object[][] data = { usuari };
                    vista.getDesplegableRol().setSelectedItem(usuari[3].toString());
                    vista.actualitzarTaula(data);

                   ;
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }else{
                String rolSeleccionat = (String) vista.getDesplegableRol().getSelectedItem();
                try {
                    Object[][] usuaris = model.obtenirUsuarisPerRol(rolSeleccionat);
                    vista.actualitzarTaula(usuaris);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }



        }
    }
}
