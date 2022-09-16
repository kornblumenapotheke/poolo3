package hebein.poolo.poolo3.proben;

import java.util.ArrayList;
import java.util.logging.Logger;

import hebein.poolo.poolo3.dispatcher.DispatcherService;

public class EinzelLinie 
{
long myLinienZeit;
ArrayList<EinzelProbe> proben;
int myLinienNummer;
ProbenStatus myBefund;
EinzelRack myRack;
DispatcherService myDispatcher;
Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
int aktuelleposition = -999;

	EinzelLinie(int inLinienNummer)
	{
		proben =  new ArrayList<EinzelProbe>();
		myBefund = new ProbenStatus();
		myBefund.setStatus(myBefund.IST_IN_AUSWERTUNG);
		myLinienNummer=inLinienNummer;
		myLinienZeit = System.currentTimeMillis();
		aktuelleposition = 0;
		
	
	}
//SET
	public void setRack(EinzelRack inRack)
	{
		myRack=inRack;
	}
	
	public void setDispatcher (DispatcherService inDispatcher)
	{
		myDispatcher = inDispatcher;
	}
	
	public void setStatusLinie(int inStatus)
	{
	//jede Probe einzeln aufrufen udn Status setzen;	
	}
	
	
//GET
	
	public ArrayList<EinzelProbe> getProben()
	{
		return proben;
	}
	
	public ProbenStatus getBefund ()
	{
		return myBefund;
	}
	public int getLinienNummer ()

	{
		return myLinienNummer;
	
	}
	
	public String getHTML()
	{
		String htmlText ="";
		//gibt den HTML der Linie und der darauf liegenden Proben retuour
		for (int i=0;i<proben.size();i++)
		{
			EinzelProbe einzelprobe = proben.get(i);
			htmlText = htmlText + einzelprobe.getHTML();
			
		}
		htmlText = "<tr bgcolor=\"#eee\"><td></td><td>"+"LINIE: "+(char)(64+getLinienNummer())+"</td><td></td><td></td><td></td><td></td></tr>" + htmlText;
		return htmlText;
	}
	
//SHOW
	
	public void showInfo()
	{
		//Zeigt mit einem JDialog Infos zur Linie her.
	}
	
//ADD
	public void add(EinzelProbe einzelprobe)
	{
		einzelprobe.setLinie(this);
		einzelprobe.setResult(new ProbenStatus().IST_IN_AUSWERTUNG); //Hier noch richtigenb Status setzen
		einzelprobe.setDispatcher(myDispatcher);
		aktuelleposition++;
		einzelprobe.setPosition(aktuelleposition);
		proben.add(einzelprobe);
		
	}
	public int getAktuelleProbe() {
		// TODO Auto-generated method stub
		return aktuelleposition;
		//return 999;
	}
}
