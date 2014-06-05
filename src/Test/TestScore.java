/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Software.HighScore;
import Software.Score;
import java.io.IOException;

/**
 *
 * @author Aloysius
 */
public class TestScore {
    public static void main(String[] args) throws IOException {
        Score p1 = new Score("Haru");
        Score p2 = new Score("Sasuke", 13);
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p1.increment());
        System.out.println(p1.getPlayerName());
        System.out.println(p1.getValue());
        p2.setPlayerName("Musica");
        p2.setValue(0);
        System.out.println(p2);
        System.out.println(p1);
        HighScore ab = new HighScore();
        ab.addScore(p1);
        ab.addScore(p2);
        System.out.println(ab);
        System.out.println(ab.getSize());
        System.out.println(ab.getObject(0));
        ab.saveHighScores("testScore.txt");
        HighScore ab2 = new HighScore();
        ab2.loadHighScore("testScore.txt");
        System.out.println(ab2);
    }
}
