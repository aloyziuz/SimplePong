/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Software.HighScoreDisplay;
import javax.swing.JFrame;

/**
 *
 * @author Aloysius
 */
public class TestHighScoreDisplay {
    public static void main(String[] args) {
        JFrame a = new JFrame();
        HighScoreDisplay b = new HighScoreDisplay();
        a.add(b);
        a.setVisible(true);
        a.pack();
    }
}
