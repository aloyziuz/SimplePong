package Software;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class Paddle1 extends Shape implements KeyListener{ 
    private int move;
    private boolean up, down;
    public Paddle1(){
        super(5, 200, 10, 70, 0, 0);
        //set coordinate of the paddle to be (5, 200)
        up = false;
        down = false;
        move = 10;
    }
    //draw the paddle
    public void draw(Graphics a){
        a.setColor(Color.yellow);
        a.fillRect(x, y, width, height);
    }
    //keylistener
    public void keyPressed(KeyEvent a){
        switch(a.getKeyCode()){
            //when Q is pressed, set variable up to be true
            case KeyEvent.VK_Q:
                up = true;
                break;
            //when A is pressed, set variable down to be true 
            case KeyEvent.VK_A:
                down = true;
                break;
            }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch(e.getKeyCode()){
            //when Q is released, set variable up to be false
            case KeyEvent.VK_Q:
                up = false;
                break;
            //when a is released, set variable down to be false
            case KeyEvent.VK_A:
                down = false;
                break;
            }
        }
    public void move(){
        //if y coordinare of the paddle is less than 0 then set y to 0
        if (y < 0){
            y = 0;
        }
        //if y coordinate of the paddle plus the height is more than 400 then set to 400(frame size) minus the height 
        if (y + height > 400){
            y = 400 - height;
        }
        //else if variable down is true and y coordinate of the paddle is more than 0 then move the paddle downward
        else if (down == true && y >= 0){
            y += move;
        }
        //else if variable up is true and y coordinate of the paddle is less than 400(frame size) minus the height of the paddle then move it upwards
        else if(up == true && y <= 400-height){
            y -= move;
        }
    }
}


