/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
package za.ac.cput.lostandfound.gui;
import java.awt.*;
import javax.swing.*;

import za.ac.cput.lostandfound.domain.Item;

import java.awt.event.*;

/**
 *
 * @author jburns
 */

public class SearchPage extends JFrame implements ActionListener {

    private JButton profileBTN, settingBTN, itemReportBTN, chatRoomBTN, mapBTN, itemVerificationBTN, helpBTN, resetBTN;
    private JComboBox<String> typeOfItemCB, modelTypeCB, colourOfItemCB, lastSeenCB;

    public SearchPage() {
        setTitle("Search Page");
        setSize(420,500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        add(topBar(),BorderLayout.NORTH);
        add(sideBar(),BorderLayout.WEST);
        add(mainPage(),BorderLayout.CENTER);


        setVisible(true);
}

    
private JPanel sideBar() {
    JPanel sideBar = new JPanel();
    sideBar.setLayout(new BoxLayout(sideBar, BoxLayout.Y_AXIS));
    sideBar.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

    
    //sideBar.setLayout(new GridLayout());


    JButton profileBTN = new JButton("Profile");
    // profileBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
      //  profileBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton settingsBTN = new JButton("Settings");
     //settingsBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
       // settingsBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton itemReportBTN = new JButton("Item Report");
    // itemReportBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
      //  itemReportBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton chatRoomBTN = new JButton("ChatRoom");
    // chatRoomBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
      //  chatRoomBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton mapBTN = new JButton("Map");
    // mapBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
      //  mapBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton itemVerificationBTN = new JButton("ItemVerification");
     //itemVerificationBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
       // itemVerificationBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

    JButton helpBTN = new JButton("Help");
     //helpBTN.setFont(new Font("SansSerif", Font.BOLD, 20));
       // helpBTN.setAlignmentX(Component.CENTER_ALIGNMENT);

        //make array and loop through since same font?
  JButton[] buttons = {
    profileBTN, settingsBTN, itemReportBTN, chatRoomBTN, mapBTN, itemVerificationBTN, helpBTN};

    for (JButton btn :buttons) {
        btn.setFont(new Font("SanSerif", Font.BOLD,14));
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btn.setMaximumSize(new Dimension(160,35));
        btn.addActionListener(this);
        sideBar.add(btn);
        sideBar.add(Box.createVerticalStrut(8));

    }
    return sideBar;
  }





private JPanel topBar() {
    JPanel topBar = new JPanel();
    topBar.setLayout(new BorderLayout());
    topBar.setBorder(BorderFactory.createEmptyBorder(10,20,10,20)); //adjust to fit 
    
    JLabel filtersLBL = new JLabel("Filters");
    filtersLBL.setFont(new Font("SanSerif", Font.BOLD,23));
    
    JButton resetBTN = new JButton("Reset");
    resetBTN.setFont(new Font("SanSerif", Font.ITALIC,12));
        resetBTN.setAlignmentX(Component.CENTER_ALIGNMENT);
        resetBTN.addActionListener(this);

    topBar.add(filtersLBL, BorderLayout.WEST);
    topBar.add(resetBTN, BorderLayout.EAST);
    
    return topBar;


}

private JPanel mainPage() {
    JPanel mainPage = new JPanel();
    mainPage.setLayout(new GridLayout(4,1));

    String[] itemTypeStrings = {"Technology", "Clothing", "Valuable", "Misc"};
    JComboBox typeOfItemCB = new JComboBox<>(itemTypeStrings);
    typeOfItemCB.addActionListener(this);

    String[] modelTypeStrings = {"Iphone XR", "Iphone 11", "Iphone 17", "Samsung Galaxy S22"}; 
    JComboBox modelTypeCB = new JComboBox<>(modelTypeStrings);
    modelTypeCB.addActionListener(this);

    String[] colourOfItemStrings = {"Red","Green","Blue"};
    JComboBox colourOfItemCB = new JComboBox<>(colourOfItemStrings);
    colourOfItemCB.addActionListener(this);

    String[] lastSeenStrings = {"Import from current location", "Import from Maps"};
    JComboBox lastSeenCB = new JComboBox<>(lastSeenStrings);
    lastSeenCB.addActionListener(this);

    mainPage.add(typeOfItemCB);
    mainPage.add(modelTypeCB);
    mainPage.add(colourOfItemCB);
    mainPage.add(lastSeenCB);

    return mainPage;
}


@Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == resetBTN) {
            typeOfItemCB.setSelectedIndex(0);
            modelTypeCB.setSelectedIndex(0);
            colourOfItemCB.setSelectedIndex(0);
            lastSeenCB.setSelectedIndex(0);
            return;
        }
    }
    //edit layout to fit design 











    //combo boxes will funtion like :get text option 1 selected in first CB, filter through db, get text option 2, filter db etc until all cb are selected, list applicable items (eg; technology, iphone 11, blue, found at d6 campus. -> display items  )
    
    /* DONT BOLT ONTO UI CLASS USE SEPERATE CLASS AND CALL THESE FUNCTIONS 
    
    public class TestSearch {
    public static void main(String[] args) {
        ItemDAO dao = new ItemDAO();
        List<Item> results = dao.searchItems("Technology", "Iphone 11", "Blue", "Location from maps");
        for (Item i : results) {
            System.out.println(i);
        }
    }
}
    */


}
       // gridlayout 
    //dropdown menu (list items like type tech, model, iphone, colour red, last seen location)
    //blank button (profile, settings, item report etc)
    //reset button 
    //import icon for home button search and app 

