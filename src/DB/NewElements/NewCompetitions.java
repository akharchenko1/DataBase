package DB.NewElements;

import DB.DataBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class NewCompetitions extends JFrame {
    JTextField name_field;
    JTextField id_field;
    JTextField date_field;
    JTextField sport_field;
    public NewCompetitions() {
        super("SportDB(NewSportsman)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel name = new JLabel("Фамилия Имя Отчество");
        name_field = new JTextField("Фамилия Имя Отчество", 1);
        JLabel id = new JLabel("id");
        sport_field = new JTextField("", 1);
        JLabel sport = new JLabel("Спорт");
        date_field = new JTextField("", 1);
        JLabel date = new JLabel("Дата проведения");
        id_field = new JTextField("", 1);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(5, 2, 2, 10));
        container.add(id);
        container.add(id_field);
        container.add(date);
        container.add(date_field);
        container.add(name);
        container.add(name_field);
        container.add(sport);
        container.add(sport_field);

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

            String SPORT =  id_field.getText();
            Integer sport = Integer.valueOf(SPORT);

            String DATE =  id_field.getText();
            Date date = Date.valueOf(DATE);


            DataBase m = new DataBase();
            Connection con = m.connectDatabase();
            String sql = "INSERT INTO sport.\"Competition\" (id, \"Date\", \"Name\", \"Sport\") VALUES (?, ?, ?, ?)";

// Создание запроса. Переменная con - это объект типа Connection
            try {
                PreparedStatement stmt = con.prepareStatement(sql);

// Установка параметров
                stmt.setInt(1, id);
                stmt.setDate(2, date);
                stmt.setString(3, name);
                stmt.setInt(4, sport);
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
