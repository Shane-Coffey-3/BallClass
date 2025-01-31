import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Arena extends JPanel {
    private final boolean RANDOM_ANGLE;
    private final boolean BOUNCE_OFF_BALLS;

    private ArrayList<Ball> balls = new ArrayList<>();
    
    public Arena(int numBalls, boolean randomAngle, boolean bounceOffBalls){
        setBackground(Color.blue);
        /*for(int i = 0; i < numBalls; i++) {
            double randomXSpeed = Math.random() * 4 - 2.9;
            double randomYSpeed = Math.random() * 4 - 2.9;
            int randomSize = (int) (Math.random() * 40) + 10;
            double randomX = Math.random() * (400 - randomSize);
            double randomY = Math.random() * (400 - randomSize);
            Color randomColor = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
            
            balls.add(new Ball(randomX, randomY, randomXSpeed, randomYSpeed, randomSize, randomColor));
        }*/
        balls.add(new Ball(200, 200, -1, -1, 50, Color.RED));
        balls.add(new Ball(50, 50, 1, 1, 10, Color.BLUE));
        RANDOM_ANGLE = randomAngle;
        BOUNCE_OFF_BALLS = bounceOffBalls;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        for (Ball ball : balls) {
            ball.draw(g);
            ball.move(this.getWidth(), this.getHeight());
            if(RANDOM_ANGLE) {
                ball.randomBounce(this.getWidth(), this.getHeight());
            } else {
                ball.bounce(this.getWidth(), this.getHeight());
            }

            if(BOUNCE_OFF_BALLS) {
                for(int i = 0; i < balls.size(); i++) {
                    for(int j = i + 1; j < balls.size(); j++) {
                        Ball ball1 = balls.get(i);
                        Ball ball2 = balls.get(j);
                        double distanceBetweenBalls = Math.sqrt(Math.pow(ball2.getX() - ball1.getX(), 2) + Math.pow(ball2.getY() - ball1.getY(), 2));
                        if(ball1.getSize() / 2.0 + ball2.getSize() / 2.0 > distanceBetweenBalls) {
                            double ball1XSpeed = ball1.getXSpeed();
                            double ball1YSpeed = ball1.getYSpeed();
                            ball1.setXSpeed(ball2.getXSpeed());
                            ball1.setYSpeed(ball2.getYSpeed());
                            ball2.setXSpeed(ball1XSpeed);
                            ball2.setYSpeed(ball1YSpeed);
                        }
                    }
                }
            }
        }
        
        try {
            Thread.sleep(4);
        } catch(Exception e){
            System.out.println("Exception:\n" + e);
        }
        
        
        repaint();
    }
}
