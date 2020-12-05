package izgledAplikacije;

import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class Help extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Help(Glavni_prozor gp) {
		super(gp,"Help",true);
		JTextPane txt = new JTextPane();
		String tekst = "U glavni prozor aplikacije dodati su menu bar, status bar i toolbar.\n"
					   + "Meni bar sadrzi:\n"
					   + "  -Podmeni File(akcelerator: alt+f). U kome se nalaze stavke: \n"
					   + "    New(mnemonik: ctrl+n): sluzi za dodavanje novog entiteta u sistem. \n"
					   + "    Close(mnemonik: ctrl+c): sluzi za zatvaranje aplikacije.\n"
					   + "  -Podmeni Edit(akcelerator: alt+e). U kome se nalaze stavke: \n"
					   + "    Edit(mnemonik: ctrl+e): sluzi za izmjenu postojeceg entiteta\n"
					   + "    Delete(mnemonik: ctrl+d): sluzi za brisanje postojeceg entiteta\n"
					   + "  -Podmeni Help(akcelerator: alt+h). U kome se nalaze stavke:\n"
					   + "    Help(mnemonik: ctrl+h): sadrzi detaljan opis o nacinu koristenja aplikacije\n"
					   + "    About(mnemonik: ctrl+a): sluzi za prikaz verzije aplikacije. I sadrzi sazetu biografiju autora.\n"
					   + "Toolbar sadrzi 4 dugmeta i jedno polje za unos teksta:\n"
					   + "  1 dugme(akcelerator alt+n): sluzi za otvaranje dijaloga i kreiranje entiteta informacionog sistema\n"
					   + "  2 dugme(akcelerator alt+e): sluzi za otvaranje dijaloga i izmjenu oznacenog entiteta\n"
					   + "  3 dugme(akcelerator alt+d): sluzi da obrise oznaceni entitet iz sistema\n"
					   + "  U tekstualno polje za pretragu korisnik moze unijeti kriterijum pretrage i pritiskom na dugme za pretragu pretraziti tabelu aktivnog taba\n"
					   + "Status bar aplikacije sadrzi: naziv aplikacije, trenutno vrijeme i trenutni datum.";
		txt.setText(tekst);
		txt.setEditable(false);
		add(txt);
		add(new JScrollPane(txt));
		setSize(new Dimension(500,400));
		setLocationRelativeTo(null);
	}
}
