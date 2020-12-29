package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaProfesora;
import model.BazaStudenata;
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
		GlavniProzor.getInstance().azurirajPrikaz("IZMENJEN", -1);
	}
	
	public void izbrisiProfesora(Profesor p) {
		BazaProfesora.getInstance().izbrisiProfesora(p.getBrojLicneKarte());
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
}
