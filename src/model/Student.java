package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	protected int id;
	
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


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (adresaStudenta == null) {
			if (other.adresaStudenta != null)
				return false;
		} else if (!adresaStudenta.equals(other.adresaStudenta))
			return false;
		if (brojIndeksa == null) {
			if (other.brojIndeksa != null)
				return false;
		} else if (!brojIndeksa.equals(other.brojIndeksa))
			return false;
		if (datumRodjenjaStudenta == null) {
			if (other.datumRodjenjaStudenta != null)
				return false;
		} else if (!datumRodjenjaStudenta.equals(other.datumRodjenjaStudenta))
			return false;
		if (emailAdresa == null) {
			if (other.emailAdresa != null)
				return false;
		} else if (!emailAdresa.equals(other.emailAdresa))
			return false;
		if (godinaUpisa != other.godinaUpisa)
			return false;
		if (imeStudenta == null) {
			if (other.imeStudenta != null)
				return false;
		} else if (!imeStudenta.equals(other.imeStudenta))
			return false;
		if (kontaktTelefon == null) {
			if (other.kontaktTelefon != null)
				return false;
		} else if (!kontaktTelefon.equals(other.kontaktTelefon))
			return false;
		if (nepolozeniIspiti == null) {
			if (other.nepolozeniIspiti != null)
				return false;
		} else if (!nepolozeniIspiti.equals(other.nepolozeniIspiti))
			return false;
		if (polozeniIspiti == null) {
			if (other.polozeniIspiti != null)
				return false;
		} else if (!polozeniIspiti.equals(other.polozeniIspiti))
			return false;
		if (prezimeStudenta == null) {
			if (other.prezimeStudenta != null)
				return false;
		} else if (!prezimeStudenta.equals(other.prezimeStudenta))
			return false;
		if (Double.doubleToLongBits(prosjecnaOcjena) != Double.doubleToLongBits(other.prosjecnaOcjena))
			return false;
		if (status != other.status)
			return false;
		if (trenutnaGodinaStudija != other.trenutnaGodinaStudija)
			return false;
		return true;
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

	public String getDatumRodjenjaStudenta() {
		DateFormat datformat = new SimpleDateFormat("dd.MM.yyyy.");
		return datformat.format(datumRodjenjaStudenta);
	}

	public void setDatumRodjenjaStudenta(String datumRodjenjaStudenta) {
		try{
			Date date1 = new SimpleDateFormat("dd.mm.yyyy.").parse(datumRodjenjaStudenta);
			this.datumRodjenjaStudenta = date1;
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [imeStudenta=" + imeStudenta + ", prezimeStudenta=" + prezimeStudenta
				+ ", datumRodjenjaStudenta=" + datumRodjenjaStudenta + ", adresaStudenta=" + adresaStudenta
				+ ", kontaktTelefon=" + kontaktTelefon + ", emailAdresa=" + emailAdresa + ", brojIndeksa=" + brojIndeksa
				+ ", godinaUpisa=" + godinaUpisa + ", trenutnaGodinaStudija=" + trenutnaGodinaStudija + ", status="
				+ status + ", prosjecnaOcjena=" + prosjecnaOcjena + ", polozeniIspiti=" + polozeniIspiti
				+ ", nepolozeniIspiti=" + nepolozeniIspiti + ", id=" + id + "]";
	}
	
	

}
