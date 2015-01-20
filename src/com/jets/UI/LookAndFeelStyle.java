/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.UI;

import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Rania
 */
public class LookAndFeelStyle {
    public void setLook(JFrame f){
        try {
            /*    
                     try {
                         UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel");
                     } catch (Exception ex) {
                         Logger.getLogger(InvitationFrame.class.getName()).log(Level.SEVERE, null, ex);
                     }
                     SwingUtilities.updateComponentTreeUI(this);
         */
                 UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());
        } catch (Exception ex) {
            Logger.getLogger(serverFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        SwingUtilities.updateComponentTreeUI(f);
    }
}
