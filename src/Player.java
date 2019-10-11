import java.awt.Color;
import java.util.Observable;

/**
 * Player
 */
public class Player extends Observable {

    private String name;
    protected long balance =0;
    protected long white, yellow, green, orange, blue, red;
    protected long[] colors = {white, yellow, green, orange, blue, red};
    public Player(){
        this.balance =10000;
    }

    public void setPlayerName(String name){
        this.name = name;
    }

    public String getPlayerName(){
        return name;
    }

    public long getBalance(){
        return balance;
    }

    public void wonGamble(String box1, String box2, String box3){
        
        String[] temp = {box1, box2, box3};
        int whiteAccu =0, yellowAccu =0, greenAccu =0, orangeAccu =0, blueAccu =0, redAccu =0;
        for(int x =0; x<temp.length; x++){
            switch(temp[x]){
                case "ff0000" : redAccu+=1; break;
                case "ffffff" : whiteAccu+=1; break;
                case "ffc800" : orangeAccu+=1; break;
                case "0000ff" : blueAccu+=1; break;
                case "00ff00" : greenAccu+=1; break;
                case "ffff00" : yellowAccu+=1; break;
            }
        }
            
        if(whiteAccu!=0){
            whiteAccu+=1;
            balance += (whiteAccu*white);
        } if(yellowAccu!=0){
            yellowAccu+=1;
            balance += (yellow*yellowAccu);
        } if(greenAccu!=0){
            greenAccu+=1;
            balance+= (green * greenAccu);
        } if(orangeAccu!=0){
            orangeAccu+=1;
            balance+= (orange*orangeAccu);
        } if(blueAccu!=0){
            blueAccu+=1;
            balance += (blue*blueAccu);
        } if(redAccu!=0){
            redAccu+=1;
            balance += (red*redAccu);
        }
        resetColors();
        setChanged();
        notifyObservers();
    }

    public Boolean bet(String value){
        for(int x =0; x<value.length(); x++){
            if(Character.isLetter(value.charAt(x)) || Character.isWhitespace(value.charAt(x))){
                return false;
            }
        }
        if(value.matches("[^a-z A-Z0-9]")){
            return false;
        }
        if(value.equals("")){
                return false;
        }
        Long tempVal = Long.parseLong(value);
        if(tempVal != 0 && tempVal<=this.balance && tempVal>0){
            balance-=tempVal;
            return true;
        }

        return false;
    }

    public void setColorsBet(String white, String yellow, String green, String orange, String blue, String red) {
        if(bet(white)){
            this.white = Long.parseLong(white);
        }
        if(bet(yellow)){
            this.yellow = Long.parseLong(yellow);
        }
        if(bet(green)){
            this.green = Long.parseLong(green);
        }
        if(bet(orange)){
            this.orange = Long.parseLong(orange);
        }
        if(bet(blue)){
            this.blue = Long.parseLong(blue);
        }
        if(bet(red)){
            this.red = Long.parseLong(red);
        }
        setChanged();
        notifyObservers();
    }

    public void resetColors() {
        for(int x =0; x<colors.length; x++){
            colors[x] = 0;
        }
        white =0;
        red =0;
        orange =0;
        blue =0;
        green =0;
        yellow =0;
    }

    //If player balance = 0 returns true
    public boolean CheckZero(){
        if(this.getBalance() == 0){
            return true;
        }
        return false;
    }
}