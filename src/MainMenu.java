import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame{
    private JPanel gridMain, flowMain, imagePanel;
    private JLabel gameColor, nameLabel;
    private JButton startButton;
    private JTextField nameTextField;

    public MainMenu(MainMenuController ct){

        flowMain = new JPanel();
        imagePanel = new JPanel();
        startButton = new JButton("Play!");
            startButton.addActionListener(ct);
        nameLabel = new JLabel("Input name:");
        nameTextField = new JTextField("",20);

        try{
        BufferedImage image = ImageIO.read(new File("src/edited.png"));
        gameColor = new JLabel(new ImageIcon(image));
        }catch(Exception ae){
            
        }

        add(imagePanel, "Center");
            imagePanel.add(gameColor);
        add(flowMain, "South");
            flowMain.add(nameLabel);
            flowMain.add(nameTextField);
            flowMain.add(startButton);
            super.setBackground(Color.BLACK);
            setSize(1024,768);
            setResizable(false);
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setTitle("GameColor");
    }

    public String getData(){
        return nameTextField.getText();
    }
}