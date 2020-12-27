package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BazaOcjena {

	private static BazaOcjena instance = null;
	
	public static BazaOcjena getInstance() {
		if(instance == null) {
			instance = new BazaOcjena();
		}
		return instance;
	}
	
	private List<Ocena> ocjene;
	private List<String> kolone;
	
	private BazaOcjena() {
		
		initOcjene();
		
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
		
	}
	
	private void initOcjene() {
		this.ocjene = new ArrayList<Ocena>();
		ocjene.add(new Ocena(BazaStudenata.getInstance().getStudenti().get(0), BazaPredmeta.getInstance().getPredmeti().get(0), 10, new Date()));
	}
	
	public List<Ocena> getOcene(){
		return ocjene;
	}
	
	public void setOcjene(List<Ocena> ocene) {
		this.ocjene = ocene;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public void dodajOcenu(Ocena o) {
		this.ocjene.add(o);
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Ocena getRow(int index) {
		return this.ocjene.get(index);
	}
	
	public String getValueAt(int row, int col) {
		Ocena o = this.ocjene.get(row);
		switch(col) {
		case 0:
			return o.getPredmet().getSifra_predmeta();
		case 1:
			return o.getPredmet().getNaziv_predmeta();
		case 2:
			return String.valueOf(o.getPredmet().getBroj_ESPB());
		case 3:
			return String.valueOf(o.getOcena());
		case 4:
			DateFormat datformat = new SimpleDateFormat("dd.MM.yyyy.");
			return datformat.format(o.getDatumPolaganja());
		default:
			return null;
		}
	}
	
}
