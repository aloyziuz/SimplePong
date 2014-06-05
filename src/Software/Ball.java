package Software;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class Ball extends Shape{
    Random rand = new Random();
    public Ball(){
        super(300, 200, 30, 30, 0, 0);
    }
    //draw the ball
    public void draw(Graphics a){
        a.setColor(Color.green);
        a.fillOval(x, y, width, height);
    }
    //determining the speed and direction of the ball
    public boolean move(){
        //bounce ball down border
        if(this.y >= 400){
            ySpeed = -ySpeed;
            return false;
        }
        //bounce ball up border
        if(this.y <= 0){
            ySpeed = -ySpeed;
            return false;
        }
        // p2(on the right) miss
        if(this.x >= 600){
            return this.restart();
        }
        //p1(on the left) miss
        if(this.x <= 0){
            return this.restart();
        }
        return false;
    }
    //moving the ball
    public void moveBall(){
        x += xSpeed;
        y += ySpeed;
    }
    //when the ball reach either side of the frame
    public boolean restart(){
        //set the position back to the middle of the field with random speed
        this.x = 300;
        this.y = 200;
        xSpeed = rand.nextInt(21)-10;
        if(xSpeed == 0){
            xSpeed = 8;
        }
        ySpeed = rand.nextInt(21)-10;
        if(ySpeed == 0){
            ySpeed = 6;
        }
        return true;
    }
}