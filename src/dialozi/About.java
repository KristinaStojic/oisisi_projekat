package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import izgledAplikacije.GlavniProzor;

public class About extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTextPane txt;
	
	public About(GlavniProzor gp) {
		super(gp,GlavniProzor.getInstance().getResourceBundle().getString("mniAbout"),true);

		txt = new JTextPane();

		JTextPane txt = new JTextPane();
		String tekst = GlavniProzor.getInstance().getResourceBundle().getString("about");
		txt.setText(tekst);
		txt.setEditable(false);
		add(txt);
		add(new JScrollPane(txt));
		setSize(new Dimension(500,400));
		setLocationRelativeTo(null);		
	}
	
}
