package Software;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aloysius
 */
public class HighScore {
    ArrayList<Score> highScore;
    public HighScore(){
        highScore = new ArrayList();
    }
    public void loadHighScore(String filename) throws IOException{
        try{
            Scanner fileInput = new Scanner(new File(filename));
            while(true){
                //if text file no more line then break the loop
                if(fileInput.hasNextLine() == false){
                    break;
                }
                else{
                    String line = fileInput.nextLine();
                    String line2 = line.replace('[', ' ');
                    String line3 = line2.replace(']', ' ');
                    String line4 = line3.trim();
                    //identify objects in a series of objects from the file
                    //store it in array     |       format: <object name>:<object value>
                    String[] object = line4.split(",");
                    for(int i = 0; i < object.length; i++){
                        String[] info = object[i].split(":");
                        String name = info[0];
                        int score = Integer.parseInt(info[1]);
                        highScore.add(new Score(name.trim(), score));
                    }
                }
            }
            fileInput.close();
        }
        //if file is not found then return false
        catch(FileNotFoundException ex){
            throw new HighScoreException("Unable to load highscores. File is not found");
        }
        }
    //saving highscore into a text file
    public void saveHighScores(String filename) throws IOException{
            try{
                FileWriter ab = new FileWriter(filename, true);
                String a = highScore.toString();
                ab.write(a+"\n");
                ab.close();                        
            }
            catch(FileNotFoundException ex){
                throw new HighScoreException("Unable to save highscore. File is not found.");
            }
            }
    /*
     * takes in variable name in form of string
     * set variable Exist to false
     * for number=0 to the end of arraylist highScore
     *      if(highScore.get(number).getPlayerName == name) then
     *          set Exist to true
     *      endif
     *      endfor
     * returns variable Exist
     */
    public boolean scoreExistForPlayer(String name){
        boolean Exist = false;
        for(int i = 0; i < highScore.size(); i++ ){
            if(highScore.get(i).getPlayerName() == name){
                Exist = true;
            }
            }
        return Exist;
        }
    public void addScore(Score a){
        boolean result = scoreExistForPlayer(a.getPlayerName());
        if(result == true){
            throw new HighScoreException("the name already exist");
        }
        else{
            highScore.add(a);
        }
    }
    //adding new score object with given name and value
    /*
     * takes in variable name in form of string and score in form of integer
     * call method scoreExistForPlayer( name ) to check whether there is a score object with same name
     * assign the result to variable a
     * if(a == false) then
     *      if(score < 0) then
     *          returns false
     *      else
     *          create the
     */
    public void addScore(String name, int score){
        boolean a = this.scoreExistForPlayer(name);
        if(a == false){
            if(score < 0){
                throw new HighScoreException("Unable to add Score object. value is less than 0.");
            }
            else{
                highScore.add(new Score(name, score));
        }
        }
        else{
            throw new HighScoreException("Unable to add Score object. name iws alerady exist");
        }
    }
    /*
     * declare variable i as int
     * for every element of arraylist highscore
     *      if(name of object a == object name in arraylist highscore) then
     *          break out of the loop
     *      else
     *          return false
     *      endif
     * endfor
     * set the value of the object with the same name with object a into object a's value
     * return true
     * @param a
     * @return true or false
     */
    public void updateScore(Score a){
        int i;
        for(i = 0; i < highScore.size(); i++ ){
            if(highScore.get(i).getPlayerName() == a.getPlayerName()){
                break;
            }
            else{
                throw new HighScoreException("Cannot update score.");
            }
        }
            highScore.get(i).setValue(a.getValue());
    }
    public boolean updateScore(String name, int newScore){
        boolean exist = false;
        int i;
        for(i = 0; i < highScore.size(); i++){
        if(highScore.get(i).getPlayerName() == name){
            highScore.get(i).setValue(newScore);
            exist = true;
            break;
        }
        }
        return exist;
    }
    //string representation of arraylist highscore
    //made by addition of the string representation of every member of the arraylist
    @Override
    public String toString(){
        if(highScore.size() == 0){
            String a = "EMPTY";
            return a;
        }
        else{
        String statement = "";
        for(int i = 0; i < highScore.size(); i++){
            String string = "Player Name: " + highScore.get(i).getPlayerName()+" score: "+highScore.get(i).getValue()+"\n";
            statement = statement + string;
        }
        return statement;
    }
}
    //get the size of the arraylist highScore
    public int getSize(){
        return highScore.size();
    }
    //get Score object from the arraylist highScore by index
    public Score getObject(int i){
        return highScore.get(i);
        
    }
    /*public static void main(String[] args) throws IOException {
        HighScore a = new HighScore();
        a.loadHighScore("Score.txt");
        System.out.println(a);
    }*/
}
