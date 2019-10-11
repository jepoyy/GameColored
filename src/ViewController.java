/**
 * ViewController
 */
import java.awt.event.*;
import javax.swing.*;

public class ViewController implements ActionListener, InterfaceView {

    private Database db;
    private View view;
    private MainMenuController mainMenuController;
    private TableScore tableScore;
    private Player player;
    private Bot bot1, bot2, bot3, bot4, bot5;

    public ViewController(Database db, View view, MainMenuController mainMenuController){
        this.db = db;
        this.view = new View(this);
        this.mainMenuController = mainMenuController;
        this.player = new Player();
        setupTableScore();
        show();
    }

    public void actionPerformed (ActionEvent ae){
        JButton source = (JButton) ae.getSource();
            if(source.getText().equals("Roll")){
                        view.t=100;
                        view.time.start();
                        view.rollButton.setText("Stop");
            }
            else if(source.getText().equals("Stop")){
                    view.time.stop();
                    view.rollButton.setText("Roll");
                    player.setColorsBet(view.tfw.getText(), view.tfy.getText(), view.tfg.getText(), view.tfo.getText(), view.tfb.getText(), view.tfr.getText());
                    player.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
                    botAuto();
            }
            else if(source.getText().equals("Quit")){
                db.executeCommands(player);
                hide();
            }

            
    }

    public void setupTableScore(){
        player.setPlayerName(mainMenuController.getName());
        bot1 = new Bot();
        bot2 = new Bot();
        bot3 = new Bot();
        bot4 = new Bot();
        bot5 = new Bot();
        this.tableScore = new TableScore(player, bot1, bot2, bot3, bot4, bot5);
        player.addObserver(tableScore);
        bot1.addObserver(tableScore);
        bot2.addObserver(tableScore);
        bot3.addObserver(tableScore);
        bot4.addObserver(tableScore);
        bot5.addObserver(tableScore);
    }

    public void show(){
        view.setVisible(true);
        tableScore.setVisible(true);
        mainMenuController.hide();
    }

    public void hide(){
        view.setVisible(false);
        tableScore.setVisible(false);
        mainMenuController.show();
        view.dispose();
        tableScore.dispose();
        
    }

    public void botAuto(){
        bot1.botBet();
        bot2.botBet();
        bot3.botBet();
        bot4.botBet();
        bot5.botBet();
        bot1.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
        bot2.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
        bot3.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
        bot4.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
        bot5.wonGamble(view.box1.getBoxColor(), view.box2.getBoxColor(), view.box3.getBoxColor());
    }

    private void labeler(){
        if(view.t==0){
            view.time.stop();
            view.rollButton.setText("Roll");
        }
        view.t-=1;
    }

}