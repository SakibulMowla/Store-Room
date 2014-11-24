/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package equationsolver;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.WindowAdapter;
import javax.swing.JFrame;

/**
 * This class extends JFrame and demonstrates initial window
 * @author Sakibul
 */

public class CreateStartScreen extends JFrame {
       
    private WindowAdapter windowAdapter;
    
    /**
     * This constructor designs initial window and
     * make initial window to wait for 2000 mili-seconds
     */
    
    public CreateStartScreen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MakeDesign design = new MakeDesign();
        getContentPane().add(design);
        pack();
//        setLocationRelativeTo(null);
        setSize(780, 468);
        setVisible(true);
        setResizable(false);
        waitingTime(2000);
        dispose();
    }
    

    public void waitingTime(int miliSecond) {
        try {
            Thread.sleep(miliSecond);
        } catch (InterruptedException err) {
            err.printStackTrace();
        }
    }
}
