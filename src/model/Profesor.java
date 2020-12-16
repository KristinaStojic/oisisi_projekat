package model;
import java.util.List;
public class Profesor {
	

	protected String prezime;
	protected String ime;
	protected String datum_rodjenja;
	protected String adresa_stanovanja;
	protected String kontakt_telefon;
	protected String email_adresa;
	protected String adresa_kancelarije;
	protected String broj_licne_karte;
	protected String titula;
	protected String zvanje;
	List<Predmet> predmeti_Profesora;
	

	public Profesor() {
		super();
	}
	
	public Profesor(String prezime, String ime, String datum_rodjenja, String adresa_stanovanja, String kontakt_telefon,
			String email_adresa, String adresa_kancelarije, String broj_licne_karte, String titula, String zvanje,
			List<Predmet> predmeti_Profesora) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.email_adresa = email_adresa;
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmeti_Profesora = predmeti_Profesora;
	}
	
	
	public Profesor(String ime, String prezime, String titula, String zvanje) {
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
		return datum_rodjenja;
	}
	public void setDatumRodjenja(String datumRodjenja) {
		this.datum_rodjenja = datumRodjenja;
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
	public String getTitula() {
		return titula;
	}
	public void setTitula(String Titula) {
		titula = Titula;
	}
	public String getZvanje() {
		return zvanje;
	}
	public void setZvanje(String Zvanje) {
		zvanje = Zvanje;
	}
	
	public List<Predmet> getPredmetiProfesora() {
		return predmeti_Profesora;
	}

	public void setPredmetiProfesora(List<Predmet> predmetiProfesora) {
		predmeti_Profesora = predmetiProfesora;
	}
	
	
}
