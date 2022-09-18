package hebein.poolo.poolo3.inputpanel;

import java.awt.Color;
import java.awt.Font;

public class Settings {

	public static final String version = "0.99.03 // 15.09.2022";
	public static final String copyright = "(C) Gunther Hebein 2022";
	
	public static final Color foreground_einzelprobe_INVALID = Color.red;
	public static final Color background_einzelprobe_INVALID = Color.black;
	public static final Color foreground_einzelprobe_NOT_CONSTRUCTED = Color.red;
	public static final Color background_einzelprobe_NOT_CONSTRUCTED = Color.black;
	public static final Color foreground_einzelprobe_IST_IN_AUSWERTUNG = Color.GREEN;
	public static final Color background_einzelprobe_IST_IN_AUSWERTUNG = Color.WHITE;
	public static final Color foreground_einzelprobe_IST_POSITIV = Color.black;
	public static final Color background_einzelprobe_IST_POSITIV = Color.red;
	public static final Color foreground_einzelprobe_IST_NEGATIV = Color.black;
	public static final Color background_einzelprobe_IST_NEGATIV = Color.green;
	public static final Color foreground_einzelprobe_IST_UNCLEAR = Color.black;
	public static final Color background_einzelprobe_IST_UNCLEAR = Color.blue;
	public static final Color foreground_einzelprobe_IST_POSITIVE_POOL = Color.black;
	public static final Color background_einzelprobe_IST_POSITIVE_POOL = Color.orange;
	public static final Color foreground_einzelprobe_DEFAULT = Color.RED;
	public static final Color background_einzelprobe_DEFAULT = Color.LIGHT_GRAY;
	
	public static final boolean enabled_button_1 = true; //rack
	public static final boolean enabled_button_2 = true; //line
	public static final boolean enabled_button_3 = false;
	public static final boolean enabled_button_4 = false;
	public static final boolean enabled_button_5 = false; //4 POOL
	public static final boolean enabled_button_6 = false; // 8 POOL
	public static final boolean enabled_button_7 = false; // GRP LIN
	public static final boolean enabled_button_8 = false; // GRP MTX
	public static final boolean enabled_button_9 = false; // GRP BIN
	
	public static final Color jlabel_rack_color = Color.black;
	public static final Font jlabel_rack_font = new Font("Calibri", Font.BOLD, 90);
	public static final Color jlabel_rack_background = Color.white;
	
	public static final Color jlabel_line_color = Color.black;
	public static final Font jlabel_line_font = new Font("Calibri", Font.BOLD, 200);
	public static final Color jlabel_line_background = Color.white;
	
	public static final Color jlabel_probe_color = Color.black;
	public static final Font jlabel_probe_font = new Font("Calibri", Font.BOLD, 90);
	public static final Color jlabel_probe_background = Color.white;
	
	
}
