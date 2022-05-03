package hebein.poolo.poolo3.dispatcher;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JTextField;

import hebein.poolo.poolo3.inputpanel.InputPanel;

public class PooloActionListener implements ActionListener {

	 private static final PooloActionListener OBJ = new PooloActionListener();
	 private HashMap<String,Object> objectList = new HashMap<String, Object>();
     
     private PooloActionListener() {
         System.out.println("Objekt gebildet...");
     }
         
     public static PooloActionListener getInstance() {
       return OBJ;
     } 
     
     
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println (e.toString());
		//Eingabezeile abgeschlossen
		System.out.println (e.getActionCommand());
		System.out.println (e.getSource().toString());
		
		String objectName = ((JComponent)e.getSource()).getName();
		
		//es wurde etwas gescannt
		if (objectName == "EANScan")
		{
			InputPanel inputframe =  (InputPanel) objectList.get("InputFrame");
			inputframe.newProbe(((JTextField)e.getSource()).getText());
			
		}
		
		//new Rack gedrückt
		if (objectName == "InputFrame_newRack")
		{
			InputPanel inputframe =  (InputPanel) objectList.get("InputFrame");
			inputframe.newRack();
			
		}
		
		//new Row gedrückt
		if (objectName == "InputFrame_newRow")
		{
			InputPanel inputframe =  (InputPanel) objectList.get("InputFrame");
			inputframe.newRow();
			
		}
		
		//Save gedrückt
				if (objectName == "InputFrame_Save")
				{
					InputPanel inputframe =  (InputPanel) objectList.get("InputFrame");
					inputframe.save_to_file();
					
				}
				
		//Save + Print gedrückt
				
				if (objectName == "InputFrame_Save_Print")
				{
					InputPanel inputframe =  (InputPanel) objectList.get("InputFrame");
					inputframe.save_to_file();
					inputframe.print();
					
				}
		
		
		
		
	}
	
	//Hier registrieren sich alle Objekte zwecks Refenzierung
	public void registerService (String inBezeichnung, Object object)
	{
		objectList.put(inBezeichnung, object);
		
	}

}
