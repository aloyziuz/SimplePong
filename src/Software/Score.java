package Software;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class Score implements Comparable<Score>{
    private String playerName;
    private int value;
    //create score object with given name and default value(0)
    public Score(String name){
        playerName = name;
        value = 0;
    }
    //create score object with given name and given score
    public Score(String name, int score){
        this.playerName = name;
        this.value = score;
    }
    //change playerName of the score object
    public void setPlayerName(String newName){
        this.playerName = newName;
    }
    //retrieve playerName of the score object
    public String getPlayerName(){
        return this.playerName;
    }
    //set the value of score object
    public void setValue(int newValue){
        if (newValue < 0){
            throw new ScoreException("Cannot set value");
        }
        else{
            this.value = newValue;
        }
    }
    //retrieve the getValue of the score object
    public int getValue(){
        return this.value;
    }
    //returns the string representation of the score object
    //format: <playerName>:<Value>
    @Override
    public String toString(){
        String statement = this.getPlayerName()+":"+this.getValue();
        return statement;
    }
    //increase value of the score object by 1
    public int increment(){
        int a = this.getValue();
        a += 1;
        this.setValue(a);
        return this.getValue();
    }

    @Override
    // compare between Score objects
    public int compareTo(Score a) {
        return new Integer(a.getValue()).compareTo(this.getValue());
    }       
}