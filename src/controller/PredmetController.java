package controller;

import java.util.ArrayList;
import java.util.Date;

import izgledAplikacije.GlavniProzor;
import model.BazaNepolozeniIspiti;
import model.BazaOcjena;
import model.BazaPredmeta;

import model.BazaStudenata;

import model.BazaProfesora;

import model.Predmet;
import model.Profesor;
import model.Student;

public class PredmetController {

	
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void dodajPredmet(Predmet p) {
		BazaPredmeta.getInstance().dodajPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz("DODAT", -1);
	}
	
	public void izmeniPredmet(Predmet p) {
		BazaPredmeta.getInstance().izmeniPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz("IZMJENJEN",-1);
		BazaStudenata.getInstance().izmeniNepolozeni(p);
		
	}
	
	public void izbrisiPredmet(Predmet p) {
		BazaProfesora.getInstance().izbrisiPredmetsaProfesora(p);
		BazaPredmeta.getInstance().obrisiPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz("IZBRISI",-1);
		
	}
	
	
	//za pretragu
		public void vratiPrikaz() {
			BazaPredmeta.getInstance().vratiPrikaz();
			GlavniProzor.getInstance().azurirajPrikaz("VRACENO", -1);
		}
		
		
		public void pretragaPredmeta(String txt) {
			BazaPredmeta.getInstance().pretraziPredmete(txt);
			GlavniProzor.getInstance().azurirajPrikaz("NADJEN", -1);
		}
	
	public void dodajNepolozeni(Predmet p, Student s) {
		BazaNepolozeniIspiti.getInstance().dodajNepolozene(p, s);
		BazaPredmeta.dodajStudentaNepolozeni(p, s);
	}
	
	
	
	//za upis ocjene
	public void izbrisiNepolozeni(Predmet p, Student s) {
		BazaNepolozeniIspiti.getInstance().izbrisiNepolozeni(p, s);
	}
	
	public void dodajPolozeni(Predmet p, Student s, int ocjena, Date datumPolaganja) {
		BazaOcjena.getInstance().dodajPolozeni(s, p, ocjena, datumPolaganja);
	
		BazaPredmeta.getInstance().dodajStudentaPolozeni(p, s);
		BazaPredmeta.getInstance().skloniStudentaNepolozeni(s, p);

	}
	
	
	
	
	
	public void ukloniProfPredmetima(ArrayList<Predmet> predmeti) {
		BazaPredmeta.getInstance().ukloniProfesoraPredmetima(predmeti);
	}
	
	public void ukloniProfesoraPredmetu(Profesor prof, Predmet pred) {
		BazaPredmeta.getInstance().ukloniProfesoraPredmetu(prof, pred);
	}

	public void naprednaPretragaPredmeta(String txt) {
		BazaPredmeta.getInstance().naprednaPretragaPredmeta(txt);
		GlavniProzor.getInstance().azurirajPrikaz("NADJEN", -1);
		
	}
	
}
