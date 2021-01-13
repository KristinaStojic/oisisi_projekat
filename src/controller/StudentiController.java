package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;

public class StudentiController {
	
	private static StudentiController instance = null;
	
	public static StudentiController getInstance() {
		if(instance == null) {
			instance = new StudentiController();
		}
		return instance;
	}
	
	private StudentiController() {}
	
	public void dodajStudenta(Student s) {
		BazaStudenata.getInstance().dodajStudenta(s);
		GlavniProzor.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
	public void vratiPrikaz() {
		BazaStudenata.getInstance().vratiPrikaz();
		GlavniProzor.getInstance().azurirajPrikaz("VRACENO", -1);
	}
	
	public void izmeniStudenta(Student s) {
		BazaStudenata.getInstance().izmeniStudenta(s);
		GlavniProzor.getInstance().azurirajPrikaz("IZMJENJEN", -1);
	}
	
	public void izbrisiStudenta(Student s) {
		BazaStudenata.getInstance().izbrisiStudenta(s.getId());
		GlavniProzor.getInstance().azurirajPrikaz("IZBRISAN", -1);
		BazaStudenata.getInstance().skloniIzPredmeta(s);
	}
	
	public void pretragaStudenata(String txt) {
		BazaStudenata.getInstance().pretraziStudente(txt);
		GlavniProzor.getInstance().azurirajPrikaz("NADJEN", -1);
	}
	
	public void naprednaPretragaStudenata(String txt) {
		BazaStudenata.getInstance().naprednaPretraga(txt);
		GlavniProzor.getInstance().azurirajPrikaz("NADJEN", -1);
	}
	
	public void ukloniPredmet(Student s, Predmet p) {
		BazaStudenata.getInstance().ukloniPredmet(s, p);
		BazaStudenata.getInstance().skloniStudentaPredmetu(s, p);
	}
	
	public void ponistiOcjenu(Student s, Ocena o) {
		BazaStudenata.getInstance().ponistiOcjenu(s, o);
		BazaStudenata.getInstance().nisuPoloziliOcjena(s, o);
	}
}
