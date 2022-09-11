package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DataBase {

    String url = "jdbc:postgresql://localhost:5432/sportDB";
    String login = "postgres";
    String password = "05042001";
    Connection con;
    public void DataBase(){
    }

    public Connection connectDatabase() {
        try {
            Class.forName("org.postgresql.Driver");
             con = DriverManager.getConnection(url, login, password);
             return con;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public void closeConnection() {
        try {
            con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
 /*       try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM JC_CONTACT");
        while (rs.next()) {
        String str = rs.getString("contact_id") + ":" + rs.getString(2);
        System.out.println("Contact:" + str);
        }
        rs.close();
        stmt.close();
        } finally { }*/