import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Game extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(5,this);
    double x=1,y=1,velx=0,vely=0,x2=779,y2=1,velx2=0,vely2=0,ballx=400,bally=400,velballx=1.5,velbally=1.5;
    public int bluetally = 0;
    public int redtally = 0;
    JLabel blueScore;
    JLabel redScore;
    public Game(JLabel blueScore,JLabel redScore){
        this.redScore = redScore;
        this.blueScore = blueScore;
        timer.start();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }
    public void paintComponent(Graphics g){
        if (y >= 561){
            y=561;
        } else if(y<=0){
            y=0;
        }
        if (y2 >= 561){
            y2=561;
        } else if(y2<=0){
            y2=0;
        }

        if (bally <= 0 || bally >= 560){
            velbally = -velbally;
        }
        else if (ballx <=0){
            ballx = 400;
            bally = 400;
            velballx = -velballx;
            redtally++;
            redScore.setText(""+redtally);
        }
        else if(ballx >= 790){
            ballx = 400;
            bally = 400;
            velballx = -velballx;
            bluetally++;
            blueScore.setText(""+bluetally);

        }

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Graphics2D GG = (Graphics2D) g;
        Graphics2D Ball = (Graphics2D) g;
        GG.setColor(Color.RED);
        GG.fill(new Rectangle2D.Double(x2,y2,20,65));
        g2.setColor(Color.BLUE);
        g2.fill(new Rectangle2D.Double(x,y,20,65));
        Ball.setColor(Color.WHITE);
        Ball.fill(new Ellipse2D.Double(ballx,bally,10,10));



        Rectangle col1 = new Rectangle();
        Rectangle col2 = new Rectangle();
        Rectangle col3 = new Rectangle();



        col1.setBounds((int)x,(int)y,20,65);
        col2.setBounds((int)x2,(int)y2,20,65);
        col3.setBounds((int)ballx,(int)bally,10,10);

        if (col3.intersects(col1)|| col3.intersects(col2)){
            velballx = -velballx;
        }



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        x2+=velx2;
        y2+=vely2;
        x+=velx;
        y+=vely;
        ballx += velballx;
        bally+=velbally;

    }

    public void up(){
        vely = -1.5;
        velx = 0;
    }
    public void down(){
        vely = 1.5;
        velx = 0;
    }
    public void up2(){
        vely2 = -1.5;
        velx2 = 0;
    }
    public void down2(){
        vely2 = 1.5;
        velx2 = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            up2();
        }
        if(code == KeyEvent.VK_S){
            down2();
        }

        if(code == KeyEvent.VK_UP){
            up();
        }
        if(code == KeyEvent.VK_DOWN){
            down();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W || code == KeyEvent.VK_S){
            velx2 = 0;
            vely2 = 0;
        }
        else {
            velx = 0;
            vely = 0;
        }

    }
}
