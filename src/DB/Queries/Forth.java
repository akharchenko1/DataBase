package DB.Queries;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Forth extends JFrame {
    JTextField sport_field;
    JTextField sport_level_field;
    Container container;
    public Forth(){
        super("SportDB(Forth)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DataBase m=new DataBase();
        Connection con = m.connectDatabase();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM find_sportsmen_with_sports()");
            rs.next();
            int count_rows =rs.getInt(1);
            ResultSet rs2 = stmt.executeQuery("SELECT * FROM find_sportsmen_with_sports()");
            String[][] data;
            data= new String[count_rows][6];
            for(int i=0;i<count_rows;i++){
                rs2.next();
                data[i][0] = rs2.getString(1);
                data[i][1] = rs2.getString(2);
                data[i][2] = rs2.getString(3);
                data[i][3] = rs2.getString(4);
                data[i][4] = rs2.getString(5);
                data[i][5] = rs2.getString(6);
            }

            String[] columnNames = {
                    "id" ,
                    "name" ,
                    "sport_level",
                    "club" ,
                    "sports" ,
                    "sport_name"
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
