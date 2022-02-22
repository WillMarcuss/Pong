import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {
        JLabel blueScore = new JLabel();
        JLabel redScore = new JLabel();
        JFrame frame = new JFrame();
        Game t = new Game(blueScore,redScore);
        blueScore.setBounds(100,100,50,50);
        blueScore.setForeground(Color.WHITE);
        redScore.setBounds(600,100,50,50);
        redScore.setForeground(Color.WHITE);
        blueScore.setText("" + t.bluetally);
        redScore.setText("" + t.redtally);
        t.add(blueScore);
        t.add(redScore);
        frame.add(t);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        t.setBackground(Color.BLACK);

    }
}
