package App.UserEspia;

import App.IniciSessio.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspiaController {
    private EspiaView vista;
    private EspiaModel model;
    private String username;

    public EspiaController(EspiaView vista, EspiaModel model, String username) {
        this.vista = vista;
        this.model = model;
        this.username = username;

        // Actualizar la ficha del usuario
        String fichaUsuari = model.obtenerFichaUsuario(username);
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEnviarMensatge(new BotonEnviarMissatgeListener());
        vista.actionListenerBotoCerrarSesion(new BotonCerrarSesionListener()); // Listener para cerrar sesión
    }

    class BotonEnviarMissatgeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String missatge = vista.getEntradaMissatge();
            if (!missatge.isEmpty()) {
                model.insertarMissatgeEncriptat(username, missatge);
                String mensajeEncriptado = model.eliminarConsonantes(missatge);
                vista.setMensajeEncriptado(mensajeEncriptado);
            } else {
                JOptionPane.showMessageDialog(vista.getFrame(), "El mensaje no puede estar vacío.");
            }
        }
    }

    // Listener para el botón de cerrar sesión
    class BotonCerrarSesionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Cerrar la ventana actual
            vista.getFrame().dispose();
            // Mostrar la ventana de inicio de sesión
            AppIniciSessio.main(new String[]{});
        }
    }
}
