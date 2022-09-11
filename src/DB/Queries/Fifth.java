package DB.Queries;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Fifth extends JFrame {
    JTextField sportsmen_field;

    Container container;
    public Fifth(){
        super("SportDB(Fifth)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel sportsmen = new JLabel("id спортсмена");
        sportsmen_field = new JTextField("", 1);
        container = super.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 10));
        container.add(sportsmen);
        container.add(sportsmen_field);
        JButton Send = new JButton("Узнать");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String SPORTSMEN = sportsmen_field.getText();
            Integer sportsmen = Integer.valueOf(SPORTSMEN);

            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM find_trainers_of_sportsman(?)");
                stmt.setInt(1,sportsmen);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int count_rows = rs.getInt(1);

                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM find_trainers_of_sportsman(?)");
                stmt2.setInt(1,sportsmen);

                ResultSet rs2 = stmt2.executeQuery();
                String[][] data;
                data = new String[count_rows][2];
                for (int i = 0; i < count_rows; i++) {
                    rs2.next();
                    data[i][0] = rs2.getString(1);
                    data[i][1] = rs2.getString(2);

                }

                String[] columnNames = {
                        "id",
                        "Name",
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
