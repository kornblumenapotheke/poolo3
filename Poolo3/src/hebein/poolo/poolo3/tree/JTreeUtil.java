package hebein.poolo.poolo3.tree;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class JTreeUtil {
  
	 private void expandAll(JTree tree, TreePath path, boolean expand) {
	        TreeNode node = (TreeNode) path.getLastPathComponent();

	        if (node.getChildCount() >= 0) {
	            Enumeration<? extends TreeNode> enumeration = node.children();
	            while (enumeration.hasMoreElements()) {
	                TreeNode treeNode = enumeration.nextElement();
	                TreePath treePath = path.pathByAddingChild(treeNode);

	                expandAll(tree, treePath, expand);
	            }
	        }

	        if (expand) {
	            tree.expandPath(path);
	        } else {
	            tree.collapsePath(path);
	    }
	 }

	 public void expandTree(JTree tree, boolean expand) {
	        TreeNode root = (TreeNode) tree.getModel().getRoot();
	        expandAll(tree, new TreePath(root), expand);
	    }
}