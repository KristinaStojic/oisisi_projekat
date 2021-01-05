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
import java.util.regex.Pattern;

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
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtIndeks"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtIme"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtPrezime"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtGodinaStudija"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtStatus"));
		this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("jtProsjek"));
	}
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		/*try {
		Student s1 = new Student("Katarina", "Zerajic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-95/2018", 2018, 3, model.Student.Status.B, 0.0, null, null);
		s1.setId(id++);
		studenti.add(s1);
		
		Student s2 = new Student("Ivana", "Markovic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "RA-99/2019", 2019, 4, model.Student.Status.B, 0.0, null, null);
		studenti.add(s2);
		s2.setId(id++);
		
		Student s3 = new Student("Marko", "Markovic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "PR-19/2010", 2010, 1, model.Student.Status.B, 0.0, null, null);
		studenti.add(s3);
		s3.setId(id++);
		
		Student s4 = new Student("Nikola", "Nikolic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "SW-10/2018", 2018, 6, model.Student.Status.B, 0.0, null, null);
		studenti.add(s4);
		s4.setId(id++);
		
		Student s5 = new Student("Ivana", "Markovic", new Date(), "Nemanjica, bb", "062/8472743", "katarinazer6@gmail.com", "PR-9/2020", 2020, 2, model.Student.Status.B, 0.0, null, null);
		studenti.add(s5);
		s5.setId(id++);
		
		privremeno = studenti;
		}catch(NullPointerException e) {}*/
		privremeno = studenti;
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
		for(Student s : studenti) {
			s.setId(id++);
		}
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
	
	public void izbrisiStudenta(int id) {
		for(Student s : studenti) {
			if(s.getId() == id) {
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
	


	public void naprednaPretraga(String txt) {
		zadovoljavajuPretragu = new ArrayList<Student>();
		
		boolean prosao = true;
		for(Student s : privremeno) {
			String[] tekst = txt.split(" ");
			prosao = true;
			if(tekst[1].equals("=")) {
				for(int i = 2; i < tekst.length; i++) {
					tekst[i] = tekst[i].replaceAll("[()]", "");
					if(tekst[i].equals("indeks")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].startsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(!pattern.matcher(s.getBrojIndeksa().toUpperCase()).matches()) {
									prosao = false;
								}
							}else {
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!s.getBrojIndeksa().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].startsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(pattern.matcher(s.getBrojIndeksa().toUpperCase()).matches()) {
									prosao = false;
								}
							}else {
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getBrojIndeksa().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}
						}
					}else if(tekst[i].equals("ime")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].startsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(!pattern.matcher(s.getImeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else {
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!s.getImeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].startsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(pattern.matcher(s.getImeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else {
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getImeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}
						}
					}else if(tekst[i].equals("prezime")) {
						
					}else if(tekst[i].equals("godina")) {
						
					}else if(tekst[i].equals("prosek")) {
						
					}else if(tekst[i].equals("slusa_predmete")) {
						System.out.println(s);
					}
				}
				if(prosao) {
					zadovoljavajuPretragu.add(s);
				}
			}
			prosao = true;
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
				if(s.getPolozeniIspiti().size() == 0) {
					prosjecna = 0.0;
				}
				st.setProsjecnaOcjena(prosjecna);
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
