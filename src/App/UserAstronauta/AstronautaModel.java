package App.UserAstronauta;

import App.Conexio;
import App.IniciSessio.*;

import java.sql.*;

public class AstronautaModel {
    Connection conn = Conexio.CrearConexio();

    // Método para obtener el nombre del usuario que ha iniciado sesión
    public String obtenerFichaUsuario(String username) {
        StringBuilder resultado = new StringBuilder();
        try {
            // Consulta para obtener los datos del astronauta exceptuando los IDs
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

                // Formateamos el resultado para mostrarlo en la vista
                resultado.append("Nom: ").append(nombre).append("\n");
                resultado.append("Edat: ").append(edad).append("\n");
                resultado.append("Data Vol: ").append(fechaVuelo).append("\n");
                resultado.append("Missió OK: ").append(missionOk).append("\n");
                resultado.append("Sexe: ").append(sexo).append("\n");
                resultado.append("Adreça: ").append(direccion).append("\n");
                resultado.append("Rang Militar: ").append(rangoMilitar).append("\n");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado.toString();
    }

    // Método para validar las coordenadas en el formato GGG MM SS [NSEW]
    public boolean validarCoordenades(String coordenades) {
        return coordenades.matches("\\d{1,3} \\d{1,2} \\d{1,2} [NSEW]");
    }
}
