package App.UserAdministrador.AfegirUser;

import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

public class AppAfegirUser {

    public static void main(String[] args) {

        AfegirUserView vista = new AfegirUserView();

        AfegirUserModel model = new AfegirUserModel();

        AfegirUserController controlador = new AfegirUserController(vista, model);

    }
}
