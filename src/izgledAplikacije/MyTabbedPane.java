package izgledAplikacije;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
	
	static JTables studentiTabela;
	static JTables profesoriTabela;
	static JTables predmetiTabela;
	
	public MyTabbedPane() {
		studentiPanel.setLayout(new BorderLayout());
		studentiTabela = new JTables(Tab.Studenti);
		JScrollPane pane = new JScrollPane(studentiTabela);
		studentiPanel.add(pane, BorderLayout.CENTER);
		add(Tab.Studenti.toString(), studentiPanel);
		
		
	}
	
	
	
}
