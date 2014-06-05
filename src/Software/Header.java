package Software;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * create 2 text fields(p1 and p2) and 2 buttons(end game and start game)
 * set end game button disabled
 * add ActionListener to start button so it will extract the 2 players' names from text fields
 *    if either one of the text field or both is empty, then show error message box
 *    else set both text fields and start button unusable, and extract the text to change the name in the Score object of both players in the arraylist
 * add ActionListener to end button
 *    stop the game
 *    set both text fields and start button usable and end button unusable
 *    set the value of both Score object in ArrayList to be the same as the Field object
 *    add both Score object to object HighScore
 *    save highscore to txt file named HighScoreTable.txt
 *    set the score back to 0
 *    refresh the HighScoreDisplay
 *    set end game button unusable
 * @author Aloysius
 */
public class Header extends JPanel{
    JTextField p1;
    JButton startBtn;
    JButton endBtn;
    JTextField p2;
    String p1Name;
    String p2Name;
    public Header(){
        setLayout(new FlowLayout());
        p1 = new JTextField(20);
        startBtn = new JButton("Start Game");
        endBtn = new JButton("End Game");
        endBtn.setFocusable(false);
        p2 = new JTextField(20);
        endBtn.setEnabled(false);
        startBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent a){
                p1Name = p1.getText();
                p2Name = p2.getText();
                //if textfield is null, error box will appear
                if("".equalsIgnoreCase(p1Name) && "".equalsIgnoreCase(p2Name)){
                    JOptionPane.showMessageDialog(p1, "both text field must be filled. ");
                }
                else if("".equals(p1Name)){
                    JOptionPane.showMessageDialog(p1, "left text field is not filled. ");
                }
                else if("".equals(p2Name)){
                    JOptionPane.showMessageDialog(p2, "right text field is not filled. ");
                }
                else{
                    //set both textfield unusable
                    p1.setEditable(false);
                    p2.setEditable(false);
                    //set start game button unusable
                    startBtn.setEnabled(false);
                    //set end game button usable
                    endBtn.setEnabled(true);
                    p1.setFocusable(false);
                    p2.setFocusable(false);
                    //set the 2 Score objects according to the inputted name
                    Pong.score.get(0).setPlayerName(p1Name);
                    Pong.score.get(1).setPlayerName(p2Name);
                }
            }
        });
        endBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                //when end button is pressed...
                //create new HighScore object
                HighScore highScore = new HighScore();
                //both textfield and start game button will be usable and focusable
                p1.setEditable(true);
                p2.setEditable(true);
                startBtn.setEnabled(true);
                p1.setFocusable(true);
                p2.setFocusable(true);
                //add the 2 player's score (Score objects) to highScore
                Pong.score.get(0).setValue(Pong.game.score.get(0).getValue());
                Pong.score.get(1).setValue(Pong.game.score.get(1).getValue());
                highScore.addScore(Pong.score.get(0));
                highScore.addScore(Pong.score.get(1));
                //stop the game
                Pong.game.gameStop();
                try {
                    //save highscore to text file
                    highScore.saveHighScores("highscoreTable.txt");
                } catch (IOException ex) {
                    Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                }
                //set value back to 0
                Pong.game.score.get(0).setValue(0);
                Pong.game.score.get(1).setValue(0);
                //update the HighScoreDisplay
                Pong.display.clearList();
                //set end game button to disabled
                endBtn.setEnabled(false);
            }
        });
        add(p1);
        add(startBtn);
        add(endBtn);
        add(p2);
    }
    /*public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Header());
        f.setVisible(true);
        f.pack();
    }*/
}