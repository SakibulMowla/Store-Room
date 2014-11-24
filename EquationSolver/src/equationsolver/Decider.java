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

import javax.swing.JFrame;

/**
 * This class decides which kind of equation to be solved
 * @author Sakibul
 */

public class Decider {
    /**
     * This constructor demonstrates the frame of decider
     */
    Decider(){
        
        EquationSolver.frame = new DeciderFrame();
        EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EquationSolver.frame.setSize(900, 500);
        EquationSolver.frame.setLocationRelativeTo(null);
        EquationSolver.frame.setVisible(true);
        EquationSolver.frame.setResizable(false);
    }
}
