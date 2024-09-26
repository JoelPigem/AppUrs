package App.UserAdministrador;

import App.Conexio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserAdministradorModel {
    Connection conn = Conexio.CrearConexio();
    public Object[] obtenirUsuariPerID(int ID) throws SQLException {

        String consultaUsuari = "SELECT id_user, username, password, rol FROM usuari WHERE id_user = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(consultaUsuari);
        preparedStatement.setInt(1, ID);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            return new Object[]{
                    resultSet.getString("id_user"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("rol")
            };
        } else {
            return null;
        }
    }
    public Object[][] obtenirUsuarisPerRol(String rol) throws SQLException {
        String consultaRol = "SELECT id_user, username, password, rol FROM usuari WHERE rol = ?";
        String consultaTots = "SELECT id_user, username, password, rol FROM usuari";

        PreparedStatement preparedStatement;

        if (rol.equals("Tots")) {
            preparedStatement = conn.prepareStatement(consultaTots);
        }
        else{
            preparedStatement = conn.prepareStatement(consultaRol);
            preparedStatement.setString(1,rol);

        }
        ResultSet resultSet = preparedStatement.executeQuery();

        ArrayList<Object[]> list = new ArrayList<>();

        while (resultSet.next()) {
            list.add(new Object[]{
                    resultSet.getString("id_user"),
                    resultSet.getString("username"),
                    resultSet.getString("password"),
                    resultSet.getString("rol")
            });
        }
        return list.toArray(new Object[0][]);
    }

    public boolean eliminarUsuari(int ID) throws SQLException {
        String eliminarUsuari = "DELETE FROM usuari WHERE id_user = ?";
        PreparedStatement preparedStatement = conn.prepareStatement(eliminarUsuari);
        preparedStatement.setInt(1, ID);

        int rowsAffected = preparedStatement.executeUpdate();
        return rowsAffected > 0;
    }
}
