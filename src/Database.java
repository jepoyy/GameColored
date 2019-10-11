import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 * Database
 */
public class Database {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/gamecolor";

    static final String username = "root";
    static final String password = "";
    private Statement stmt;
    private Connection conn;
    
    public Database(){
        
    }

    public DefaultTableModel setModel(DefaultTableModel model) {
        
        model.setRowCount(0);
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, username, password);

            stmt = conn.createStatement();
            String sql = "SELECT Name, Score FROM halloffame ORDER BY Score DESC";
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                String name = rs.getString("Name");
                int score = rs.getInt("Score");
                model.addRow(new Object[] {name, Integer.toString(score)});
            }
            
        }catch(Exception ae){
            
        }
        return model;
    }

    public void executeCommands(Player thisPlayer){
        try{
            stmt.executeUpdate(String.format("INSERT INTO halloffame(Name,Score) Values ('%s', '%d')",thisPlayer.getPlayerName(), thisPlayer.getBalance()));
        }catch (Exception ae){    
            
        }
    }
}