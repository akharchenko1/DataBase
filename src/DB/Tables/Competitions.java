package DB.Tables;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Competitions extends JFrame {
    public Competitions(){
        super("SportDB(Competitions)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DataBase m=new DataBase();
        Connection con = m.connectDatabase();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM sport.\"Competition\"");
            rs.next();
            int count_rows =rs.getInt(1);
            ResultSet rs2 = stmt.executeQuery("SELECT s.id,s.\"Date\",s.\"Name\",c.\"Name\" FROM sport.\"Competition\" s inner join sport.\"View_of_sport\" c on s.\"Sport\" = c.id");
            String[][] data;
            data= new String[count_rows][4];
            for(int i=0;i<count_rows;i++){
                rs2.next();
                data[i][0] = rs2.getString(1);
                data[i][1] = rs2.getString(2);
                data[i][2] = rs2.getString(3);
                data[i][3] = rs2.getString(4);

            }

            String[] columnNames = {
                    "id",
                    "Date",
                    "Name",
                    "Sport"
            };
            rs.close();
            rs2.close();
            stmt.close();
            Container container = super.getContentPane();
            container.setLayout(new GridLayout(2, 3, 2, 10));
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            container.add(scrollPane);
            JButton Buildings = new JButton("Building");
            JButton Results = new JButton("Results");
            JButton Organisators = new JButton("Organisators");
            container.add(Buildings);
            container.add(Results);
            container.add(Organisators);
            m.closeConnection();
        } catch(Exception e) {
            e.printStackTrace();}
    }
}
