package App.UserAstronauta;

import App.IniciSessio.IniciSessioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AstronautaController {
    private AstronautaView vista;
    private AstronautaModel model;
    IniciSessioView usuari;
    public AstronautaController(AstronautaView vista, AstronautaModel model) {
        this.vista = vista;
        this.model = model;

        String fichaUsuari = model.obtenerFichaUsuario("Joel");
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEntrar(new BotonListener());
    }

    class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Enviar")) {
                String coordenades = vista.getEntradaCoordenades();
                if (model.validarCoordenades(coordenades)) {
                    System.out.println("Coordenades enviades: " + coordenades);
                } else {
                    System.out.println("Format de coordenades incorrecte!");
                }
            }
        }
    }
}