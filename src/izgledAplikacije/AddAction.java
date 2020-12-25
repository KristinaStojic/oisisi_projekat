package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

import dialozi.AddProfessor;
import dialozi.AddStudent;



public class AddAction extends AbstractAction{

		private static final long serialVersionUID = 1583426086994634757L;

		public AddAction() {
			
			//putValue(MNEMONIC_KEY,KeyEvent.VK_N);
			putValue(SHORT_DESCRIPTION, "New");
			putValue(SMALL_ICON, new ImageIcon("imgs" + File.separator+ "insert.jpg"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Pritisnuto dugme");
				if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 0) {
					AddStudent addStudent = new AddStudent();
					addStudent.setVisible(true);
				}
				else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 1) {
					AddProfessor addProfessor = new AddProfessor();
					addProfessor.setVisible(true);
					
				}

	}
	
	
	
}
