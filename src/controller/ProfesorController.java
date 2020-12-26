package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaProfesora;
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
}
