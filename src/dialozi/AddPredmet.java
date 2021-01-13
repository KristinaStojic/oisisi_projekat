package dialozi;

import java.awt.BorderLayout;
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

public class AddPredmet  extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Dimension dim;
	protected JPanel panCen;
	protected BoxLayout boxcen;
	
	protected JPanel panSifra;
	protected JLabel labSifra;
	protected JTextField txtSifra;
	
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
	
	protected JPanel panSem;
	protected JLabel labSem;
	protected JComboBox<String> sem;
	protected DefaultComboBoxModel<String> semModel;
	
	public AddPredmet() {
		
		
		setTitle(GlavniProzor.getInstance().getResourceBundle().getString("addPredmet"));
		setSize(450,600);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSifra = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("newSifra"));
		labSifra.setPreferredSize(dim);
		txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		panSifra.add(labSifra);
		panSifra.add(txtSifra);
		panCen.add(panSifra);
		
		panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNaziv = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("newNaziv"));
		labNaziv.setPreferredSize(dim);
		txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		panNaziv.add(labNaziv);
		panNaziv.add(txtNaziv);
		panCen.add(panNaziv);
		
		panGodina = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labGodina = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("newGodina"));
		labGodina.setPreferredSize(dim);
		txtGodina = new JTextField();
		txtGodina.setPreferredSize(dim);
		txtGodina.addFocusListener(new MyFocusListener7());
		panGodina.add(labGodina);
		panGodina.add(txtGodina);
		panCen.add(panGodina);
		
		panESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labESPB = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("newESPB"));
		labESPB.setPreferredSize(dim);
		txtESPB = new JTextField();
		txtESPB.setPreferredSize(dim);
		txtESPB.addFocusListener(new MyFocusListener8());
		panESPB.add(labESPB);
		panESPB.add(txtESPB);
		panCen.add(panESPB);
		
		panSem = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSem = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("newSemestar"));
		labSem.setPreferredSize(dim);
		sem = new JComboBox<String>();
		semModel = new DefaultComboBoxModel<String>();
		semModel.addElement(GlavniProzor.getInstance().getResourceBundle().getString("newBoxZimski"));
		semModel.addElement(GlavniProzor.getInstance().getResourceBundle().getString("newBoxLetnji"));
		sem.setModel(semModel);
		sem.setSelectedIndex(0);
		sem.setPreferredSize(dim);
		panSem.add(labSem);
		panSem.add(sem);
		panCen.add(panSem);
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("btnPotvrdi"));
		potvrdi.setEnabled(false);
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {		
					Predmet predmet = collectData();
					PredmetController.getInstance().dodajPredmet(predmet);
					dispose();
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		KeyListener provjera = new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
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
					boolean postoji = false;
					for(int i = 0; i < BazaPredmeta.getInstance().getPredmeti().size(); i++) {
						if((txtSifra.getText().equals(BazaPredmeta.getInstance().getPredmeti().get(i).getSifra_predmeta()))) {
							//JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().getResourceBundle().getString("postojiSifra"));
							postoji = true;
						}
					}
					boolean ispravan_unos = false;
					Pattern godina = Pattern.compile("[1-6]");
					Pattern espb = Pattern.compile("[1-9][0-9]?");
					if(godina.matcher(txtGodina.getText()).matches() && espb.matcher(txtESPB.getText()).matches()){
						ispravan_unos = true;
					}
					if(!postoji && sve_uneseno && ispravan_unos) {
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
		txtSifra.addKeyListener(provjera);
		
		odustani = new JButton(GlavniProzor.getInstance().getResourceBundle().getString("btnOdustani"));
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panBtn.add(potvrdi);
		panBtn.add(odustani);
		panCen.add(panBtn);
		
		
		add(panCen, BorderLayout.CENTER);
	}
	
	
	
	public Predmet collectData() {		
		String sifra_predmeta = (txtSifra.getText()).toUpperCase();
	    String naziv_predmeta = txtNaziv.getText();
		int godina_izvodjenja = Integer.parseInt(txtGodina.getText());
		int broj_ESPB = Integer.parseInt(txtESPB.getText());
		Semestar semestar;
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
