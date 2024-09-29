package App.Mecanic;

import App.IniciSessio.AppIniciSessio;
import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;
import App.UserEspia.EspiaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MecanicController {

    private MecanicView vista;
    private MecanicModel model;
    private String username;
    private String password;

    public MecanicController(MecanicView vista, MecanicModel model, String username, String password) {
        this.vista = vista;
        this.model = model;
        this.username = username;
        this.password = password;

        //this.iniciSessioModel = new IniciSessioModel();
        //this.iniciSessioView = new IniciSessioView();
        this.vista.actionListenerLlistar(new ListenerLlistar());
        this.vista.actionListenerImprimir(new actionListenerImprimir());
        this.vista.actionListenerFitxarEntrada(new actionListenerFitxarEntrada());
        this.vista.actionListenerFitxarSortida(new actionListenerFitxarSortida());
        this.vista.actionListenerBotoCerrarSesion(new BotonCerrarSesionListener());

        String fichaUsuari = model.obtenerFichaUsuario(username);
        vista.actualitzarFitxa(fichaUsuari);

    }

    class ListenerLlistar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] cotxes = model.llistarCotxes();
                vista.actualitzarTaula(cotxes);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class BotonCerrarSesionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Cerrar la ventana actual
            vista.getFrame().dispose();
            // Mostrar la ventana de inicio de sesión
            try {
                AppIniciSessio.main(new String[]{});
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    class actionListenerImprimir implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Object[][] cotxes = model.llistarCotxes();
                model.imprimirLlista(cotxes);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    class actionListenerFitxarEntrada implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                model.fitxarEntrada(model.obtenirID(username, password));
                System.out.println("fitxat correctament");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

    class actionListenerFitxarSortida implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                model.fitxarSortida(model.obtenirID(username, password));
                System.out.println("fitxat sortida correctament");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }

}
