package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTable;

public class ChooseProffesor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension dim;
	JTable chooseProf;
	JPanel profPan;
	
	public ChooseProffesor() {
		setTitle("Odaberi profesora");
		setSize(400,400);
		setLocationRelativeTo(null);
		setModal(true);
		
		dim = new Dimension(150, 20);
		profPan = new JPanel();
		
		
		
		add(profPan, BorderLayout.CENTER);
		
	}
	
}
