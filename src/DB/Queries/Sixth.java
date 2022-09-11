package DB.Queries;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sixth extends JFrame {
    JTextField first_date_field;
    JTextField second_date_field;
    JTextField organisator_field;

    Container container;
    public Sixth(){
        super("SportDB(Second)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel first_date = new JLabel("от даты");
        first_date_field = new JTextField("0001-01-01", 1);
        JLabel second_date = new JLabel("до даты");
        second_date_field = new JTextField("0001-01-01", 1);
        JLabel organisator = new JLabel("id организатора");
        organisator_field = new JTextField("0", 1);
        container = super.getContentPane();
        container.setLayout(new GridLayout(4, 2, 2, 10));
        container.add(first_date);
        container.add(first_date_field);
        container.add(second_date);
        container.add(second_date_field);
        container.add(organisator);
        container.add(organisator_field);
        JButton Send = new JButton("Узнать");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String FD = first_date_field.getText();
            Date fd = Date.valueOf(FD);
            String SD = second_date_field.getText();
            Date sd = Date.valueOf(SD);
            String O = organisator_field.getText();
            Integer o = Integer.valueOf(O);
            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM find_competition_of_date(?,?,?)");
                stmt.setDate(1,fd);
                stmt.setDate(2,sd);
                stmt.setInt(3,o);

                ResultSet rs = stmt.executeQuery();
                rs.next();
                int count_rows = rs.getInt(1);

                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM find_competition_of_date(?,?,?)");
                stmt2.setDate(1,fd);
                stmt2.setDate(2,sd);
                stmt2.setInt(3,o);
                ResultSet rs2 = stmt2.executeQuery();
                String[][] data;
                data = new String[count_rows][5];
                for (int i = 0; i < count_rows; i++) {
                    rs2.next();
                    data[i][0] = rs2.getString(1);
                    data[i][1] = rs2.getString(2);
                    data[i][2] = rs2.getString(3);
                    data[i][3] = rs2.getString(4);
                    data[i][4] = rs2.getString(5);
                }

                String[] columnNames = {
                        "id",
                        "Name",
                        "Date",
                        "id Org",
                        "Organisator"

                };
                rs.close();
                rs2.close();
                stmt.close();
                stmt2.close();
                //JTable table = new JTable(data, columnNames);
                //JScrollPane scrollPane = new JScrollPane(table);
                //container.add(scrollPane);

                //JTable table = new JTable(data, columnNames);
                //JScrollPane scrollPane = new JScrollPane(table);
                // Container cont = super.getContentPane();
                // cont.setLayout(new ScrollPaneLayout());
                //cont.add(table);
                DB.Table j = new DB.Table(data,columnNames);
                j.setVisible(true);
                m.closeConnection();
            } catch (Exception i) {
                i.printStackTrace();
            }
        }

    }

}
