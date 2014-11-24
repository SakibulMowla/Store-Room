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

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * This class shows the output of Quadratic Equation
 * @author Sakibul
 */

public class QuadraticOutput extends JFrame{
    private JButton btn1, btn2;
    private JLabel label1, label2, label3;
    
    /**
     * This method designs answer showing part of
     * Quadratic Equation Solver
     */
    
    QuadraticOutput(){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
        
	setContentPane(new JLabel(new ImageIcon("src\\Images\\Solution.png")));
        setLayout(new FlowLayout());
        
        label3 = new JLabel();
        
        if(QuadraticInput.solvable == false){
            alter();
        }
        else{
            alterAlter();
        }
        
    }
    
    /**
     * This method solves equation and shows answer when there is 
     * imaginary roots
     */
    
    void alter(){
        String ss;
        double d1 = (-Quadratic.B + Math.sqrt(-Quadratic.D)) / (2 * Quadratic.A);
        double d2 = (-Quadratic.B - Math.sqrt(-Quadratic.D)) / (2 * Quadratic.A);
        
        ss = "X" + Integer.toString(1) + "  =   " + Double.toString(d1) + "i";
        label1 = new JLabel(ss);
        add(label1);
        Font labelFont = label1.getFont();
        label1.setForeground(Color.blue);

        ss = "X" + Integer.toString(2) + "  =   " + Double.toString(d2) + "i";
        label2 = new JLabel(ss);
        add(label2);
        labelFont = label2.getFont();
        label2.setForeground(Color.blue);

        
        label3 = new JLabel("It has Complex Roots!");
        add(label3);
        label3.setForeground(Color.blue);
        labelFont = label3.getFont();
        label3.setFont(new Font(labelFont.getName(), Font.PLAIN, 35));
        

        btn1 = new JButton("Solve Again\n");
        add(btn1);
        
        thehandler handler = new thehandler();
        btn1.addActionListener(handler);
        
    }
    
    /**
     * This method solves equation and shows answer when there is no
     * imaginary roots
     */
    
    void alterAlter(){
        String ss;
        ss = "X" + Integer.toString(1) + "    =   " + Double.toString(Quadratic.X1);
        label1 = new JLabel(ss);
        add(label1);
        label1.setForeground(Color.blue);
        Font labelFont = label1.getFont();

        ss = "X" + Integer.toString(2) + "    =   " + Double.toString(Quadratic.X2);
        label2 = new JLabel(ss);
        add(label2);
        labelFont = label2.getFont();
        label2.setForeground(Color.blue);

        System.out.println("X1 = " + Quadratic.X1);
        System.out.println("X2 = " + Quadratic.X2);


        btn1 = new JButton("Solve Again\n");
        add(btn1);

        thehandler handler = new thehandler();
        btn1.addActionListener(handler);
    }
    
    /**
     * This method implements ActionListener and decides
     * what to do according to which button is clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btn1){
                EquationSolver.frame.dispose();
                
                Quadratic qc = new Quadratic();
            }
            else if(e.getSource() == btn2){
                EquationSolver.frame.dispose();
                
                Quadratic qc = new Quadratic();
            }
        }
        
    }
}
