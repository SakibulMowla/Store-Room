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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Scanner;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This method inputs the matrix of System of Linear Equations to
 * be solved and it extends JFrame
 * @author Sakibul
 */

public class getMatrix extends JFrame{
    
    public static double mat[][];
    public static double con[];
    public static int unknown;
    
    private final JTextField item[];
    private final JLabel label[];
    private final JButton buton;
    private final JButton buton1;
    
    int i, j, n, cntitem, cntlabel;
    String str;
    
    /**
     * This method designs the frame of the matrix of 
     * System of Linear Equations to be solved
     * @param n dimension of matrix
     */
    
    public getMatrix(int n){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
        
        setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("src\\Images\\black3.jpg")));
        setLayout(new FlowLayout());
        
        unknown = this.n = n;
        
        item  = new JTextField[(n+1)*(n+1)];
        label  = new JLabel[(n+1)*(n+1)];
        
        cntitem = 0;
        cntlabel = 0;
        
        for(i=1; i<=n; i++){
            
            for(j=1; j<=n; j++){
                item[cntitem] = new JTextField(5);
                add(item[cntitem++]);
                
                str = "X";
                str = str + Integer.toString(j);
                if(j != n)
                    str = str + "+";
                else 
                    str = str + " = ";

                label[cntlabel] = new JLabel(str);
                label[cntlabel].setForeground(Color.white);
                add(label[cntlabel++]);
            }
            
            item[cntitem] = new JTextField(5);
            add(item[cntitem++]);
        }
        
        buton1 = new JButton("Back");
        add(buton1);
        buton = new JButton("Solve");
        add(buton);
        
        thehandler handler = new thehandler();
        buton.addActionListener(handler);
        buton1.addActionListener(handler);
    }
    
    /**
     * This method implements ActionListener and decides
     * what to do according to which button is clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event){
            
            if(event.getSource() == buton){
                
                mat = new double[n+5][n+5];
                con = new double[n+5];
                
                cntitem = 0;

                for(i=1; i<=n; i++){
                    for(j=1; j<=n; j++){
                        str = item[cntitem++].getText();
                        mat[i][j] = Double.parseDouble(str);
                    }
                    str = item[cntitem++].getText();
                    con[i] = Double.parseDouble(str);
                }
                
                EquationSolver.frame.dispose();
               
                
                EquationSolver.frame = new ShowAns();
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                if(n == 1)
                    EquationSolver.frame.setSize(250, 150);
                else
                    EquationSolver.frame.setSize(250, 95*n);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
            
            else if(event.getSource() == buton1){
                EquationSolver.frame.dispose();
                
                Input take = new Input();
                take.takeInput();
            }
        }
        
    }
   
}
