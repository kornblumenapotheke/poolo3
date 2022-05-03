package hebein.poolo.poolo3.proben;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class EinzelRack 
{
	//refs
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	int myRackNummer=-999;
	ArrayList<EinzelLinie> einzelLinien; 
	EinzelLinie aktuelleEinzelLinie;
	int nummerAktuelleEinzelLinie=-999;
	
	//konst
	
	
	//KONSTRUKT
	EinzelRack (int inRackNummer)
	{
		myRackNummer=inRackNummer;
		einzelLinien = new ArrayList<EinzelLinie>();
		nummerAktuelleEinzelLinie = 0;
		aktuelleEinzelLinie = new EinzelLinie(nummerAktuelleEinzelLinie);
		einzelLinien.add(aktuelleEinzelLinie);
		
	}
	
	//SET
	
	//GET
	private int getNumberRack ()
	{
		return myRackNummer;
	}
	
	private int getCountLines ()
	{
		return 0;
	}
	
	private int getCountProben()
	{
		return 0;
	}
	
	public String getHTML()
	{
		String htmlText ="";
		//gibt den HTML der Linie und der darauf liegenden Proben retuour
		for (int i=0;i<einzelLinien.size();i++)
		{
			EinzelLinie einzelLinie = einzelLinien.get(i);
			htmlText = htmlText + " " + einzelLinie.getHTML();
			
		}
		htmlText = "RACK: "+getNumberRack() +  htmlText;
		return htmlText;
	}
	
	//SHOW 
	public void showInfo()
	{
		JFrame jFrame = new JFrame ("INFO");
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout());
		jPanel.add(new JButton("ID of Rack"+Integer.toString(getNumberRack())));
		jPanel.add(new JButton("NO of Lines"+Integer.toString(getCountLines())));
		jPanel.add(new JButton("NO of Probes"+Integer.toString(getCountProben())));
		jFrame.add(jPanel);
		jFrame.show();
		jFrame.pack();
	}

	
	
	//ADD
	
	public void addLinie() {
		// TODO Auto-generated method stub
		
		
	}

	public void addprobe(EinzelProbe einzelprobe) {
		// TODO Auto-generated method stub
		einzelprobe.setRack(this);
		aktuelleEinzelLinie.add(einzelprobe);
		
		
	}
	
	public static void main(String args[])
	{
		EinzelRack er =new EinzelRack(0);
		er.showInfo();
	}

}
