package App.UserAdministrador.ModificarUser;

import App.UserAdministrador.AfegirUser.AfegirUserController;
import App.UserAdministrador.AfegirUser.AfegirUserModel;
import App.UserAdministrador.AfegirUser.AfegirUserView;

public class AppModificarUser {
    public static void main(String[] args) {

        ModificarUserView vista = new ModificarUserView();

        ModificarUserModel model = new ModificarUserModel();

        ModificarUserController controlador = new ModificarUserController(model,vista);

    }
}
