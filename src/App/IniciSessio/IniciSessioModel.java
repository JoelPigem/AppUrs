package App.IniciSessio;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import App.Conexio;
import App.Conexio.*;

public class IniciSessioModel {


    // Método para validar el usuario y la contraseña
    public boolean validarUsuari(String usuari, String contrasenya) throws SQLException {

        Connection conn = Conexio.CrearConexio();

        String queryInicioSesion = "SELECT username, password, rol FROM usuari WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryInicioSesion);

        preparedStatement.setString(1, usuari);

        preparedStatement.setString(2, contrasenya);

        ResultSet resultado = preparedStatement.executeQuery();

        if (resultado.next()) {
            System.out.println("usuari: " + resultado.getString("username"));
            System.out.println("contrasenya: " + resultado.getString("password"));
            System.out.println("rol: " + resultado.getString("rol"));
        } else {
            return false;
        }

        return true;
    }


    public String[] obtenirRol(String usuari, String contrasenya) throws SQLException {
        Connection conn = Conexio.CrearConexio();
        String queryRol = "SELECT username, password, rol FROM usuari WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryRol);

        preparedStatement.setString(1, usuari);
        preparedStatement.setString(2, contrasenya);

        ResultSet resultado = preparedStatement.executeQuery();

        if (resultado.next()) {
            String rol = resultado.getString("rol");
            String username = resultado.getString("username");
            return new String[]{username, rol}; // Retornar tanto el username como el rol
        } else {
            return null;
        }
    }



}
