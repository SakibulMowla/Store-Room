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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * This class creates the Menu Bar of the Application
 * @author Sakibul
 */

public class CreateMenu {
    /**
     * This method adds different Menu Items in Menu Bar
     * @param frame the frame in which the Menu Bar is added
     */
    
    public CreateMenu(JFrame frame){
        
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem exit = new JMenuItem("Exit");
        JMenuItem mainmenu = new JMenuItem("Main Menu");
        JMenuItem help = new JMenuItem("Help");
        JMenuItem about = new JMenuItem("About");
        
        exit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        mainmenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                EquationSolver.frame.dispose();
                
                Decider dr = new Decider();
            }
        });
        
        help.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                EquationSolver.frame.dispose();
                
                EquationSolver.frame = new Help();
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EquationSolver.frame.setSize(670, 650);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
        });
        
        about.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                EquationSolver.frame.dispose();
                
                EquationSolver.frame = new About();
                EquationSolver.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                EquationSolver.frame.setSize(670, 600);
                EquationSolver.frame.setLocationRelativeTo(null);
                EquationSolver.frame.setVisible(true);
                EquationSolver.frame.setResizable(false);
            }
        });
        
        menu.add(mainmenu);
        menu.add(help);
        menu.add(about);
        menu.add(exit);
        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }
    
}
