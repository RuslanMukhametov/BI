package Test1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Руслан on 28.09.2015.
 */

public class Paint extends JPanel {
    ArrayList<Element> elements;
    ArrayList<Element> initialPlacement;
    int pcbWidth;
    int pcbHeight;
    int xRA;
    int yRA;
    int widthRA;
    int heightRA;
    public Paint (ArrayList<Element> initialPlacement, ArrayList<Element> elements, int pcbWidth, int pcbHeight, int widthRA, int heightRA, int xRA, int yRA){
        this.initialPlacement = initialPlacement;
        this.elements = elements;
        this.pcbWidth = pcbWidth;
        this.pcbHeight = pcbHeight;
        this.xRA = xRA;
        this.yRA = yRA;
        this.widthRA = widthRA;
        this.heightRA = heightRA;

    }

    public  void paint (Graphics g){
        g.setColor(Color.black);
        g.drawRect(0, 0, pcbWidth, pcbHeight);
        for (int j = 0; j < initialPlacement.size(); j ++){
            g.drawRect(initialPlacement.get(j).getCentreX() - initialPlacement.get(j).getWdth() / 2, initialPlacement.get(j).getCentreY() - initialPlacement.get(j).getHeght() / 2, initialPlacement.get(j).getWdth(), initialPlacement.get(j).getHeght());
        }
        g.drawRect(pcbWidth + 5, 0, pcbWidth, pcbHeight);
        for (int i = 0; i < elements.size(); i++) {
            g.drawRect(elements.get(i).getCentreX() - elements.get(i).getWdth() / 2 + pcbWidth + 5, elements.get(i).getCentreY() - elements.get(i).getHeght() / 2, elements.get(i).getWdth(), elements.get(i).getHeght());
        }
        g.setColor(Color.red);
        g.fillRect(xRA - widthRA/2, yRA - heightRA/2, widthRA, heightRA);



    }
}
