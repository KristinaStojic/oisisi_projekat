package model;

import java.io.Serializable;
import java.util.List;

public class Predmet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Semestar {Zimski, Letnji};
	protected String sifra_predmeta;
	protected String naziv_predmeta;
	protected Semestar semestar;
	protected int godina_izvodjenja;
	protected Profesor predmetni_profesor;
	protected int broj_ESPB;
	protected List<Student> studenti_polozili;
	protected List<Student> studenti_nisu_polozili;
	protected int id;
	
	public Predmet() {
		super();
	}

	public Predmet(String sifra_predmeta, String naziv_predmeta, Semestar semestar, int godina_izvodjenja,
			Profesor predmetni_profesor, int broj_ESPB, List<Student> studenti_polozili,
			List<Student> studenti_nisu_polozili) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_izvodjenja = godina_izvodjenja;
		this.predmetni_profesor = predmetni_profesor;
		this.broj_ESPB = broj_ESPB;
		this.studenti_polozili = studenti_polozili;
		this.studenti_nisu_polozili = studenti_nisu_polozili;
	}

	public Predmet(Predmet p) {

		super();

		this.sifra_predmeta = p.getSifra_predmeta();
		this.naziv_predmeta = p.getNaziv_predmeta();
		this.semestar = p.getSemestar();
		this.godina_izvodjenja = p.getGodina_izvodjenja();
		this.predmetni_profesor = p.getPredmetni_profesor();
		broj_ESPB = p.getBroj_ESPB();
		this.studenti_polozili = p.getStudenti_polozili();
		this.studenti_nisu_polozili = p.getStudenti_nisu_polozili();

	}

	public String getSifra_predmeta() {
		return sifra_predmeta;
	}

	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}

	public String getNaziv_predmeta() {
		return naziv_predmeta;
	}

	public void setNaziv_predmeta(String naziv_predmeta) {
		this.naziv_predmeta = naziv_predmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public int getGodina_izvodjenja() {
		return godina_izvodjenja;
	}

	public void setGodina_izvodjenja(int godina_izvodjenja) {
		this.godina_izvodjenja = godina_izvodjenja;
	}

	public Profesor getPredmetni_profesor() {
		return predmetni_profesor;
	}

	public void setPredmeni_profesor(Profesor predmetni_profesor) {
		this.predmetni_profesor = predmetni_profesor;
	}

	public int getBroj_ESPB() {
		return broj_ESPB;
	}

	public void setBroj_ESPB(int broj_ESPB) {
		this.broj_ESPB = broj_ESPB;
	}

	public List<Student> getStudenti_polozili() {
		return studenti_polozili;
	}

	public void setStudenti_polozili(List<Student> studenti_polozili) {
		this.studenti_polozili = studenti_polozili;
	}

	public List<Student> getStudenti_nisu_polozili() {
		return studenti_nisu_polozili;
	}

	public void setStudenti_nisu_polozili(List<Student> studenti_nisu_polozili) {
		this.studenti_nisu_polozili = studenti_nisu_polozili;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Predmet [sifra_predmeta=" + sifra_predmeta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + broj_ESPB;
		result = prime * result + godina_izvodjenja;
		result = prime * result + id;
		result = prime * result + ((naziv_predmeta == null) ? 0 : naziv_predmeta.hashCode());
		result = prime * result + ((predmetni_profesor == null) ? 0 : predmetni_profesor.hashCode());
		result = prime * result + ((semestar == null) ? 0 : semestar.hashCode());
		result = prime * result + ((sifra_predmeta == null) ? 0 : sifra_predmeta.hashCode());
		result = prime * result + ((studenti_nisu_polozili == null) ? 0 : studenti_nisu_polozili.hashCode());
		result = prime * result + ((studenti_polozili == null) ? 0 : studenti_polozili.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		Predmet other = (Predmet) obj;
		if(this.sifra_predmeta.equals(other.sifra_predmeta)) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
}