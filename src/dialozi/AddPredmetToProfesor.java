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

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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
	
	Predmet dodat = null;
	JList<String> predList;
	List<String> list;
	ArrayList<Predmet> listaMogucihPredmeta;
	
	
	public AddPredmetToProfesor(Profesor p){
		
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("addPredmet"));
		setSize(400,400);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setModal(true);
		
		dimension = new Dimension(150, 20);
		predmetPane = new JPanel(new BorderLayout());
		
		
		JLabel lab= new JLabel(GlavniProzor.getInstance().resourceBundle.getString("predmeti"));
		JPanel labsPanel = new JPanel (new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.insets = new Insets(5, 5, 5, 0);
        labsPanel.add(lab, c);
	
        
        
        
        list = new ArrayList<String>();
		listaMogucihPredmeta = new ArrayList<Predmet>();
		
		try {
			
			for (Predmet pr : BazaPredmeta.getInstance().getPredmeti()) {

				if (pr.getPredmetni_profesor() == null) {  
					list.add(pr.getSifra_predmeta() + " - " + pr.getNaziv_predmeta());
					listaMogucihPredmeta.add(pr);
				}
			}
			
			
		}catch(NullPointerException e) {}
		
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();

		for (Predmet predm : listaMogucihPredmeta) {
			String ispis = predm.getSifra_predmeta() + " - " + predm.getNaziv_predmeta();
			model.addElement(ispis);
		}

		JList<String> lista = new JList<String>(model);
		lista.setSelectedIndex(0);

		JScrollPane scrollPane = new JScrollPane(lista);
		scrollPane.setPreferredSize(scrollPane.getMaximumSize());
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		JPanel buttons = new JPanel();
		buttons.setBorder(BorderFactory.createEmptyBorder(0, 0, 15, 0));
		BoxLayout box = new BoxLayout(buttons, BoxLayout.X_AXIS);
		buttons.setLayout(box);

		JButton potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		JButton odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));


		buttons.add(Box.createHorizontalGlue());
		buttons.add(potvrdi);
		buttons.add(Box.createHorizontalStrut(10));
		buttons.add(odustani);
		

		
		//predList = new JList<String>(list.toArray(new String[list.size()]));
		//JScrollPane pane1 = new JScrollPane();
		//pane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		//pane1.setViewportView(lista);
		//lista.setLayoutOrientation(JList.VERTICAL);
		
		predmetPane.add(scrollPane);
        

		btnPan = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));
		btnPan.add(potvrdi);
		btnPan.add(odustani);
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int izabrani = lista.getSelectedIndex();

				dodat = new Predmet(listaMogucihPredmeta.get(izabrani));

				
				
				if (dodat.getPredmetni_profesor() != null) {

					
						ProfesorController.getInstance().izbrisiPredmetProfesoru(dodat.getPredmetni_profesor(), dodat);
						ProfesorController.getInstance().dodajPredmet(p, dodat);
						BazaPredmeta.getInstance().findById(dodat.getSifra_predmeta()).setPredmeni_profesor(p);
						
						dispose();

					
				} else {

					ProfesorController.getInstance().dodajPredmet(p, dodat);
					BazaPredmeta.getInstance().findById(dodat.getSifra_predmeta()).setPredmeni_profesor(p);
					
					dispose();
				}
				
				
				
				
				
				
				
				
				
				
				/*
				
				
				
				//Predmet predmet = listaMogucihPredmeta.get(predList.getSelectedIndex());
				Profesor stariProf = dodat.getPredmetni_profesor();
				System.out.println(stariProf);
				if(stariProf!=null) {
					ProfesorController.getInstance().izbrisiPredmetProfesoru(stariProf, dodat);
					PredmetController.getInstance().ukloniProfesoraPredmetu(dodat.getPredmetni_profesor(), dodat);
					
				}
				
				//ProfesorController.getInstance().izbrisiPredmetProfesoru(dodat.getPredmetni_profesor(),dodat);
				
				//PredmetController.getInstance().ukloniProfesoraPredmetu(dodat.getPredmetni_profesor(), dodat);
				PredmetController.getInstance().dodajProfesoraPredmetu(p, dodat);
				
				ProfesorController.getInstance().dodajPredmet(p, dodat);
				//System.out.println(p.getPredmetiProfesora().toString());
				System.out.println("posle brisanja kao:\n");
				System.out.println(dodat.getPredmetni_profesor());
				
				System.out.println("Predmeti novo profesora:\n");
				System.out.println(p.getPredmetiProfesora().toString());

				dispose();
				
				
				+*/
				
				
				//if(predList.getSelectedIndex() != -1) {
					
					/*Predmet predmet = listaMogucihPredmeta.get(predList.getSelectedIndex());
					Profesor stariProf = predmet.getPredmetni_profesor();
					if(stariProf!=null) {
						ProfesorController.getInstance().izbrisiPredmetProfesoru(stariProf, predmet);
						
					}
					ProfesorController.getInstance().dodajPredmet(p, predmet);
					dispose();*/
					
					
					/*Predmet predmet = listaMogucihPredmeta.get(predList.getSelectedIndex());
					Profesor stariProf = predmet.getPredmetni_profesor();
					if(stariProf!=null) {
						Object[] izbor = {"DA", "NE"};
						Object defaultChoice = izbor[0];
						
						int a = JOptionPane.showOptionDialog(pane1, "Da li zelite da zamijenite postojeceg profesora", "Dodavanje predmeta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, izbor, defaultChoice);
						stariProf.getPredmetiProfesora().remove(predmet);
					
					if(a == JOptionPane.YES_OPTION) {
						stariProf.getPredmetiProfesora().remove(predmet);
						predmet.setPredmeni_profesor(p);
						ProfesorController.getInstance().dodajPredmet(p, predmet);
						dispose();
					}
					}
					else {
						predmet.setPredmeni_profesor(p);
						ProfesorController.getInstance().dodajPredmet(p, predmet);
						dispose();
					}
					*/
				//}
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
