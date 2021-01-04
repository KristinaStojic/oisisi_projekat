package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import izgledAplikacije.GlavniProzor;

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
		
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtpSifra"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtpNaziv"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtpESPB"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtpGodina"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtpSemestar"));
		
		
	}
	
	private void inicijalizujPredmete(){
		
		this.predmeti = new ArrayList<Predmet>();
		/*Predmet p1 = new Predmet("E2","OISISI",model.Predmet.Semestar.Zimski,3,null,8,null,null);
		p1.setId(id++);
		predmeti.add(p1);
		Predmet p2 = new Predmet("E33","NANS",model.Predmet.Semestar.Letnji,4,null,8,null,null);
		p2.setId(id++);
		predmeti.add(p2);
		Predmet nep1 = new Predmet("P13","Baze podataka",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		Predmet nep2 = new Predmet("E3","SAU",model.Predmet.Semestar.Zimski,2,null,8,null,null);
		nep1.setId(id++);
		nep2.setId(id++);
		predmeti.add(nep2);
		predmeti.add(nep1);
		Predmet pr1 = new Predmet("P132","Baze podataka3",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		Predmet pr2 = new Predmet("E32","SAU3",model.Predmet.Semestar.Zimski,6,null,8,null,null);
		pr1.setId(id++);
		pr2.setId(id++);
		predmeti.add(pr2);
		predmeti.add(pr1);*/
		
		ObjectInputStream in = null;
		Predmet pr = null;
		
		try {
			in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.txt")));
			while(true) {
				pr=(Predmet) in.readObject();
				dodajPredmet(pr);
			}
		}catch (Exception e) {
		}finally {
			if(in!=null) {
				try {
					in.close();
				}catch (Exception e) {
				}
			}
		}
		
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
		for(Predmet p : predmeti) {
			p.setId(id++);
		}
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
	
	public void ukloniProfesora(int id) {
		for(Predmet p : predmeti) {
			if(p.getPredmetni_profesor() != null) {
				if(p.getPredmetni_profesor().getId() == id) {
					p.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	public void ukloniProfesoraPredmetima(ArrayList<Predmet> predm) {
		for(Predmet p : predm) {
			for(Predmet pr : predmeti) {
				if(pr.getSifra_predmeta().equals(p.getSifra_predmeta())) {
					pr.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	
	public void saveDataPredmetTxt()throws IOException{
		ObjectOutputStream out=null;
		
		try {
			out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.txt")));
			for(Predmet pr:predmeti) {
				out.writeObject(pr);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				try {
					out.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
	
	public void ukloniProfesoraPredmetu(Profesor prof, Predmet pred) {
		for(Predmet p : predmeti) {
			if(p.getPredmetni_profesor() != null) {
				if(p.getPredmetni_profesor().getBrojLicneKarte().equals(prof.getBrojLicneKarte())) {
					p.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	
}
