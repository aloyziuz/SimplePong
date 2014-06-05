/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Software;

import java.awt.Graphics;

/**
 *
 * @author Aloysius
 */
public class ScoreDisplay extends Shape {
    private int value;
    public ScoreDisplay(int x, int y, int value){
        super(x, y, 4, 4, 0, 0);
        this.value = value;
    }
    @Override
    public void draw(Graphics a) {
        a.drawString(value+"", x, y);
    }
    public void setValue(int a){
        this.value = a;
    }
}
