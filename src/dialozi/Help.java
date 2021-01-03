package dialozi;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import izgledAplikacije.GlavniProzor;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help(GlavniProzor gp) {
		super(gp,"Help",true);
		JTextPane txt = new JTextPane();
		String tekst = GlavniProzor.getInstance().resourceBundle.getString("help"); 
				
		txt.setText(tekst);
		txt.setEditable(false);
		add(txt);
		add(new JScrollPane(txt));
		setSize(new Dimension(500,400));
		setLocationRelativeTo(null);
	}
}
