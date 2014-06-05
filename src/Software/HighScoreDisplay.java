package Software;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class HighScoreDisplay extends JPanel{
    private ArrayList <Score> list;
    JTextArea b;
    private HighScore highscore;
    public HighScoreDisplay(){
        setPreferredSize(new Dimension(250, 400));
        setLayout(new BorderLayout());
        list = new ArrayList();
        highscore = new HighScore();
        //load highscore from text file
        try {
            highscore.loadHighScore("highscoreTable.txt");
        } catch (IOException ex) {
            Logger.getLogger(HighScoreDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        //adding the Score object abstracted from the text file to the list
        for(int i = 0; i < highscore.getSize(); i++){
            list.add(highscore.getObject(i));
        }
        //create new text area and set it uneditable
        b = new JTextArea();
        Font font = new Font("Arial", Font.BOLD, 12);
        b.setFont(font);
        b.setEditable(false);
        //the text area will fill the whole frame
        add(b, BorderLayout.CENTER);
        //sorting the list according to Score object's value in descending order
        Collections.sort(list);
        //show it in text area
        for(int i = 0; i<list.size(); i++){
            String a = "Player Name: "+ list.get(i).getPlayerName() + " score: "+ list.get(i).getValue()+"\n";
            b.append(a);
        }
    }
    public void clearList(){
        b.setText("");
        ArrayList<Score> list2 = new ArrayList();
        HighScore highScore2 = new HighScore();
        try {
            highScore2.loadHighScore("highscoreTable.txt");
        } catch (IOException ex) {
            Logger.getLogger(HighScoreDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        //adding the Score object abstracted from the text file to the list
        for(int i = 0; i < highScore2.getSize(); i++){
            list2.add(highScore2.getObject(i));
        }
        Collections.sort(list2);
        for(int i = 0; i<list2.size(); i++){
            String a = "Player Name: "+ list2.get(i).getPlayerName() + " score: "+ list2.get(i).getValue()+"\n";
            b.append(a);
        }
    }
}

