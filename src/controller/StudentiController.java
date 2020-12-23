package controller;

import izgledAplikacije.GlavniProzor;
import model.BazaStudenata;
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
}
