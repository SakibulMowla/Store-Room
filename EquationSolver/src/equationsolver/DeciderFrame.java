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

/**
 * This class extends JFrame and designs Decider
 * @author Sakibul
 */

public class DeciderFrame extends JFrame{
    
    private final JLabel label;
    private final JButton button1, button2;
    public static int equationType;
    
    /**
     * This constructor designs buttons and other labels
     * of Decider and decides on the click which equation
     * to solve
     */
    
    DeciderFrame(){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
	setContentPane(new JLabel(new ImageIcon("src\\Images\\Black.jpg")));
        setLayout(new FlowLayout());
        
        label = new JLabel("Which kind of Equation will be solved?");
        add(label);
        label.setForeground(Color.white);
        Font labelFont = label.getFont();
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 50));
        
        button1 = new JButton("System of Linear ALgebric Equations");
        add(button1);
        
        button2 = new JButton("Quadratic Equation");
        add(button2);
        
        thehandler handler = new thehandler();
        button1.addActionListener(handler);
        button2.addActionListener(handler);
    }
    
    /**
     * This inner class defines which action to do
     * according to the button clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent event){
            
            if(event.getSource() == button1){
                EquationSolver.frame.dispose();
                
                Input take = new Input();
                take.takeInput(); 
            }
                
            else if(event.getSource() == button2){
                EquationSolver.frame.dispose();
                
                Quadratic qc = new Quadratic(); 
            }
        }
        
    }
}
