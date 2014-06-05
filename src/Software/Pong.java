package Software;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * create arraylist to store the score of both players
 * create Header object
 * add the Header object to Pong window
 * create a new Field object
 * add the Field object into the frame under the Header object
 * create a new HighScoreDisplay object
 * add the HighScoreDisplay beside the Field object
 * add KeyListener to the Field object so that the game will start when space bar is pressed
 * @author Aloysius
 */
public class Pong extends JFrame{
    Header header;
    static HighScoreDisplay display;
    static ArrayList<Score> score;
    static Field game;
    public Pong(){
        //store 2 Score objects for the 2 players playing the game
        score = new ArrayList();
        score.add(new Score("Unknown"));
        score.add(new Score("Anonymous"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Pong");
        setResizable(false);
        //set layout
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        header = new Header();
        c.insets = new Insets(0, 0, 0, 0);
        c.gridx = 0;
        c.gridwidth = 5;
        c.gridy = 0;
        add(header, c);
        //add the game panel
        game = new Field();
        c.insets = new Insets(10, 0, 0, 0);
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        add(game, c);
        //add a panel to display highscore
        display = new HighScoreDisplay();
        c.gridx = 4;
        c.gridy = 1;
        add(display, c);
        game.requestFocusInWindow();
        //add keylistener to game panel
        game.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            //when space is pressed, game will start (timer in Field object will start)
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    game.gameStart();
            }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        pack();
    }
    public static void main(String[] args) {
        Pong pong = new Pong();
        pong.setVisible(true);
    }
}