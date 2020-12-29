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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

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
	
	public ChooseProffesor(Predmet predmet) {
		setTitle("Odaberi profesora");
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
		
		profPan.add(pane1);
		profPan.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		
		btnPan = new JPanel();
		
		potvrdi = new JButton("Potvrdi");
		
		odustani = new JButton("Odustani");
		
		btnPan.add(potvrdi);
		btnPan.add(odustani);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				izabrani = BazaProfesora.getInstance().getProfesori().get(profList.getSelectedIndex());
				EditPredmet.txtProf.setText(getIzabrani().getIme() + " " + getIzabrani().getPrezime());
				dispose();
			}	
			
		});
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				izabrani = null;
				dispose();
			}
		});
		
		add(profPan, BorderLayout.CENTER);
		add(btnPan, BorderLayout.SOUTH);
		
	}
	
	public Profesor getIzabrani() {
		return izabrani;
	}
	
}
