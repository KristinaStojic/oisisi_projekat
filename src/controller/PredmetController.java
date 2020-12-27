package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class PredmetController {

	
private static PredmetController instance = null;
	
	public static PredmetController getInstance() {
		if(instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	
	public void izbrisiPredmet(Predmet p) {
		BazaPredmeta.getInstance().obrisiPredmet(p);
		GlavniProzor.getInstance().azurirajPrikaz("IZBRISI",-1);
		
	}
	
}
