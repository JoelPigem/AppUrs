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

        String usuari = vista.getEntradaUsuari().getText();
        String contrasenya = vista.getEntradaContrasenya().getText();

        //if (model.validarUsuari(usuari, contrasenya)){
            MecanicView mecanicView = new MecanicView();
        //}


        //MecanicView mecanicView = new MecanicView();

    }
}
