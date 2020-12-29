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
	private int id;
	
	private List<Predmet> pomocni;
	private List<Predmet> zadovoljavajuPretragu;
	
	private BazaPredmeta() {

		id = 0;
		
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
		Predmet p1 = new Predmet("E2","OISISI",model.Predmet.Semestar.Zimski,3,null,8,null,null);
		p1.setId(id++);
		predmeti.add(p1);
		Predmet p2 = new Predmet("E3","NANS",model.Predmet.Semestar.Letnji,4,null,8,null,null);
		p2.setId(id++);
		predmeti.add(p2);
		pomocni = predmeti;
		
	}
	
	public void obrisiPredmet(Predmet p) {
		for(Predmet i : predmeti) {
			if(i.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				predmeti.remove(p);
				break;
			}
		}
		pomocni = predmeti;
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
		p.setId(id++);
		this.predmeti.add(p);
		pomocni = predmeti;
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
	
	public void izmeniPredmet(Predmet p) {
		for(Predmet pr : predmeti) {
			if(pr.getId() == p.getId()) {
				pr.setSifra_predmeta(p.getSifra_predmeta());
				pr.setNaziv_predmeta(p.getNaziv_predmeta());
				pr.setSemestar(p.getSemestar());
				pr.setGodina_izvodjenja(p.getGodina_izvodjenja());
				pr.setPredmeni_profesor(p.getPredmetni_profesor());
				pr.setBroj_ESPB(p.getBroj_ESPB());
				pr.setStudenti_polozili(p.getStudenti_polozili());
				pr.setStudenti_nisu_polozili(p.getStudenti_nisu_polozili());
			}
		}
		pomocni = predmeti;
	}
	
	
	// u slucaju da je polje za pretragu prazno, vraca pocetnu tabelu
		public void vratiPrikaz() {
			predmeti = pomocni;
		}
		
		public void pretraziPredmete(String txt) {
			zadovoljavajuPretragu = new ArrayList<Predmet>();
			
			
			for(Predmet pred : pomocni) {
				String rijeci[] = txt.split(" ");
				if(rijeci.length == 1) {
					String naziv = rijeci[0];
					if(pred.getNaziv_predmeta().toUpperCase().contains(naziv.toUpperCase())) {
						zadovoljavajuPretragu.add(pred);
					}
				}
			}
			predmeti = zadovoljavajuPretragu;
		}
	
	
	
}
