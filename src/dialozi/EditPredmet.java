package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import izgledAplikacije.GlavniProzor;
import listeneri.MyFocusListener7;
import listeneri.MyFocusListener8;
import model.BazaPredmeta;
import model.Predmet;
import model.Predmet.Semestar;

public class EditPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected Dimension dim;
	protected JPanel panCen;
	protected BoxLayout boxcen;
	
	String sifra_predmeta;
    String naziv_predmeta;
    int godina_izvodjenja;
	int broj_ESPB;
	Semestar semestar;
	
	protected JPanel panSifra;
	protected JLabel labSifra;
	protected JTextField txtSifra;
	
	protected JPanel panProf;
	protected JLabel labProf;
	protected static JTextField txtProf;
	protected JButton plus;
	protected JButton minus;
	
	protected JPanel panNaziv;
	protected JLabel labNaziv;
	protected JTextField txtNaziv;
	
	protected JPanel panSemestar;
	protected JLabel labSemestar;
	protected JTextField txtSemestar;
	
	protected JPanel panGodina;
	protected JLabel labGodina;
	protected JTextField txtGodina;
	
	protected JPanel panESPB;
	protected JLabel labESPB;
	protected JTextField txtESPB;
	
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	ChooseProffesor chooseProffesor;
	
	protected JPanel panSem;
	protected JLabel labSem;
	protected JComboBox<String> sem;
	protected DefaultComboBoxModel<String> semModel;
	

	public EditPredmet(Predmet p) {
		add(editPredmet(p));
	}
	
	private JPanel editPredmet(Predmet p) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("editPredmet"));
		setSize(450,500);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSifra = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newSifra"));
		labSifra.setPreferredSize(dim);
		txtSifra = new JTextField(p.getSifra_predmeta());
		txtSifra.setPreferredSize(dim);
		panSifra.add(labSifra);
		panSifra.add(txtSifra);
		panCen.add(panSifra);
		
		panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNaziv = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newNaziv"));
		labNaziv.setPreferredSize(dim);
		txtNaziv = new JTextField(p.getNaziv_predmeta());
		txtNaziv.setPreferredSize(dim);
		panNaziv.add(labNaziv);
		panNaziv.add(txtNaziv);
		panCen.add(panNaziv);
		
		panGodina = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labGodina = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newGodina"));
		labGodina.setPreferredSize(dim);
		txtGodina = new JTextField(String.valueOf(p.getGodina_izvodjenja()));
		txtGodina.setPreferredSize(dim);
		txtGodina.addFocusListener(new MyFocusListener7());
		panGodina.add(labGodina);
		panGodina.add(txtGodina);
		panCen.add(panGodina);
		
		panESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labESPB = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newESPB"));
		labESPB.setPreferredSize(dim);
		txtESPB = new JTextField(String.valueOf(p.getBroj_ESPB()));
		txtESPB.setPreferredSize(dim);
		txtESPB.addFocusListener(new MyFocusListener8());
		panESPB.add(labESPB);
		panESPB.add(txtESPB);
		panCen.add(panESPB);
		
		panSem = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSem = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newSemestar"));
		labSem.setPreferredSize(dim);
		sem = new JComboBox<String>();
		semModel = new DefaultComboBoxModel<String>();
		semModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxZimski"));
		semModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxLetnji"));
		sem.setModel(semModel);
		int semestar;
		if(p.getSemestar() == Semestar.Letnji) {
			semestar = 1;
		}else {
			semestar = 0;
		}
		sem.setSelectedIndex(semestar);
		sem.setPreferredSize(dim);
		panSem.add(labSem);
		panSem.add(sem);
		panCen.add(panSem);
		
		panProf = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labProf = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("editProfesor"));
		labProf.setPreferredSize(dim);
		if(p.getPredmetni_profesor() == null) {
			txtProf = new JTextField("");
			
		}else {
			txtProf = new JTextField(p.getPredmetni_profesor().getIme() + " " + p.getPredmetni_profesor().getPrezime()); 
		}
		txtProf.setPreferredSize(new Dimension(100, 20));
		txtProf.setEditable(false);
		plus = new JButton("+");
		minus = new JButton("-");
		panProf.add(labProf);
		panProf.add(txtProf);
		panProf.add(plus);
		panProf.add(minus);
		panCen.add(panProf);
		
		if(txtProf.getText().trim().isEmpty()) {
			plus.setEnabled(true);
			minus.setEnabled(false);
		}else {
			plus.setEnabled(false);
			minus.setEnabled(true);
		}
		
			plus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					chooseProffesor = new ChooseProffesor(p, plus, minus);
					chooseProffesor.setVisible(true);
						
				}
			});
				
			 minus.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					DeleteProfesorFromPredmet dp = new DeleteProfesorFromPredmet(p.getPredmetni_profesor(),p,plus,minus);
					dp.setVisible(true);
					if(p.getPredmetni_profesor() == null) {
						txtProf.setText("");
							
					}
				}
			});
				
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Predmet predmet = collectData();
				predmet.setId(p.getId());
				predmet.setPredmeni_profesor(p.getPredmetni_profesor());
				PredmetController.getInstance().izmeniPredmet(predmet);
				dispose();

			}
		});
		

		KeyListener provjera = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				boolean sve_uneseno = false;
				if(txtSifra.getText().trim().isEmpty()|| txtNaziv.getText().trim().isEmpty() 
						|| txtGodina.getText().trim().isEmpty()	|| txtESPB.getText().trim().isEmpty()) {
					sve_uneseno = false;
				}else {
					sve_uneseno = true;
				}
				boolean ispravan_unos = false;
				Pattern godina = Pattern.compile("[1-6]");
				Pattern espb = Pattern.compile("[1-9][0-9]?");
				if(godina.matcher(txtGodina.getText()).matches() && espb.matcher(txtESPB.getText()).matches()){
					ispravan_unos = true;
				}
				boolean postoji = false;
				for(int i = 0; i < BazaPredmeta.getInstance().getAll().size(); i++) {
					if((txtSifra.getText().equals(BazaPredmeta.getInstance().getAll().get(i).getSifra_predmeta())
							&& p.getId() != BazaPredmeta.getInstance().getAll().get(i).getId())) {
						txtSifra.setToolTipText(GlavniProzor.getInstance().getResourceBundle().getString("postojiSifra"));
						//JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("postojiSifra"));
						postoji = true;
					}
				}
				if(ispravan_unos && sve_uneseno && !postoji) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		txtESPB.addKeyListener(provjera);
		txtGodina.addKeyListener(provjera);
		txtNaziv.addKeyListener(provjera);
		//txtProf.addKeyListener(provjera);
		txtSifra.addKeyListener(provjera);
		

		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));

		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		panBtn.add(potvrdi);
		panBtn.add(odustani);
		panCen.add(panBtn);
		
		
		return panCen;
	}
	
	
	
	public Predmet collectData() {		
		sifra_predmeta = txtSifra.getText();
	    naziv_predmeta = txtNaziv.getText();
		godina_izvodjenja = Integer.parseInt(txtGodina.getText());
		broj_ESPB = Integer.parseInt(txtESPB.getText());
		int id = sem.getSelectedIndex();
		if(id == 0) {
			semestar = Semestar.Zimski;
		}else {
			semestar = Semestar.Letnji;
		}	
		Predmet predmet = new Predmet(sifra_predmeta,naziv_predmeta,semestar,godina_izvodjenja,
				null, broj_ESPB, null, null);
		
		return predmet;
	}

	
}
