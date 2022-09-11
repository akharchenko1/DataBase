package DB.Queries;

import DB.DataBase;
import DB.Tables.Dop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Second extends JFrame{
    JTextField sport_field;
    JTextField sport_level_field;
    Container container;
    public Second(){
        super("SportDB(Second)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel sport = new JLabel("id вида спорта");
        sport_field = new JTextField("", 1);
        JLabel sport_level = new JLabel("минимальный разряд");
        sport_level_field = new JTextField("0", 1);
        container = super.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 10));
        container.add(sport);
        container.add(sport_field);
        container.add(sport_level);
        container.add(sport_level_field);
        JButton Send = new JButton("Узнать");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String SPORT = sport_field.getText();
            Integer sport = Integer.valueOf(SPORT);
            String SPORT_LEVEL = sport_level_field.getText();
            Integer sport_level = Integer.valueOf(SPORT_LEVEL);

            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM find_sportsmen(?,?)");
                stmt.setInt(1,sport);
                stmt.setInt(2,sport_level);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int count_rows = rs.getInt(1);

                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM find_sportsmen(?,?)");
                stmt2.setInt(1,sport);
                stmt2.setInt(2,sport_level);
                ResultSet rs2 = stmt2.executeQuery();
                String[][] data;
                data = new String[count_rows][4];
                for (int i = 0; i < count_rows; i++) {
                    rs2.next();
                    data[i][0] = rs2.getString(1);
                    data[i][1] = rs2.getString(2);
                    data[i][2] = rs2.getString(3);
                    data[i][3] = rs2.getString(4);
                }

                String[] columnNames = {
                        "id",
                        "Name",
                        "Sport level",
                        "Club"
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
