package DB;

import javax.swing.*;

public class Table extends JFrame {
    public Table(String[][] data, String[] Names) {
        super("SportDB(TableSec)");
        super.setBounds(200, 100, 600, 400);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JTable table = new JTable(data, Names);
        JScrollPane scrollPane = new JScrollPane(table);
        super.getContentPane().add(scrollPane);
    }
}
