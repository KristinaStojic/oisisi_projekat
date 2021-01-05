package izgledAplikacije;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentiController;

public class ToolBar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JButton btn1;
	
	public ToolBar() {
	
	AddAction dodaj = new AddAction();
    btn1 = new JButton(dodaj);
	add(btn1);

	
	//btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), GlavniProzor.getInstance().getResourceBundle().getString("toolNew"));

	btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
    KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), "New");

	addSeparator();
	
	
	InsertAction izmeni = new InsertAction();
	JButton btn2 = new JButton(izmeni);
	//btn2.setToolTipText("Izmeni");
	btn2.setIcon(new ImageIcon("imgs" + File.separator + "olovka.jpg"));
	add(btn2);
	btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	        KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK), "Edit");
	addSeparator();
	
	
	DeleteAction izbrisi = new DeleteAction();
	JButton btn3 = new JButton(izbrisi);
	//btn3.setToolTipText("Obrisi");
	add(btn3);
	btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	        KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK), "Delete");
	setFloatable(false);
	
	
	
	
	JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);
	panBottom.add(Box.createGlue());
	JTextField trazi = new JTextField();
	panBottom.add(trazi);
	trazi.setMaximumSize(new Dimension(5000,100));
	add(panBottom);
	
	
	JButton Btn4 = new JButton();
	Btn4.setToolTipText("Search");
	Btn4.setIcon(new ImageIcon("imgs" + File.separator +"search.jpg"));
	add(Btn4);
	
	Btn4.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 0) {
				String txt = trazi.getText();
				if(txt.trim().equals("")) {
					StudentiController.getInstance().vratiPrikaz();
				}
				if(txt.contains("student")) {
					StudentiController.getInstance().naprednaPretragaStudenata(txt);
				}else {
					StudentiController.getInstance().pretragaStudenata(txt);
				}
			}
			else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 1) {
				String txt = trazi.getText();
				//ako je polje za pretragu prazno
				if(txt.trim().equals("")) {
					ProfesorController.getInstance().vratiPrikaz();
				}
				ProfesorController.getInstance().pretragaProfesora(txt);
			}
			else if(GlavniProzor.getInstance().tabbedPane.getSelectedIndex() == 2) {
				String txt = trazi.getText();
				//ako je polje za pretragu prazno
				if(txt.trim().equals("")) {
					PredmetController.getInstance().vratiPrikaz();
				}
				PredmetController.getInstance().pretragaPredmeta(txt);
			}
		}
	});
	
	/*oolBar toolbar = new JToolBar();
	toolbar.add(dodaj);*/
	
	setVisible(true);
	}
	
	
	public void initToolBar() {
		
	}
}
