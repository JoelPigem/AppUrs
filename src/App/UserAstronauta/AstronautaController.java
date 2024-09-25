package App.UserAstronauta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AstronautaController {
    private AstronautaView vista;
    private AstronautaModel model;
    private String username; // Añadir un campo para el username

    public AstronautaController(AstronautaView vista, AstronautaModel model, String username) {
        this.vista = vista;
        this.model = model;
        this.username = username; // Guardar el username

        String fichaUsuari = model.obtenerFichaUsuario(username); // Usar el username aquí
        vista.actualitzarFitxa(fichaUsuari);

        vista.actionListenerBotoEntrar(new BotonListener());
        vista.actionListenerBotoEnviarMissatge(new BotonEnviarMissatgeListener()); // Añadimos el listener del mensaje
    }

    class BotonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Enviar")) {
                String coordenades = vista.getEntradaCoordenades();
                if (model.validarCoordenades(coordenades)) {
                    // Aquí llamamos al método para insertar coordenadas en la base de datos
                    model.insertarCoordenades(username, coordenades); // Usamos el username
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
                // Aquí llamamos al método para insertar el mensaje encriptado
                model.insertarMissatgeEncriptat(username, missatge);
                System.out.println("Missatge enviat: " + missatge);
            } else {
                System.out.println("El missatge no pot estar buit!");
            }
        }
    }
}
