package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexio {
        private static Connection conn = null;
        private static String url = "jdbc:mysql://localhost:3306/db_urs";
        private static String user = "root";
        private static String password = "123456";

        public static Connection CrearConexio(){
            try {
                conn = DriverManager.getConnection(url,user,password);
                if(!conn.isClosed()) System.out.println("La connexio s'ha establert amb exit!");
            }catch (SQLException e){
                System.out.println("La connexio ha fallat: " + e.getMessage());
            }
            return conn;
        }
}


