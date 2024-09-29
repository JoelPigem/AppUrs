package App.UserEspia;

import App.IniciSessio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EspiaController {
    private EspiaView vista;
    private EspiaModel model;
    private String username;

    public EspiaController(EspiaView vista, EspiaModel model, String username) {
        this.vista = vista;
        this.model = model;
        this.username = username;

        String fichaUsuari = model.obtenirFitxaUsuari(username);
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEnviarMensatge(new BotonEnviarMissatgeListener());
        vista.actionListenerBotoCerrarSesion(new BotonCerrarSesionListener());
        this.vista.actionListenerFitxarEntrada(new EspiaController.actionListenerFitxarEntrada());
        this.vista.actionListenerFitxarSortida(new EspiaController.actionListenerFitxarSortida());
    }

    class BotonEnviarMissatgeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String missatge = vista.getEntradaMissatge();
            if (!missatge.isEmpty()) {
                model.insertarMissatgeEncriptat(username, missatge);
                String mensajeEncriptado = model.eliminarConsonants(missatge);
                vista.setMensajeEncriptado(mensajeEncriptado);
            } else {
                JOptionPane.showMessageDialog(vista.getFrame(), "El missatge no pot estar buit.");
            }
        }
    }

    class BotonCerrarSesionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            vista.getFrame().dispose();
            try {
                AppIniciSessio.main(new String[]{});
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


    class actionListenerFitxarEntrada implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                model.fitxarEntrada(model.obtenirID(username));
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
                model.fitxarSortida(model.obtenirID(username));
                System.out.println("fitxat sortida correctament");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

        }
    }
}
