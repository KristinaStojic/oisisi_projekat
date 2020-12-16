package model;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<String> kolone;
	
	private BazaStudenata() {
		
		initStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosjek");
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Katarina", "Zerajic", "20.10.1999", "Nemanjica, bb", "062/847-27-43", "katarinazer6@gmail.com", "RA-95", 2018, 3, model.Student.Status.B, 9.41, null, null));
	}
	
	public List<Student> getStudenti(){
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	public int getColumnCount() {
		return 6;
	}
	
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student s = this.studenti.get(row);
		switch(column) {
		case 0:
			return s.getBrojIndeksa();
		case 1:
			return s.getImeStudenta();
		case 2:
			return s.getPrezimeStudenta();
		case 3:
			return String.valueOf(s.getTrenutnaGodinaStudija());
		case 4:
			return String.valueOf(s.getStatus());
		case 5:
			return String.valueOf(s.getProsjecnaOcjena());
		default:
			return null;
		}
	}
	
	public void dodajStudenta(String imeStudenta, String prezimeStudenta, String datumRodjenjaStudenta, String adresaStudenta,
			String kontaktTelefon, String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija, model.Student.Status status,
			double prosjecnaOcjena, List<Ocena> polozeniIspiti, List<Predmet> nepolozeniIspiti) {
		Student s = new Student(imeStudenta, prezimeStudenta, datumRodjenjaStudenta, adresaStudenta, kontaktTelefon, emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status, prosjecnaOcjena, polozeniIspiti, nepolozeniIspiti);
		this.studenti.add(s);
	}
	
	public void izbrisiStudenta(String brojIndeksa) {
		for(Student s : studenti) {
			if(s.getBrojIndeksa() == brojIndeksa) {
				studenti.remove(s);
			}
		}
	}
	
}
