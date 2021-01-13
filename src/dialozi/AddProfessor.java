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

import controller.ProfesorController;
import izgledAplikacije.GlavniProzor;
import listeneri.MyFocusListener1;
import listeneri.MyFocusListener2;
import listeneri.MyFocusListener6;
import listeneri.MyKeyListener1;
import listeneri.MyKeyListener2;
import model.BazaProfesora;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class AddProfessor  extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Dimension dimension;
	protected JPanel panCen;
	protected BoxLayout boxcen;
	
	protected JPanel panPrz;
	protected JLabel labPrz;
	protected JTextField txtPrz;
	
	protected JPanel panIme;
	protected JLabel labIme;
	protected JTextField txtIme;
	
	protected JPanel panDatum;
	protected JLabel labDatum;
	protected JTextField txtDatum;
	
	protected JPanel panAdresa;
	protected JLabel labAdresa;
	protected JTextField txtAdresa;
	
	protected JPanel panTel;
	protected JLabel labTel;
	protected JTextField txtTel;
	
	protected JPanel panEmail;
	protected JLabel labEmail;
	protected JTextField txtEmail;
	
	protected JPanel panAdresaKanc;
	protected JLabel labAdresaKanc;
	protected JTextField txtAdresaKanc;
	
	protected JPanel panBrLicne;
	protected JLabel labBrLicne;
	protected JTextField txtBrLicne;
	
	protected JPanel panTgs;
	protected JLabel labTgs;
	protected JComboBox<String> god;
	protected DefaultComboBoxModel<String> godModel;
	
	protected JPanel panTitula;
	protected JLabel labTitula;
	protected JComboBox<String> tit;
	protected DefaultComboBoxModel<String> titModel;
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	public AddProfessor() {
		//setTitle("Dodavanje profesora");
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("addProfesor"));
		setSize(450,600);
		setLocationRelativeTo(GlavniProzor.getInstance());
		setModal(true);
		
		dimension = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labIme = new JLabel("Ime*");
		labIme = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newIme"));
		labIme.setPreferredSize(dimension);
		txtIme = new JTextField();
		txtIme.setPreferredSize(dimension);
		txtIme.addKeyListener(new MyKeyListener1());
		panIme.add(labIme);
		panIme.add(txtIme);
		panCen.add(panIme);
		
		
		panPrz = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labPrz = new JLabel("Prezime*");
		labPrz = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newPrezime"));
		labPrz.setPreferredSize(dimension);
		txtPrz = new JTextField();
		txtPrz.setPreferredSize(dimension);
		txtPrz.addKeyListener(new MyKeyListener1());
		panPrz.add(labPrz);
		panPrz.add(txtPrz);
		panCen.add(panPrz);

		panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labDatum = new JLabel("Datum rođenja*");
		labDatum = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newDatumRodjenja"));
		labDatum.setPreferredSize(dimension);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dimension);
		txtDatum.addFocusListener(new MyFocusListener1());
		panDatum.add(labDatum);
		panDatum.add(txtDatum);
		panCen.add(panDatum);
		
		
		
		panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labAdresa = new JLabel("Adresa stanovanja*");
		labAdresa = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newAdresaStanovanja"));
		labAdresa.setPreferredSize(dimension);
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dimension);
		//txtAdresa.addFocusListener(new MyFocusListener5());
		panAdresa.add(labAdresa);
		panAdresa.add(txtAdresa);
		panCen.add(panAdresa);
		
		
		panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labTel = new JLabel("Kontakt telefon*");
		labTel = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newBrojTelefona"));
		labTel.setPreferredSize(dimension);
		txtTel = new JTextField();
		txtTel.setPreferredSize(dimension);
		txtTel.addFocusListener(new MyFocusListener2());
		panTel.add(labTel);
		panTel.add(txtTel);
		panCen.add(panTel);
		
		
		panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labEmail = new JLabel("Email adresa*");
		labEmail = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newEmail"));
		labEmail.setPreferredSize(dimension);
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(dimension);
		txtEmail.addFocusListener(new MyFocusListener6());
		panEmail.add(labEmail);
		panEmail.add(txtEmail);
		panCen.add(panEmail);
		
		
		
		panAdresaKanc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labAdresaKanc = new JLabel("Adresa kancelarije*");
		labAdresaKanc = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newAdresaKancelarije"));
		labAdresaKanc.setPreferredSize(dimension);
		txtAdresaKanc = new JTextField();
		txtAdresaKanc.setPreferredSize(dimension);
		//txtAdresaKanc.addFocusListener(new MyFocusListener5());
		panAdresaKanc.add(labAdresaKanc);
		panAdresaKanc.add(txtAdresaKanc);
		panCen.add(panAdresaKanc);
		
		
		
		panBrLicne = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labBrLicne = new JLabel("Broj lične karte*");
		labBrLicne = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newBrojLicne"));
		labBrLicne.setPreferredSize(dimension);
		txtBrLicne = new JTextField();
		txtBrLicne.setPreferredSize(dimension);
		txtBrLicne.addKeyListener(new MyKeyListener2());
		panBrLicne.add(labBrLicne);
		panBrLicne.add(txtBrLicne);
		panCen.add(panBrLicne);
		
		
		panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labTitula = new JLabel("Titula*");
		labTitula = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newTitula"));
		labTitula.setPreferredSize(dimension);
		tit = new JComboBox<String>();
		titModel = new DefaultComboBoxModel<String>();
		/*titModel.addElement("BSc");
		titModel.addElement("MSc");
		titModel.addElement("mr");
		titModel.addElement("dr");
		titModel.addElement("prof");
		titModel.addElement("prof.dr");
		titModel.addElement("dipl.ing.");*/
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxBSc"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxMSc"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxMr"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDr"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxProf"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxProfDr"));
		titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDiplIng"));
		tit.setModel(titModel);
		tit.setSelectedIndex(0);
		tit.setPreferredSize(dimension);
		//god.setEditable(true);
		panTitula.add(labTitula);
		panTitula.add(tit);
		panCen.add(panTitula);
		
		
		
		panTgs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		//labTgs = new JLabel("Zvanje*");
		labTgs = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newZvanje"));

		labTgs.setPreferredSize(dimension);
		god = new JComboBox<String>();
		godModel = new DefaultComboBoxModel<String>();
		/*godModel.addElement("Saradnik u nastavi");
		godModel.addElement("Asistent");
		godModel.addElement("Asistent sa doktoratom");
		godModel.addElement("Docent");
		godModel.addElement("Vanredni profesor");
		godModel.addElement("Redovni profesor");
		godModel.addElement("Profesor emeritus");*/
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxSaradnik"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxAsistent"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxAsistentSaDoktoratom"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDocent"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxVanredni"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxRedovniProfesor"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxEmeritus"));
		god.setModel(godModel);
		god.setSelectedIndex(0);
		god.setPreferredSize(dimension);
		//god.setEditable(true);
		panTgs.add(labTgs);
		panTgs.add(god);
		panCen.add(panTgs);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		potvrdi.setEnabled(false);
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//	try {
				
				//	if(txtIme.getText().trim().isEmpty() || txtPrz.getText().trim().isEmpty() 
				//			|| txtDatum.getText().trim().isEmpty() || txtAdresa.getText().trim().isEmpty()
				//				|| txtTel.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
				//					|| txtAdresaKanc.getText().trim().isEmpty() || txtBrLicne.getText().trim().isEmpty()) {
				//		JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("svaPolja"));

				//	}else {
					//	Profesor profesor = collectData();
						
				//		boolean postoji = false;
					//	for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
					//		if((profesor.getBrojLicneKarte().equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte()))) {
					//			//JOptionPane.showMessageDialog(null, "Uneseni broj lične karte već postoji!");
					//			JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("postojiLicna"));

					//			postoji = true;
					//		}}
					//		if(!postoji) {
					/*			Pattern datum = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
								Pattern adresa = Pattern.compile("[A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*[0-9]*[,_ ][A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*");
								Pattern telefon = Pattern.compile("[0-9]{3}[/][0-9]{6,7}");
								Pattern mejl = Pattern.compile("[a-z|0-9|_|.]+[a-z|0-9][@]([a-z]+[.][a-z]+)+");
								
								boolean ispravan_unos = false;
								if(datum.matcher(profesor.getDatumRodjenja()).matches() && adresa.matcher(profesor.getAdresaStanovanja()).matches()
										&& telefon.matcher(profesor.getKontaktTelefon()).matches() && mejl.matcher(profesor.getEmailAdresa()).matches()
										&& adresa.matcher(profesor.getAdresaKancelarije()).matches()) {
									ispravan_unos = true;
								}
								if(!ispravan_unos) {
									//.showMessageDialog(null, "Neispravan unos!");
									JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("neispravanUnos"));

								}
								if(!postoji && ispravan_unos) {
									ProfesorController.getInstance().dodajProfesora(profesor);
									dispose();
								}
							}
						
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}*/
				
				Profesor profesor;
				profesor = collectData();
				ProfesorController.getInstance().dodajProfesora(profesor);
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
				if(txtIme.getText().trim().isEmpty() || txtPrz.getText().trim().isEmpty() 
									|| txtTel.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
											|| txtAdresaKanc.getText().trim().isEmpty() || txtBrLicne.getText().trim().isEmpty() || txtDatum.getText().trim().isEmpty()) {
					sve_uneseno = false;
				}else {
					sve_uneseno = true;
				}
				Pattern datum = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
				//Pattern adresa = Pattern.compile("[A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*[0-9]*[,_ ][A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*");
				Pattern telefon = Pattern.compile("[0-9]{3}[/][0-9]{6,7}");
				Pattern mejl = Pattern.compile("[a-z|0-9|_|.]+[a-z|0-9][@]([a-z]+[.][a-z]+)+");
				
				boolean ispravan_unos = false;
				if(datum.matcher(txtDatum.getText()).matches() && (txtAdresa.getText() != "")
						&& telefon.matcher(txtTel.getText()).matches() && mejl.matcher(txtEmail.getText()).matches()
						&& (txtAdresaKanc.getText()!= "")) {
					ispravan_unos = true;
				} {
					ispravan_unos = true;
				}
				boolean postoji = false;
				
				if(BazaProfesora.getInstance().getProfesori().isEmpty()) {
					postoji = false;
				}else {
				for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
						if((txtBrLicne.getText().equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte()))) {
							postoji = true;
							txtBrLicne.setToolTipText( GlavniProzor.getInstance().resourceBundle.getString("postojiLicna"));
							
						}else {
								txtBrLicne.setToolTipText(null);

							}
						
						
						
				if(ispravan_unos && sve_uneseno && !postoji) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
			}
				
				if(ispravan_unos && sve_uneseno && !postoji) {
					potvrdi.setEnabled(true);
				}else {
					potvrdi.setEnabled(false);
				}
			}
			@Override
			public void keyPressed(KeyEvent e) {}};
				
			
			txtIme.addKeyListener(provjera);
			txtPrz.addKeyListener(provjera);
			txtAdresa.addKeyListener(provjera);
			txtAdresaKanc.addKeyListener(provjera);
			txtBrLicne.addKeyListener(provjera);
			txtDatum.addKeyListener(provjera);
			txtEmail.addKeyListener(provjera);
			txtTel.addKeyListener(provjera);
			
		
		
		
		
		
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnOdustani"));

		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
		
		panBtn.add(potvrdi);
		panBtn.add(odustani);
		panCen.add(panBtn);
		
		add(panCen, BorderLayout.CENTER);
		
		
		
		
		
	}
	
	
	
	public Profesor collectData() {		
		 String prezime = txtPrz.getText();
		 String ime = txtIme.getText();
		 String datum_rodjenja = txtDatum.getText();
		 String adresa_stanovanja = txtAdresa.getText();
		 String kontakt_telefon = txtTel.getText();
		 String email_adresa = txtEmail.getText();
		 String adresa_kancelarije = txtAdresaKanc.getText();
		 String broj_licne_karte = txtBrLicne.getText();
		 Zvanje zvanje = null;
		 Titula titula = null;
		 int id = god.getSelectedIndex();
			if(id == 0) {
				zvanje = Zvanje.saradnik_u_nastavi;
			}
			else if(id == 1) {
				zvanje = Zvanje.asistent;
			}
			else if(id == 2) {
				zvanje = Zvanje.asistent_sa_doktoratom;
			}
			else if(id == 3) {
				zvanje = Zvanje.docent;		
			}
			else if(id == 4) {
				zvanje = Zvanje.vanredni_profesor;
			}
			else if(id == 5) {
				zvanje = Zvanje.redovni_profesor;
			}
			else if(id == 6) {
				zvanje = Zvanje.profesor_emeritus;
			}
			
			int t = tit.getSelectedIndex();
			if(t == 0) {
				titula = Titula.BSc;
			}
			else if(t == 1) {
				titula = Titula.MSc;
			}
			else if(t == 2) {
				titula = Titula.mr;
			}
			else if(t == 3) {
				titula = Titula.dr;
			}
			else if(t == 4) {
				titula = Titula.prof;
			}
			else if(t == 5) {
				titula = Titula.prof_dr;
			}
			else if(t == 6) {
				titula = Titula.dipl_ing;
			}
		 
		 
		Profesor prof = new Profesor(prezime, ime, datum_rodjenja, adresa_stanovanja, kontakt_telefon,
			 email_adresa, adresa_kancelarije, broj_licne_karte, titula, zvanje, null);
		return prof;
	}
}
