package App.UserAstronauta;


import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

public class AppAstronauta {
    public static void main(String[] args) {
        // Asegurarnos de que se recibe el username desde el argumento
        if (args.length == 0) {
            System.err.println("No username provided");
            return;
        }
        String username = args[0];

        // Crear la vista
        AstronautaView vista = new AstronautaView();

        // Crear el modelo
        AstronautaModel model = new AstronautaModel();

        // Crear el controlador, pasando el username al modelo
        AstronautaController controlador = new AstronautaController(vista, model, username);
    }
}
