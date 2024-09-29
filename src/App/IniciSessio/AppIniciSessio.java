package App.IniciSessio;

import java.sql.Connection;
import java.sql.SQLException;

import App.Conexio;
import App.Mecanic.MecanicView;


public class AppIniciSessio {
    public static void main(String[] args) throws SQLException {


        IniciSessioView vista = new IniciSessioView();

        IniciSessioModel model = new IniciSessioModel();

        IniciSessioController controlador = new IniciSessioController(vista, model);




    }
}
