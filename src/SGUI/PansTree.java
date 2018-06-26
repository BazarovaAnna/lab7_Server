package SGUI;


import manage.*;
import model.Pancakes;
import model.PansNames;
import model.Size;
import server.SampleServer;
import server.Windows1251Control;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TreeSet;

public class PansTree extends JPanel
        implements ActionListener{
    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private static DynamicTree treePanel;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private JTextField textField;
    ResourceBundle rb = ResourceBundle.getBundle("locale.Resources", SampleServer.locale, new Windows1251Control());

    public PansTree() {
        super(new BorderLayout());
        Locale.setDefault(SampleServer.locale);
        //Create the components.
        treePanel = new DynamicTree();
        populateTree(treePanel);

        JButton addButton = new JButton(rb.getString("Add"));
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);

        JButton removeButton = new JButton(rb.getString("Remove"));
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);

        JButton clearButton = new JButton(rb.getString("Clear"));
        clearButton.setActionCommand(CLEAR_COMMAND);
        clearButton.addActionListener(this);

        textField = new JTextField();

        //Lay everything out.
        treePanel.setPreferredSize(new Dimension(300, 150));
        add(treePanel, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(clearButton);
        panel.add(textField);
        add(panel, BorderLayout.SOUTH);
    }

    public DefaultTreeModel getModel() {
        treePanel.clear();
        populateTree(treePanel);
        return treePanel.treeModel;
    }

    private void populateTree(DynamicTree treePanel) {

        String category1Name = rb.getString("ByColor");
        DefaultMutableTreeNode category1;
        category1 = treePanel.addObject(null, category1Name);
        String type11Name = rb.getString("YELLOW");
        String type12Name = rb.getString("BROWN");
        String type13Name = rb.getString("BLUE");
        String type14Name = rb.getString("RED");
        DefaultMutableTreeNode type11, type12, type13, type14;
        type11 = treePanel.addObject(category1, type11Name);
        type12 = treePanel.addObject(category1, type12Name);
        type13 = treePanel.addObject(category1, type13Name);
        type14 = treePanel.addObject(category1, type14Name);

        for (Integer key : new TreeSet<>(SampleServer.pl.Mo.keySet())) {
            Pancakes o = SampleServer.pl.Mo.get(key);
            switch (o.color) {
                case ("YELLOW"):
                    treePanel.addObject(type11, o.toString());
                    break;
                case ("BROWN"):
                    treePanel.addObject(type12, o.toString());
                    break;
                case ("BLUE"):
                    treePanel.addObject(type13, o.toString());
                    break;
                case ("RED"):
                    treePanel.addObject(type14, o.toString());
                    break;
            }


        }

        String category2Name = rb.getString("BySIZE");
        DefaultMutableTreeNode category2;
        category2 = treePanel.addObject(null, category2Name);
        String type21Name = rb.getString("BIG");
        String type22Name = rb.getString("MEDIUM");
        String type23Name = rb.getString("SMALL");
        DefaultMutableTreeNode type21, type22, type23;
        type21 = treePanel.addObject(category2, type21Name);
        type22 = treePanel.addObject(category2, type22Name);
        type23 = treePanel.addObject(category2, type23Name);

        for (
                Integer key : new TreeSet<>(SampleServer.pl.Mo.keySet()))

        {
            Pancakes o = SampleServer.pl.Mo.get(key);
            if (o.size.equals(Size.BIG)) {
                treePanel.addObject(type21, o.toString());
            } else if (o.size.equals(Size.MEDIUM)) {
                treePanel.addObject(type22, o.toString());
            } else if (o.size.equals(Size.SMALL)) {
                treePanel.addObject(type23, o.toString());
            }
        }

        String category3Name = rb.getString("ByTYPE");
        DefaultMutableTreeNode category3;
        category3 = treePanel.addObject(null, category3Name);
        String type31Name = rb.getString("BANANA");
        String type32Name = rb.getString("CHOCOLATE");
        String type33Name = rb.getString("VANILLA");
        String type34Name = rb.getString("USUAL");
        DefaultMutableTreeNode type31, type32, type33, type34;
        type31 = treePanel.addObject(category3, type31Name);
        type32 = treePanel.addObject(category3, type32Name);
        type33 = treePanel.addObject(category3, type33Name);
        type34 = treePanel.addObject(category3, type34Name);

        for (
                Integer key : new TreeSet<>(SampleServer.pl.Mo.keySet()))

        {
            Pancakes o = SampleServer.pl.Mo.get(key);
            if (o.name.equals(PansNames.BANANA)) {
                treePanel.addObject(type31, o.toString());
            } else if (o.name.equals(PansNames.CHOC)) {
                treePanel.addObject(type32, o.toString());
            } else if (o.name.equals(PansNames.VANILLA)) {
                treePanel.addObject(type33, o.toString());
            } else if (o.name.equals(PansNames.PAN)) {
                treePanel.addObject(type34, o.toString());
            }
        }

        String category4Name = rb.getString("ALL");
        DefaultMutableTreeNode category4;
        category4 = treePanel.addObject(null, category4Name);

        for (
                Integer key : new TreeSet<>(SampleServer.pl.Mo.keySet()))

        {
            Pancakes o = SampleServer.pl.Mo.get(key);
            treePanel.addObject(category4, o.toString());
        }

    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (ADD_COMMAND.equals(command)) {
            //Add button clicked
            String data = textField.getText();
            if (data != null && !data.equals("")) {
                try {
                    Commands.add(SampleServer.pl.Mo, data);
                    Parse.deserialaize(data);
                    Pancakes pan = new Pancakes(Parse.Size, Parse.Name, Parse.Id, Parse.Location);
                    treePanel.addObject(pan);
                } catch (Exception exc) {
                    toolkit.beep();
                }
            } else {
                toolkit.beep();
            }
        } else if (REMOVE_COMMAND.equals(command)) {
            //Remove button clicked
            treePanel.removeCurrentNode(SampleServer.pl.Mo);


        } else if (CLEAR_COMMAND.equals(command)) {
            //Clear button clicked.
            Commands.clear(SampleServer.pl.Mo);
            treePanel.clear();
        }
    }

}