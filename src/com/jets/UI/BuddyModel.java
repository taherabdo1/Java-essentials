package com.jets.UI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.DefaultListModel;

/**
 *
 * @author taher
 */
public class BuddyModel extends DefaultListModel<Main.Buddy>{

    public BuddyModel(Main.Buddy[] buddies) {
    
        for(Main.Buddy bdy : buddies)
            addElement(bdy);
    }
    
    
}
