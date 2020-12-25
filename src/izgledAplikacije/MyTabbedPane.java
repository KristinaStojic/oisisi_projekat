package izgledAplikacije;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import izgledAplikacije.MyTabbedPan.Tab;

public class MyTabbedPane extends JTabbedPane{

	
	enum Tab {Studenti, Profesori, Predmeti};
	
	
	JPanel studentiPanel = new JPanel();
	JPanel profesoriPanel = new JPanel();
	JPanel predmetiPanel = new JPanel();
	

	static JTable profesoriTabela;
	static JTable predmetiTabela;
	
	public MyTabbedPane() {
		
		
		profesoriPanel.setLayout(new BorderLayout());
		profesoriTabela = new JTables(Tab.Profesori);
		JScrollPane pane1 = new JScrollPane(profesoriTabela);
		profesoriPanel.add(pane1, BorderLayout.CENTER);
		add(Tab.Profesori.toString(), profesoriPanel);
		
	}
	
	
	public void azurirajPrikazProfesora(String akcija, int vrijednost) {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) profesoriTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
}
