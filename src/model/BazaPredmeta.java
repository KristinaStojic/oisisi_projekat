package model;

import java.util.ArrayList;
import java.util.List;

public class BazaPredmeta {
		
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	
	
	
	private BazaPredmeta() {
		
		inicijalizujPredmete();
		
		
	
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina na kojoj se predmet izvodi");
		this.kolone.add("Semestar u kome se predmet izvodi");
		
		
	}
	
	private void inicijalizujPredmete(){
		
		this.predmeti = new ArrayList<Predmet>();
		predmeti.add(new Predmet("E2","OISISI",model.Predmet.Semestar.Zimski,3,null,8,null,null));
		predmeti.add(new Predmet("E3","NANS",model.Predmet.Semestar.Letnji,4,null,8,null,null));
		
	}
	
	public void obrisiPredmet(Predmet p) {
		for(Predmet i : predmeti) {
			if(i.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				predmeti.remove(p);
				break;
			}
		}
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}
	
	public void dodajPredmet(Predmet p) {
		this.predmeti.add(p);
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	
	public String getValueAt(int row, int column) {
		Predmet p = this.predmeti.get(row);
		switch(column) {
		case 0:
			return p.getSifra_predmeta();
		case 1:
			return p.getNaziv_predmeta();
		case 2:
			return String.valueOf(p.getBroj_ESPB());
		case 3:
			return String.valueOf(p.getGodina_izvodjenja());
		case 4:
			return String.valueOf(p.getSemestar());
		default:
			return null;
		}
	}
	
	
	
	
	
	
}
