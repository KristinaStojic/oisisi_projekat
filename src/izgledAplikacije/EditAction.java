package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import dialozi.EditPredmet;
import dialozi.EditProfesor;
import dialozi.EditStudent;
import model.Predmet;
import model.Profesor;
import model.Student;

public class EditAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EditAction() {
		
		//putValue(MNEMONIC_KEY,KeyEvent.VK_I);
		putValue(SHORT_DESCRIPTION, "Edit");
		putValue(SMALL_ICON, new ImageIcon("imgs" + File.separator +"search.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 1) {
		    Profesor izabraniProfesor = GlavniProzor.getInstance().tabbedPane.getIzabraniProfesor();
		   //System.out.println(izabraniProfesor);
			if(izabraniProfesor !=null) {
			EditProfesor editProfesor = new EditProfesor(izabraniProfesor);
			editProfesor.setVisible(true);
			}else {
			JOptionPane.showMessageDialog(null, "Morate izabrati profesora!");
			}
		}else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 0) {
			Student izabraniStudent = GlavniProzor.getInstance().tabbedPane.getIzabraniStudent();
			if(izabraniStudent != null) {
				EditStudent editStudent = new EditStudent(izabraniStudent);
				editStudent.setVisible(true);
				GlavniProzor.getInstance().azurirajPrikaz("IZMJENI", -1);
			}else {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), GlavniProzor.getInstance().getResourceBundle().getString("morateIzabratiStudenta"));
			}
		}else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 2) {
			Predmet izabraniPredmet = GlavniProzor.getInstance().tabbedPane.getIzabraniPredmet();
			if(izabraniPredmet != null) {
				EditPredmet editPredmet = new EditPredmet(izabraniPredmet);
				editPredmet.setVisible(true);
				GlavniProzor.getInstance().azurirajPrikaz("IZMJENE", -1);
			}else {
				JOptionPane.showMessageDialog(GlavniProzor.getInstance(), GlavniProzor.getInstance().getResourceBundle().getString("morateIzabratiPredmet"));
			}
		}

}
}
