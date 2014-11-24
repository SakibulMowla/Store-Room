/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package equationsolver;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * This class extends JComponent and designs initial screen
 * @author Sakibul
 */
public class MakeDesign extends JComponent{
    
    public Graphics graphics=null;
   /**
    * This method paint the graphics in component
    * @param g graphics to be painted 
    */
    @Override
    public void update(Graphics g){
        paint(g);
    }
    /**
     * This method initializes graphics variable
     * @param g graphics to be painted
     */
    @Override
    public void paint(Graphics g){
        if(graphics==null){
            graphics = g.create();
        }
        
        BuildStartScreen.StartPage(graphics);
    }
    
}
