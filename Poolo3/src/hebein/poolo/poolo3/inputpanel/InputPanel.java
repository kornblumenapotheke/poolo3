package hebein.poolo.poolo3.inputpanel;
//https://stackoverflow.com/questions/34770139/gridbag-layout-how-to-push-components-north
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.tree.DefaultTreeModel;

import hebein.poolo.poolo3.dispatcher.PooloActionListener;
import hebein.poolo.poolo3.exporters.HTMLPrinter;
import hebein.poolo.poolo3.proben.Racks;
import hebein.poolo.poolo3.tree.JTreeUtil;
import hebein.poolo.poolo3.tree.MyTreeCellRenderer;
import hebein.poolo.poolo3.tree.PCRTree;

public class InputPanel extends JPanel
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final JPanel rightPanel_1 = new JPanel(new GridBagLayout()) {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Dimension getPreferredSize() {

            return new Dimension(1000, 550);
        };
    };
    
    private final JPanel rightPanel_2 = new JPanel(new GridBagLayout()) {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public Dimension getPreferredSize() {

            return new Dimension(800, 300);
        };
    };

   

    // BORDERS
    private final Border homeTopPanel_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Border rightPanel1_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private final Border rightPanel2_LineBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
    private JTree tree;
    private PCRTree myPCRTree;    
    private JLabel jlabel_rack = new JLabel ("1");
    private JLabel jlabel_line = new JLabel ("A");
    private JLabel jlabel_probe = new JLabel ("1?");
    
    
    GridBagConstraints gbc = new GridBagConstraints();
    
  
    
    public final void constructLeftButtons() {
 
    	 gbc.weightx = 0;
         gbc.weighty = 0;
         gbc.gridheight = 1;
         gbc.gridx = 0;
         gbc.gridy = 1;

         gbc.anchor = GridBagConstraints.PAGE_START;
        JButton button3 = new JButton ("Save");
		button3.setName("InputFrame_Save");
		button3.addActionListener(PooloActionListener.getInstance());
		this.add(button3, gbc);
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.gridx = 0;
        gbc.gridy = 2;

		JButton button4 = new JButton ("Print");
		button4.setName("InputFrame_Save_Print");
		button4.addActionListener(PooloActionListener.getInstance());
		this.add(button4, gbc);
		

		gbc.gridx = 3;
        gbc.gridy = 8;
        gbc.ipady=2;
        gbc.weighty=2.0;
        textField.setPreferredSize(new Dimension (250,30));
        this.add(textField, gbc);
        
		
    }
    

    public final void constructRightPanel_1() {

        rightPanel_1.setBackground(Color.RED);
        gbc.fill = GridBagConstraints.BOTH; 
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 3;
        gbc.gridy = 0;
        this.add(rightPanel_1, gbc);
    }

    
    public final void constructRightPanel_2() {
    	log.info("constructRightPanel_2");
    	
        rightPanel_2.setBackground(Color.WHITE);
        gbc.gridheight = 8;
        rightPanel_1.add(rightPanel_2, gbc);
    }
    
    
    public final void constructRightPanel_2_Components()
    {
    	log.info("constructRightPanel_2_Components");
    	gbc.weightx = 10;
        gbc.weighty = 0;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
    	rightPanel_2.add(new JScrollPane(tree), gbc);  	
    }
    
    

    public final void constructLeftPanelComponents() {

       
        gbc.weightx = 0;
        gbc.weighty = 0;
        gbc.gridheight = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.PAGE_START;
        JButton button1 = new JButton ("New Rack");
		button1.setName("InputFrame_newRack");
		button1.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button1, gbc);        
		
		
		gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JButton button2 = new JButton ("New Line");
		button2.setName("InputFrame_newRow");
		button2.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button2, gbc);        
        
		
		gbc.gridx = 0;
        gbc.gridy = 2;                
        JButton button5 = new JButton ("4er Pool");
		button5.setName("InputFrame_Pool_4");
		button5.setBackground(Color.yellow);
		button5.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button5,gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 3;
		JButton button6 = new JButton ("8er Pool");
		button6.setName("InputFrame_Pool_8");
		button6.setBackground(Color.yellow);
		button6.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button6,gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 4;
        JButton button7 = new JButton ("GRP LIN");
		button7.setName("InputFrame_Group_linear");
		button7.setBackground(Color.white);
		button7.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button7,gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 5;
		JButton button8 = new JButton ("GRP MTX");
		button8.setName("InputFrame_Group_Matrix");
		button8.setBackground(Color.white);
		button8.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button8,gbc);
		
		gbc.gridx = 0;
        gbc.gridy = 6;
		JButton button9 = new JButton ("GRP BIN");
		button9.setName("InputFrame_Group_binary");
		button9.setBackground(Color.white);
		button9.addActionListener(PooloActionListener.getInstance());
		rightPanel_1.add(button9,gbc);  
		
		gbc.gridx = 0;
        gbc.gridy = 7;
        jlabel_rack = new JLabel ("1");
        //jlabel_rack.setOpaque(true);
        jlabel_rack.setBackground(Color.white);
        jlabel_rack.setFont(new Font("Calibri", Font.BOLD, 90));
        rightPanel_1.add(jlabel_rack,gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 7;
         jlabel_line = new JLabel ("A");
        jlabel_line.setBackground(Color.white);
        jlabel_line.setFont(new Font("Calibri", Font.BOLD, 90));
		
		rightPanel_1.add(jlabel_line,gbc);
		
		 gbc.gridx = 2;
	     gbc.gridy = 7;
	     jlabel_probe = new JLabel ("1");
	     jlabel_probe.setBackground(Color.white);
	     jlabel_probe.setFont(new Font("Calibri", Font.BOLD, 90));
			
		 rightPanel_1.add(jlabel_probe,gbc);  
    }
    

    private void setRightPanelBorders() {

        rightPanel_1.setBorder(rightPanel1_LineBorder);
        rightPanel_2.setBorder(rightPanel2_LineBorder);
        this.setBorder(homeTopPanel_LineBorder);
    }
    
    
	
	Racks racks = new Racks();
	
	public static final Logger log = Logger.getLogger(InputPanel.class.getName());
	Container c;
	GridBagLayout gbl;
	
	JPanel jPanel ;	
	JTextField textField = new JTextField ("");
	//JLabelExtended jLScanMonitor = new JLabelExtended(); // wird verwendet für das HTML, kann durch einen String ersetzt werden !
	//JPanelExtendedNew jLScanMonitorNew = new JPanelExtendedNew (); 


//Konstruktor
	InputPanel ()
	{
		
		log.info("Konstruktor Inputframe Beginn");
		//actualRackNumber--;
		//actualRowNumber--;
		log.info("JPanel anlegen");
		myPCRTree = new PCRTree();
		tree = new JTree(myPCRTree.getTreeRoot() );
		myPCRTree.setTree(tree);
		racks.setTree (myPCRTree);
		MyTreeCellRenderer myTreeCellRenderer = new MyTreeCellRenderer ();
		myTreeCellRenderer.setProbenVerzeichnis(racks.getProbenverzeichnis());
		tree.setCellRenderer(myTreeCellRenderer);
		
		
		setScanLine();
		
		this.setLayout(new GridBagLayout()); //setting of layout should ALWAYS come first before adding constraints and components
		constructLeftButtons();
	    constructRightPanel_1();
	    constructRightPanel_2();
	    constructLeftPanelComponents();
        constructRightPanel_2_Components();

	    setRightPanelBorders();
	    
	    
		
		
		
		log.info("Registrierten beim Listener");
		PooloActionListener.getInstance().registerService("InputFrame", (Object)this);
		
		log.info("Konstruktor Inputframe Ende");
		((DefaultTreeModel)tree.getModel()).reload();
		JTreeUtil jTreeUtil = new JTreeUtil();
		jTreeUtil.expandTree(tree, true);
		textField.grabFocus();
	}
	
	
	/**
	 * Registriere Scanzeile 
	 */
	private void setScanLine()
	{
		log.info("Textfield anlegen");
		textField.addActionListener(PooloActionListener.getInstance());
		textField.setName("EANScan");
		textField.setFocusable(true);
		textField.setSize(250, 30);
	
	}
	
	

	 
	
	
	
	//was muss durchgef�hrt werdne, wenn scan durchgef�hrt wurde
	/**public void addScan (String inString) 
	{
		log.info("addcan aufgerufen");		
		jLScanMonitor.newLine(inString);
		textField.setFocusable(true);
	} BRAUCHT MAN DAS??**/ 
	
	/**
	 * Eine neue Probe wird angelegt
	 * @param inString Probenbezeichnung
	 */
	public void newProbe (String inString)
	{
		log.info("Neue Probe anlegen ");
		//checke ob diese Probe nicht schon existiert (Hash).
		
		racks.addProbe(inString);
		set_label_probe(Integer.toString((racks.getActualRack()).getAktuelleLine().getAktuelleProbe()));
		
		
		//Probenobjekt anlegen mit allen Referenzen!
		// if (insString not in Hash)
		//actualPos++;
		textField.setText("");
		//jLScanMonitor.newLine("&emsp;<font size='3' bgcolor='white' color='black'> "+actualPos+":"+inString+"</font>");
		//aktuelles_Rack.addProbe(inString, Character.toString(actualRowNumber), Integer.toString(actualPos));	
		//PCRTree.addProbe(Integer.toString(1)+": "+inString);
		((DefaultTreeModel)tree.getModel()).reload();
		JTreeUtil jTreeUtil = new JTreeUtil();
		jTreeUtil.expandTree(tree, true);
		//endif
		textField.grabFocus();
	}
	
	/**
	 * Ein neues Rack soll angelegt werden
	 */
	public void newRack ()
	{
		log.info("Neuen rack anlegen");		
		racks.addRack();
		set_label_rack(racks.getActualRackNumber());
		//actualRackNumber++;
		//actualRowNumber ='A';
		//actualRowNumber--;
		//jLScanMonitor.newLine("<font size='8' bgcolor='black' color='orange'> New Rack "+actualRackNumber+"</font>");
		textField.grabFocus();
		//Probenrack aktuelles_Rack = new Probenrack (); //daten mit übergeben!
		//racks.add(aktuelles_Rack);
		//myPCRTree.addRack(Character.toString(actualRackNumber));
		((DefaultTreeModel)tree.getModel()).reload();
		JTreeUtil jTreeUtil = new JTreeUtil();
		jTreeUtil.expandTree(tree, true);
		textField.grabFocus();

			
		}
	
	/**
	 * Eine neue Linie wird angelegt
	 */
	public void newRow ()
	{
		log.info("Neue Row anlegen");		
		racks.addLinie();
		set_label_line(racks.getActualLine()); //update von Label mit aktueler Liniennummer
		//neue Row anlegen
		//text ausgeben
		//actualRowNumber++;
		//actualPos=0;
		//jLScanMonitor.newLine("&ensp;<font size='5' bgcolor='black' color='green'> New ROW " + actualRowNumber + "("+(Character.getNumericValue(actualRowNumber)-9)+")"+"</font>");
		textField.grabFocus();
		//aktuelles_Rack.addRow(Character.toString(actualRowNumber)); //Daten übergeben
		//myPCRTree.addLine(Character.toString(actualRowNumber));
		((DefaultTreeModel)tree.getModel()).reload();
		JTreeUtil jTreeUtil = new JTreeUtil();
		jTreeUtil.expandTree(tree, true);
		textField.grabFocus();
	}
	
	/**
	 * Als HTMl abspeichern
	 */
	public void save_to_file()
	{
		log.info("Save to file ausgeloest");
		//HTMLPrinter.getInstance().save_to_file(jLScanMonitor.getText());
		
		JFrame jFrame = new JFrame();
        JOptionPane.showMessageDialog(jFrame, "Save_to_file noch nicht verfuegbar");
	}
	
	
	
	public static void main (String args[])
	{
		
		JFrame frame = new JFrame();
		frame.setTitle("Poolo " + Settings.version +" "+Settings.copyright);
        frame.add(new InputPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
		
		
		
	}

/**
 * Ausdruck als HTML via Browser
 */
	public void print() {
		
		log.info("Save to file und drucken ausgeloest");
		HTMLPrinter.getInstance().print(racks.getHTML());	
		//JFrame jFrame = new JFrame();
        //JOptionPane.showMessageDialog(jFrame, "Print  noch nicht verf�gbar");
	
	}

	public void set_label_rack (String inString)
	{
		jlabel_rack.setText(inString);
		textField.grabFocus();
		
	}
	
	public void set_label_line (String inString)
	{
		jlabel_line.setText(inString);	
		//super.update(this.getGraphics());
		textField.grabFocus();
		
	}
	
	public void set_label_probe (String inString)
	{
		jlabel_probe.setText(inString);
		//jlabel_probe.setText("A");
		textField.grabFocus();
		
	}
	
}
