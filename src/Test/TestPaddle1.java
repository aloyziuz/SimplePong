/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Software.Paddle1;
import Software.Paddle2;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Aloysius
 */
public class TestPaddle1 extends JPanel implements ActionListener{
    private Timer timer;
    private Paddle1 p1;
    private Paddle2 p2;
    public TestPaddle1(){
        setPreferredSize(new Dimension(600, 400));
        timer = new Timer(10, this);
        timer.start();
        p1 = new Paddle1();
        addKeyListener(p1);
        p2 = new Paddle2();
        addKeyListener(p2);
        setFocusable(true);
    }
    public void gameStart(){
        timer.start();
    }
    protected void paintComponent(Graphics a){
        super.paintComponent(a);
        a.setColor(Color.BLACK);
        a.fillRect(0, 0, getWidth(), getHeight());
        p1.draw(a);
        p1.move();
        p2.draw(a);
        p2.move();
    }
    public void actionPerformed(ActionEvent a){
        repaint();
    }
    public static void main(String[] args) {
        JFrame a = new JFrame();
        TestPaddle1 b = new TestPaddle1();
        a.add(b);
        a.setVisible(true);
        a.pack();
        
    }
}
