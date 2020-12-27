package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import dialozi.DeletePredmet;
import dialozi.DeleteStudent;
import model.Predmet;
import model.Student;

public class DeleteAction extends AbstractAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DeleteAction() {
		
		//putValue(MNEMONIC_KEY,KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("imgs" + File.separator + "delete.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Pritisnuto dugme");

		if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 2) {
		    Predmet izabraniPredmet = GlavniProzor.getInstance().tabbedPane.getIzabraniPredmet();
		  
			if(izabraniPredmet !=null) {
		    DeletePredmet deletePredmet = new DeletePredmet(izabraniPredmet);
		    deletePredmet.setVisible(true);
			}else {
			JOptionPane.showMessageDialog(null, "Morate izabrati predmet!");
			}
		}else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 0) {
			Student izabraniStudent = GlavniProzor.getInstance().tabbedPane.getIzabraniStudent();
			
			if(izabraniStudent != null) {
				DeleteStudent deleteStudent = new DeleteStudent(izabraniStudent);
				deleteStudent.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(null, "Morate izabrati studenta!");
			}
		}

}
}
