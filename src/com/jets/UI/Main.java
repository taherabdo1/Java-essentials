package com.jets.UI;

/*
 * Main.java
 *
 * Created on February 17, 2006, 4:00 PM
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
//import BuddyCellRenderer.Adapter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.ListModel;

/**
 * @author Hans Muller (Hans.Muller@Sun.COM)
 */
public class Main {

    private Container cp;
    //modified by taher it was a private static class
    static BuddyModel model;

    static class Buddy {

        String name;
        BuddyCellRenderer.Adapter.Status status;
        String message;
        URL buddyIconURL;

        Buddy(String name, BuddyCellRenderer.Adapter.Status status, String message, String buddyIcon) {
            this.name = name;

            this.status = status;
            this.message = message;
            this.buddyIconURL = (buddyIcon == null) ? null
                    : Main.class.getResource("/resources/sample-buddy-icons/" + buddyIcon);
        }
    }

    private static class BuddyAdapter extends BuddyCellRenderer.Adapter {

        private final Map<URL, ImageIcon> iconCache = new HashMap<URL, ImageIcon>();

        private Buddy getBuddy() {
            return (Buddy) getValue();
        }

        public String getName() {
            return getBuddy().name;
        }

        public Status getStatus() {
            return getBuddy().status;
        }

        public String getMessage() {
            return getBuddy().message;
        }

        public ImageIcon getBuddyIcon() {
            URL url = getBuddy().buddyIconURL;
            if (url == null) {
                return null;
            }
            ImageIcon icon = iconCache.get(url);
            if (icon != null) {
                return icon;
            }
            icon = new ImageIcon(url);
            iconCache.put(url, icon);
            return icon;
        }
    }

    public JList initialize() {
       /* try {
            String name = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(name);
        } catch (Exception e) {
            // TBD log a warning
        }*/

        Buddy buddyList[] = {
            new Buddy("Quark", BuddyCellRenderer.Adapter.Status.AWAY, "Away From My Nucleus (Never Idle)", null),
            new Buddy("Alfalfa", BuddyCellRenderer.Adapter.Status.AWAY, "Away From My Desk", "alfalfa.jpg"),
            new Buddy("Aretha", BuddyCellRenderer.Adapter.Status.ONLINE, null, "aretha.jpg"),
            new Buddy("Johnny", BuddyCellRenderer.Adapter.Status.ONLINE, "Online (Idle 90 Seconds)", "carson.jpg"),
            new Buddy("Winston", BuddyCellRenderer.Adapter.Status.ONLINE, "Working on Memoirs", "churchill.jpg"),
            new Buddy("Darth", BuddyCellRenderer.Adapter.Status.AWAY, "I Am Your Father", "darth.jpg"),
            new Buddy("EraserHead", BuddyCellRenderer.Adapter.Status.AWAY, "On Vacation", "eraserhead.jpg"),
            new Buddy("Felix", BuddyCellRenderer.Adapter.Status.OFFLINE, null, "felix.jpg"),
            new Buddy("Marvin", BuddyCellRenderer.Adapter.Status.AWAY, "Thinking ...", "marvin.jpg"),
            new Buddy("Mona", BuddyCellRenderer.Adapter.Status.ONLINE, null, "mona.jpg"),
            new Buddy("Snark", BuddyCellRenderer.Adapter.Status.ONLINE, null, null)
        };
        model = new BuddyModel(buddyList);
        model.addElement(new Buddy("taher", BuddyCellRenderer.Adapter.Status.ONLINE, null, "mona.jpg"));
        JList buddyJList = new JList();
        BuddyCellRenderer bcr = new BuddyCellRenderer(new BuddyAdapter());
        buddyJList.setCellRenderer(bcr);
        buddyJList.setModel(model);
        model.addElement(new Buddy("taher2", BuddyCellRenderer.Adapter.Status.ONLINE, null, "mona.jpg"));

        /* Set prototypeCellValue to force all cells (rows) to 
         * have the same height.  This is important because 
         * cells that correspond to an offline buddy only
         * contain one line of text and will end up be a 
         * little smaller (vertically) than the others.
         */
        //buddyJList.setPrototypeCellValue(buddyList[0]);
        buddyJList.setPrototypeCellValue(model.elementAt(0));
        Toolkit.getDefaultToolkit().setDynamicLayout(true);
        
        return buddyJList;
        //mainFrame = new JFrame("BuddyList");
        //Container cp = mainFrame.getContentPane();
        //cp.setLayout(new BorderLayout());
        //JScrollPane scrollPane = new JScrollPane(buddyJList);
        //cp.add(scrollPane, BorderLayout.CENTER);
    }

/*    private void show() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
*/
    public void getMenu(final Container cont) {
       // this.mainFrame = cont;
        Runnable doCreateAndShowGUI = new Runnable() {
            public void run() {
                try {
         
        Main app = new Main();
        app.cp = cont;
        app.initialize();//
        model.addElement(new Buddy("taher3", BuddyCellRenderer.Adapter.Status.ONLINE, null, "mona.jpg"));
                }
               catch (Exception e) {
                    // TBD log an error
                }
            }
        };
        SwingUtilities.invokeLater(doCreateAndShowGUI);
    
//        app.show();

    }

}
