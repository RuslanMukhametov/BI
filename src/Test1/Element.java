package Test1;

import java.util.ArrayList;

/**
 * Created by Руслан on 12.09.2015.
 */

public class Element {
    int centreX;
    int centreY;
    int width;
    int height;
    public Element (int centreX, int centreY, int width, int height){
        this.centreX = centreX;
        this.centreY = centreY;
        this.width = width;
        this.height = height;
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
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

}
