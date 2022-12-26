package Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleDbConnection {
    private static Connection con = null;
    static {
        String url = "jdbc:mysql:// localhost:3306/productsmanager";
        String user = "maraFx";
        String pass = "maraFx";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            System.out.println("CONNECTED !");
        }catch (SQLException e){
            e.getStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
