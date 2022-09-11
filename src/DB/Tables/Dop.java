package DB.Tables;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Dop extends JFrame {
    JTextField id_field;
    public Dop() {
        super("SportDB(Buildings)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel id = new JLabel("id заинтересовавшего строения");
        id_field = new JTextField("", 1);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(2, 2, 2, 10));
        container.add(id);
        container.add(id_field);
        DataBase m = new DataBase();
        Connection con = m.connectDatabase();
    JButton Send = new JButton("Узнать");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());
}

class ButtonEventManager implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {




        String ID =  id_field.getText();
        Integer ids = Integer.valueOf(ID);


        DataBase m = new DataBase();
        Connection con = m.connectDatabase();
        String sql = "SELECT \"Type\" FROM sport.\"Building\" WHERE id = ?";

// Создание запроса. Переменная con - это объект типа Connection
        try {
            PreparedStatement stmt = con.prepareStatement(sql);

// Установка параметров
            stmt.setInt(1, ids);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String type = rs.getString(1);
            stmt.close();
// Выполнение запроса


            if (type.equals("swimming pool"))
            {
                String sql2 = "SELECT * FROM sport.\"swimming_pool\" WHERE id = ?";
                PreparedStatement stmt2 = con.prepareStatement(sql2);
                stmt2.setInt(1, ids);
                ResultSet ps = stmt2.executeQuery();
                while(ps.next())
                {String str = "id :" + ps.getString(1);
                String str2 = "Long :" + ps.getString(2);
                String str3 = "count_road :" + ps.getString(3);
                JOptionPane.showMessageDialog(null,  str + "\n" + str2 + "\n" + str3, "DOP", JOptionPane.PLAIN_MESSAGE );}
                stmt2.close();
            }
            m.closeConnection();
            dispose();
        }
        catch(Exception i) {
            i.printStackTrace();}

    }
}
}
