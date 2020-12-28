package model;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class Profesor {
	
	public enum Titula {BSc, MSc, mr, dr, prof, prof_dr, dipl_ing};
	public enum Zvanje {saradnik_u_nastavi, asistent, asistent_sa_doktoratom, docent, vanredni_profesor, redovni_profesor, profesor_emeritus};
	protected String prezime;
	protected String ime;
	protected Date datum_rodjenja;
	protected String adresa_stanovanja;
	protected String kontakt_telefon;
	protected String email_adresa;
	protected String adresa_kancelarije;
	protected String broj_licne_karte;
	protected Titula titula;
	protected Zvanje zvanje;
	List<Predmet> predmeti_Profesora;
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profesor() {
		super();
	}
	
	public Profesor(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email_adresa, String adresa_kancelarije, String broj_licne_karte, Titula titula, Zvanje zvanje,
			List<Predmet> predmeti_Profesora) {
		super();
		DateFormat datformat = new SimpleDateFormat("dd.MM.yyyy.");
		try {
		this.datum_rodjenja = datformat.parse(datum_rodjenja);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		this.prezime = prezime;
		this.ime = ime;
		//this.datum_rodjenja = datum_rodjenja;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email_adresa = email_adresa;
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti_Profesora = predmeti_Profesora;
	}
	
	
	public Profesor(String ime, String prezime, Titula titula, Zvanje zvanje) {
		this.ime = ime;
		this.prezime = prezime;
		this.titula = titula;
		this.zvanje = zvanje;
	}
	
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String Ime) {
		ime = Ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String Prezime) {
		prezime = Prezime;
	}
	public String getDatumRodjenja() {
		DateFormat datformat = new SimpleDateFormat("dd.MM.yyyy.");
		return datformat.format(datum_rodjenja);
	}
	public void setDatumRodjenja(String datumRodjenja) {
		try{
		Date date1=new SimpleDateFormat("dd.mm.yyyy.").parse(datumRodjenja);
		this.datum_rodjenja = date1;
	}
	catch(ParseException e) {
		e.printStackTrace();
	}
	}	
	
	public String getAdresaStanovanja() {
		return adresa_stanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresa_stanovanja = adresaStanovanja;
	}
	public String getKontaktTelefon() {
		return kontakt_telefon;
	}
	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontakt_telefon = kontaktTelefon;
	}
	public String getEmailAdresa() {
		return email_adresa;
	}
	public void setEmailAdresa(String emailAdresa) {
		this.email_adresa = emailAdresa;
	}
	public String getAdresaKancelarije() {
		return adresa_kancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresa_kancelarije = adresaKancelarije;
	}
	public String getBrojLicneKarte() {
		return broj_licne_karte;
	}
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.broj_licne_karte = brojLicneKarte;
	}
	public Titula getTitula() {
		return titula;
	}
	public void setTitula(Titula Titula) {
		titula = Titula;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje Zvanje) {
		zvanje = Zvanje;
	}
	
	public List<Predmet> getPredmetiProfesora() {
		return predmeti_Profesora;
	}

	public void setPredmetiProfesora(List<Predmet> predmetiProfesora) {
		predmeti_Profesora = predmetiProfesora;
	}

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datum_rodjenja=" + datum_rodjenja
				+ ", adresa_stanovanja=" + adresa_stanovanja + ", kontakt_telefon=" + kontakt_telefon
				+ ", email_adresa=" + email_adresa + ", adresa_kancelarije=" + adresa_kancelarije
				+ ", broj_licne_karte=" + broj_licne_karte + ", titula=" + titula + ", zvanje=" + zvanje
				+ ", predmeti_Profesora=" + predmeti_Profesora + ", id=" + id + "]";
	}

	
	
}
