import java.awt.event.*;
import javax.swing.*;
/**
 * MainMenuController
 */
public class MainMenuController implements ActionListener, InterfaceView {

    private Database db;
    private MainMenu mainMenu;
    private View view;
    private AllTimeScore allTimeScore;

    public MainMenuController(){
        this.db = new Database();
        this.mainMenu = new MainMenu(this);
        show();
    }

    public void actionPerformed (ActionEvent ae){
        if(!mainMenu.getData().isEmpty()){
            new ViewController(db, view, this);
        }else
            JOptionPane.showMessageDialog(null, "Invalid Name");
    }

    public void show(){
        mainMenu.setVisible(true);
        this.allTimeScore = new AllTimeScore(db);
        allTimeScore.setVisible(true);
    }

    public void hide(){
        mainMenu.setVisible(false);
        allTimeScore.setVisible(false);
        allTimeScore.dispose();
    }

    public String getName(){
        return mainMenu.getData();
    }
}