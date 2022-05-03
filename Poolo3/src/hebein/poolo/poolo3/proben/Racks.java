package hebein.poolo.poolo3.proben;

import java.util.ArrayList;
import java.util.logging.Logger;
/**
 * Hier werden sämtliche Racks angelegt
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
	//konst
		
		
	//KONSTRUKT
	Racks ()
	{
		rackList = new ArrayList<EinzelRack>();
		aktuellesRackNummer = 0;
		aktuellesRack = new EinzelRack(aktuellesRackNummer);
		rackList.add(aktuellesRack);
		probenverzeichnis = new ProbenVerzeichnis ();
	}
		//SET
		//GET
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
		
	}
	
	public void addLinie ()
	{
		aktuellesRack.addLinie();
		
	}
	
	public void addProbe (String inProbenNummer)
	{
		//Checke Probenverzeichnis
		aktuellesRack.addprobe (inProbenNummer);
		
	}

}
