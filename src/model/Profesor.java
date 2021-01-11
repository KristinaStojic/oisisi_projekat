package model;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
public class Profesor implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Titula {BSc, MSc, mr, dr, prof, prof_dr, dipl_ing};
	public enum Zvanje {saradnik_u_nastavi, asistent, asistent_sa_doktoratom, docent, vanredni_profesor, redovni_profesor, profesor_emeritus};
	protected String prezime;
	protected String ime;
	protected Date datumRodjenja;
	protected String adresaStanovanja;
	protected String kontaktTelefon;
	protected String emailAdresa;
	protected String adresaKancelarije;
	protected String brojLicneKarte;
	protected Titula titula;
	protected Zvanje zvanje;

	List<Predmet> predmetiProfesora;
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
		this.datumRodjenja = datformat.parse(datum_rodjenja);
		}
		catch(ParseException e) {
			e.printStackTrace();
		}
		this.prezime = prezime;
		this.ime = ime;
		//this.datum_rodjenja = datum_rodjenja;
		this.adresaStanovanja = adresa_stanovanja;
		this.kontaktTelefon = kontakt_telefon;
		this.emailAdresa = email_adresa;
		this.adresaKancelarije = adresa_kancelarije;
		this.brojLicneKarte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmetiProfesora = predmeti_Profesora;
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
		return datformat.format(datumRodjenja);
	}
	public void setDatumRodjenja(String datumRodjenja) {
		try{
		Date date1=new SimpleDateFormat("dd.mm.yyyy.").parse(datumRodjenja);
		this.datumRodjenja = date1;
	}
	catch(ParseException e) {
		e.printStackTrace();
	}
	}	
	
	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}
	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
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
	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}
	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}
	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}
	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
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
		return predmetiProfesora;
	}

	public void setPredmetiProfesora(List<Predmet> predmetiProfesora) {
		predmetiProfesora = predmetiProfesora;
	}
	
	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datum_rodjenja=" + datumRodjenja
				+ ", adresa_stanovanja=" + adresaStanovanja + ", kontakt_telefon=" + kontaktTelefon
				+ ", email_adresa=" + emailAdresa + ", adresa_kancelarije=" + adresaKancelarije
				+ ", broj_licne_karte=" + brojLicneKarte + ", titula=" + titula + ", zvanje=" + zvanje
				+ ", predmeti_Profesora=" + predmetiProfesora + ", id=" + id + "]";
	}
}
