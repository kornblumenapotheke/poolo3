package hebein.poolo.poolo3.proben;

import java.util.logging.Logger;

import hebein.poolo.poolo3.dispatcher.DispatcherService;

public class EinzelProbe 
{
	long myProbenZeit;
	EinzelRack myRack;
	EinzelLinie myLinie;
	String myProbenId;
	boolean isValid = false;
	ProbenStatus myStatus = new ProbenStatus();
	DispatcherService myDispatcher;
	int meinePosition = -999;
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	
	EinzelProbe(String inProbenID)
	{
		myStatus.setStatus(myStatus.IST_IN_AUSWERTUNG);
		myProbenZeit = System.currentTimeMillis();
		myProbenId = inProbenID;
		isValid = true;
		meinePosition = -888;
		
	}

//SETS 
	
	public void setRack (EinzelRack inRack)
	{
		myRack = inRack;	
	}
	
	public void setLinie (EinzelLinie inLinie)
	{
		myLinie = inLinie;
	}
	
	public void setResult(int inResult)
	{
		myStatus.setStatus(inResult);
	}
	
	public void setDispatcher (DispatcherService inDispatcher)
	{
		myDispatcher = inDispatcher;		
	}
	public void setPosition(int aktuelleposition) {
		meinePosition = aktuelleposition;
		
	}
	
	
//GET
	public String getHTML ()
	{
		return "<tr><td></td><td></td><td>"+meinePosition+"</td><td>"+myProbenId+"</td><td>"+myStatus.getStatusText()+"</td><td>"+isValid+"</td></tr>";
	}
	
	public String getProbenID ()
	{
		return myProbenId;
	}
	public String getPosition() {
		// TODO Auto-generated method stub
		return Integer.toString(meinePosition);
	}
	public ProbenStatus getStatus ()
	{
		return myStatus;
		
	}

//SHOWS
	/**
	 * macht einen Dialog mit den Details der Probe auf.
	 */
	public void showInfo()
	{
		//Zeigt mit einem JDialog Infos zur Linie her.
	}

	

	
	

}
