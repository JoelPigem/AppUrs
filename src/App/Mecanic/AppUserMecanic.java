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

        MecanicView view = new MecanicView();

        MecanicModel model = new MecanicModel();

        MecanicController controller = new MecanicController(view, model, username, password);

    }
}
