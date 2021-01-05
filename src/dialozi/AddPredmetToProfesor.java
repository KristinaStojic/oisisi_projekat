package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import controller.ProfesorController;
import izgledAplikacije.GlavniProzor;
import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;

public class AddPredmetToProfesor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Dimension dimension;
	
	JPanel btnPan;
	JButton potvrdi;
	JButton odustani;
	
	JScrollBar scrol;
	JPanel predmetPane;
	
	
	JList<String> predList;
	List<String> list;
	ArrayList<Predmet> listaMogucihPredmeta;
	
	
	public AddPredmetToProfesor(Profesor p){
		
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("addPredmet"));
		setSize(400,400);
		setLocationRelativeTo(null);
		setModal(true);
		
		dimension = new Dimension(150, 20);
		predmetPane = new JPanel(new BorderLayout());
		
		//ISPRAVI OVO, STAVI DA PREDMETI STOJI SKROZ LIJEVO
		JLabel lab= new JLabel("Predmeti:");
		JPanel labsPanel = new JPanel (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(5, 5, 5, 0);
        labsPanel.add(lab, c);
	
        
        
        
        list = new ArrayList<String>();
		listaMogucihPredmeta = new ArrayList<Predmet>();
		boolean imaPredmet = false;
		try {
			
			for(Predmet p1 : BazaPredmeta.getInstance().getPredmeti()) {
				
	
				if(p.getPredmetiProfesora() != null) { //ako profesor nema nijedan predmet na kom predaje
				for(int i=0;i<p.getPredmetiProfesora().size();i++)
			    {
					if(p1.getSifra_predmeta().equals(p.getPredmetiProfesora().get(i).getSifra_predmeta())) {
						imaPredmet = true;
					}
				}
				}
				
				if(imaPredmet == false) {
					
					list.add(p1.getSifra_predmeta() + " - " + p1.getNaziv_predmeta());
					listaMogucihPredmeta.add(p1);
				}
				imaPredmet = false;
				
			}
			
		}catch(NullPointerException e) {}
		
		predList = new JList<String>(list.toArray(new String[list.size()]));
		JScrollPane pane1 = new JScrollPane();
		pane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		pane1.setViewportView(predList);
		predList.setLayoutOrientation(JList.VERTICAL);
		
		predmetPane.add(pane1);
        

		btnPan = new JPanel();
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		btnPan.add(potvrdi);
		btnPan.add(odustani);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(predList.getSelectedIndex() != -1) {
					Predmet predmet = listaMogucihPredmeta.get(predList.getSelectedIndex());
					predmet.setPredmeni_profesor(p);
					ProfesorController.getInstance().dodajPredmet(p, predmet);
					predmet.setPredmeni_profesor(p);
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
		
		add(labsPanel,BorderLayout.NORTH);
		add(predmetPane, BorderLayout.CENTER);
		add(btnPan, BorderLayout.SOUTH);
		
	}
}
