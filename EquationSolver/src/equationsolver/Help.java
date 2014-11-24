/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakibul Mowla
 * Department of Computer Science and Engineering - 20th
 * Batch Shahjalal University of Science and Technology
 */

package equationsolver;

import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class demonstrates the Help section of the application
 * and it extends JFrame
 * @author Sakibul
 */

public class Help extends JFrame{
    /**
     * This constructor handles the internal writings of
     * Help section of Application
     */
    
    Help(){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
	setContentPane(new JLabel(new ImageIcon("src\\Images\\Help.PNG")));
        setLayout(new FlowLayout());
    }
}
