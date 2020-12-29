package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaNepolozeniIspiti;
import model.BazaPredmeta;
import model.Predmet;
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
		
	}
	
	public void izbrisiPredmet(Predmet p) {
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
	}
	
}
