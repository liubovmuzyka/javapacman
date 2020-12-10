package src;

import java.awt.*;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Score {

    /* Score information */
    int currScore;

    int highScore;
    /* if the high scores have been cleared, we have to update the top of the screen to reflect that */
    boolean clearHighScores= false;

    Font font = new Font("Monospaced", Font.BOLD, 12);

    Score() {
        initHighScores();
        currScore = 0;
    }

    /* Reads the high scores file and saves it */
    public void initHighScores()
    {
        File file = new File("highScores.txt");
        Scanner sc;
        try
        {
            sc = new Scanner(file);
            highScore = sc.nextInt();
            sc.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /* Writes the new high score to a file and sets flag to update it on screen */
    public void updateScore(int score)
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter("highScores.txt");
            out.println(score);
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        highScore=score;
        clearHighScores=true;
    }

    /* Wipes the high scores file and sets flag to update it on screen */
    public void clearHighScores()
    {
        PrintWriter out;
        try
        {
            out = new PrintWriter("highScores.txt");
            out.println("0");
            out.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        highScore=0;
        clearHighScores=true;
    }

    public void updateScore(Graphics g, boolean demo){
        if (clearHighScores) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, 600, 18);
            g.setColor(Color.YELLOW);
            g.setFont(font);
            clearHighScores = false;
            if (demo)
                g.drawString("DEMO MODE PRESS ANY KEY TO START A GAME\t High Score: " + highScore, 20, 10);
            else
                g.drawString("Score: " + (currScore) + "\t High Score: " + highScore, 20, 10);
        }
    }
}
