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
    public Paint (ArrayList<Element> initialPlacement, ArrayList<Element> elements, int pcbWidth, int pcbHeight){
        this.initialPlacement = initialPlacement;
        this.elements = elements;
        this.pcbWidth = pcbWidth;
        this.pcbHeight = pcbHeight;

    }

    public  void paint (Graphics g){
        g.setColor(Color.black);
        g.drawRect(0, 0, pcbWidth, pcbHeight);
        for (int j = 0; j < initialPlacement.size(); j ++){
            g.fillRect(initialPlacement.get(j).getCentreX() - initialPlacement.get(j).getWidth() / 2, initialPlacement.get(j).getCentreY() - initialPlacement.get(j).getHeight() / 2, initialPlacement.get(j).getWidth(), initialPlacement.get(j).getHeight());
        }
        g.drawRect(pcbWidth + 5, 0, pcbWidth, pcbHeight);
        for (int i = 0; i < elements.size(); i++) {
            g.fillRect(elements.get(i).getCentreX() - elements.get(i).getWidth() / 2 + pcbWidth + 5, elements.get(i).getCentreY() - elements.get(i).getHeight() / 2, elements.get(i).getWidth(), elements.get(i).getHeight());
        }


    }
}
