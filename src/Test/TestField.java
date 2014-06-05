/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Software.Field;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

/**
 *
 * @author Aloysius
 */
public class TestField {
    public static void main(String[] args) {
        JFrame a = new JFrame();
        final Field field = new Field();
        a.add(field);
        field.addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                 if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    field.gameStart();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        a.setResizable(false);
        a.pack();
        a.setVisible(true);
    }
}
