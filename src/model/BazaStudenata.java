package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	private int id;
	
	private BazaStudenata() {
		
		id = 0;
		
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
		Student s1 = new Student("Katarina", "Zerajic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-95/2018", 2018, 3, model.Student.Status.B, 9.41, null, null);
		s1.setId(id++);
		ArrayList<Ocena> pi = new ArrayList<Ocena>();
		pi.add(new Ocena(s1, BazaPredmeta.getInstance().getPredmeti().get(0), 10, new Date()));
		pi.add(new Ocena(s1, BazaPredmeta.getInstance().getPredmeti().get(1), 10, new Date()));
		s1.setPolozeniIspiti(pi);
		studenti.add(s1);
		Student s2 = new Student("Katarina", "Zerajic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-99/2018", 2018, 3, model.Student.Status.B, 9.41, null, null);
		s2.setId(id++);
		s2.setPolozeniIspiti(pi);
		studenti.add(s2);
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
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
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
	
	public void dodajStudenta(String imeStudenta, String prezimeStudenta, Date datumRodjenjaStudenta, String adresaStudenta,
			String kontaktTelefon, String emailAdresa, String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija, model.Student.Status status,
			double prosjecnaOcjena, List<Ocena> polozeniIspiti, List<Predmet> nepolozeniIspiti) {
		Student s = new Student(imeStudenta, prezimeStudenta, datumRodjenjaStudenta, adresaStudenta, kontaktTelefon, emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status, prosjecnaOcjena, polozeniIspiti, nepolozeniIspiti);
		s.setId(id++);
		this.studenti.add(s);
	}
	
	public void dodajStudenta(Student s) {
		s.setId(id++);
		this.studenti.add(s);
	}
	
	public void izbrisiStudenta(String brojIndeksa) {
		for(Student s : studenti) {
			if(s.getBrojIndeksa().equals(brojIndeksa)) {
				studenti.remove(s);
				break;
			}
		}
	}
	
	public void izmeniStudenta(Student s) {
		System.out.println(s);
		for(Student st : studenti) {
			System.out.println(st);
			if(st.getId() == s.getId()) {
				st.setImeStudenta(s.getImeStudenta());
				st.setPrezimeStudenta(s.getPrezimeStudenta());
				st.setDatumRodjenjaStudenta(s.getDatumRodjenjaStudenta());
				st.setAdresaStudenta(s.getAdresaStudenta());
				st.setKontaktTelefon(s.getKontaktTelefon());
				st.setEmailAdresa(s.getEmailAdresa());
				st.setBrojIndeksa(s.getBrojIndeksa());
				st.setGodinaUpisa(s.getGodinaUpisa());
				st.setTrenutnaGodinaStudija(s.getTrenutnaGodinaStudija());
				st.setStatus(s.getStatus());
				//st.setProsjecnaOcjena(s.getProsjecnaOcjena());
				//st.setPolozeniIspiti(s.getPolozeniIspiti());
				//st.setNepolozeniIspiti(s.getNepolozeniIspiti());
			}
		}
	}
	
}
