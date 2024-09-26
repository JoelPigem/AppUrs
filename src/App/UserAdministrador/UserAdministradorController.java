package App.UserAdministrador;

import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;
import App.UserAdministrador.AfegirUser.AppAfegirUser;
import App.UserAdministrador.ModificarUser.AppModificarUser;

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
        vista.getBotoAfegir().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose();
                AppAfegirUser.main(new String[]{});
            }
        });
        vista.getBotoModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose();
                AppModificarUser.main(new String[]{});
            }
        });
        vista.getBotoBorrar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textID = vista.getBuscarUsuari().getText().trim();

                if (!textID.isEmpty()) {
                    try {
                        int idUsuari = Integer.parseInt(textID);

                        int confirm = JOptionPane.showConfirmDialog(vista.getFrame(),
                                "¿Estás segur de que desitges eliminar aquest usuari?", "Confirmació",
                                JOptionPane.YES_NO_OPTION);

                        if (confirm == JOptionPane.YES_OPTION) {

                            boolean eliminado = model.eliminarUsuari(idUsuari);
                            if (eliminado) {
                                JOptionPane.showMessageDialog(vista.getFrame(), "Usuari eliminat correctament.");
                                vista.clearBuscarUsuari();
                                vista.actualitzarTaula(new Object[0][]);
                            } else {
                                JOptionPane.showMessageDialog(vista.getFrame(), "No s'ha pogut eliminar l'usuario. Verifica l'ID.");
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(vista.getFrame(), "Siusplou, introdueix un ID vàlid.");
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(vista.getFrame(), "Error eliminant l'usuari: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(vista.getFrame(), "Siusplou, introdueix un ID per borrar l'usuari.");
                }
            }
        });

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
                    vista.getDesplegableRol().setSelectedItem("Tots");
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
