package DB.NewElements;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class NewSportsmen extends JFrame {
    JTextField name_field;
    JTextField id_field;
    JTextField sport_level_field;
    JTextField club_field;
    public NewSportsmen() {
        super("SportDB(NewSportsman)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel name = new JLabel("Фамилия Имя Отчество");
        name_field = new JTextField("Фамилия Имя Отчество", 1);
        JLabel id = new JLabel("id");
        sport_level_field = new JTextField("", 1);
        JLabel sport_level = new JLabel("Спортивный уровень");
        club_field = new JTextField("", 1);
        JLabel club = new JLabel("id клуба");
        id_field = new JTextField("", 1);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));
        container.add(id);
        container.add(id_field);
        container.add(name);
        container.add(name_field);
        container.add(sport_level);
        container.add(sport_level_field);
        container.add(club);
        container.add(club_field);
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

            String SPORT_LEVEL =  id_field.getText();
            Integer sport_level = Integer.valueOf(SPORT_LEVEL);

            String CLUB =  id_field.getText();
            Integer club = Integer.valueOf(CLUB);

            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
            String sql = "INSERT INTO sport.\"Sportsmen\" (id, name, \"Sport_level\", \"Club\") VALUES (?, ?, ?, ?)";

// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement(sql);

// Установка параметров
                stmt.setInt(1, id);
                stmt.setString(2, name);
                stmt.setInt(3, sport_level);
                stmt.setInt(4, club);
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
