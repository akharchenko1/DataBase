package DB.Tables;

import DB.DataBase;
import DB.NewElements.NewCompetitions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.*;

public class Buildings extends JFrame {
    public Buildings() {
        super("SportDB(Buildings)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        DataBase m = new DataBase();
        Connection con = m.connectDatabase();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT count(*) FROM sport.\"Building\"");
            rs.next();
            int count_rows = rs.getInt(1);
            ResultSet rs2 = stmt.executeQuery("SELECT s.id,s.\"adress\",s.\"name\",s.\"Type\" FROM sport.\"Building\" s;");
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
                    "adress",
                    "name",
                    "Type"
            };
            rs.close();
            rs2.close();
            stmt.close();
            Container container = super.getContentPane();
            container.setLayout(new GridLayout(2, 3, 2, 10));
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane(table);
            container.add(scrollPane);
            JButton Building_with_id = new JButton("Доп. информация");
            ;
            container.add(Building_with_id);

            m.closeConnection();
            Building_with_id.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.Tables.Dop dop = new Dop();
                dop.setVisible(true);
                dop.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent e) {
                        Building_with_id.setEnabled(false);
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        Building_with_id.setEnabled(true);
                    }

                    @Override
                    public void windowClosed(WindowEvent e) {

                    }

                    @Override
                    public void windowIconified(WindowEvent e) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent e) {

                    }

                    @Override
                    public void windowActivated(WindowEvent e) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent e) {

                    }
                });
            };
        }
        );


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
