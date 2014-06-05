package Software;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class Field extends JPanel implements Runnable{
    static ArrayList<Score> score;
    Thread thread;
    private Random rand = new Random();
    private Ball ball;
    private Paddle1 p1;
    private Paddle2 p2;
    private ScoreDisplay scoreDisplayp1, scoreDisplayp2;
    public Field(){
        setPreferredSize(new Dimension(600, 400));
        thread = new Thread(this);
        thread.start();
        //create arraylist to store the 2 players' score
        score = new ArrayList();
        score.add(new Score("p1"));
        score.add(new Score("p2"));
        scoreDisplayp1 = new ScoreDisplay(100, 50, score.get(0).getValue());
        scoreDisplayp2 = new ScoreDisplay(500, 50, score.get(1).getValue());
        ball = new Ball();
        p1 = new Paddle1();
        //add keylistener to the p1 object and p2 object
        addKeyListener(p1);
        p2 = new Paddle2();
        addKeyListener(p2);
        //set Field object focusable
        setFocusable(true);
    }
    public void gameStart(){
        ball.restart();
    }
    public void gameStop(){
        ball.x = 300;
        ball.y = 200;
        ball.setXSpeed(0);
        ball.setYSpeed(0);
        try {
            thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void paintComponent(Graphics a){
        super.paintComponent(a);
        //set background colour black
        a.setColor(Color.BLACK);
        a.fillRect(0, 0, getWidth(), getHeight());
        a.setColor(Color.red);
        //create p1 collder
        if(ball.x <= ball.width + p1.width){
            if (ball.y <= p1.y+p1.height & ball.y >= p1.y){
                ball.xSpeed = rand.nextInt(10)+1;
            }
        }
        //create p2 collider
        if(ball.x >= 600 - (ball.width + p2.width)){
            if (ball.y <= p2.y+p2.height & ball.y >= p2.y){
                ball.xSpeed = -1 * (rand.nextInt(10)+1);
            }
        }
        ball.draw(a);
        p1.draw(a);
        p2.draw(a);
        //set font to be Arial of size 50
        Font font = new Font("Arial", Font.PLAIN, 50);
        a.setFont(font);
        //paint the 2 player's scores
        scoreDisplayp1.setValue(score.get(0).getValue());
        scoreDisplayp2.setValue(score.get(1).getValue());
        scoreDisplayp1.draw(a);
        scoreDisplayp2.draw(a);
        synchronized(this){
            ball.move();
            //moving the ball
            ball.moveBall();
            if(ball.x <= 0){
                score.get(1).increment();
                gameStop();
            }
            if(ball.x >= 600){
                score.get(0).increment();
                gameStop();
            }
            p2.move();
            p1.move();
        }
    }
    @Override
    public void run(){
        boolean running = true;
        while(running){
            repaint();
            try{
                thread.sleep(20);
            }catch(InterruptedException ex){
            }
        }
    }
}