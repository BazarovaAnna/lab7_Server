package SGUI;

import manage.Commands;
import model.Pancakes;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.*;
import java.awt.*;
import java.util.Hashtable;

class DynamicTree extends JPanel {
    private DefaultMutableTreeNode rootNode;
    static DefaultTreeModel treeModel;
    private JTree tree;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();


    DynamicTree() {
        super(new GridLayout(1, 0));

        rootNode = new DefaultMutableTreeNode("The Pancakes Collection");
        treeModel = new DefaultTreeModel(rootNode);
        treeModel.addTreeModelListener(new MyTreeModelListener());
        tree = new JTree(treeModel);
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);

        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane);
    }

    /**
     * Remove all nodes except the root node.
     */
    void clear() {
        rootNode.removeAllChildren();
        treeModel.reload();

    }

    /**
     * Remove the currently selected node.
     */
    void removeCurrentNode(Hashtable<Integer, Pancakes> pl) {
        TreePath currentSelection = tree.getSelectionPath();
        if (currentSelection != null) {
            DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode)
                    (currentSelection.getLastPathComponent());
            MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
            if (parent != null) {
                String j = currentNode.toString();
                String[] m = j.split(" ");
                if (m.length >= 3) {
                    Commands.remove(pl, m[0]);
                }
                treeModel.removeNodeFromParent(currentNode);
                return;
            }
        }

        // Either there was no selection, or the root was selected.
        toolkit.beep();
    }

    /**
     * Add child to the currently selected node.
     */
    DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode;
        TreePath parentPath = tree.getSelectionPath();

        if (parentPath == null) {
            parentNode = rootNode;
        } else {
            parentNode = (DefaultMutableTreeNode)
                    (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                     Object child) {
        return addObject(parent, child, false);
    }

    private DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                             Object child,
                                             boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);

        if (parent == null) {
            parent = rootNode;
        }

        //It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            tree.scrollPathToVisible(new TreePath(childNode.getPath()));
        }
        return childNode;
    }

    class MyTreeModelListener implements TreeModelListener {
        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

            /*
             * If the event lists children, then the changed
             * node is the child of the node we've already
             * gotten.  Otherwise, the changed node and the
             * specified node are the same.
             */

            int index = e.getChildIndices()[0];
            node = (DefaultMutableTreeNode) (node.getChildAt(index));

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + node.getUserObject());
        }

        public void treeNodesInserted(TreeModelEvent e) {
        }

        public void treeNodesRemoved(TreeModelEvent e) {
        }

        public void treeStructureChanged(TreeModelEvent e) {
        }
    }
}