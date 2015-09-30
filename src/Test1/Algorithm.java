package Test1;

import java.util.ArrayList;
import static java.lang.Math.*;

/**
 * Created by Руслан on 12.09.2015.
 */
public class Algorithm {
    static int newCentreX;
    static int newCentreY;
    static int speedX;
    static int speedY;
    static int targetFunction = 0;
    public static int movingX (int centreX){
        speedX = (int)(Math.random() * 10);
        newCentreX = centreX + speedX;
        return newCentreX;
    }
    public static int movingY (int centreY){
        speedY = (int)(Math.random() * 6);
        newCentreY = centreY + speedY;
        return newCentreY;
    }
    public static int distance (ArrayList<Element> elements, int i, int j){
        double dist = sqrt(pow(elements.get(i).getCentreX() - elements.get(j).getCentreX(), 2.0) + pow(elements.get(i).getCentreY() - elements.get(j).getCentreY(), 2.0));
        int distance = (int) dist;
        return distance;
    }
    public static int targetFunction (int[][] matrix, ArrayList<Element> elements){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != 0){
                    targetFunction = targetFunction + matrix[i][j] * distance(elements, i, j);
                }

            }
        }
        return targetFunction;
    }
}

