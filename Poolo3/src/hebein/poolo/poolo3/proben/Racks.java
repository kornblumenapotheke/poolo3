package hebein.poolo.poolo3.proben;

import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hebein.poolo.poolo3.tree.PCRTree;
/**
 * Hier werden s�mtliche Racks angelegt
 * @author GuntherBackoffice
 *
 */
public class Racks {
	
	//refs
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	ArrayList<EinzelRack> rackList;
	EinzelRack aktuellesRack;
	int aktuellesRackNummer;
	ProbenVerzeichnis probenverzeichnis;
	PCRTree myPCRTree;
	//konst
		
		
	//KONSTRUKT
	public Racks ()
	{
		rackList = new ArrayList<EinzelRack>();
		aktuellesRackNummer = 0;
		aktuellesRack = new EinzelRack(aktuellesRackNummer);
		rackList.add(aktuellesRack);
		probenverzeichnis = new ProbenVerzeichnis ();
	}
		//SET
		//GET
	public String getHTML()
	{
		String htmlText ="";
		//gibt den HTML der Linie und der darauf liegenden Proben retuour
		for (int i=0;i<rackList.size();i++)
		{
			EinzelRack einzelrack = rackList.get(i);
			htmlText = htmlText + einzelrack.getHTML();
			
		}
		htmlText = "MAINRACK"+ htmlText;
		return "<html><head>\r\n"
				+ "      <style>\r\n"
				+ "         table, th, td {\r\n"
				+ "            border: 1px solid black;\r\n"
				+ "         }\r\n"
				+ "      </style>\r\n"
				+ "   </head><table><tr><th>RackID</th><th>LineId</th><th>Probe lfd Nr</th><th>Probe ID</th><th>Result</th><th>is valid</th></tr>"+htmlText+"</table></html>";
	}
		//SHOW 
	public void showInfo()
	{
		//Zeigt mit einem JDialog Infos zur Linie her.
	}
	
		//ADD

	public void addRack()
	{
		aktuellesRackNummer++;
		aktuellesRack = new EinzelRack(aktuellesRackNummer);
		rackList.add(aktuellesRack);
		myPCRTree.addRack(Integer.toString(aktuellesRackNummer));
		
	}
	
	public void addLinie ()
	{
		aktuellesRack.setTree(myPCRTree);
		aktuellesRack.addLinie();
		
	}
	
	public void addProbe (String inProbenNummer)
	{
		//Checke Probenverzeichnis
		EinzelProbe einzelprobe = new EinzelProbe (inProbenNummer);
		if (probenverzeichnis.addProbe(inProbenNummer, einzelprobe)) //die Nummer existiert nich nicht
		{
			aktuellesRack.addprobe (einzelprobe);
			myPCRTree.addProbe(inProbenNummer);
			System.out.println (getHTML());
			
		}
		else
		{
			//Fehlermeldung dass schon existent!
			JFrame jFrame = new JFrame();
	        JOptionPane.showMessageDialog(jFrame, "Probe schon existent!");
		}
		
	}
	public void setTree(PCRTree inMyPCRTree) {
		// TODO Auto-generated method stub
		myPCRTree =inMyPCRTree;
		
	}

}
