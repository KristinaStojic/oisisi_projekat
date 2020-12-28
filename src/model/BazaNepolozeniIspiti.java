package model;

import java.util.ArrayList;
import java.util.List;

import izgledAplikacije.GlavniProzor;

public class BazaNepolozeniIspiti {
private static BazaNepolozeniIspiti instance = null;
	
	public static BazaNepolozeniIspiti getInstance() {
		if(instance == null) {
			instance = new BazaNepolozeniIspiti();
		}
		return instance;
	}
	
	private List<Predmet> nepolozeni;
	private List<String> kolone;
	
	private BazaNepolozeniIspiti() {
		
		initNepolozeni();
		
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");
		
	}
	
	private void initNepolozeni() {
		this.nepolozeni = new ArrayList<Predmet>();
		Student s = GlavniProzor.getInstance().tabbedPane.getIzabraniStudent();
		for(Predmet o : s.getNepolozeniIspiti()){
			nepolozeni.add(o);
		}
	}
	
	public List<Predmet> getNepolozeni(){
		return nepolozeni;
	}
	
	public void setNepolozeni(List<Predmet> nepolozeni) {
		this.nepolozeni = nepolozeni;
	}
	
	public int getColumnCount() {
		return 5;
	}
	
	public void dodajNepolozene(Predmet p) {
		this.nepolozeni.add(p);
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int index) {
		return this.nepolozeni.get(index);
	}
	
	public String getValueAt(int row, int col) {
		Predmet p = this.nepolozeni.get(row);
		switch(col) {
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
