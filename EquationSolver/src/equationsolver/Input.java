/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sakibul Mowla
 * Department of Computer Science and Engineering - 20th Batch
 * Shahjalal University of Science and Technology
 */

package equationsolver;

import javax.swing.JFrame;

/**
 * This class begins the proceeding of Linear Algebraic Equation Solver
 * @author Sakibul
 */

public class Input {
    /**
     * This method creates the frame which identifies how many
     * equation will be solved
     */
    void takeInput(){
        
        EquationSolver.frame = new UnknownFinder();
        
        EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EquationSolver.frame.setSize(800, 300);
        EquationSolver.frame.setLocationRelativeTo(null);
        EquationSolver.frame.setVisible(true);
        EquationSolver.frame.setResizable(false);
    }
}

