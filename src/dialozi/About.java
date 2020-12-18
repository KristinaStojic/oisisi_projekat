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

	public About(GlavniProzor gp) {
		super(gp,"About",true);
		JTextPane txt = new JTextPane();
		String tekst = "Verzija: 2020/2021\n"
						+ "Aplikacija studentska sluzba\n"
						+ "Student 1:\n"
						+ "Katarina Žerajić\n"
						+ "Rođena 20.10.1999 u Nevesinju. Student treće godine racunarstva i automatike.\n"
						+ "Student 2:\n"
						+ "Kristina Stojić\n"
						+ "Rođena 5.03.1999 u Zvorniku. Student treće godine racunarstva i automatike.";
		txt.setText(tekst);
		txt.setEditable(false);
		add(txt);
		add(new JScrollPane(txt));
		setSize(new Dimension(500,400));
		setLocationRelativeTo(null);		
	}
}
