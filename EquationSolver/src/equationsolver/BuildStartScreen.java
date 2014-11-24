/**
 *
 * @author Sakibul Mowla
 * Department of Computer Science and Engineering - 20th Batch 
 * Shahjalal University of Science and Technology
 */

package equationsolver;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 * This class demonstrates the initializer window of the Application
 * @author Sakibul
 */

public class BuildStartScreen {
    /**
     * This method designs the frame of initial window
     * @param graphics manipulates the component of initial window
     */
    public static void StartPage(Graphics graphics) {
        graphics.setColor(Color.darkGray);
        graphics.fillRect(0, 0, 780, 468);
		
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("Gabriola", Font.BOLD, 60));
        graphics.drawString("Equation Solver", 260, 210);

    }
}


