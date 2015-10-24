package Test1;

import java.awt.*;
import java.util.ArrayList;
import static java.lang.Math.*;

/**
 * Created by Руслан on 12.09.2015.
 */
public class Algorithm {

    public static int movingX (int centreX, int minFreq, int maxFreq, int xBest, int maxStep){
        int newCentreX;
        double speedX;
        //V = Vi + w * (Xi - Xbest), Xbest - координата центра элемента, с которым перемещаемый имеет наибольшее число связей
        // w - частота (freq). w = w(min) + (w(max) - w(min)) * U(0;1)

        double u = Math.random();
        double freq = minFreq + (maxFreq - minFreq) * u;
        speedX = freq * (xBest - centreX);
        if (speedX > maxStep){
            speedX = maxStep;
        }
        if (speedX < (0 - maxStep)){
            speedX = 0 -maxStep;
        }
        newCentreX = centreX + (int) speedX;
        return newCentreX;
    }
    public static int movingY (int centreY, int minFreq, int maxFreq, int yBest, int maxStep){
        int newCentreY;
        double speedY;

        double u = Math.random();
        double freq = minFreq + (maxFreq - minFreq) * u;
        speedY = freq * (yBest - centreY);
        if (speedY > maxStep){
            speedY = maxStep;
        }
        if (speedY < (0 - maxStep)){
            speedY = 0 -maxStep;
        }
        newCentreY = centreY + (int) speedY;
        return newCentreY;
    }
    public static int distance (ArrayList<Element> elements, int i, int j){
        double dist = sqrt(pow(elements.get(i).getCentreX() - elements.get(j).getCentreX(), 2.0) + pow(elements.get(i).getCentreY() - elements.get(j).getCentreY(), 2.0));
        int distance = (int) dist;
        return distance;
    }
    public static int targetFunction (int[][] matrix, ArrayList<Element> elements){
        int targetFunction = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != 0){
                    targetFunction = targetFunction + matrix[i][j] * distance(elements, i, j);
                }

            }
        }
        return targetFunction;
    }
    public  static void checkConfines (ArrayList<Element> elements){
        for (int i = 0; i < elements.size(); i++) {
            int j = 0;
            while (j < elements.size()){
                if (j != i) {
                    if (elements.get(i).intersects(elements.get(j))) {
                        System.out.println("Ky - Ky");
                        while (elements.get(i).getCentreX() > elements.get(j).getCentreX()) {
                            elements.get(i).setCentreX(elements.get(i).getCentreX() + 1);
                        }
                        while (elements.get(i).getCentreX() < elements.get(j).getCentreX()) {
                            elements.get(i).setCentreX(elements.get(i).getCentreX() - 1);
                        }
                        while (elements.get(i).getCentreX() == elements.get(j).getCentreX()){
                            elements.get(i).setCentreX(elements.get(i).getCentreX() - 1);
                        }


                        System.out.println("Координаты : " + elements.get(i).getCentreX());
                        System.out.println("Координаты : " + elements.get(i).getCentreY());
                        /*if (elements.get(i).getLeftX() <= elements.get(j).getLeftX() && elements.get(j).getLeftX() <= elements.get(i).getRightX() && elements.get(i).getDownY()  <= elements.get(j).getTopY() && elements.get(j).getTopY() <= elements.get(i).getTopY()){
                            elements.get(i).setCentreY(elements.get(i).getCentreY() - 1);
                        }*/
                    }


                }
                j++;

            }
        }

    }
}

