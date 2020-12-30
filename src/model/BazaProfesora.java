package model;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {

	public static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	
	private List<Profesor> profesori;
	private List<Profesor> pomocni;
	private List<Profesor> zadovoljavajuPretragu;
	private List<String> kolone;
	private int id;
	
	private BazaProfesora() {
		inicijalizujProfesore();
		
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	private void inicijalizujProfesore() {
		this.profesori=new ArrayList<Profesor>();
		try {
		Profesor p1 = new Profesor("Stojic", "Kristina", "05.03.1999.","Jardan 129, ZV","064/3515864","stojic.kris@gmail.com","Futoska 50, NS","KA10101", model.Profesor.Titula.dr, model.Profesor.Zvanje.redovni_profesor, null);
		
		List<Predmet> pred = new ArrayList<Predmet>();
		pred.add(new Predmet("P13","Baze podataka",model.Predmet.Semestar.Letnji,4,null,6,null,null));
		pred.add(new Predmet("P132","Algebra",model.Predmet.Semestar.Letnji,4,null,6,null,null));
		pred.add(new Predmet("S13","Fizika",model.Predmet.Semestar.Zimski,2,null,6,null,null));
		
		
		p1.setId(id++);
		p1.setPredmetiProfesora(pred);
		profesori.add(p1);
		
		Profesor p2 = new Profesor("Delic", "Nikolina", "19.12.1999.","Caparde 201, NS","064/3757567","delicnikolina@gmail.com","Futoska 55","MA101S", model.Profesor.Titula.dr,model.Profesor.Zvanje.profesor_emeritus, null);
		List<Predmet> pred2 = new ArrayList<Predmet>();
		pred2.add(new Predmet("S13","Fizika",model.Predmet.Semestar.Zimski,2,null,6,null,null));
		p2.setId(id++);
		p2.setPredmetiProfesora(pred2);
		profesori.add(p2);
		
		Profesor p3 = new Profesor("Hrnjak", "Jelena", "28.08.1999.","Backa Topola 20, NS","064/7852567","hrnjakjelena@gmail.com","Svetojovanska 2","JH909", model.Profesor.Titula.BSc, model.Profesor.Zvanje.docent, null);
		p3.setId(id++);
		profesori.add(p3);
		pomocni = profesori;
		}catch(NullPointerException e) {}
	}
	
	public void dodajProfesor(Profesor p) {
		p.setId(id++);
		profesori.add(p);
		pomocni = profesori;
	}
	
	public void izbrisiProfesora(String brojLicneKarte) {
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesori.remove(p);
				break;
			}
		}
		pomocni = profesori;
	}
	
	public void izmeniProfesora(Profesor p) {
		for(Profesor i: profesori) {
			if(i.getBrojLicneKarte().equals(p.getBrojLicneKarte())) {
				i.setIme(p.getIme());
				i.setPrezime(p.getPrezime());
				i.setDatumRodjenja(p.getDatumRodjenja());
				i.setAdresaStanovanja(p.getAdresaStanovanja());
				i.setKontaktTelefon(p.getKontaktTelefon());
				i.setEmailAdresa(p.getEmailAdresa());
				i.setAdresaKancelarije(p.getAdresaKancelarije());
				i.setBrojLicneKarte(p.getBrojLicneKarte());
				i.setTitula(p.getTitula());
				i.setZvanje(p.getZvanje());
				//System.out.println(i);
			}	
			}
		pomocni = profesori;
	}
	public List<Profesor> getProfesori(){
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	
	public String getValueAt(int row, int column) {
		Profesor p = this.profesori.get(row);
		switch(column) {
		case 0:
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return String.valueOf(p.getTitula());
		case 3:
			return String.valueOf(p.getZvanje());
		default:
			return null;
		}
	}
	
	// u slucaju da je polje za pretragu prazno, vraca pocetnu tabelu
	public void vratiPrikaz() {
		 profesori = pomocni;
	}
	
	public void pretraziProfesore(String txt) {
		zadovoljavajuPretragu = new ArrayList<Profesor>();
		
		
		for(Profesor prof : pomocni) {
			String rijeci[] = txt.split(" ");
			if(rijeci.length == 2) {

				String prezime = rijeci[0];
				String ime = rijeci[1];
				if(prof.getPrezime().toUpperCase().contains(prezime.toUpperCase()) && prof.getIme().toUpperCase().contains(ime.toUpperCase())) {
					zadovoljavajuPretragu.add(prof);
				}
			}
			if(rijeci.length == 1) {

				String prezime = rijeci[0];
				if(prof.getPrezime().toUpperCase().contains(prezime.toUpperCase())) {
					zadovoljavajuPretragu.add(prof);
				}
			}
		}
		profesori = zadovoljavajuPretragu;
	}

	public void ukloniPredmete(Profesor pf, ArrayList<Predmet> pp) {
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte().equals(pf.getBrojLicneKarte())) {
				for(Predmet predmet : pp) {
					p.getPredmetiProfesora().remove(predmet);
				}
			}
		}
	}
	
	public void dodajPredmete(Profesor pe,Predmet pp) {
		
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte().equals(pe.getBrojLicneKarte())) {
					if(p.getPredmetiProfesora()!=null) {
						p.getPredmetiProfesora().add(pp);
					}
					else {
						List<Predmet> pom = new ArrayList<Predmet>();
						pom.add(pp);
						p.setPredmetiProfesora(pom);
					}
			}
		}
	}
	
	
	public void saveDataProfesorTxt()throws IOException{
		ObjectOutputStream out=null;
		
		try {
			out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("profesori.txt")));
			for(Profesor p:profesori) {
				out.writeObject(p);
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
	
}
