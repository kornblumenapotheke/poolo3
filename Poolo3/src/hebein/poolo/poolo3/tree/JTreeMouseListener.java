package hebein.poolo.poolo3.tree;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JTreeMouseListener extends MouseAdapter {
	
	public void mousePressed(MouseEvent e) {
        int selRow = tree.getRowForLocation(e.getX(), e.getY());
        TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if(selRow != -1) {
            if(e.getClickCount() == 1) {
                mySingleClick(selRow, selPath);
            }
            else if(e.getClickCount() == 2) {
                myDoubleClick(selRow, selPath);
            }
        }
    }

}
