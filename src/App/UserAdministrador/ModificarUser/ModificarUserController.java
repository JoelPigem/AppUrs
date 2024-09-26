package App.UserAdministrador.ModificarUser;

import App.UserAdministrador.AppUserAdministrador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import javax.swing.*;

public class ModificarUserController {
    private ModificarUserView vista;
    private ModificarUserModel model;

    ModificarUserController(ModificarUserModel model, ModificarUserView vista) {
        this.vista = vista;
        this.model = model;

        vista.getBotoBuscar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuari = Integer.parseInt(vista.getIdUsuari());
                    Object[] usuari = model.obtenirUsuariPerID(idUsuari);

                    if (usuari != null) {
                        vista.setNom(usuari[1].toString());
                        vista.setPassword(usuari[2].toString());
                        vista.setRol(usuari[3].toString());
                        vista.habilitarBotoModificar(true);
                    } else {
                        JOptionPane.showMessageDialog(vista.getFrame(), "Usuari no trobat.");
                        vista.habilitarBotoModificar(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vista.getFrame(), "Error de base de dades.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista.getFrame(), "ID invàlid.");
                }
            }
        });

        vista.getBotoModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int idUsuari = Integer.parseInt(vista.getIdUsuari());
                    String nom = vista.getNom();
                    String password = vista.getPassword();
                    String rol = vista.getRol();

                    model.modificarUsuari(idUsuari, nom, password, rol);
                    JOptionPane.showMessageDialog(vista.getFrame(), "Usuari modificat correctament.");
                    vista.netejarTexts();
                    vista.habilitarBotoModificar(false);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(vista.getFrame(), "Error al modificar l'usuari.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(vista.getFrame(), "ID invàlid.");
                }
            }
        });

        vista.getBotoEnrere().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.getFrame().dispose();
                AppUserAdministrador.main(new String[]{});
            }
        });
    }
}
