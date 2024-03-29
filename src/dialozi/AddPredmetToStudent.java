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

import controller.PredmetController;
import izgledAplikacije.GlavniProzor;
import model.BazaPredmeta;
import model.Ocena;
import model.Predmet;
import model.Student;

public class AddPredmetToStudent extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Dimension dim;
	JTable chooseProf;
	JPanel profPan;
	JList<String> predList;
	ArrayList<String> list;
	ArrayList<Predmet> listaMogucihPredmeta;
	
	JPanel btnPan;
	JButton potvrdi;
	JButton odustani;
	
	public AddPredmetToStudent(Student s) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("addPredmet"));
		setSize(400,400);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		profPan = new JPanel(new BorderLayout());
		list = new ArrayList<String>();
		listaMogucihPredmeta = new ArrayList<Predmet>();
		
		int suma = 0;
		try {
			for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
			
				if(s.getPolozeniIspiti() != null) {
					for(Ocena o : s.getPolozeniIspiti()) {
						if(p.getSifra_predmeta().equals(o.getPredmet().getSifra_predmeta())) {
							suma += 1;
						}
					}
				}
				if(s.getNepolozeniIspiti() != null) {
					for(Predmet pr : s.getNepolozeniIspiti()) {
						if(p.getSifra_predmeta().equals(pr.getSifra_predmeta())) {
							suma += 1;
						}
					}
				}
			
				if(p.getGodina_izvodjenja() > s.getTrenutnaGodinaStudija()) {
					suma += 1;
				}
			
				if(suma == 0) {
					list.add(p.getSifra_predmeta() + " - " + p.getNaziv_predmeta());
					listaMogucihPredmeta.add(p);
				}
				suma = 0;
			}
		}catch(NullPointerException e) {}
			
		predList = new JList<String>(list.toArray(new String[list.size()]));
		JScrollPane pane1 = new JScrollPane();
		pane1.setViewportView(predList);
		predList.setLayoutOrientation(JList.VERTICAL);
		
		profPan.add(pane1);
		profPan.setBorder(BorderFactory.createEmptyBorder(30,10,10,10));
		
		btnPan = new JPanel();
		
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnDodaj"));
		
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));
		
		btnPan.add(potvrdi);
		btnPan.add(odustani);
		
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(predList.getSelectedIndex() != -1) {
					Predmet predmet = listaMogucihPredmeta.get(predList.getSelectedIndex());
					PredmetController.getInstance().dodajNepolozeni(predmet, s);
					dispose();
				}
			}
		});
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		add(profPan, BorderLayout.CENTER);
		add(btnPan, BorderLayout.SOUTH);
	}
	
}
