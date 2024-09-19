package App.IniciSessio;

import java.sql.Connection;

import App.Conexio;



public class AppIniciSessio {
    public static void main(String[] args) {

        // Crear la vista
        IniciSessioView vista = new IniciSessioView();

        // Crear el modelo
        IniciSessioModel model = new IniciSessioModel();

        // Crear el controlador
        IniciSessioController controlador = new IniciSessioController(vista, model);
    }
}
