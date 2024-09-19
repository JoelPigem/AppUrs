package App.IniciSessio;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import App.Conexio;
import App.Conexio.*;

public class IniciSessioModel {


    // Método para validar el usuario y la contraseña
    public boolean validarUsuari(String usuari, String contrasenya) {
        // Consulta SQL para validar usuario y contraseña
        String sql = "SELECT username, password FROM usuari WHERE username = " + usuari + " AND password  = " + contrasenya + "; ";
        Connection conn = Conexio.CrearConexio();
        try {

                Statement sentencia;
                sentencia = conn.createStatement();

                //ResultSet sortida = null;
                ResultSet sortida = sentencia.executeQuery(sql);
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
        }

    }
