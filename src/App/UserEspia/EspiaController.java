package App.UserEspia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EspiaController {
    private EspiaView vista;
    private EspiaModel model;
    private String username; // Añadir un campo para el username

    public EspiaController(EspiaView vista, EspiaModel model, String username) {
        this.vista = vista;
        this.model = model;
        this.username = username; // Guardar el username

        // Actualizar la ficha del usuario
        String fichaUsuari = model.obtenerFichaUsuario(username);
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEnviarMensatge(new BotonEnviarMissatgeListener());
    }

    class BotonEnviarMissatgeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String missatge = vista.getEntradaMissatge();
            if (!missatge.isEmpty()) {
                // Aquí llamamos al método para insertar el mensaje encriptado
                model.insertarMissatgeEncriptat(username, missatge);
                String mensajeEncriptado = model.eliminarConsonantes(missatge);
                vista.setMensajeEncriptado(mensajeEncriptado); // Actualizar la vista con el mensaje encriptado
            } else {
                JOptionPane.showMessageDialog(vista.getFrame(), "El mensaje no puede estar vacío.");
            }
        }
    }
}
