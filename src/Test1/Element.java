package Test1;

import java.awt.*;

/**
 * Created by Руслан on 12.09.2015.
 */

public class Element extends Rectangle {
    int centreX;
    int centreY;
    int width;
    int height;
    int leftX;
    int rightX;
    int topY;
    int downY;

    public Element (int centreX, int centreY, int width, int height){
        this.centreX = centreX;
        this.centreY = centreY;
        this.width = width;
        this.height = height;
        this.leftX = centreX - width/2;
        this.rightX = centreX + width/2;
        this.topY = centreY + height/2;
        this.downY = centreY - height/2;
    }

    public int getCentreX(){
        return centreX;
    }
    public int getCentreY() {
        return centreY;
    }
    public void setCentreX(int centreX){
        this.centreX = centreX;
    }
    public void setCentreY (int centreY){
        this.centreY = centreY;
    }
    public int getWdth() {
        return width;
    }
    public int getHeght() {
        return height;
    }
    public int getLeftX(){
        return leftX;
    }
    public int getRightX() {
        return rightX;
    }
    public int getTopY(){
        return topY;
    }
    public int getDownY() {
        return downY;
    }

}
