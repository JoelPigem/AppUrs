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

        // Consulta SQL para validar usuario y contraseña
        String queryInicioSesion = "SELECT username, password, rol FROM usuari WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryInicioSesion);
        // En este paso se le asignan las variables a las columnas de la select.

        // La variable usuari tendrá el valor de username en la select
        preparedStatement.setString(1, usuari);
        // La variable contrasenya tendrá el valor de password en la select
        preparedStatement.setString(2, contrasenya);




        ResultSet resultado = preparedStatement.executeQuery();



        if (resultado.next()) {
            System.out.println("usuari: " + resultado.getString("username"));
            System.out.println("contrasenya: " + resultado.getString("password"));
            System.out.println("rol: " + resultado.getString("rol"));
        } else {
            return false;
        }

        /*try {

                Statement sentencia;
                sentencia = conn.createStatement();

                //ResultSet sortida = null;
                ResultSet sortida = sentencia.executeQuery(queryInicioSesion);
            if ( sortida.getString(2) == usuari && sortida.getString(3) == contrasenya){
                return true;
            }
            else {
                return false;
            }

            } catch (SQLException e) {
                System.out.println("Error en realitzart la consulta: " + e.getMessage());
                return false;
            }
        }*/

        return true;
    }


    public String obtenirRol(String usuari, String contrasenya) throws SQLException {
        Connection conn = Conexio.CrearConexio();
        String queryRol = "SELECT username, password, rol FROM usuari WHERE username = ? AND password = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(queryRol);

        preparedStatement.setString(1, usuari);
        preparedStatement.setString(2, contrasenya);

        ResultSet resultado = preparedStatement.executeQuery();

        if (resultado.next()) {
            // Mueve el cursor a la primera fila antes de intentar obtener valores
            String rol = resultado.getString("rol");
            System.out.println(rol);
            return rol;
        } else {
            // Si no hay resultados, devuelve un valor o lanza una excepción
            return null; // O puedes manejar el caso de que no se haya encontrado un rol
        }
    }


}
