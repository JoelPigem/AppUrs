package App.UserAstronauta;

import App.Conexio;

import java.sql.*;

public class AstronautaModel {
    Connection conn = Conexio.CrearConexio();

    public String obtenerFichaUsuario(String username) {
        StringBuilder resultado = new StringBuilder();
        try {
            String query = "SELECT NOM, EDAT, DATA_VOL, MISSION_OK, SEXE, ADRECA, RANG_MILITAR " +
                    "FROM ASTRONAUTA JOIN usuari ON usuari.ID_USER = astronauta.ID_USER WHERE usuari.username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("NOM");
                int edad = rs.getInt("EDAT");
                Date fechaVuelo = rs.getDate("DATA_VOL");
                String missionOk = rs.getString("MISSION_OK");
                String sexo = rs.getString("SEXE");
                String direccion = rs.getString("ADRECA");
                String rangoMilitar = rs.getString("RANG_MILITAR");

                resultado.append("<html>");
                resultado.append("<span style='color:white;'>");

                resultado.append("Nom: ").append(nombre).append("<br>");
                resultado.append("Edat: ").append(edad).append("<br>");
                resultado.append("Data Vol: ").append(fechaVuelo).append("<br>");
                resultado.append("Missió OK: ").append(missionOk).append("<br>");
                resultado.append("Sexe: ").append(sexo).append("<br>");
                resultado.append("Adreça: ").append(direccion).append("<br>");
                resultado.append("Rang Militar: ").append(rangoMilitar).append("<br>");

                resultado.append("</span>");
                resultado.append("</html>");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado.toString();
    }

    public int obtenerIdAstronauta(String username) {
        int idAstronauta = -1;
        try {
            String query = "SELECT ASTRONAUTA.ID_ASTRONAUTA " +
                    "FROM ASTRONAUTA JOIN USUARI ON ASTRONAUTA.ID_USER = USUARI.ID_USER " +
                    "WHERE USUARI.USERNAME = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idAstronauta = rs.getInt("ID_ASTRONAUTA");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idAstronauta;
    }

    public boolean validarCoordenades(String coordenades) {
        return coordenades.matches("\\d{1,3} \\d{1,2} \\d{1,2} [NSEW]");
    }

    public void insertarCoordenades(String username, String coordenades) {
        try {
            String queryId = "SELECT ID_USER FROM USUARI WHERE username = ?";
            PreparedStatement stmtId = conn.prepareStatement(queryId);
            stmtId.setString(1, username);
            ResultSet rsId = stmtId.executeQuery();

            if (rsId.next()) {
                int idUser = rsId.getInt("ID_USER");

                String insertQuery = "INSERT INTO COORDENADES (ID_ASTRONAUTA, COORDENADA, DATA_ENVIAMENT) VALUES (?, ?, NOW())";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setInt(1, idUser);
                insertStmt.setString(2, coordenades);
                insertStmt.executeUpdate();
                insertStmt.close();
            }
            rsId.close();
            stmtId.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarMissatgeEncriptat(String username, String missatge) {
        String missatgeEncriptat = eliminarVocals(missatge);
        try {
            String queryId = "SELECT ID_USER FROM USUARI WHERE username = ?";
            PreparedStatement stmtId = conn.prepareStatement(queryId);
            stmtId.setString(1, username);
            ResultSet rsId = stmtId.executeQuery();

            if (rsId.next()) {
                int idUser = rsId.getInt("ID_USER");

                String insertQuery = "INSERT INTO msg_encr_astronauta (ID_ASTRONAUTA, MISSATGE_ENCRIPTAT, DATA_ENVIAMENT) VALUES (?, ?, NOW())";
                PreparedStatement insertStmt = conn.prepareStatement(insertQuery);
                insertStmt.setInt(1, idUser);
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

    public String eliminarVocals(String missatge) {
        return missatge.replaceAll("[aeiouAEIOU]", "");
    }

    public int obtenirID(String username) throws SQLException {

        String sql = "select ID_USER from usuari where username = ?";
        Connection conn = Conexio.CrearConexio();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);

        ResultSet rs = ps.executeQuery();

        int a = 0;

        while(rs.next()){
            a = rs.getInt("ID_USER");
        }

        return a;
    }

    public void fitxarEntrada(int id) throws SQLException {
        String sql = "update usuari set fitxar = true where id_user = ?";
        Connection con = Conexio.CrearConexio();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
    }

    public void fitxarSortida(int id) throws SQLException {
        String sql = "update usuari set fitxar = false where id_user = ?";
        Connection con = Conexio.CrearConexio();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
    }
}
