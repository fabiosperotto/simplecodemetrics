
package org.engmetrics.ccscounter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.engmetrics.gui.StartWindow;


/**
 * Main class
 */
public class CCSCounter {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CCSCounter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CCSCounter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CCSCounter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(CCSCounter.class.getName()).log(Level.SEVERE, null, ex);
        }
        StartWindow window = new StartWindow();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
