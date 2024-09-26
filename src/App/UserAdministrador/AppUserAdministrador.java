package App.UserAdministrador;

import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

public class AppUserAdministrador {
    public static void main(String[] args) {

       UserAdministradorView vista = new UserAdministradorView();

        UserAdministradorModel model = new UserAdministradorModel();

        UserAdministradorController controlador = new UserAdministradorController(vista, model);

    }
}
