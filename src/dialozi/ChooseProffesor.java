package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controller.ProfesorController;
import izgledAplikacije.GlavniProzor;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class ChooseProffesor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension dim;
	JTable chooseProf;
	JPanel profPan;
	JList<String> profList;
	ArrayList<String> list;
	
	JPanel btnPan;
	JButton potvrdi;
	JButton odustani;
	
	Profesor izabrani;
	
	public ChooseProffesor(Predmet predmet, JButton plus, JButton minus) {
		
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("odaberiProfesora"));
		setSize(400,400);
		setLocationRelativeTo(null);
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		profPan = new JPanel(new BorderLayout());
		list = new ArrayList<String>();
		
		for(Profesor p : BazaProfesora.getInstance().getProfesori()) {
			list.add(p.getIme() + " " + p.getPrezime());
		}
		profList = new JList<String>(list.toArray(new String[list.size()]));
		JScrollPane pane1 = new JScrollPane();
		pane1.setViewportView(profList);
		profList.setLayoutOrientation(JList.VERTICAL);
		profList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		profPan.add(pane1);
		profPan.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		
		btnPan = new JPanel();
		
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));
		
		btnPan.add(potvrdi);
		btnPan.add(odustani);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(profList.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("morateIzabratiProfesora"));
				}else {
					izabrani = BazaProfesora.getInstance().getProfesori().get(profList.getSelectedIndex());
					EditPredmet.txtProf.setText(izabrani.getIme() + " " + izabrani.getPrezime());
					predmet.setPredmeni_profesor(izabrani);
					ProfesorController.getInstance().dodajPredmet(izabrani, predmet);
					if(predmet.getPredmetni_profesor() != null) {
						plus.setEnabled(false);
						minus.setEnabled(true);
					}else {
						plus.setEnabled(true);
						minus.setEnabled(false);
					}
					dispose();
				}
			}	
			
		});
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				predmet.setPredmeni_profesor(null);
				dispose();
			}
		});
		
		add(profPan, BorderLayout.CENTER);
		add(btnPan, BorderLayout.SOUTH);
		
	}
	
}
