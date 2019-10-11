/**
 * DicePaint
 */
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class DicePaint extends JPanel{
    private Random rand = new Random();
    private Color[] colors ={Color.white, Color.YELLOW,Color.GREEN, Color.ORANGE, Color.BLUE, Color.red};
    public Color boxColor;

    public void paint(Graphics g){
        super.paint(g);
        g.setColor(colors[rand.nextInt(colors.length)]);
        this.boxColor = g.getColor();
        g.fillRect(120, 100, 100,100);
        g.setColor(Color.BLACK);
        g.drawRect(120, 100, 100,100);   
    }

    public String getBoxColor(){
        return getHexColor(this.boxColor);
    }
    
    //Converts Color into Hex
    public String getHexColor(Color boxColor){
        String hex = Integer.toHexString(boxColor.getRGB());  
        hex = hex.substring(2, hex.length());
        return hex;
    }
}