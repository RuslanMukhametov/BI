package Test1;

/**
 * Created by Руслан on 23.09.2015.
 */
import javax.swing.*;

public class  MainWindow extends JFrame {
    int pcbWidth;
    int pcbHeight;


    MainWindow(int pcbWidth, int pcbHeight){
        super("Bat Algorithm");
        this.pcbHeight = pcbHeight;
        this.pcbWidth = pcbWidth;
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(pcbWidth * 3, pcbHeight * 3);


    }
}
