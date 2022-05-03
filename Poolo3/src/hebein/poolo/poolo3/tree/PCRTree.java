package hebein.poolo.poolo3.tree;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

public class PCRTree 
{
	public static final Logger log = Logger.getLogger(PCRTree.class.getName());

	private DefaultMutableTreeNode myTreeRoot;
	private JTree myTree;
	DefaultMutableTreeNode actualRack;
	DefaultMutableTreeNode actualLine;
	
	
	PCRTree ()
	{
		myTreeRoot = new DefaultMutableTreeNode ("Untersuchung");
	}
	
	public DefaultMutableTreeNode createTree()
	{
	 DefaultMutableTreeNode root = new DefaultMutableTreeNode( "Durchlauf" );       
     return root;
	}
	
	public TreeNode getTreeRoot()
	{
		return myTreeRoot;
	}

	public void addProbe(String inString) 
	{
		// TODO Auto-generated method stub
		log.info ("Tree added");
		actualLine.add(new DefaultMutableTreeNode("PROBE:"+ inString));
		treeExpand();
		
	}
	
	public void addRack (String inString)
	{
		log.info ("Rack added");
		actualRack=new DefaultMutableTreeNode("RACK: "+inString);
		myTreeRoot.add(actualRack);
		treeExpand();
		
	}
	
	public void addLine (String inString)
	{
		log.info ("Tree added");
		actualLine= new DefaultMutableTreeNode("LINE: "+ inString);				
		actualRack.add(actualLine);
		treeExpand();
	}
	
	public void treeExpand()
	{
		
	    
		
	}
	
	public void setTree (JTree inTree)
	{
		myTree = inTree;
	}
}
