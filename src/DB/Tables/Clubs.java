package DB.Tables;

import DB.DataBase;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Clubs extends JFrame {
    public Clubs(){
        super("SportDB(Clubs)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DataBase m=new DataBase();
        Connection con = m.connectDatabase();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM sport.\"Sport_club\"");
            rs.next();
            int count_rows =rs.getInt(1);
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM sport.\"Sport_club\"");
            String[][] data;
            data= new String[count_rows][2];
            for(int i=0;i<count_rows;i++){
                rs2.next();
                data[i][0] = rs2.getString(1);
                data[i][1] = rs2.getString(2);

            }

            String[] columnNames = {
                    "Name",
                    "id"
            };
            rs.close();
            rs2.close();
            stmt.close();
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            super.getContentPane().add(scrollPane);
            m.closeConnection();
        } catch(Exception e) {
            e.printStackTrace();}

    }
}
