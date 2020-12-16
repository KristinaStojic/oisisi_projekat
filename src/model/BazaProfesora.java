package model;

import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {

	public static BazaProfesora instance = null;
	
	public static BazaProfesora getInstance() {
		if(instance == null) {
			instance = new BazaProfesora();
		}
		return instance;
	}
	
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	private BazaProfesora() {
		inicijalizujProfesore();
		
		this.kolone = new ArrayList<String>();
		this.profesori = new ArrayList<Profesor>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}
	
	private void inicijalizujProfesore() {
		this.profesori=new ArrayList<Profesor>();
		profesori.add(new Profesor("Kristina", "Stojic", "05.03.1999.","Jardan 129","064/351-58-64","stojic.kris@gmail.com","Futoska 50","KA10101", "dr", "Profesor", null));
	}
	
	
	public List<Profesor> getProfesori(){
		return profesori;
	}
	
	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	public int getColumnCount() {
		return 4;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int rowIndex) {
		return this.profesori.get(rowIndex);
	}
	
	
	public String getValueAt(int row, int column) {
		Profesor p = this.profesori.get(row);
		switch(column) {
		case 0:
			return p.getIme();
		case 1:
			return p.getPrezime();
		case 2:
			return p.getTitula();
		case 3:
			return p.getZvanje();
		default:
			return null;
		}
	}
	
}
