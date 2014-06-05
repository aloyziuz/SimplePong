package Software;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public abstract class Shape {
    protected int xSpeed, ySpeed, width, height, x, y;
    public Shape(int x, int y, int width, int height, int xSpeed, int ySpeed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        if (xSpeed <= -10 || xSpeed >= 10 || ySpeed <= -10 || ySpeed >= 10|| width < 3 || width >= 200 || height < 3 || height >= 200){
            throw new ShapeException("Cannot create object. Variables are out of range.");
        }
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public int getXSpeed(){
        return this.xSpeed;
    }
    public int getYSpeed(){
        return this.ySpeed;
    }
    public int getWidth(){
        return this.width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setX(int newX){
        this.x = newX;
    }
    public void setY(int newY){
        this.y = newY;
    }
    public void setXSpeed(int newXSpeed){
        this.xSpeed = newXSpeed;
    }
    public void setYSpeed(int newYSpeed){
        this.ySpeed = newYSpeed;
    }
    //create abstract method draw
    abstract void draw(Graphics a);
    /*public static void main(String[] args) {
        Shape a = new Shape(0, 0, 100, 100, 0, 0) {
            @Override
            void draw(Graphics a) {
                a.fillRect(x, y, width, height);
            }
        };
        System.out.println(a.getHeight());
        System.out.println(a.getWidth());
        System.out.println(a.getX());
        System.out.println(a.getY());
        a.setX(30);
        a.setY(50);
        System.out.println(a.getX());
        System.out.println(a.getY());
    }*/
}