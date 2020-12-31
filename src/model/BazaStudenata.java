package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import izgledAplikacije.GlavniProzor;

public class BazaStudenata {
	
	private static BazaStudenata instance = null;
	
	public static BazaStudenata getInstance() {
		if(instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private List<Student> studenti;
	private List<Student> privremeno;
	private List<Student> zadovoljavajuPretragu;
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
		/*try {
		Student s1 = new Student("Katarina", "Zerajic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-95/2018", 2018, 3, model.Student.Status.B, 9.41, null, null);
		s1.setId(id++);
		ArrayList<Ocena> pi = new ArrayList<Ocena>();
		List<Predmet> nep = new ArrayList<Predmet>();
		
		Predmet p11 = new Predmet("P13","Baze podataka",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		Predmet p12 = new Predmet("S13","Fizika",model.Predmet.Semestar.Zimski,2,null,6,null,null);
		Predmet p13 = new Predmet("P132","Algebra",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		nep.add(p11);
		nep.add(p12);
		nep.add(p13);
		BazaPredmeta.getInstance().dodajPredmet(p11);
		BazaPredmeta.getInstance().dodajPredmet(p12);
		BazaPredmeta.getInstance().dodajPredmet(p13);
		
		
		pi.add(new Ocena(s1, BazaPredmeta.getInstance().getPredmeti().get(0), 10, new Date()));
		pi.add(new Ocena(s1, BazaPredmeta.getInstance().getPredmeti().get(2), 10, new Date()));
		s1.setPolozeniIspiti(pi);
		s1.setNepolozeniIspiti(nep);
		studenti.add(s1);
		Student s2 = new Student("Ivana", "Markovic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-99/2018", 2018, 3, model.Student.Status.B, 9.41, null, null);
		ArrayList<Ocena> pi1 = new ArrayList<Ocena>();
		List<Predmet> nep1 = new ArrayList<Predmet>();
		pi1.add(new Ocena(s2, BazaPredmeta.getInstance().getPredmeti().get(1), 10, new Date()));
		pi1.add(new Ocena(s2, BazaPredmeta.getInstance().getPredmeti().get(0), 10, new Date()));
		nep1.add( new Predmet("E31","SAU",model.Predmet.Semestar.Zimski,2,null,8,null,null));
		s2.setId(id++);
		s2.setPolozeniIspiti(pi1);
		s2.setNepolozeniIspiti(nep1);
		
		studenti.add(s2);
		privremeno = studenti;
		}catch(NullPointerException e) {}*/
		ObjectInputStream in=null;
		Student s=null;
		
		try {
			in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("studenti.txt")));
			while(true) {
				s=(Student) in.readObject();
				dodajStudenta(s);
			}
		}catch (Exception e) {
		}finally {
			if(in!=null) {
				try {
					in.close();
				}catch (Exception e) {
				}
			}
		}
		privremeno = studenti;
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
		privremeno = studenti;
	}
	
	public void dodajStudenta(Student s) {
		s.setId(id++);
		this.studenti.add(s);
		privremeno = studenti;
	}
	
	public void izbrisiStudenta(String brojIndeksa) {
		for(Student s : studenti) {
			if(s.getBrojIndeksa().equals(brojIndeksa)) {
				studenti.remove(s);
				break;
			}
		}
		privremeno = studenti;
	}
	
	public void izmeniStudenta(Student s) {
		for(Student st : studenti) {
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
		privremeno = studenti;
	}
	
	public void pretraziStudente(String txt) {
		zadovoljavajuPretragu = new ArrayList<Student>();
		for(Student s : privremeno) {
			String rijeci[] = txt.split(" ");
			if(rijeci.length == 3) {
				String prezime = rijeci[0];
				String ime = rijeci[1];
				String index = rijeci[2];
				if(s.getPrezimeStudenta().toUpperCase().contains(prezime.toUpperCase()) && s.getImeStudenta().toUpperCase().contains(ime.toUpperCase()) && s.getBrojIndeksa().toUpperCase().contains(index.toUpperCase())) {
					zadovoljavajuPretragu.add(s);
				}
			}
			if(rijeci.length == 2) {

				String prezime = rijeci[0];
				String ime = rijeci[1];
				if(s.getPrezimeStudenta().toUpperCase().contains(prezime.toUpperCase()) && s.getImeStudenta().toUpperCase().contains(ime.toUpperCase())) {
					zadovoljavajuPretragu.add(s);
				}
			}
			if(rijeci.length == 1) {

				String prezime = rijeci[0];
				if(s.getPrezimeStudenta().toUpperCase().contains(prezime.toUpperCase())) {
					zadovoljavajuPretragu.add(s);
				}
			}
		}
		studenti = zadovoljavajuPretragu;
	}
	
	public void vratiPrikaz() {
		studenti = privremeno;
	}
	
	public void ukloniPredmet(Student s, Predmet p) {
		for(Student st : studenti) {
			if(st.getBrojIndeksa().equals(s.getBrojIndeksa())){
				st.getNepolozeniIspiti().remove(p);
			}
		}
	}
	public void ponistiOcjenu(Student s, Ocena o) {
		for(Student st : studenti) {
			if(st.getBrojIndeksa().equals(s.getBrojIndeksa())) {
				st.getPolozeniIspiti().remove(o);
				st.getNepolozeniIspiti().add(o.getPredmet());
				double prosjecna = 0;
				double suma = 0;
				for(Ocena oc : s.getPolozeniIspiti()) {
					suma += oc.getOcena();
				}
				prosjecna = suma / s.getPolozeniIspiti().size();
				st.setProsjecnaOcjena(prosjecna);
				GlavniProzor.getInstance().azurirajPrikaz("OCENA", -1);
			}
		}
	}
	
	
	public void saveDataStudentTxt()throws IOException{
		ObjectOutputStream out=null;
		
		try {
			out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("studenti.txt")));
			for(Student s:studenti) {
				out.writeObject(s);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(out!=null) {
				try {
					out.close();
				}catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
	
}
