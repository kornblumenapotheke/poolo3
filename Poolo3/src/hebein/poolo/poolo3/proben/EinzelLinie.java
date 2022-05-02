package hebein.poolo.poolo3.proben;

import java.util.ArrayList;

import hebein.poolo.poolo3.dispatcher.DispatcherService;

public class EinzelLinie 
{
long myLinienZeit;
ArrayList<EinzelProbe> proben;
String myLinienNummer;
ProbenStatus myBefund;
EinzelRack myRack;
DispatcherService myDispatcher;

	EinzelLinie(String inLinienNummer)
	{
		proben =  new ArrayList<EinzelProbe>();
		myBefund.setStatus(myBefund.IST_IN_AUSWERTUNG);
		myLinienNummer=inLinienNummer;
		myLinienZeit = System.currentTimeMillis();
		
	
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
	public String getLinienNummer ()

	{
		return myLinienNummer;
	
	}
	
	public String getHTML()
	{
		//gibt den HTML der Linie und der darauf liegenden Proben retuour
		return "HTML HIER VON LINIE REKURSIV";
	}
	
//SHOW
	
	public void showInfo()
	{
		//Zeigt mit einem JDialog Infos zur Linie her.
	}
	
//ADD
	public EinzelProbe add(String inProbenID)
	{
		EinzelProbe einzelprobe = new EinzelProbe(inProbenID);
		einzelprobe.setLinie(this);
		einzelprobe.setResult(new ProbenStatus().IST_IN_AUSWERTUNG); //Hier noch richtigenb Status setzen
		einzelprobe.setDispatcher(myDispatcher);
		proben.add(einzelprobe);
		return einzelprobe;
	}
}
