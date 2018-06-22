package SGUI;


import manage.Commands;
import manage.JasonException;
import manage.Parse;
import model.Pancakes;
import model.PansNames;
import model.Size;
import server.SampleServer;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

public class PansTree extends JPanel
        implements ActionListener {
    private int newNodeSuffix = 1;
    private static String ADD_COMMAND = "add";
    private static String REMOVE_COMMAND = "remove";
    private static String CLEAR_COMMAND = "clear";
    private static DynamicTree treePanel;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private JTextField textField;


    public PansTree() {
        super(new BorderLayout());

        //Create the components.
        treePanel = new DynamicTree();
        populateTree(treePanel);

        JButton addButton = new JButton("Add");
        addButton.setActionCommand(ADD_COMMAND);
        addButton.addActionListener(this);

        JButton removeButton = new JButton("Remove");
        removeButton.setActionCommand(REMOVE_COMMAND);
        removeButton.addActionListener(this);

        JButton clearButton = new JButton("Clear");
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

        String category1Name = "By COLOR";
        DefaultMutableTreeNode category1;
        category1 = treePanel.addObject(null, category1Name);
        String type11Name = "YELLOW";
        String type12Name = "BROWN";
        String type13Name = "BLUE";
        String type14Name = "RED";
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

        String category2Name = "By SIZE";
        DefaultMutableTreeNode category2;
        category2 = treePanel.addObject(null, category2Name);
        String type21Name = "BIG";
        String type22Name = "MEDIUM";
        String type23Name = "SMALL";
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

        String category3Name = "By TYPE";
        DefaultMutableTreeNode category3;
        category3 = treePanel.addObject(null, category3Name);
        String type31Name = "BANANA";
        String type32Name = "CHOCOLATE";
        String type33Name = "VANILLA";
        String type34Name = "USUAL";
        DefaultMutableTreeNode type31, type32, type33, type34;
        type31 = treePanel.addObject(category3, type31Name);
        type32 = treePanel.addObject(category3, type32Name);
        type33 = treePanel.addObject(category3, type33Name);
        type34 = treePanel.addObject(category3, type34Name);

        for (
                Integer key : new TreeSet<>(SampleServer.pl.Mo.keySet()))

        {
            Pancakes o = SampleServer.pl.Mo.get(key);
            DefaultMutableTreeNode pancake = new DefaultMutableTreeNode(o.toString());
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

        String category4Name = "ALL";
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
                } catch (JasonException exc) {
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