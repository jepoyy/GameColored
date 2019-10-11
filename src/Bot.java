/**
 * Bot
 */
import java.util.Random;
public class Bot extends Player {

    private String botNames[] = {"VivianBOT", "ElsonBOT"," AndreaBOT", "ShairaBOT", "VerstellaBOT", "ReyBOT", "CrabBOT", "JakeBOT"
        , "GeorgieBOT", "PennywiseBOT", "AllanBOT", "MaloreBOT", "ErickBOT", "IanBOT", "WalterBOT", "ReeceBOT", "SamBOT", "EricaBOT",
         "AliceBOT", "DerrickBOT", "FerdinandBOT", "MagellanBOT", "LapuBOT", "HatdogBOT", "ReidBOT", "AlbertoBOT", "SpongebobBOT", "TrojanBOT",
          "GeeseBOT", "PepeBOT", "JeffBOT", "VademBOT", "LambertoBOT","KyleBOT", "RolandBOT", "AlucardBOT", "AtopBOT", "PatrickBOT","Aurelia","Alexandra","MaximusBOT" };
    private Random rand;

    public Bot(){
        super();
        rand = new Random();
        super.setPlayerName(botNames[rand.nextInt(botNames.length)]);
    }

    
    public void botBet() {
        for(int x = 0; x<rand.nextInt(this.colors.length); x++){
            if(super.getBalance()!=0){
                int tempBal = (int) super.getBalance();
                int temp = rand.nextInt(tempBal);
                this.colors[x] += temp;
                this.balance-= temp;
            }
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public void wonGamble(String box1,String box2, String box3){
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
            balance += whiteAccu*this.colors[0];
        }else if(yellowAccu!=0){
            yellowAccu+=1;
            balance += yellow*this.colors[1];
        }else if(greenAccu!=0){
            greenAccu+=1;
            balance+= green * this.colors[2];
        }else if(orangeAccu!=0){
            orangeAccu+=1;
            balance+= orange*this.colors[3];
        }else if(blueAccu!=0){
            blue+=1;
            balance += blue*this.colors[4];
        }else if(redAccu!=0){
            red+=1;
            balance += red*this.colors[5];
        }

        CheckZero();

        resetColors();
        setChanged();
        notifyObservers();
    }

    //If player balance = 0 returns true
    @Override
    public boolean CheckZero(){
        if(this.getBalance() == 0 ||this.getBalance() == 1){
            super.setPlayerName(botNames[rand.nextInt(botNames.length)]);
            setBalance();
            return true;
        }
        return false;
    }

    public void setBalance(){
        this.balance = 10000;
    }
}