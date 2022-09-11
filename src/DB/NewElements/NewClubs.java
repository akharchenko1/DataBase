package DB.NewElements;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewClubs extends JFrame{
    JTextField name_field;
    JTextField id_field;

    public NewClubs() {
        super("SportDB(NewClub)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel name = new JLabel("Фамилия Имя Отчество");
        name_field = new JTextField("Фамилия Имя Отчество", 1);
        JLabel id = new JLabel("id");
        id_field = new JTextField("", 1);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 10));
        container.add(name);
        container.add(name_field);
        container.add(id);
        container.add(id_field);
        JButton Send = new JButton("Отправить");
        container.add(Send);
        Send.addActionListener(new ButtonEventManager());
    }

    class ButtonEventManager implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            String name = name_field.getText();

            String ID =  id_field.getText();
            Integer id = Integer.valueOf(ID);
            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
            String sql = "INSERT INTO sport.\"Trainer\" (name, id) VALUES (?, ?)";

// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement(sql);

// Установка параметров
                stmt.setInt(2, id);
                stmt.setString(1, name);


// Выполнение запроса
                stmt.executeUpdate();
                stmt.close();
                m.closeConnection();
                dispose();
            }
            catch(Exception i) {
                i.printStackTrace();}

        }
    }
}
