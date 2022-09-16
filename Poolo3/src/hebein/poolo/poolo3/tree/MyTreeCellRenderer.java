package hebein.poolo.poolo3.tree;
import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import hebein.poolo.poolo3.inputpanel.Settings;
import hebein.poolo.poolo3.proben.EinzelProbe;
import hebein.poolo.poolo3.proben.ProbenStatus;
import hebein.poolo.poolo3.proben.ProbenVerzeichnis;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {

	ProbenVerzeichnis probenverzeichnis;
	public void setProbenVerzeichnis (ProbenVerzeichnis inProbenverzeichnis)
	{
		probenverzeichnis = inProbenverzeichnis;
	}
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
            
            //hole probennummer
        	String probennummer = node.substring(node.indexOf(": ")+2);
        	System.out.println ("PROBENNUMMER CHECK IT: "+probennummer);
            //hole einzelprobe
        	EinzelProbe einzelprobe = probenverzeichnis.getprobe(probennummer);
            //hole status von einzelprobe
        	
            //farbe nach Settings auswählen
            switch (einzelprobe.getStatus().getStatus()) //status
            {
            case ProbenStatus.INVALID:
            	setForeground(Settings.foreground_einzelprobe_INVALID);
            	setBackground (Settings.background_einzelprobe_INVALID);
            	break;
            case ProbenStatus.NOT_CONSTRUCTED: //kein Konstriuktor aufgerufen
            	setForeground(Settings.foreground_einzelprobe_NOT_CONSTRUCTED);
            	setBackground (Settings.background_einzelprobe_NOT_CONSTRUCTED);
            	break;
            case ProbenStatus.IST_IN_AUSWERTUNG:  //Wiord ausgewertet, keiner Ergebnis
            	setForeground(Settings.foreground_einzelprobe_IST_IN_AUSWERTUNG);
            	setBackground (Settings.background_einzelprobe_IST_IN_AUSWERTUNG);
            	break;
            case ProbenStatus.IST_POSITIV: //Ergebnis NACHGEWIESEN
            	setForeground(Settings.foreground_einzelprobe_IST_POSITIV);
            	setBackground (Settings.background_einzelprobe_IST_POSITIV);
            	break;
            case ProbenStatus.IST_NEGATIV:  //Ergebnis NICHTS NACHGEWIESEN
            	setForeground(Settings.foreground_einzelprobe_IST_NEGATIV);
            	setBackground (Settings.background_einzelprobe_IST_NEGATIV);
            	break;
            case ProbenStatus.IST_UNCLEAR:  //Ergebnis unklar, kein Befund
            	setForeground(Settings.foreground_einzelprobe_IST_UNCLEAR);
            	setBackground (Settings.background_einzelprobe_IST_UNCLEAR);
            	break;
            case ProbenStatus.IST_POSITIVE_POOL:
            	setForeground(Settings.foreground_einzelprobe_IST_POSITIVE_POOL);
            	setBackground (Settings.background_einzelprobe_IST_POSITIVE_POOL);
            	break;
            default:
            	setForeground(Settings.foreground_einzelprobe_DEFAULT);
            	setBackground (Settings.background_einzelprobe_DEFAULT);
            	break;
            }
            
            setOpaque(true);
        }

        return this;
    }
}