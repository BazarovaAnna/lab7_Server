package server;

import SGUI.Menu;
import SGUI.PansTree;
import SGUI.PassFrame;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ServerGUI extends Thread {
    public static PansTree tree;
    public static JFrame frame;

    @Override
    public void run() {

        frame = new JFrame("Server");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(e.getComponent(), "Do u want to go finish?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                    if (JOptionPane.showConfirmDialog(e.getComponent(), "Leave server working?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == 0) {
                        frame.dispose();
                    } else {
                        System.exit(0);
                    }
                }
            }
        });
        //Create and set up the tree & buttons pane.
        tree = new PansTree();
        tree.setOpaque(true); //content panes must be opaque
        JPanel mainPan = new JPanel();
        mainPan.setLayout(new BoxLayout(mainPan, BoxLayout.Y_AXIS));
        mainPan.add(tree);
        frame.add(mainPan);

        //Create and set up the menu pane.
        Menu demo = new Menu();
        frame.setJMenuBar(demo.createMenuBar());

        //Display the window.
        frame.pack();

        PassFrame pf = new PassFrame(frame);
        pf.pack();
        pf.setVisible(true);
    }

}
