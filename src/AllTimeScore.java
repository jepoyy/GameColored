import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * AllTimeScore
 */
public class AllTimeScore extends JFrame {

    private String[] columns = {"Name", "Score"};
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JTable table;
    private Database db;
    private JPanel panel;

    public AllTimeScore (Database db){
        this.db = db;
        panel = new JPanel(new BorderLayout());
        model = new DefaultTableModel(columns,0);
        db.setModel(model);
        table = new JTable(model){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setAutoCreateColumnsFromModel(true);
        scroll = new JScrollPane(table);

        add(panel, "Center");
            panel.add(scroll);
        setTitle("Hall of Fame");
        setSize(300,200);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    }
}