package hebein.poolo.poolo3.exporters;
import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;

public class HTMLPrinter 
{
	private static final HTMLPrinter OBJ = new HTMLPrinter();
	String printername ="";
	
	
	 private HTMLPrinter() {
         System.out.println("Objekt gebildet...");
     }
         
     public static HTMLPrinter getInstance() {
       return OBJ;
     } 
	
     /**
      * Speichert den eingegebenen String (HTML) 
      * @param inString
      */
	public static void save_to_file (String inString)
	{
		
		String timestamp = Long.toString(System.currentTimeMillis());
		String directory = System.getProperty("user.home")+"\\";
		String filename = directory+timestamp+".html";
		System.out.println("SAVING TO "+filename);
		
		try {
		      FileWriter myWriter = new FileWriter(filename);
		      myWriter.write(inString);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}

	public void print(String inString) {
		// TODO Auto-generated method stub
		
		String timestamp = Long.toString(System.currentTimeMillis());
		String directory = System.getProperty("user.home")+"\\";
		String filename = directory+timestamp+".html";
		System.out.println("SAVING TO "+filename);
		inString  = inString.replace("</html>", "<br> Zeit: "+timestamp+"</html>");
		//save
		try {
		      FileWriter myWriter = new FileWriter(filename);
		      myWriter.write(inString);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		//print
		if (Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.PRINT))
            {
                try {
                	File file = new File(filename);
                	desktop.open(file);
                    //desktop.print(file);
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
            }
            //System.exit(0);
        }
       else {
        System.out.println("File does exist = "+ filename);
    }
		}
		
}
	

