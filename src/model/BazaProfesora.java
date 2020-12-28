package model;

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
		Profesor p1 = new Profesor("Stojic", "Kristina", "05.03.1999.","Jardan 129, ZV","064/3515864","stojic.kris@gmail.com","Futoska 50, NS","KA10101", model.Profesor.Titula.dr, model.Profesor.Zvanje.redovni_profesor, null);
		p1.setId(id++);
		profesori.add(p1);
		
		Profesor p2 = new Profesor("Delic", "Nikolina", "19.12.1999.","Caparde 201, NS","064/3757567","delicnikolina@gmail.com","Futoska 55","MA101S", model.Profesor.Titula.dr,model.Profesor.Zvanje.profesor_emeritus, null);
		p2.setId(id++);
		profesori.add(p2);
		
		Profesor p3 = new Profesor("Hrnjak", "Jelena", "28.08.1999.","Backa Topola 20, NS","064/7852567","hrnjakjelena@gmail.com","Svetojovanska 2","JH909", model.Profesor.Titula.BSc, model.Profesor.Zvanje.docent, null);
		p3.setId(id++);
		profesori.add(p3);
	}
	
	public void dodajProfesor(Profesor p) {
		profesori.add(p);
	}
	
	public void izbrisiProfesora(String brojLicneKarte) {
		for(Profesor p : profesori) {
			if(p.getBrojLicneKarte().equals(brojLicneKarte)) {
				profesori.remove(p);
				break;
			}
		}
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
			}	}
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
	
}
