package SGUI;


import manage.Commands;
import server.SampleServer;
import server.ServerGUI;
import server.Windows1251Control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class Menu implements ActionListener {
    private static String READ_COMMAND = "read";
    private static String SAVE_COMMAND = "save";
    private static String UPDATE_COMMAND = "update";
    private static String RUS = "rus";
    private static String ROU = "rou";
    private static String ENG = "eng";
    private static String SWE = "swe";

    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleServer.locale, new Windows1251Control());

    public JMenuBar createMenuBar() {
        JMenuBar menuBar;


        //Create the menu bar.
        menuBar = new JMenuBar();

        //Build the first menu.
        JMenu menu = new JMenu(rb.getString("Menu"));
        menu.setMnemonic(KeyEvent.VK_M);
        menuBar.add(menu);

        //a group of JMenuItems
        JMenuItem menuItem1 = new JMenuItem(rb.getString("Read"),
                KeyEvent.VK_R);

        menuItem1.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem1.setActionCommand(READ_COMMAND);
        menuItem1.addActionListener(this);
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem(rb.getString("Save"),
                KeyEvent.VK_S);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem2.setActionCommand(SAVE_COMMAND);
        menuItem2.addActionListener(this);
        menu.add(menuItem2);

        JMenuItem menuItem3 = new JMenuItem(rb.getString("Update"),
                KeyEvent.VK_U);
        //menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
        menuItem3.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem3.setActionCommand(UPDATE_COMMAND);
        menuItem3.addActionListener(this);
        menu.add(menuItem3);

        JMenu menu1 = new JMenu(rb.getString("Language"));
        menu1.setMnemonic(KeyEvent.VK_L);
        menuBar.add(menu1);

        JMenuItem menuItem4 = new JMenuItem(rb.getString("eng"),
                KeyEvent.VK_E);

        menuItem4.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem4.setActionCommand(ENG);
        menuItem4.addActionListener(this);
        menu1.add(menuItem4);

        JMenuItem menuItem5 = new JMenuItem(rb.getString("rus"),
                KeyEvent.VK_R);

        menuItem5.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_2, ActionEvent.ALT_MASK));
        menuItem5.setActionCommand(RUS);
        menuItem5.addActionListener(this);
        menu1.add(menuItem5);

        JMenuItem menuItem6 = new JMenuItem(rb.getString("rou"),
                KeyEvent.VK_O);

        menuItem6.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_3, ActionEvent.ALT_MASK));
        menuItem6.setActionCommand(ROU);
        menuItem6.addActionListener(this);
        menu1.add(menuItem6);

        JMenuItem menuItem7 = new JMenuItem(rb.getString("swe"),
                KeyEvent.VK_S);

        menuItem7.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_4, ActionEvent.ALT_MASK));
        menuItem7.setActionCommand(SWE);
        menuItem7.addActionListener(this);
        menu1.add(menuItem7);

        return menuBar;
    }

    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();
        if (READ_COMMAND.equals(command)) {
            //Read button clicked
            try {
                Commands.read(SampleServer.pl.Mo);
            } catch (Exception exc) {
                toolkit.beep();
            }
            (ServerGUI.tree.getModel()).reload();
            ServerGUI.frame.repaint();

        } else if (SAVE_COMMAND.equals(command)) {
            //Save button clicked
            Commands.write(SampleServer.pl.Mo);
        } else if (UPDATE_COMMAND.equals(command)) {
            //Update button clicked.
            (ServerGUI.tree.getModel()).reload();
            ServerGUI.frame.repaint();
        } else if(ROU.equals(command)){
            SampleServer.locale=new Locale("ro","RO");
            Commands.read(SampleServer.pl.Mo);
            SampleServer.sgui.close();
            SampleServer.sgui = new ServerGUI();
            SampleServer.sgui.start();
        }else if(RUS.equals(command)){
            SampleServer.locale=new Locale("ru","RU");
            Commands.read(SampleServer.pl.Mo);
            SampleServer.sgui.close();
            SampleServer.sgui = new ServerGUI();
            SampleServer.sgui.start();
        }else if(SWE.equals(command)){
            SampleServer.locale=new Locale("sv","SE");
            Commands.read(SampleServer.pl.Mo);
            SampleServer.sgui.close();
            SampleServer.sgui = new ServerGUI();
            SampleServer.sgui.start();
        }else if(ENG.equals(command)){
            SampleServer.locale=new Locale("en","GB");
            Commands.read(SampleServer.pl.Mo);
            SampleServer.sgui.close();
            SampleServer.sgui = new ServerGUI();
            SampleServer.sgui.start();
        }
    }
}