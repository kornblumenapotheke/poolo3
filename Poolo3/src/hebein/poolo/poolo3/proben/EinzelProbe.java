package hebein.poolo.poolo3.proben;

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
	
	EinzelProbe(String inProbenID)
	{
		myStatus.setStatus(myStatus.IST_IN_AUSWERTUNG);
		myProbenZeit = System.currentTimeMillis();
		myProbenId = inProbenID;
		isValid = true;
		
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
	
	
//GET
	public String getHTML ()
	{
		return "HTML HIER VON EINZELPROBE"; //Hier sollte eine geeignete Darstellung derProbe als HTMNL erstell werden.
	}
	
	public String getProbenID ()
	{
		return myProbenId;
	}
	

//SHOWS
	/**
	 * macht einen Dialog mit den Details der Probe auf.
	 */
	public void showProbenDetails ()
	{
		
	}

}
