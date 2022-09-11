package DB.Queries;

import DB.BuildingTypes.Stadium;
import DB.BuildingTypes.SwimmingPool;
import DB.DataBase;
import DB.Tables.SportViews;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class First extends JFrame {

    public First() {
        super("SportDB(First)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Container container = super.getContentPane();
        container.setLayout(new GridLayout(1, 2, 2, 10));

        JButton SP = new JButton("Бассейн");
        JButton ST = new JButton("Стадион");
        container.add(SP);
        container.add(ST);
        ST.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.BuildingTypes.Stadium stadium = new Stadium();
                stadium.setVisible(true);
            }
        });
        SP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB.BuildingTypes.SwimmingPool swimmingPool = new SwimmingPool();
                swimmingPool.setVisible(true);
            }
        });

    }

}
