package App.UserEspia;

import java.sql.*;
import App.Conexio;

public class EspiaModel {
    private Connection conn;

    public EspiaModel() {
        conn = Conexio.CrearConexio();
    }

    // Método para obtener la ficha del Espía desde la base de datos
    public String obtenerFichaUsuario(String username) {
        StringBuilder ficha = new StringBuilder();
        try {
            String query = "SELECT * FROM USUARI WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ficha.append("Username: ").append(rs.getString("username")).append(", ");
                ficha.append("Rol: ").append(rs.getString("rol")).append(", ");
                // Añadir más campos según la tabla USUARI
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ficha.toString();
    }

    // Método para insertar el mensaje encriptado en la base de datos
    public void insertarMissatgeEncriptat(String username, String missatge) {
        String missatgeEncriptat = eliminarConsonantes(missatge);
        try {
            // Obtener ID_USER del username
            String queryId = "SELECT ID_USER FROM USUARI WHERE username = ?";
            PreparedStatement stmtId = conn.prepareStatement(queryId);
            stmtId.setString(1, username);
            ResultSet rsId = stmtId.executeQuery();

            if (rsId.next()) {
                int idEspia = rsId.getInt("ID_USER");

                // Insertar mensaje en la tabla MISSATGES_ENCRIPTATS
                String insertQuery = "INSERT INTO MISSATGES_ENCRIPTATS_ESPIES (ID_ESPIA, MISSATGE_ENCRIPTAT, DATA_ENVIAMENT) VALUES (?, ?, NOW())";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setInt(1, idEspia);
                insertStmt.setString(2, missatgeEncriptat);
                insertStmt.executeUpdate();
                insertStmt.close();
            }
            rsId.close();
            stmtId.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar las consonantes de un mensaje
    public String eliminarConsonantes(String missatge) {
        return missatge.replaceAll("[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", ""); // Eliminar todas las consonantes
    }
}
