package model;

import java.util.ArrayList;
import java.util.List;

public class Predmet {
	
	public enum Semestar {Zimski, Letnji};
	protected String sifra_predmeta;
	protected String naziv_predmeta;
	protected Semestar semestar;
	protected int godina_izvodjenja;
	protected Profesor predmeni_profesor;
	protected int broj_ESPB;
	protected List<Student> studenti;
	
	public Predmet() {
		super();
	}
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, Semestar semestar, int godina_izvodjenja,
			Profesor predmeni_profesor, int broj_ESPB, ArrayList<model.Student> studenti) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_izvodjenja = godina_izvodjenja;
		this.predmeni_profesor = predmeni_profesor;
		this.broj_ESPB = broj_ESPB;
		this.studenti = studenti;
	}
	
	public Predmet(String sifra, String naziv, int espb, int godina, Semestar semestar) {
		this.sifra_predmeta = sifra;
		this.naziv_predmeta = naziv;
		this.broj_ESPB = espb;
		this.godina_izvodjenja = godina;
		this.semestar = semestar;
	}
	
	
	public String getSifraPredmeta() {
		return sifra_predmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		sifra_predmeta = sifraPredmeta;
	}
	public String getNazivPredmeta() {
		return naziv_predmeta;
	}
	public void setNazivPredmeta(String nazivPredmeta) {
		naziv_predmeta = nazivPredmeta;
	}
	public Semestar getSemestar() {
		return semestar;
	}
	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}
	public int getGodinaIzvodjenja() {
		return godina_izvodjenja;
	}
	public void setGodinaIzvodjenja(int godinaIzvodjenja) {
		godina_izvodjenja = godinaIzvodjenja;
	}

	public Profesor getPredmetniProfesor() {
		return predmeni_profesor;
	}
	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		predmeni_profesor = predmetniProfesor;
	}
	
	
	public int getESPB() {
		return broj_ESPB;
	}
	public void setESPB(int ESPB) {
		broj_ESPB = ESPB;
	}
	
	
	
	public List<Student> getStudenti(){
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
