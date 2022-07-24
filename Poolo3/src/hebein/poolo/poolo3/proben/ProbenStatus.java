package hebein.poolo.poolo3.proben;

import java.util.ArrayList;

/**
 * legt die einzelnen Stati einer Probe an.
 * NOT_CONSTRUCTED ==> Konstruktor nicht aufegrufen
 * INVALID ==> Kontruktor ja, aber kein Wert zugewiesen
 * @author GuntherBackoffice
 *
 */
public class ProbenStatus {
	
	public final int INVALID = -999; // Konstruktor aber keine weitere Bearbeitugn
	final int NOT_CONSTRUCTED = -888; //kein Konstriuktor aufgerufen
	final int IST_IN_AUSWERTUNG = -100; //Wiord ausgewertet, keiner Ergebnis
	final int IST_POSITIV = 200; //Ergebnis NACHGEWIESEN
	final int IST_NEGATIV = 100; //Ergebnis NICHTS NACHGEWIESEN
	final int IST_UNCLEAR = 0; //Ergebnis unklar, kein Befund
	final int IST_POSITIVE_POOL = 300; //Ergebnis positiv, aber in einem Pool
	
	ArrayList<String> statusaenderungen = new ArrayList<String>();
	
	int myStatus = this.NOT_CONSTRUCTED;
	
	
	ProbenStatus ()
	{
		myStatus = this.INVALID;
		statusaenderungen.add(System.currentTimeMillis()+" STATUS to "+Integer.toString(myStatus)+ " by Konstructor");
	}
	
	public void setStatus (int inStatus)
	{
		statusaenderungen.add(System.currentTimeMillis()+" STATUS from  "+Integer.toString(myStatus)+ " to "+Integer.toString(inStatus)+" by Setstatus");
		myStatus = inStatus;
	}
	
	public int getStatus ()
	{
		return myStatus;
	}
	
	public String getStatusText()
	{
		
		
		switch (myStatus)
		{
		case INVALID: return "INVALID";
		case NOT_CONSTRUCTED: return "CONSTRUCTOR ERROR"; //kein Konstriuktor aufgerufen
		case IST_IN_AUSWERTUNG: return "IN AUSWERTUNG"; //Wird ausgewertet, keiner Ergebnis
		case IST_POSITIV: return "!!! NACHGEWIESEN"; //Ergebnis NACHGEWIESEN
		case IST_NEGATIV: return "NICHT NACHGEWIESEN"; //Ergebnis NICHTS NACHGEWIESEN
		case IST_UNCLEAR: return "NICHT BEFUNDBAR"; //Ergebnis unklar, kein Befund
		case IST_POSITIVE_POOL: return "POSITIVER POOL"; //Ergebnis positiv, aber in einem Pool
		default: return "ERROR";
		}
		
		
	}
	
	public String getAenderungen ()
	{
		return statusaenderungen.toString();
	}
	

}
