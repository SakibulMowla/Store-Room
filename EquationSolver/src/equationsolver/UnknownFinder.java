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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 * This class extends JFrame and finds out how many equations to be solved
 * @author Sakibul
 */

public class UnknownFinder extends JFrame{
    
    private final JTextField item;
    private final JButton button;
    private final JLabel label;
    private int dim;
    private String ss;
    
    /**
     * This method designs frame of unknown finder
     */
    
    public UnknownFinder(){
        
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
		setContentPane(new JLabel(new ImageIcon("src\\Images\\Black.jpg")));
        setLayout(new FlowLayout());
        
        label = new JLabel("How many Unknowns?");
        label.setPreferredSize(new Dimension(200, 100));
        label.setForeground(Color.white);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        add(label);
        
        item  = new JTextField();
        item.setPreferredSize(new Dimension(60, 30));
        add(item);
        
        button = new JButton("OK");
        add(button);
        
        thehandler handler = new thehandler();
        item.addActionListener(handler);
        button.addActionListener(handler);
        
    }
    
    /**
     * This method returns dimension of the given matrix 
     * @return dimension of matrix
     */
    
    public int getDim(){
        
        return dim;
    }
    
    /**
     * This method implements ActionListener and decides
     * what to do according to which button is clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event){
            
            if(event.getSource() == button){
                
                ss = item.getText();
                getMatrix.unknown = dim = Integer.parseInt(ss);
              
                EquationSolver.frame.dispose();
                EquationSolver.frame = new getMatrix(dim);
                
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                if(dim == 1)
                    EquationSolver.frame.setSize(95*(dim+1), 150*dim);
                else
                    EquationSolver.frame.setSize(95*(dim+1), 70*dim);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
            
        }
        
    }
    
    
}
