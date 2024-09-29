package App.Mecanic;

import App.Conexio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MecanicModel {

    public void imprimirLlista(Object[][] cotxes){
        String fitxer = "C:\\Users\\raull\\IdeaProjects\\AppUrs\\src\\App\\Mecanic\\llista.txt";

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fitxer));
            for(Object[] fila : cotxes){
                for(Object dato : fila){
                    bufferedWriter.write(dato.toString() + "\t");
                }
                bufferedWriter.newLine();
            }

            bufferedWriter.close();

            System.out.println("contenido escrito");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Object[][] llistarCotxes() throws SQLException {

        Connection conn = Conexio.CrearConexio();
        String sql = "select * from cotxes";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList<Object[]> cotxesList = new ArrayList<>();

        while(rs.next()) {
            cotxesList.add(new Object[]{
                    rs.getInt("ID_MECANIC"),
                    rs.getInt("ID_COTXE"),
                    rs.getString("MARCA"),
                    rs.getString("MODEL"),
                    rs.getString("PROBLEMA")
            });
        }
        return cotxesList.toArray(new Object[0][]);
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


    public int obtenirID(String username, String password) throws SQLException {

        String sql = "select ID_USER from usuari where username = ? and password = ?";
        Connection conn = Conexio.CrearConexio();

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();

        int a = 0;

        while(rs.next()){
            a = rs.getInt("ID_USER");
        }

        return a;
    }

    public String obtenerFichaUsuario(String username) {
        Connection conn = Conexio.CrearConexio();
        StringBuilder ficha = new StringBuilder();
        try {
            String query = "SELECT u.ID_USER, m.ID_MECANIC, m.NOM, m.SALARI, m.EDAT, m.NUM_TALLER, m.ADRECA, m.ANYS_EXP, m.CIUTAT, m.SEXE " +
                    "FROM MECANIC m " +
                    "JOIN USUARI u ON u.ID_USER = m.ID_USER " +
                    "WHERE u.username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                ficha.append("ID_Usuari: ").append(rs.getString("id_user")).append(", ");
                ficha.append("ID_Mecanic: ").append(rs.getString("id_mecanic")).append(", ");
                ficha.append("Nom: ").append(rs.getString("nom")).append(", ");
                ficha.append("Salari: ").append(rs.getDouble("salari")).append(", ");
                ficha.append("Edat: ").append(rs.getInt("edat")).append(", ");
                ficha.append("NumTaller: ").append(rs.getInt("num_taller")).append(", ");
                ficha.append("Adreça: ").append(rs.getString("adreca")).append(", ");
                ficha.append("Any Exp: ").append(rs.getString("anys_exp")).append(", ");
                ficha.append("Ciutat: ").append(rs.getString("ciutat")).append(", ");
                ficha.append("Sexe: ").append(rs.getString("sexe")).append(", ");
                // Añadir más campos según la tabla USUARI
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ficha.toString();
    }


}
