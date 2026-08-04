/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package za.ac.cput.lostandfound.Application;

import javax.swing.SwingUtilities;
import za.ac.cput.lostandfound.gui.AppEntryPage;

/**
 *
 * @author rjbur
 */
public class LostAndFound {


     public static void main(String[] args) {
        
        SwingUtilities.invokeLater(AppEntryPage::new);
    }
}
