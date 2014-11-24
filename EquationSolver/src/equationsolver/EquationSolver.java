/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package equationsolver;

import javax.swing.JFrame;

/**
 * @author Sakibul Mowla
 * Department of Computer Science and Engineering - 20th Batch
 * Shahjalal University of Science and Technology
 */

/**
 * This is the class holding the main method of the Application
 * and it starts the proceedings of the Application
 * @author Sakibul
 */

public class EquationSolver {
    public static JFrame frame;
    
    /**
     * This method shows start screen and then decider screen
     * @param args unused 
     */
    
    public static void main(String[] args) {
        
        StartScreen sc = new StartScreen();
        
        Decider dr = new Decider();
    }

}
