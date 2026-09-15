/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package za.ac.cput.lostandfound.Application;

import javax.swing.SwingUtilities;
import za.ac.cput.lostandfound.gui.AppEntryPage;
import za.ac.cput.lostandfound.gui.ReceiverChatRoomGUI;
import za.ac.cput.lostandfound.gui.SignUpPage;

/**
 *
 * @author rjbur
 */
public class LostAndFound {


     public static void main(String[] args) {
        System.out.print(0);
        SwingUtilities.invokeLater(AppEntryPage::new);
          SwingUtilities.invokeLater(SignUpPage::new);
            SwingUtilities.invokeLater(
                ReceiverChatRoomGUI::new);
    }
}
 