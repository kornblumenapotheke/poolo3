package hebein.poolo.poolo3.tree;
import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
            boolean sel, boolean exp, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, exp, leaf, row, hasFocus);

        // Assuming you have a tree of Strings
        String node = (String) ((DefaultMutableTreeNode) value).getUserObject();

        // If the node is a leaf and ends with "xxx"
        if (node.contains("Untersuchung")) {
            // Paint the node in blue
            setForeground(Color.BLACK);
            setBackground (Color.WHITE);
            setOpaque(true);
        }
        if (node.contains("RACK")) {
            // Paint the node in blue
            setForeground(Color.white);
            setBackground (Color.BLACK);
            setOpaque(true);
        }
        
        if (node.contains("LINE")) {
            // Paint the node in blue
        	setForeground(Color.white);
            setBackground (Color.DARK_GRAY);
            setOpaque(true);
        }
        
        if (node.contains("PROBE")) {
            // Paint the node in blue
            setForeground(Color.BLACK);
            setBackground (new Color(ThreadLocalRandom.current().nextInt(125, 256),ThreadLocalRandom.current().nextInt(125, 256),ThreadLocalRandom.current().nextInt(125, 256)));
            setOpaque(true);
        }

        return this;
    }
}