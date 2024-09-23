package App.UserAdministrador;

import App.IniciSessio.IniciSessioController;
import App.IniciSessio.IniciSessioModel;
import App.IniciSessio.IniciSessioView;

public class AppUserAdministrador {
    public static void main(String[] args) {

        // Crear la vista
       UserAdministradorView vista = new UserAdministradorView();

        // Crear el modelo
        UserAdministradorModel model = new UserAdministradorModel();

        // Crear el controlador
        UserAdministradorController controlador = new UserAdministradorController(vista, model);

    }
}
