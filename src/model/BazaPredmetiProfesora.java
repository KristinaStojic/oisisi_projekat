package model;

import java.util.ArrayList;
import java.util.List;

import izgledAplikacije.GlavniProzor;

public class BazaPredmetiProfesora {

	
		private static BazaPredmetiProfesora instance = null;
			
			public static BazaPredmetiProfesora getInstance() {
				//if(instance == null) {
					instance = new BazaPredmetiProfesora();
				//}
				return instance;
			}
			
			private List<Predmet> predmetiProfesora;
			private List<String> kolone;
			
			private BazaPredmetiProfesora() {
				
				initPredmetiProfesora();
				
				this.kolone = new ArrayList<String>();
				
				this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolSifra"));
				this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("kolNaziv"));
				this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("godStud"));
				this.kolone.add(GlavniProzor.getInstance().getResourceBundle().getString("semStud"));
				
			}
			
			private void initPredmetiProfesora() {
				this.predmetiProfesora = new ArrayList<Predmet>();
				Profesor p = GlavniProzor.getInstance().tabbedPane.getIzabraniProfesor();
				try {
				for(Predmet o : p.getPredmetiProfesora()){
					predmetiProfesora.add(o);
				}
				}catch(NullPointerException e) {
					
				}
			}
			
			public List<Predmet> getPredmetiProfesora(){
				return predmetiProfesora;
			}
			
			public void setPredmetiProfesora(List<Predmet> predmetiProfesora) {
				this.predmetiProfesora = predmetiProfesora;
			}
			
			public int getColumnCount() {
				return 4;
			}
			
			public void dodajPredmetiProfesora(Predmet p) {
				this.predmetiProfesora.add(p);
			}
			
			public String getColumnName(int index) {
				return this.kolone.get(index);
			}
			
			public Predmet getRow(int index) {
				return this.predmetiProfesora.get(index);
			}
			
			public String getValueAt(int row, int col) {
				Predmet p = this.predmetiProfesora.get(row);
				switch(col) {
				case 0:
					return p.getSifra_predmeta();
				case 1:
					return p.getNaziv_predmeta();
				case 2:
					return String.valueOf(p.getGodina_izvodjenja());
				case 3:
					return String.valueOf(p.getSemestar());
				default:
					return null;
				}
			}
}
