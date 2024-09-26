package App.UserAdministrador.AfegirUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import App.Conexio;
public class AfegirUserModel {

    public void afegirUsuari(String nom, String password, String rol) throws SQLException {
        Connection conn = Conexio.CrearConexio();
        String sql = "INSERT INTO usuari (username, password, rol) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, nom);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, rol);

        preparedStatement.executeUpdate();
        conn.close();

    }
}
