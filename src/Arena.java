import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Arena extends JPanel {
    public static final boolean RANDOM_ANGLE = true;
    private ArrayList<Ball> balls = new ArrayList<>();
    
    public Arena(int numBalls){
        setBackground(Color.blue);
        for(int i = 0; i < numBalls; i++) {
            double randomX = Math.random() * this.getWidth();
            double randomY = Math.random() * this.getHeight();
            double randomXSpeed = Math.random() * 4 - 2.9;
            double randomYSpeed = Math.random() * 4 - 2.9;
            int randomSize = (int) (Math.random() * 40) + 10;
            Color randomColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
            
            balls.add(new Ball(randomX, randomY, randomXSpeed, randomYSpeed, randomSize, randomColor));
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (Ball ball : balls) {
            ball.draw(g);
            ball.move();
            if(RANDOM_ANGLE) {
                ball.randomBounce(this.getWidth(), this.getHeight());
            } else {
                ball.bounce(this.getWidth(), this.getHeight());
            }
        }
        
        try {
            Thread.sleep(4);
        } catch(Exception e){}
        
        
        repaint();
    }
}
