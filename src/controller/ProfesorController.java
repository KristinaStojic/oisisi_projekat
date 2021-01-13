package controller;

import java.util.ArrayList;

import izgledAplikacije.GlavniProzor;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class ProfesorController {

	
private static ProfesorController instance = null;
	
	public static ProfesorController getInstance() {
		if(instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}
	
	private ProfesorController() {}
	
	public void dodajProfesora(Profesor p) {
		BazaProfesora.getInstance().dodajProfesor(p);
		GlavniProzor.getInstance().azurirajPrikaz("DODAT", -1);
		
	}
	
	public void izmeniProfesora(Profesor p) {
		BazaProfesora.getInstance().izmeniProfesora(p);
		BazaPredmeta.getInstance().izmeniProfesora(p);
		GlavniProzor.getInstance().azurirajPrikaz("IZMENJEN", -1);
	}
	
	public void izbrisiProfesora(Profesor p) {
		BazaProfesora.getInstance().izbrisiProfesora(p.getId());
		BazaPredmeta.getInstance().ukloniProfesora(p.getId());
		GlavniProzor.getInstance().azurirajPrikaz("IZBRISAN", -1);
	}
	
	//za pretragu
	public void vratiPrikaz() {
		BazaProfesora.getInstance().vratiPrikaz();
		GlavniProzor.getInstance().azurirajPrikaz("VRACENO", -1);
	}
	
	
	public void pretragaProfesora(String txt) {
		BazaProfesora.getInstance().pretraziProfesore(txt);
		GlavniProzor.getInstance().azurirajPrikaz("NADJEN", -1);
	}
	
	public void ukloniPredmete(Profesor pf, ArrayList<Predmet> pp) {
		BazaProfesora.getInstance().ukloniPredmete(pf, pp);
	}
	
	public void dodajPredmet(Profesor p, Predmet pp) {
		BazaProfesora.getInstance().dodajPredmete(p, pp);
	}
	
	public void izbrisiPredmetProfesoru(Profesor prof, Predmet pred) {
		BazaProfesora.getInstance().izbrisiPredmet(prof, pred);
		//GlavniProzor.getInstance().tabbedPane.azurirajPrikazProfesora("OBRISAN", -1);
		}

}
