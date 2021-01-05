package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import izgledAplikacije.GlavniProzor;

public class BazaOcjena {

	private static BazaOcjena instance = null;
	
	public static BazaOcjena getInstance() {
		//if(instance == null) {
			instance = new BazaOcjena();
		//}
		return instance;
	}
	
	private List<Ocena> ocjene;
	private List<String> kolone;
	
	private BazaOcjena() {
		
		initOcjene();
		
		this.kolone = new ArrayList<String>();
		
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolSifra"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolNaziv"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolESPB"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolOcena"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolDatum"));
		
		
	}
	
	private void initOcjene() {
		this.ocjene = new ArrayList<Ocena>();
		try {
		Student s = GlavniProzor.getInstance().tabbedPane.getIzabraniStudent();
		for(Ocena o : s.getPolozeniIspiti()){
			ocjene.add(o);
		}
		}catch(NullPointerException e) {}
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
	
	public void dodajPolozeni(Student s, Predmet p, int ocjena, Date datumPolaganja) {
		if(s.getPolozeniIspiti() == null) {
			ArrayList<Ocena> pol = new ArrayList<Ocena>();
			Ocena o = new Ocena();
			o.setPredmet(p);
			o.setDatumPolaganja(datumPolaganja);
			o.setOcena(ocjena);
			o.setStudentPolozio(s);
			pol.add(o);
			for(Student st : BazaStudenata.getInstance().getStudenti()) {
				if(st.getBrojIndeksa().equals(s.getBrojIndeksa())) {
					st.setPolozeniIspiti(pol);
				}
			}
		}else {
			for(Student st : BazaStudenata.getInstance().getStudenti()) {
				if(st.getBrojIndeksa().equals(s.getBrojIndeksa())) {
					Ocena o = new Ocena();
					o.setPredmet(p);
					o.setDatumPolaganja(datumPolaganja);
					o.setOcena(ocjena);
					o.setStudentPolozio(s);
					s.dodajPolozeneIspite(o);
				}
			}
		}
	}
	
}
