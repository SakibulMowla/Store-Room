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
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class extends JFrame and shows the answer of 
 * System of Linear Algebraic Equations
 * @author Sakibul
 */

public class ShowAns extends JFrame{
    
    private final JLabel label[];
    private final JButton btn;
    private final JButton btn1;
    private final JButton btn2;
    
    /**
     * This method designs the answer showing part of
     * System of Linear Algebraic Equations
     */
    
    ShowAns(){
        super("Equation Solver");
        CreateMenu cm = new CreateMenu(this);
        
        setLayout(new BorderLayout());
	setContentPane(new JLabel(new ImageIcon("src\\Images\\Solution.png")));
        setLayout(new FlowLayout());
        
        Solve sol = new Solve();
        boolean b = sol.solver();
        
        int i, n, btncnt;
        String str;
        
        btncnt = 0;
        n = getMatrix.unknown;
        label = new JLabel[(n+1)*(n+1)];
        
        if(b == false){
//            System.out.println("No Solution Math Error :(");
//            JOptionPane.showMessageDialog(null, "No Solution Math Error :(");
            label[btncnt] = new JLabel("No Solution Math Error :(");
            add(label[btncnt]);
            label[btncnt].setForeground(Color.blue);
        }
        else{
            for(i=1; i<=n; i++){
                str = "X" + Integer.toString(i) + "   =   ";
                str = str + Double.toString(Solve.ans[i]);
                
                label[btncnt] = new JLabel(str);
                label[btncnt].setForeground(Color.DARK_GRAY);
                label[btncnt].setPreferredSize(new Dimension(200, 10));
                add(label[btncnt]);
                label[btncnt++].setForeground(Color.blue);
            }
        }
        
        btn2 = new JButton("Back");
        add(btn2);
        
        btn1 = new JButton("Solve Again\n");
        add(btn1);
        
        btn = new JButton("EXIT");
//        add(btn);
        
        thehandler handler = new thehandler();
        btn.addActionListener(handler);
        btn1.addActionListener(handler);
        btn2.addActionListener(handler);
    }
    
    /**
     * This method implements ActionListener and decides
     * what to do according to which button is clicked
     */
    
    private class thehandler implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == btn){
                EquationSolver.frame.dispose();
            }
            else if(e.getSource() == btn1){
                EquationSolver.frame.dispose();
                Input take = new Input();
                take.takeInput();
            }
            else if(e.getSource() == btn2){
                EquationSolver.frame.dispose();
                
                EquationSolver.frame = new getMatrix(getMatrix.unknown);
                
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                if(getMatrix.unknown == 1)
                    EquationSolver.frame.setSize(95*(getMatrix.unknown+1), 150*getMatrix.unknown);
                else
                    EquationSolver.frame.setSize(95*(getMatrix.unknown+1), 70*getMatrix.unknown);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
        }
        
    }
    
    void answer(){
        String str;
        str = "";
        
        Solve sol = new Solve();
        boolean b = sol.solver();
        
        int i, n;
        n = getMatrix.unknown;
        
        if(b == false){
            System.out.println("No Solution Math Error :(");
            JOptionPane.showMessageDialog(null, "No Solution Math Error :(");
        }
        else{
            for(i=1;i<=n;i++){
                str = str + "X";
                str = str + Integer.toString(i);
                str = str + " = ";
                str = str + Double.toString(Solve.ans[i]) + "\n";
                System.out.println("X"+i+" = " + Solve.ans[i]);
            }
            JOptionPane.showMessageDialog(null, str);
        }
    }
}


