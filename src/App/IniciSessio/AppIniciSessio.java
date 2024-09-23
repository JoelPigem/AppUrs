package App.IniciSessio;

import java.sql.Connection;

import App.Conexio;



public class AppIniciSessio {
    public static void main(String[] args) {

        IniciSessioView vista = new IniciSessioView();

        IniciSessioModel model = new IniciSessioModel();

        IniciSessioController controlador = new IniciSessioController(vista, model);

    }
}
