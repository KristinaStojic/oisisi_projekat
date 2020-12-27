package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaPredmeta;
import model.Predmet;

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
	
}
