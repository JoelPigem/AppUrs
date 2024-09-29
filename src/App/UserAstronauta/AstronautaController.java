package App.UserAstronauta;

import App.IniciSessio.AppIniciSessio;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AstronautaController {
    private AstronautaView vista;
    private AstronautaModel model;
    private String username;

    public AstronautaController(AstronautaView vista, AstronautaModel model, String username) {
        this.vista = vista;
        this.model = model;
        this.username = username;

        String fichaUsuari = model.obtenerFichaUsuario(username);
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEntrar(new BotonListener());
        vista.actionListenerBotoEnviarMissatge(new BotonEnviarMissatgeListener());
        vista.actionListenerBotoCerrarSesion(new AstronautaController.BotonCerrarSesionListener());
        this.vista.actionListenerFitxarEntrada(new AstronautaController.actionListenerFitxarEntrada());
        this.vista.actionListenerFitxarSortida(new AstronautaController.actionListenerFitxarSortida());

    }

    class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Enviar")) {
                String coordenades = vista.getEntradaCoordenades();
                if (model.validarCoordenades(coordenades)) {
                    model.insertarCoordenades(username, coordenades);
                    System.out.println("Coordenades enviades: " + coordenades);
                } else {
                    System.out.println("Format de coordenades incorrecte!");
                }
            }
        }
    }

    class BotonEnviarMissatgeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String missatge = vista.getEntradaMissatge();
            if (!missatge.isEmpty()) {
                model.insertarMissatgeEncriptat(username, missatge);
                System.out.println("Missatge enviat: " + missatge);
            } else {
                System.out.println("El missatge no pot estar buit!");
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
