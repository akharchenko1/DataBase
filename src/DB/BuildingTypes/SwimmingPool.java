package DB.BuildingTypes;

import DB.DataBase;
import DB.Queries.Second;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SwimmingPool extends JFrame {
    JTextField long_field;
    JTextField cr_field;
    Container container;
    public SwimmingPool(){
        super("SportDB(SwimmingPool)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel longing = new JLabel("Длина дорожки");
        long_field = new JTextField("0", 1);
        JLabel cr = new JLabel("Кол-во дорожек");
        cr_field = new JTextField("0", 1);
        container = super.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 10));
        container.add(longing);
        container.add(long_field);
        container.add(cr);
        container.add(cr_field);
        JButton Send = new JButton("Узнать");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());

    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String LONG = long_field.getText();
            Integer longing = Integer.valueOf(LONG);
            String CR = cr_field.getText();
            Integer cr = Integer.valueOf(CR);

            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement("SELECT count(*) FROM find_buildings(?,?,?)");
                stmt.setString(1,"swimming pool");
                stmt.setInt(2,longing);
                stmt.setInt(3,cr);
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int count_rows = rs.getInt(1);

                PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM find_buildings(?,?,?)");
                stmt2.setString(1,"swimming pool");
                stmt2.setInt(2,longing);
                stmt2.setInt(3,cr);
                ResultSet rs2 = stmt2.executeQuery();
                String[][] data;
                data = new String[count_rows][3];
                for (int i = 0; i < count_rows; i++) {
                    rs2.next();
                    data[i][0] = rs2.getString(1);
                    data[i][1] = rs2.getString(2);
                    data[i][2] = rs2.getString(3);
                }

                String[] columnNames = {
                        "id",
                        "Adress",
                        "Name"
                };
                rs.close();
                rs2.close();
                stmt.close();
                stmt2.close();

                DB.Table j = new DB.Table(data,columnNames);
                j.setVisible(true);
                m.closeConnection();
            } catch (Exception i) {
                i.printStackTrace();
            }
        }

    }

}

