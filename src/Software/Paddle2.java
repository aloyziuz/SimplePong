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
 * basically the same as Paddle1.java but the coordinate of the paddle is different
 * @author Aloysius
 */
public class Paddle2 extends Shape implements KeyListener{
    private int move;
    private boolean up;
    private boolean down;
    public Paddle2(){
        super(585, 200, 10, 70, 0, 0);
        up = false;
        down = false;
        move = 10;
    }
    //draw paddle
    public void draw(Graphics a){
        a.setColor(Color.yellow);
        a.fillRect(x, y, width, height);
    }
    public void keyPressed(KeyEvent a){
        switch(a.getKeyCode()){
            //when P is pressed, variable up will be set to true
            case KeyEvent.VK_P:
                up = true;
                break;
            //when P is pressed, variable down will be set to true
            case KeyEvent.VK_L:
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
            //when P is pressed, variable up will be set to false
            case KeyEvent.VK_P:
                up = false;
                break;
            //when P is pressed, variable down will be set to false
            case KeyEvent.VK_L:
                down = false;
                break;
            }
        }
    public void move(){
        if (y <= 0){
            y = 2;
        }
        if (y >= 340){
            y = 330;
        }
        else if (down == true && y >= 0){
            y += move;
        }
        else if(up == true && y <= 400-height){
            y -= move;
        }
    }
}
