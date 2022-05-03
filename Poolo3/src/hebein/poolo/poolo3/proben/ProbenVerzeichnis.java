package hebein.poolo.poolo3.proben;

import java.util.HashMap;
import java.util.logging.Logger;

public class ProbenVerzeichnis 
{
	//refs
	
	HashMap<String,EinzelProbe> myProbenverzeichnis;
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	
	//konst
	
			
			
			//KONSTRUKT
	ProbenVerzeichnis ()
	{
		myProbenverzeichnis = new HashMap<String,EinzelProbe>();
	}
	
			//SET
			//GET
	/**
	 * Gibt eine Einzelprobe nach probennummer retour
	 * @param inString Probennummer
	 * @return Einzelprobe oder null
	 */
	public EinzelProbe getprobe (String inString)
	{
		
		EinzelProbe probe = myProbenverzeichnis.get(inString);
		if (probe == null)
			logger.severe("probe unbekannt");
		return probe;
	}
	
			//SHOW 
		public void showInfo()
		{
			//Zeigt mit einem JDialog Infos zur Linie her.
		}
		
			//ADD
		/**
		 * Fügt dem probenverzeichnis eine Probe hinzu
		 * @param inString Probennummer
		 * @param inEinzelProbe Einzelprobe
		 * @return true ==> huinzugefügt false ==> schon existent
		 */
		public boolean addProbe (String inString, EinzelProbe inEinzelProbe)
		{
			if (myProbenverzeichnis.containsKey(inString))
			{
				logger.severe("Probe Duplikat!");
				return false;
			}
			else
			{
				myProbenverzeichnis.put(inString, inEinzelProbe);
				return true;
			}
		}

}
