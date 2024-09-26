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
        String sql = "update table usuari set fitxar = true where id_user = ?";
        Connection con = Conexio.CrearConexio();

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();
    }

    public int obtenirID(String username, String password) throws SQLException {
        Connection conn = Conexio.CrearConexio();
        String sql = "select ID from usuario where username = ? and password = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();

        return rs.getInt("ID");
    }


}
