package izgledAplikacije;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import model.BazaProfesora;
import model.Profesor;

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
		JScrollPane pane = new JScrollPane(studentiTabela);
		studentiPanel.add(pane, BorderLayout.CENTER);
		add(Tab.Studenti.toString(), studentiPanel);
		
		profesoriPanel.setLayout(new BorderLayout());
		profesoriTabela = new JTables(Tab.Profesori);
		JScrollPane pane1 = new JScrollPane(profesoriTabela);
		profesoriPanel.add(pane1, BorderLayout.CENTER);
		add(Tab.Profesori.toString(), profesoriPanel);
		
		predmetiPanel.setLayout(new BorderLayout());
	    predmetiTabela = new JTables(Tab.Predmeti);
	    JScrollPane pane2 = new JScrollPane(predmetiTabela);
	    predmetiPanel.add(pane2,BorderLayout.CENTER);
	    add(Tab.Predmeti.toString(), predmetiPanel);
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
	
	//cuva vrstu izabranog profesora
	public Profesor getIzabraniProfesor() {
		if (profesoriTabela.getSelectedRow() < 0)
		{
			return null;
		}
		Profesor profesor = BazaProfesora.getInstance().getRow(profesoriTabela.getSelectedRow());
		return profesor;
	}
	
}
