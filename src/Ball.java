import java.awt.*;
public class Ball {

    private double x, y, xSpeed, ySpeed, size;
    private Color color;

    public Ball(double x, double y, double xSpeed, double ySpeed, double size, Color color){
        this.x=x;
        this.y=y;
        this.xSpeed=xSpeed;
        this.ySpeed = ySpeed;
        this.size=size;
        this.color=color;
    }

    public void draw(Graphics g) {
        g.fillOval((int) x, (int) y, (int) size, (int) size);
        g.setColor(color);
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounce(int width, int height) {
        if(this.getX() + this.getSize() > width) {
            this.setXSpeed(-this.getXSpeed());
        } else if(this.getX() < 0) {
            this.setXSpeed(-this.getXSpeed());
        }

        if(this.getY() + this.getSize() > height) {
            this.setYSpeed(-this.getYSpeed());
        } else if(this.getY() < 0) {
            this.setYSpeed(-this.getYSpeed());
        }
    }

    public void randomBounce(int width, int height) {
        double speed = Math.sqrt(Math.pow(xSpeed, 2) + Math.pow(ySpeed, 2));
        if(this.getX() + this.getSize() > width) {

        } else if(this.getX() < 0) {

        }

        if(this.getY() + this.getSize() > height) {
            this.setYSpeed(-this.getYSpeed());
        } else if(this.getY() < 0) {
            this.setYSpeed(-this.getYSpeed());
        }
    }


    public Color getColor(){
        return color;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getXSpeed() {
        return xSpeed;
    }

    public double getYSpeed() {
        return ySpeed;
    }

    public double getSize() {
        return size;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setXSpeed(double xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(double ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}