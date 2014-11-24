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
 * This class starts the proceedings of Quadratic Equation Solver
 * @author Sakibul
 */

public class Quadratic {
    public static double A, B, C, D, X1, X2;
    /**
     * This method designs the frame of Quadratic Equation Solver
     */
    Quadratic(){
        EquationSolver.frame = new QuadraticInput();
        
        EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EquationSolver.frame.setSize(500, 300);
        EquationSolver.frame.setLocationRelativeTo(null);
        EquationSolver.frame.setVisible(true);
        EquationSolver.frame.setResizable(false);
    }
}
