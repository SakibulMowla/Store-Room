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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * This class takes input for Quadratic Equation Solver
 * @author Sakibul
 */

public class QuadraticInput extends JFrame{
    private final JLabel label;
    private final JLabel label1;
    private final JLabel label2;
    private final JLabel label3;
    private final JTextField text1;
    private final JTextField text2;
    private final JTextField text3;
    private final JButton button;
    String ss;
    public static boolean solvable;
    
    /**
     * This method designs the frame of Quadratic Equation Solver
     * add boxes to take input and then starts solving proceeding 
     * when solve button is clicked
     */
    
    public QuadraticInput(){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
        
        setContentPane(new JLabel(new ImageIcon("src\\Images\\blue.jpg")));
        setLayout(new FlowLayout());
        
        label = new JLabel("Equation of the form Ax^2 + Bx + C = 0 can be solved");
        add(label);
        label.setForeground(Color.white);
        Font labelFont = label.getFont();
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        
        label1 = new JLabel("A = ",JLabel.CENTER);
        label1.setForeground(Color.white);
        label1.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        add(label1);
        
        text1 = new JTextField(10);
        add(text1);
        
        label2 = new JLabel("B = ",JLabel.CENTER);
        label2.setForeground(Color.white);
        label2.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        add(label2);
        
        text2 = new JTextField(10);
        add(text2);
        
        label3 = new JLabel("C = ",JLabel.CENTER);
        label3.setForeground(Color.white);
        label3.setFont(new Font(labelFont.getName(), Font.PLAIN, 20));
        add(label3);
        
        text3 = new JTextField(10);
        add(text3);
        
        button = new JButton("Solve");
        add(button);
        
        thehandler handler = new thehandler();
        button.addActionListener(handler);
    }
    
    /**
     * This method implements ActionListener and decides
     * what to do according to which button is clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){
             
            if(e.getSource() == button){
                ss = text1.getText();
                Quadratic.A = Double.parseDouble(ss);
                ss = text2.getText();
                Quadratic.B = Double.parseDouble(ss);
                ss = text3.getText();
                Quadratic.C = Double.parseDouble(ss);
                
                solve();
                
                EquationSolver.frame.dispose();
               
                EquationSolver.frame = new QuadraticOutput();
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EquationSolver.frame.setSize(400, 300);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
            
        }
        
    }
    
    /**
     * This method solves the Quadratic Equation for given input
     */
    
    void solve(){
        Quadratic.D = (Quadratic.B * Quadratic.B) - (4 * Quadratic.A * Quadratic.C);
        if(Quadratic.D < 0){
            solvable = false;
            return;
        }
        System.out.println("abc " + Quadratic.A + " " + Quadratic.B + " " + Quadratic.C);
        Quadratic.X1 = (-Quadratic.B + Math.sqrt(Quadratic.D)) / (2 * Quadratic.A);
        Quadratic.X2 = (-Quadratic.B - Math.sqrt(Quadratic.D)) / (2 * Quadratic.A);
        solvable = true;
        
        
    }
}
