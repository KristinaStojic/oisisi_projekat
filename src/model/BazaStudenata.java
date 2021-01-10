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
		this.studenti = studenti;
		privremeno = studenti;
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
		for(Student s : privremeno) {
			if(s.getId() == id) {
				studenti.remove(s);
				privremeno.remove(s);
				break;
			}
		}
		//privremeno = studenti;
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
		//privremeno = studenti;
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
		boolean pogresanUnos = false;
		
		boolean prosao = true;
		for(Student s : privremeno) {
			String[] tekst = txt.split(" ");
			List<String> lista = new ArrayList<String>();
			List<String> slusa_predmete = new ArrayList<String>();
			prosao = true;
			boolean otvorena = false;
			boolean zatvorena = false;
			boolean duplap = false;
			boolean duplak = false;
			if(tekst[0].equals("studenti") && tekst[1].equals("=") && tekst[2].startsWith("(")) {
				for(int i = 2; i < tekst.length; i++) {
					if(tekst[i].contains("(")) {
						tekst[i] = tekst[i].substring(1, tekst[i].length());
						otvorena = true;
					}
					if(tekst[i].contains("(")) {
						tekst[i] = tekst[i].substring(1, tekst[i].length());
						duplap = true;
					}
					if(tekst[i].equals("indeks")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/")) {
								if(!tekst[i].endsWith("/")) {
									pogresanUnos = true;
								}
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(!pattern.matcher(s.getBrojIndeksa().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!s.getBrojIndeksa().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/")) {
								if(!tekst[i].endsWith("/")) {
									pogresanUnos = true;
								}
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(pattern.matcher(s.getBrojIndeksa().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getBrojIndeksa().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else {
							pogresanUnos = true;
						}
					}else if(tekst[i].equals("ime")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/") && tekst[i].endsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(!pattern.matcher(s.getImeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!s.getImeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/") && tekst[i].endsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(pattern.matcher(s.getImeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getImeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}else {
							//pogresanUnos = true;
						}
					}else if(tekst[i].equals("prezime")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/") && tekst[i].endsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(!pattern.matcher(s.getPrezimeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!s.getPrezimeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/") && tekst[i].endsWith("/")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1);
								Pattern pattern = Pattern.compile(tekst[i]);
								if(pattern.matcher(s.getPrezimeStudenta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getPrezimeStudenta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}else {
							//pogresanUnos = true;
						}
					}else if(tekst[i].equals("godina")) {
						i++;
						/*boolean uhvaceno = false;
						try {							//ne radi?
							Integer.parseInt(tekst[i]);
						}catch(NumberFormatException e) {
							uhvaceno = true;
						}*/
						/*if(uhvaceno) {
							pogresanUnos = true;
						}else {*/
							if(tekst[i].equals("==")) {
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() != Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else if(tekst[i].equals("!=")) {	
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() == Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else if(tekst[i].equals("<")) {
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() >= Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else if(tekst[i].equals(">")) {
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() <= Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else if(tekst[i].equals("<=")) {
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() > Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else if(tekst[i].equals(">=")) {
								i++;
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
									tekst[i] = tekst[i].replaceAll("[()]", "");
									tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getTrenutnaGodinaStudija() < Integer.parseInt(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						//}
					}else if(tekst[i].equals("prosek")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(s.getProsjecnaOcjena() != Double.parseDouble(tekst[i].toUpperCase())) {
									prosao = false;
								}
						}else if(tekst[i].equals("!=")) {	
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", "");
							if(s.getProsjecnaOcjena() == Double.parseDouble(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else if(tekst[i].equals("<")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", "");
							if(s.getProsjecnaOcjena() >= Double.parseDouble(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else if(tekst[i].equals(">")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", "");
							if(s.getProsjecnaOcjena() <= Double.parseDouble(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else if(tekst[i].equals("<=")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", "");
							if(s.getProsjecnaOcjena() > Double.parseDouble(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else if(tekst[i].equals(">=")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", "");
							if(s.getProsjecnaOcjena() < Double.parseDouble(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else {
							//pogresanUnos = true;
						}
					}else if(tekst[i].equals("slusa_predmete")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains("{")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length());
								
								while(!tekst[i].contains("}")) {
									slusa_predmete.add(tekst[i]);
									if(tekst[i].equals("and") || tekst[i].equals("or")) {
										tekst[i] = "x";
									}
									i++;
								}
								
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
								
								slusa_predmete.add(tekst[i].substring(0, tekst[i].length() - 1));
								List<Predmet> predmeti = new ArrayList<Predmet>();
								predmeti = predmetiKojeSlusa(slusa_predmete);
								
								if(s.getNepolozeniIspiti() == null) {
										prosao = false;
								}else {
									int prosao1 = 0;
									for(Predmet pr : predmeti) {
										for(Predmet pr1 : s.getNepolozeniIspiti()) {
											if(pr.getSifra_predmeta().equals(pr1.getSifra_predmeta())) {
												prosao1++;
											}
										}
									}
									if(prosao1 == 0) {
										prosao = false;
									}
								}
							}
						}else if(tekst[i].equals("!=")) {	
							i++;
								if(tekst[i].contains("{")) {
									tekst[i] = tekst[i].substring(1, tekst[i].length());
									
									while(!tekst[i].contains("}")) {
										slusa_predmete.add(tekst[i]);
										if(tekst[i].equals("and") || tekst[i].equals("or") || tekst[i].equals("OR") || tekst[i].equals("AND") || tekst[i].equals("||") || tekst[i].equals("&&")) {
											tekst[i] = "x";
										}
										i++;
									}
									
									if(tekst[i].contains(")")) {
										tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
										zatvorena = true;
									}
									
									slusa_predmete.add(tekst[i].substring(0, tekst[i].length() - 1));
									List<Predmet> predmeti = new ArrayList<Predmet>();
									predmeti = predmetiKojeSlusa(slusa_predmete);
									
									if(s.getNepolozeniIspiti() == null) {
											prosao = true;
									}else {
										int prosao1 = 0;
										for(Predmet pr : predmeti) {
											for(Predmet pr1 : s.getNepolozeniIspiti()) {
												if(pr.getSifra_predmeta().equals(pr1.getSifra_predmeta())) {
													prosao1++;
												}
											}
										}
										if(prosao1 != 0) {
											prosao = false;
										}
									}
								}
						}else {
							//pogresanUnos = true;
						}
			
				}
				if(!pogresanUnos) {
				boolean samo_slusa = false;
				if(txt.contains("(slusa_predmete") && txt.contains("})")) {
					samo_slusa = true;
				}
				if((!txt.contains("and") && !txt.contains("or") && !txt.contains("AND") && !txt.contains("OR") && !txt.contains("&&") && !txt.contains("||") && prosao) || (prosao && samo_slusa)) {
					zadovoljavajuPretragu.add(s);
					samo_slusa = false;
				}else if(!txt.contains("and") && !txt.contains("or") && !txt.contains("AND") && !txt.contains("OR") && !txt.contains("&&") && !txt.contains("||") && !prosao){
					System.out.println("Nije prosao");
				}else if(tekst[i].equals("and") || tekst[i].contains("AND") || tekst[i].contains("&&")){
					lista.add("and");
				}else if(tekst[i].equals("or") || tekst[i].contains("OR") || tekst[i].contains("||")) {
					lista.add("or");
				}else{
					if(otvorena && zatvorena) {
						if(prosao) {
							lista.add("(");
							lista.add("T");
							lista.add(")");
						}else {
							lista.add("(");
							lista.add("F");
							lista.add(")");
						}
					}else {
						if(otvorena) {
							if(prosao) {
								lista.add("(");
								lista.add("T");
							}else {
								lista.add("(");
								lista.add("F");
							}
						}else if(zatvorena) {
						
							if(prosao) {
								lista.add("T");
								lista.add(")");
							}else {
								lista.add("F");
								lista.add(")");
							}
						}else {
							if(prosao) {
								lista.add("T");
							}else {
								lista.add("F");
							}
						}
					}
				}
				
				if(tekst[tekst.length - 1].contains("))")) {
					duplak = true;
				}
				
				otvorena = false;
				zatvorena = false;
				prosao = true;
				}
			}
			if(!pogresanUnos) {
				if(duplap) {
					lista.add(1, "(");
					duplap = false;
				}
				if(duplak) {
					lista.add(")");
					duplak = false;
				}
				
				if(!lista.isEmpty()) {
					lista.remove(lista.size() - 1);
					lista.remove(0);
				}
			if(lista.contains("and")) {
				for(int b = 0; b < lista.size(); b++) {//prioritet za and
					if(lista.get(b).equals("and")) {
						
						String prvi = lista.get(b - 1);
						
						String drugi = lista.get(b + 1);
					if(!prvi.equals(")") && !drugi.equals("(")) {
						if(prvi.equals("T") && drugi.equals("T")) {
							lista.set(b - 1, "T");
						}else {
							lista.set(b - 1, "F");
						}
						lista.remove(b + 1);
						lista.remove(b);
					}
						
					}
				}
			}
			if(lista.size() != 1) {
			if(!lista.isEmpty() && (lista.contains(")") || lista.contains("("))) {
				for(int k = lista.size() - 1; k >= 0; k--) {
					if(lista.get(k).equals(")")) {
						lista.remove(k);
						k--;
						for(int b = k; b >= 0; b--) {
							
							String prvi = lista.get(b);
							
							lista.remove(b);
							b--;
						
							String akcija = lista.get(b);
							if(akcija.equals("(")) {
								lista.set(b, prvi);
								k = b;
								break;
							}else {
							lista.remove(b);
							b--;
						
							String drugi = lista.get(b);
							
							if(akcija.equals("and")) {
								if(prvi.equals("T") && drugi.equals("T")) {
									lista.set(b, "T");
								}else {
									lista.set(b,"F");
								}
							}else if(akcija.equals("or")) {
								if(prvi.equals("F") && drugi.equals("F")) {
									lista.set(b,"F");
								}else {
									lista.set(b, "T");
								}
							}

							int x = b;
							
							if(lista.get(x-1).equals("(")){
								lista.remove(b-1);
								k = b;
								break;
							}
							b+= 1;
							}
						}
					}
				}
				
			}
			if(lista.size() >= 3) {
				
			for(int k = lista.size() - 1; k >= 0; k--) {
				String prvi = lista.get(k);
				lista.remove(k);
				k--;
				
				String akcija = lista.get(k);
				lista.remove(k);
				k--;
				
				String drugi = lista.get(k);
				lista.remove(k);
				
				if(akcija.equals("and")) {
					if(prvi.equals("T") && drugi.equals("T")) {
						lista.add("T");
					}else {
						lista.add("F");
					}
				}else if(akcija.equals("or")) {
					if(prvi.equals("F") && drugi.equals("F")) {
						lista.add("F");
					}else {
						lista.add("T");
					}
				}
			
				if(!lista.contains("or") && !lista.contains("and")) {
					break;
				}else {
					k += 1;
				}
				
			}
			}
			
			}
			if(!lista.isEmpty()) {
			if(lista.get(0).equals("T")) {
				zadovoljavajuPretragu.add(s);
			}	
			}
			lista.clear();
			prosao = true;
			}
		}else {
			//pogresanUnos = true;
		}
		}
		//if(!pogresanUnos) {																	//Ako korisnik unese pogresno, ne mijenja se izgled tabele
			studenti = zadovoljavajuPretragu;
		//}
	}
	
	public List<Predmet> predmetiKojeSlusa(List<String> tekst){
		ArrayList<Predmet> ret = new ArrayList<Predmet>();
		ArrayList<String> lista = new ArrayList<String>();
		boolean prosao;
		
		for(Predmet predmet : BazaPredmeta.getInstance().getPredmeti()) {
			prosao = true;
			lista.clear();
			
			for(int i = 0; i < tekst.size() - 1; i++) {
					
					if(tekst.get(i).equals("sifra")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(tekst.get(i).startsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								if(!pattern.matcher(predmet.getSifra_predmeta()).matches()) {
									prosao = false;
								}
							}else{
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(!predmet.getSifra_predmeta().equals(tekst.get(i))) {
									prosao = false;
								}
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(tekst.get(i).startsWith("/") && tekst.get(i).endsWith("\"")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								if(pattern.matcher(predmet.getSifra_predmeta()).matches()) {
									prosao = false;
								}
							}else{
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(predmet.getSifra_predmeta().equals(tekst.get(i))) {
									prosao = false;
								}
							}
						}
					}else if(tekst.get(i).equals("naziv")) {
						i++;
						
						if(tekst.get(i).equals("==")) {System.out.println(predmet.getNaziv_predmeta());
							i++;
							
							if(tekst.get(i).startsWith("/") && tekst.get(i).endsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i).toUpperCase());
								
								if(!pattern.matcher(predmet.getNaziv_predmeta()).matches()) {
									prosao = false;
								}
							}else{
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(predmet.getNaziv_predmeta().equals(tekst.get(i))) {
									prosao = false;
								}
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(tekst.get(i).startsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								if(pattern.matcher(predmet.getNaziv_predmeta()).matches()) {
									prosao = false;
								}
							}else{
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								
								if(!predmet.getNaziv_predmeta().equals(tekst.get(i))) {
									prosao = false;
								}
							}
						}
					}else if(tekst.get(i).equals("ESPB")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(predmet.getBroj_ESPB() != Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(predmet.getBroj_ESPB() == Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals(">")) {
							i++;
							if(predmet.getBroj_ESPB() <= Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("<")) {
							i++;
							if(predmet.getBroj_ESPB() >= Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals(">=")) {
							i++;
							if(predmet.getBroj_ESPB() < Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("<=")) {
							i++;
							if(predmet.getBroj_ESPB() > Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}
					}else if(tekst.get(i).equals("godina")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(predmet.getGodina_izvodjenja() != Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(predmet.getGodina_izvodjenja() == Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals(">")) {
							i++;
							if(predmet.getGodina_izvodjenja() <= Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("<")) {
							i++;
							if(predmet.getGodina_izvodjenja() >= Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals(">=")) {
							i++;
							if(predmet.getGodina_izvodjenja() < Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}else if(tekst.get(i).equals("<=")) {
							i++;
							if(predmet.getGodina_izvodjenja() > Integer.parseInt(tekst.get(i))) {
								prosao = false;
							}
						}

					}else if(tekst.get(i).equals("semestar")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")) {
								if(!predmet.getSemestar().toString().equals(tekst.get(i))) {
									prosao = false;
								}
							}	
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")) {
								if(predmet.getSemestar().toString().equals(tekst.get(i))) {
									prosao = false;
								}
							}
						}
					
					if(tekst.get(i).equals("and") || tekst.get(i).equals("AND") || tekst.get(i).equals("&&")) {
						lista.add("and");
					}else if(tekst.get(i).equals("or") || tekst.get(i).equals("OR") || tekst.get(i).equals("||")) {
						lista.add("or");
					}else if(prosao) {
						lista.add("T");
					}else if(!prosao) {
						lista.add("F");
					}
					prosao = true;
				
			}
					if(lista.contains("and")) {
						for(int b = 0; b < lista.size(); b++) {//prioritet za and
							if(lista.get(b).equals("and")) {
								
								String prvi = lista.get(b - 1);
								
								String drugi = lista.get(b + 1);
							if(!prvi.equals(")") && !drugi.equals("(")) {
								if(prvi.equals("T") && drugi.equals("T")) {
									lista.set(b - 1, "T");
								}else {
									lista.set(b - 1, "F");
								}
								lista.remove(b + 1);
								lista.remove(b);
							}
								
							}
						}
					}
			if(lista.size() > 1) {
				for(int k = lista.size() - 1; k >= 0; k--) {
					String prvi = lista.get(k);
					
					lista.remove(k);
					k--;
					String akcija = lista.get(k);
					
					lista.remove(k);
					k--;
					String drugi = lista.get(k);
					
					lista.remove(k);
					
					if(akcija.equals("and") || akcija.equals("AND") || akcija.equals("&&")) {
						if(prvi.equals("T") && drugi.equals("T")) {
							lista.add("T");
						}else {
							lista.add("F");
						}
					}else if(akcija.equals("or") || akcija.equals("OR") || akcija.equals("||")) {
						if(prvi.equals("F") && drugi.equals("F")) {
							lista.add("F");
						}else {
							lista.add("T");
						}
					}
				
					if(lista.size() == 1) {
						break;
					}else {
						k += 1;
					}
					
				}
			}	
			
			if(lista.get(0).equals("T")) {
			
				ret.add(predmet);
			}
			
		}
		
		
		return ret;
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
		//privremeno = studenti;
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
		//privremeno = studenti;
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
	
	public void setPrivremeno(List<Student> lista) {
		privremeno = lista;
	}
	
}
