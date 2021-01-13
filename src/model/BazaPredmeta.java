package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class BazaPredmeta {
		
	private static BazaPredmeta instance = null;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();
		}
		return instance;
	}
	
	private List<Predmet> predmeti;
	private List<String> kolone;
	private int id;
	
	private List<Predmet> pomocni;
	private List<Predmet> zadovoljavajuPretragu;
	
	private BazaPredmeta() {

		id = 0;
		
		inicijalizujPredmete();
		
		
	
		this.kolone = new ArrayList<String>();
		
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("Broj ESPB bodova");
		this.kolone.add("Godina na kojoj se predmet izvodi");
		this.kolone.add("Semestar u kome se predmet izvodi");
		
		
	}
	
	private void inicijalizujPredmete(){
		
		this.predmeti = new ArrayList<Predmet>();
		/*Predmet p1 = new Predmet("E2","OISISI",model.Predmet.Semestar.Zimski,3,null,8,null,null);
		p1.setId(id++);
		predmeti.add(p1);
		Predmet p2 = new Predmet("E33","NANS",model.Predmet.Semestar.Letnji,4,null,8,null,null);
		p2.setId(id++);
		predmeti.add(p2);
		Predmet nep1 = new Predmet("P13","Baze podataka",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		Predmet nep2 = new Predmet("E3","SAU",model.Predmet.Semestar.Zimski,2,null,8,null,null);
		nep1.setId(id++);
		nep2.setId(id++);
		predmeti.add(nep2);
		predmeti.add(nep1);
		Predmet pr1 = new Predmet("P132","Baze podataka3",model.Predmet.Semestar.Letnji,4,null,6,null,null);
		Predmet pr2 = new Predmet("E32","SAU3",model.Predmet.Semestar.Zimski,6,null,8,null,null);
		pr1.setId(id++);
		pr2.setId(id++);
		predmeti.add(pr2);
		predmeti.add(pr1);*/
		
		ObjectInputStream in = null;
		Predmet pr = null;
		
		try {
			in=new ObjectInputStream(new BufferedInputStream(new FileInputStream("predmeti.txt")));
			while(true) {
				pr=(Predmet) in.readObject();
				dodajPredmet(pr);
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
		
		pomocni = predmeti;
		
	}
	
	public void obrisiPredmet(Predmet p) {
		for(Predmet i : predmeti) {
			if(i.getSifra_predmeta().equals(p.getSifra_predmeta())) {
				predmeti.remove(p);
				pomocni.remove(p);
				break;
			}
		}
		//pomocni = predmeti;
	}
	
	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}
	
	public void dodajPredmet(Predmet p) {
		p.setId(id++);
		this.predmeti.add(p);
		pomocni = predmeti;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}
	
	
	public String getValueAt(int row, int column) {
		Predmet p = this.predmeti.get(row);
		switch(column) {
		case 0:
			return p.getSifra_predmeta();
		case 1:
			return p.getNaziv_predmeta();
		case 2:
			return String.valueOf(p.getBroj_ESPB());
		case 3:
			return String.valueOf(p.getGodina_izvodjenja());
		case 4:
			return String.valueOf(p.getSemestar());
		default:
			return null;
		}
	}
	
	public void izmeniPredmet(Predmet p) {
		for(Predmet pr : predmeti) {
			if(pr.getId() == p.getId()) {
				pr.setSifra_predmeta(p.getSifra_predmeta());
				pr.setNaziv_predmeta(p.getNaziv_predmeta());
				pr.setSemestar(p.getSemestar());
				pr.setGodina_izvodjenja(p.getGodina_izvodjenja());
				pr.setPredmeni_profesor(p.getPredmetni_profesor());
				pr.setBroj_ESPB(p.getBroj_ESPB());
				pr.setStudenti_polozili(p.getStudenti_polozili());
				pr.setStudenti_nisu_polozili(p.getStudenti_nisu_polozili());
			}
		}
		//pomocni = predmeti;
	}
	
	
	// u slucaju da je polje za pretragu prazno, vraca pocetnu tabelu
		public void vratiPrikaz() {
			predmeti = pomocni;
		}
		
		public void pretraziPredmete(String txt) {
			zadovoljavajuPretragu = new ArrayList<Predmet>();
			
			
			for(Predmet pred : pomocni) {
				String rijeci[] = txt.split(" ");
				if(rijeci.length == 1) {
					String naziv = rijeci[0];
					if(pred.getNaziv_predmeta().toUpperCase().contains(naziv.toUpperCase())) {
						zadovoljavajuPretragu.add(pred);
					}
				}
			}
			predmeti = zadovoljavajuPretragu;
		}
	
	public void ukloniProfesora(int id) {
		for(Predmet p : predmeti) {
			if(p.getPredmetni_profesor() != null) {
				if(p.getPredmetni_profesor().getId() == id) {
					p.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	public void ukloniProfesoraPredmetima(ArrayList<Predmet> predm) {
		for(Predmet p : predm) {
			for(Predmet pr : predmeti) {
				if(pr.getSifra_predmeta().equals(p.getSifra_predmeta())) {
					pr.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	
	public void dodajPredmetuProfesora(Profesor prof, Predmet pred) {
		for(Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(pred.getSifra_predmeta())) {
				p.setPredmeni_profesor(prof);
			}
		}
	}
	
	
	public void saveDataPredmetTxt()throws IOException{
		ObjectOutputStream out=null;
		
		try {
			out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("predmeti.txt")));
			for(Predmet pr:predmeti) {
				out.writeObject(pr);
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
	
	
	public void ukloniProfesoraPredmetu(Profesor prof, Predmet pred) {
		for(Predmet p : predmeti) {
			if(p.getPredmetni_profesor() != null) {
				if(p.getPredmetni_profesor().getBrojLicneKarte().equals(prof.getBrojLicneKarte())) {
					p.setPredmeni_profesor(null);
				}
			}
		}
	}
	
	
	public Predmet findById(String sifra) {
		for (Predmet p : predmeti) {
			if (p.getSifra_predmeta().equals(sifra)) {

				return p;

			}
		}
		return null;

	}
	
	public void dodajProfesoraPredmetu(Profesor prof, Predmet pred) {
		BazaPredmeta.getInstance().dodajPredmetuProfesora(prof, pred);
	}
	
	
	public void naprednaPretragaPredmeta(String txt) {
		zadovoljavajuPretragu = new ArrayList<Predmet>();
		boolean prosao = true;
		
		
		for(Predmet p: predmeti) {
			String[] tekst = txt.split(" ");
			List<String> lista = new ArrayList<String>();
			List<String> sadrzi_profesora = new ArrayList<String>();
			prosao = true;
			boolean otvorena = false;
			boolean zatvorena = false;
			boolean duplap = false;
			boolean duplak = false;
			boolean pogresanUnos = false;
			
			if(tekst[0].equals("predmeti") && tekst[1].equals("=") && tekst[2].startsWith("(")) {
				
				for(int i = 2; i < tekst.length; i++) {
					
					if(tekst[i].contains("(")) {
						tekst[i] = tekst[i].substring(1, tekst[i].length());
						otvorena = true;
					}
					if(tekst[i].contains("(")) {
						tekst[i] = tekst[i].substring(1, tekst[i].length());
						duplap = true;
					}
					
					
					if(tekst[i].equals("sifra")) {
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
								if(!pattern.matcher(p.getSifra_predmeta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!p.getSifra_predmeta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else if(tekst[i].equals("!=")){	
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
								if(pattern.matcher(p.getSifra_predmeta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(p.getSifra_predmeta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else {
							pogresanUnos = true;
						}
					}else if(tekst[i].equals("naziv")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							if(tekst[i].startsWith("/") && tekst[i].endsWith("/")) { //ako je regularni izraz
								tekst[i] = tekst[i].substring(1, tekst[i].length() - 1); //skloni //
								Pattern pattern = Pattern.compile(tekst[i].toUpperCase());
								if(!pattern.matcher(p.getNaziv_predmeta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(!p.getNaziv_predmeta().toUpperCase().equals(tekst[i].toUpperCase())) {
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
								Pattern pattern = Pattern.compile(tekst[i].toUpperCase());
								if(pattern.matcher(p.getNaziv_predmeta().toUpperCase()).matches()) {
									prosao = false;
								}
							}else if(tekst[i].startsWith("\"") && tekst[i].endsWith("\"")){
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(p.getNaziv_predmeta().toUpperCase().equals(tekst[i].toUpperCase())) {
									prosao = false;
								}
							}else {
								pogresanUnos = true;
							}
						}else {
							pogresanUnos = true;
						}
					}else if(tekst[i].equals("ESPB")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(p.getBroj_ESPB() != Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getBroj_ESPB() == Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getBroj_ESPB() >= Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getBroj_ESPB() <= Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getBroj_ESPB() > Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getBroj_ESPB() < Integer.parseInt(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}

					}else if(tekst[i].equals("godina")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
								tekst[i] = tekst[i].replaceAll("[\"]", "");
								if(p.getGodina_izvodjenja() != Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getGodina_izvodjenja() == Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getGodina_izvodjenja() >= Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getGodina_izvodjenja() <= Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getGodina_izvodjenja() > Integer.parseInt(tekst[i].toUpperCase())) {
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
							if(p.getGodina_izvodjenja() < Integer.parseInt(tekst[i].toUpperCase())) {
								prosao = false;
							}
						}else {
							//pogresanUnos = true;
						}

					}else if(tekst[i].equals("semestar")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							
							if(tekst[i].contains(")")) {
								tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
								zatvorena = true;
							}
							tekst[i] = tekst[i].replaceAll("[()]", "");
							tekst[i] = tekst[i].replaceAll("[\"]", ""); 
								
								if(!p.getSemestar().toString().equals((tekst[i].substring(0,1).toUpperCase() + tekst[i].substring(1,tekst[i].length()).toLowerCase()))) {
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
							
								if(p.getSemestar().toString().equals((tekst[i].substring(0,1).toUpperCase() + tekst[i].substring(1,tekst[i].length()).toLowerCase()))) {  //tekst[i].toLowerCase()
									prosao = false;
									
								}
						}else {
							//pogresanUnos = true;
						}
					}else if(tekst[i].equals("profesori")) {
						i++;
						if(tekst[i].equals("==")) {
							i++;
							if(tekst[i].contains("{")) {
								tekst[i] = tekst[i].substring(1, tekst[i].length());
								
								while(!tekst[i].contains("}")) {
									sadrzi_profesora.add(tekst[i]);
									if(tekst[i].equals("and") || tekst[i].equals("or") || tekst[i].equals("OR") || tekst[i].equals("AND") || tekst[i].equals("||") || tekst[i].equals("&&")) {
										tekst[i] = "x";
									}
									i++;
								}
								
								if(tekst[i].contains(")")) {
									tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
									zatvorena = true;
								}
								
								sadrzi_profesora.add(tekst[i].substring(0, tekst[i].length() - 1));
								List<Profesor> profesori = new ArrayList<Profesor>();
								profesori = profesoriKojeSadrzi(sadrzi_profesora);
								
								if(p.getPredmetni_profesor() == null) {
										prosao = false;
								}else {
									int prosao1 = 0;
									for(Profesor pr : profesori) {
										for(Predmet pr1 : pr.getPredmetiProfesora()) {
											if(pr1.getPredmetni_profesor().equals(p.getPredmetni_profesor())) {
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
							{	
								i++;
								if(!tekst[i].contains("}")) {
									//pogresanUnos = true;
								}
									if(tekst[i].contains("{")) {
										tekst[i] = tekst[i].substring(1, tekst[i].length());
										
										while(!tekst[i].contains("}")) {
											sadrzi_profesora.add(tekst[i]);
											if(tekst[i].equals("and") || tekst[i].equals("or") || tekst[i].equals("OR") || tekst[i].equals("AND") || tekst[i].equals("||") || tekst[i].equals("&&")) {
												tekst[i] = "x";
											}
											i++;
										}
										
										if(tekst[i].contains(")")) {
											tekst[i] = tekst[i].substring(0, tekst[i].length() - 1);
											zatvorena = true;
										}
										
										sadrzi_profesora.add(tekst[i].substring(0, tekst[i].length() - 1));
										List<Profesor> profesori = new ArrayList<Profesor>();
										profesori = profesoriKojeSadrzi(sadrzi_profesora);
										
										if(p.getPredmetni_profesor() == null) {
												prosao = true;
										}else {
											int prosao1 = 0;
											for(Profesor pr : profesori) {
												for(Predmet pr1 : pr.getPredmetiProfesora()) {
													if(pr1.getPredmetni_profesor().equals(p.getPredmetni_profesor())) {
														prosao1++;
													}
												}
											}
											if(prosao1 != 0) {
												prosao = false;
											}
										}
									}
							}
				
							
						}
			
				}
				
				
					if(!pogresanUnos) {
						boolean samo_slusa = false;
						if(txt.contains("(profesori") && txt.contains("})")) {
							samo_slusa = true;
						}
						if((!txt.contains("and") && !txt.contains("or") && !txt.contains("AND") && !txt.contains("OR") && !txt.contains("&&") && !txt.contains("||") && prosao) || (prosao && samo_slusa)) {
							zadovoljavajuPretragu.add(p);
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
									//
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
						zadovoljavajuPretragu.add(p);
					}	
					}
					lista.clear();
					prosao = true;
					}
				}
				}
				predmeti = zadovoljavajuPretragu;
			}

	public List<Profesor> profesoriKojeSadrzi(List<String> tekst) {

		ArrayList<Profesor> ret = new ArrayList<Profesor>();
		ArrayList<String> lista = new ArrayList<String>();
		boolean prosao;
		for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			prosao = true;
			lista.clear();
			boolean pogresanUnos = false;
			for(int i = 0; i < tekst.size() - 1; i++) {
					
					if(tekst.get(i).equals("ime")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(tekst.get(i).startsWith("/") && tekst.get(i).endsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								
								if(!pattern.matcher(profesor.getIme()).matches()) {
									prosao = false;
								}
							}else if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")) {
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(!profesor.getIme().equals(tekst.get(i))) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(tekst.get(i).startsWith("/") && tekst.get(i).endsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								if(pattern.matcher(profesor.getIme()).matches()) {
									prosao = false;
								}
							}else if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")){
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(profesor.getIme().equals(tekst.get(i))) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}
					}else if(tekst.get(i).equals("prezime")) {
						i++;
						if(tekst.get(i).equals("==")) {
							i++;
							if(tekst.get(i).startsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								
								if(!pattern.matcher(profesor.getIme()).matches()) {
									prosao = false;
								}
							}else if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")){
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(!profesor.getIme().equals(tekst.get(i))) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}else if(tekst.get(i).equals("!=")) {
							i++;
							if(tekst.get(i).startsWith("/")) {
								tekst.set(i, tekst.get(i).substring(1, tekst.get(i).length() - 1));
								Pattern pattern = Pattern.compile(tekst.get(i));
								if(pattern.matcher(profesor.getIme()).matches()) {
									prosao = false;
								}
							}else if(tekst.get(i).startsWith("\"") && tekst.get(i).endsWith("\"")){
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(profesor.getIme().equals(tekst.get(i))) {
									prosao = false;
								}
							}else {
								//pogresanUnos = true;
							}
						}
					}else if(tekst.get(i).equals("titula")) {
						i++;
						if(tekst.get(i).equals("==")) {
								i++;
							
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(!profesor.getTitula().toString().equals(tekst.get(i))) {
									prosao = false;
								}else {
									//pogresanUnos = true;
								}
							
						}else if(tekst.get(i).equals("!=")) {
								i++;
								
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(profesor.getTitula().toString().equals(tekst.get(i))) {
									prosao = false;
								}else {
									//pogresanUnos = true;
								}
							
						}else {
							//pogresanUnos = true;
						}
					}else if(tekst.get(i).equals("zvanje")) {
						i++;
						if(tekst.get(i).equals("==")) {
								i++;
							
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(!profesor.getZvanje().toString().equals(tekst.get(i))) {
									prosao = false;
								}else {
									//pogresanUnos = true;
								}
							
						}else if(tekst.get(i).equals("!=")) {
								i++;
								
								tekst.set(i, tekst.get(i).replaceAll("\"", ""));
								if(profesor.getZvanje().toString().equals(tekst.get(i))) {
									prosao = false;
								}else {
									//pogresanUnos = true;
								}
							
						}else {
							//pogresanUnos = true;
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
			/*for(String str : lista) {
				System.out.println(str);
			}
			System.out.println("\n");*/
			
			//provjera 2 po dva uslova da li su tacna
			if(!pogresanUnos) {
				if(lista.contains("and") || lista.contains("AND") || lista.contains("&&")) {
					for(int b = 0; b < lista.size(); b++) {//prioritet za and
						if(lista.get(b).equals("and") || lista.get(b).equals("AND") || lista.get(b).equals("&&")) {
							
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
		
			ret.add(profesor);
		}
		}
	}
	
	
	return ret;
	
	}
	
	public static void dodajStudentaNepolozeni(Predmet p, Student s) {
		for(Student st : BazaStudenata.getInstance().getStudenti()) {
			if(st.getBrojIndeksa().equals(s.getBrojIndeksa())) {
				for(Predmet pr : BazaPredmeta.getInstance().getPredmeti()) {
					if(p.getSifra_predmeta().equals(pr.getSifra_predmeta())) {
						if(p.getStudenti_nisu_polozili() != null) {
							p.getStudenti_nisu_polozili().add(st);
						}else {
							ArrayList<Student> list = new ArrayList<Student>();
							list.add(st);
							p.setStudenti_nisu_polozili(list);
						}
					}
				}
			}
		}
	}
		
}
