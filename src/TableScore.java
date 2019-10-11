import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * TableScore
 */
public class TableScore extends JFrame implements Observer {

    private Player playerName; 
    private Bot bot1Name, bot2Name, bot3Name, bot4Name,bot5Name;
    private JTable table;
    private JPanel mainPanel;
    private DefaultTableModel model;
    private String[] columns = {"Player", "Balance"};
    private JScrollPane scroll;

    public TableScore(Player playerName, Bot bot1Name, Bot bot2Name, Bot bot3Name, Bot bot4Name, Bot bot5Name){
        this.playerName = playerName;
        this.bot1Name = bot1Name;
        this.bot2Name = bot2Name;
        this.bot3Name = bot3Name;
        this.bot4Name = bot4Name;
        this.bot5Name = bot5Name;
        model = new DefaultTableModel(columns,0);
        table = new JTable(model){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setAutoCreateColumnsFromModel(true);
        scroll = new JScrollPane(table);
        mainPanel = new JPanel(new BorderLayout());
        add(mainPanel);
            mainPanel.add(scroll, BorderLayout.CENTER);
        setTitle("ScoreBoard");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        reloadModel();
    }

    public void update(Observable observer, Object args){
        model.setRowCount(0);
        reloadModel();
    }

    public void reloadModel(){
        model.addRow(new Object[]{playerName.getPlayerName(), playerName.getBalance()});
        model.addRow(new Object[]{bot1Name.getPlayerName(), bot1Name.getBalance()});
        model.addRow(new Object[]{bot2Name.getPlayerName(), bot2Name.getBalance()});
        model.addRow(new Object[]{bot3Name.getPlayerName(), bot3Name.getBalance()});
        model.addRow(new Object[]{bot4Name.getPlayerName(), bot4Name.getBalance()});
        model.addRow(new Object[]{bot5Name.getPlayerName(), bot5Name.getBalance()});
    }
}