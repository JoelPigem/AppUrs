package App.Mecanic;

import App.UserAdministrador.UserAdministradorController;
import App.UserAdministrador.UserAdministradorModel;
import App.UserAdministrador.UserAdministradorView;

public class AppUserMecanic {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("No username provided");
            return;
        }
        String username = args[0];
        String password = args[1];
        // Crear la vista
        MecanicView view = new MecanicView();

        // Crear el modelo
        MecanicModel model = new MecanicModel();

        // Crear el controlador
        MecanicController controller = new MecanicController(view, model, username, password);

    }
}
