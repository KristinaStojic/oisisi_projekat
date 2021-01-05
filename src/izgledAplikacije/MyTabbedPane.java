package izgledAplikacije;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;

public class MyTabbedPane extends JTabbedPane{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


enum Tab {Studenti, Profesori, Predmeti};
	
	JPanel studentiPanel = new JPanel();
	JPanel profesoriPanel = new JPanel();
	JPanel predmetiPanel = new JPanel();
	
	public static Tab tab = Tab.Studenti;
	
	static JTable studentiTabela;
	static JTable profesoriTabela;
	static JTable predmetiTabela;
	
	public MyTabbedPane() {
		
		studentiPanel.setLayout(new BorderLayout());
		studentiTabela = new JTables(Tab.Studenti);
		studentiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane pane = new JScrollPane(studentiTabela);
		studentiPanel.add(pane, BorderLayout.CENTER);
		add(GlavniProzor.getInstance().getResourceBundle().getString("tabStudenti"), studentiPanel);
		
		profesoriPanel.setLayout(new BorderLayout());
		profesoriTabela = new JTables(Tab.Profesori);
		profesoriTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane pane1 = new JScrollPane(profesoriTabela);
		profesoriPanel.add(pane1, BorderLayout.CENTER);
		add(GlavniProzor.getInstance().getResourceBundle().getString("tabProfesori"), profesoriPanel);
		
		predmetiPanel.setLayout(new BorderLayout());
	    predmetiTabela = new JTables(Tab.Predmeti);
	    predmetiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    JScrollPane pane2 = new JScrollPane(predmetiTabela);
	    predmetiPanel.add(pane2,BorderLayout.CENTER);
	    add(GlavniProzor.getInstance().getResourceBundle().getString("tabPredmeti"), predmetiPanel);
	}
	
	public void azurirajPrikazStudenata(String akcija, int vrijednost) {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) studentiTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazProfesora(String akcija, int vrijednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) profesoriTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public Student getIzabraniStudent() {
		if(studentiTabela.getSelectedRow() < 0) {
			return null;
		}
		Student student = new Student();
		String izabraniIndeks = studentiTabela.getValueAt(studentiTabela.getSelectedRow(), 0).toString();
		for(Student s : BazaStudenata.getInstance().getStudenti()) {
			if(s.getBrojIndeksa().equals(izabraniIndeks)) {
				student = s;
			}
		}
		
		return student;
	}
	
	//cuva vrstu izabranog profesora
	public Profesor getIzabraniProfesor() {
		if (profesoriTabela.getSelectedRow() < 0)
		{
			return null;
		}
		//Profesor profesor = BazaProfesora.getInstance().getRow(profesoriTabela.getSelectedRow());
		Profesor prof = BazaProfesora.getInstance().getProfesori().get(profesoriTabela.convertRowIndexToModel(profesoriTabela.getSelectedRow()));
		
		return prof;
	}
	
	public Predmet getIzabraniPredmet() {
		if (predmetiTabela.getSelectedRow() < 0)
		{
			return null;
		}
		Predmet predmet = new Predmet();
		String izabranaSifra = predmetiTabela.getValueAt(predmetiTabela.getSelectedRow(), 0).toString();
		for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			if(p.getSifra_predmeta().equals(izabranaSifra)) {
				predmet = p;
			}
		}
		return predmet;
	}
	
	
	public void azurirajPrikazPredmeta(String akcija, int vrijednost) {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) predmetiTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void initTab() {
		setTitleAt(0, GlavniProzor.getInstance().getResourceBundle().getString("tabStudenti"));
		studentiTabela.getColumnModel().getColumn(0).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtIndeks"));
		studentiTabela.getColumnModel().getColumn(1).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtIme"));
		studentiTabela.getColumnModel().getColumn(2).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtPrezime"));
		studentiTabela.getColumnModel().getColumn(3).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtGodinaStudija"));
		studentiTabela.getColumnModel().getColumn(4).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtStatus"));
		studentiTabela.getColumnModel().getColumn(5).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtProsjek"));
		
		setTitleAt(1, GlavniProzor.getInstance().getResourceBundle().getString("tabProfesori"));
		profesoriTabela.getColumnModel().getColumn(0).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtIme"));
		profesoriTabela.getColumnModel().getColumn(1).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtPrezime"));
		profesoriTabela.getColumnModel().getColumn(2).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtprTitula"));
		profesoriTabela.getColumnModel().getColumn(3).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtprZvanje"));
		
		
		setTitleAt(2, GlavniProzor.getInstance().getResourceBundle().getString("tabPredmeti"));
		predmetiTabela.getColumnModel().getColumn(0).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtpSifra"));
		predmetiTabela.getColumnModel().getColumn(1).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtpNaziv"));
		predmetiTabela.getColumnModel().getColumn(2).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtpESPB"));
		predmetiTabela.getColumnModel().getColumn(3).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtpGodina"));
		predmetiTabela.getColumnModel().getColumn(4).setHeaderValue(GlavniProzor.getInstance().getResourceBundle().getString("jtpSemestar"));

	}
	
	
}
