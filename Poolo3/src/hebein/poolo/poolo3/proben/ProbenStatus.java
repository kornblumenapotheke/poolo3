package hebein.poolo.poolo3.proben;

public class ProbenStatus {
	
	final int INVALID = -999;
	final int NOT_CONSTRUCTED = -888;
	final int IN_AUSWERTUNG = -100;
	final int IST_POSITIV = 200;
	final int IST_NEGATIV = 100;
	final int IST_UNCLEAR = 0;
	final int IST_POSITIVE_POOL = 300;
	
	int myStatus = this.NOT_CONSTRUCTED;
	
	
	ProbenStatus ()
	{
		myStatus = this.INVALID;
	}
	
	public void setStatus (int inStatus)
	{
		myStatus = inStatus;
	}
	
	public int getStatus ()
	{
		return myStatus;
	}
	

}
