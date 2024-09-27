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


}
