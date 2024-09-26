package App.UserAdministrador.ModificarUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import App.Conexio;

public class ModificarUserModel {

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
    public void modificarUsuari(int id, String username, String password, String rol) throws SQLException {
        String consulta = "UPDATE usuari SET username = ?, password = ?, rol = ? WHERE ID_USER = ?";
        PreparedStatement statement = conn.prepareStatement(consulta);
        statement.setString(1, username);
        statement.setString(2,password);
        statement.setString(3,rol);
        statement.setInt(4,id);
        statement.executeUpdate();
    }
}
