package model;

import java.util.Date;
import java.util.List;

public class Student {
	public enum Status {B, S};
	protected String imeStudenta;
	protected String prezimeStudenta;
	protected Date datumRodjenjaStudenta;
	protected String adresaStudenta;
	protected String kontaktTelefon;
	protected String emailAdresa;
	protected String brojIndeksa;

	protected int godinaUpisa;
	protected int trenutnaGodinaStudija;
	protected Status status;
	protected double prosjecnaOcjena;
	List<Ocena> polozeniIspiti;
	List<Predmet> nepolozeniIspiti;
	
	public Student() {
		super();
		
	}

	public Student(String imeStudenta, String prezimeStudenta, Date datumRodjenjaStudenta, String adresaStudenta,
			String kontaktTelefon, String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija,
			Status status, double prosjecnaOcjena, List<Ocena> polozeniIspiti, List<Predmet> nepolozeniIspiti) {
		super();
		this.imeStudenta = imeStudenta;
		this.prezimeStudenta = prezimeStudenta;
		this.datumRodjenjaStudenta = datumRodjenjaStudenta;
		this.adresaStudenta = adresaStudenta;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.polozeniIspiti = polozeniIspiti;
		this.nepolozeniIspiti = nepolozeniIspiti;
	}



	public String getImeStudenta() {
		return imeStudenta;
	}

	public void setImeStudenta(String imeStudenta) {
		this.imeStudenta = imeStudenta;
	}

	public String getPrezimeStudenta() {
		return prezimeStudenta;
	}

	public void setPrezimeStudenta(String prezimeStudenta) {
		this.prezimeStudenta = prezimeStudenta;
	}

	public Date getDatumRodjenjaStudenta() {
		return datumRodjenjaStudenta;
	}

	public void setDatumRodjenjaStudenta(Date datumRodjenjaStudenta) {
		this.datumRodjenjaStudenta = datumRodjenjaStudenta;
	}

	public String getAdresaStudenta() {
		return adresaStudenta;
	}

	public void setAdresaStudenta(String adresaStudenta) {
		this.adresaStudenta = adresaStudenta;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public double getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}

	public void setProsjecnaOcjena(double prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}

	public List<Ocena> getPolozeniIspiti() {
		return polozeniIspiti;
	}

	public void setPolozeniIspiti(List<Ocena> polozeniIspiti) {
		this.polozeniIspiti = polozeniIspiti;
	}

	public List<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}

	public void setNepolozeniIspiti(List<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	
	
}
