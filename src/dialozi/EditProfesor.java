package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorController;
import listeneri.MyFocusListener1;
import listeneri.MyFocusListener2;
import listeneri.MyFocusListener5;
import listeneri.MyFocusListener6;
import listeneri.MyKeyListener1;
import listeneri.MyKeyListener2;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class EditProfesor extends JDialog {

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
	
	 public EditProfesor(Profesor profesor) {
		
		 
		setTitle("Izmena profesora");
		setSize(450,600);
		setLocationRelativeTo(null);
		setModal(true);
		
		dimension = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labIme = new JLabel("Ime*");
		labIme.setPreferredSize(dimension);
		txtIme = new JTextField();
		txtIme.setText(profesor.getIme());
		txtIme.setPreferredSize(dimension);
		txtIme.addKeyListener(new MyKeyListener1());
		panIme.add(labIme);
		panIme.add(txtIme);
		panCen.add(panIme);
		
		
		panPrz = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labPrz = new JLabel("Prezime*");
		labPrz.setPreferredSize(dimension);
		txtPrz = new JTextField();
		txtPrz.setPreferredSize(dimension);
		txtPrz.setText(profesor.getPrezime());
		txtPrz.addKeyListener(new MyKeyListener1());
		panPrz.add(labPrz);
		panPrz.add(txtPrz);
		panCen.add(panPrz);

		panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labDatum = new JLabel("Datum rođenja*");
		labDatum.setPreferredSize(dimension);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dimension);
		txtDatum.setText(profesor.getDatumRodjenja());
		txtDatum.addFocusListener(new MyFocusListener1());
		panDatum.add(labDatum);
		panDatum.add(txtDatum);
		panCen.add(panDatum);
		
		
		
		panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdresa = new JLabel("Adresa stanovanja*");
		labAdresa.setPreferredSize(dimension);
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dimension);
		txtAdresa.setText(profesor.getAdresaStanovanja());
		txtAdresa.addFocusListener(new MyFocusListener5());
		panAdresa.add(labAdresa);
		panAdresa.add(txtAdresa);
		panCen.add(panAdresa);
		
		
		panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTel = new JLabel("Kontakt telefon*");
		labTel.setPreferredSize(dimension);
		txtTel = new JTextField();
		txtTel.setPreferredSize(dimension);
		txtTel.setText(profesor.getKontaktTelefon());
		txtTel.addFocusListener(new MyFocusListener2());
		panTel.add(labTel);
		panTel.add(txtTel);
		panCen.add(panTel);
		
		
		panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labEmail = new JLabel("Email adresa*");
		labEmail.setPreferredSize(dimension);
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(dimension);
		txtEmail.setText(profesor.getEmailAdresa());
		txtEmail.addFocusListener(new MyFocusListener6());
		panEmail.add(labEmail);
		panEmail.add(txtEmail);
		panCen.add(panEmail);
		
		
		
		panAdresaKanc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdresaKanc = new JLabel("Adresa kancelarije*");
		labAdresaKanc.setPreferredSize(dimension);
		txtAdresaKanc = new JTextField();
		txtAdresaKanc.setPreferredSize(dimension);
		txtAdresaKanc.setText(profesor.getAdresaKancelarije());
		txtAdresaKanc.addFocusListener(new MyFocusListener5());
		panAdresaKanc.add(labAdresaKanc);
		panAdresaKanc.add(txtAdresaKanc);
		panCen.add(panAdresaKanc);
		
		
		
		panBrLicne = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBrLicne = new JLabel("Broj lične karte*");
		labBrLicne.setPreferredSize(dimension);
		txtBrLicne = new JTextField();
		txtBrLicne.setPreferredSize(dimension);
		txtBrLicne.setText(profesor.getBrojLicneKarte());
		txtBrLicne.addKeyListener(new MyKeyListener2());
		panBrLicne.add(labBrLicne);
		panBrLicne.add(txtBrLicne);
		panCen.add(panBrLicne);
		
		
		panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTitula = new JLabel("Titula*");
		labTitula.setPreferredSize(dimension);
		tit = new JComboBox<String>();
		titModel = new DefaultComboBoxModel<String>();
		titModel.addElement("BSc");
		titModel.addElement("MSc");
		titModel.addElement(" mr");
		titModel.addElement("dr");
		titModel.addElement("prof");
		titModel.addElement("prof.dr");
		titModel.addElement("dipl.ing.");
		tit.setModel(titModel);
		//napravi da prikaze titulu profesora koji je oznacen
		//tit.setSelectedItem(profesor.getTitula());
		tit.setPreferredSize(dimension);
		panTitula.add(labTitula);
		panTitula.add(tit);
		panCen.add(panTitula);
		
		
		
		panTgs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTgs = new JLabel("Zvanje*");
		labTgs.setPreferredSize(dimension);
		god = new JComboBox<String>();
		godModel = new DefaultComboBoxModel<String>();
		godModel.addElement("Saradnik u nastavi");
		godModel.addElement("Asistent");
		godModel.addElement("Asistent sa doktoratom");
		godModel.addElement("Docent");
		godModel.addElement("Vanredni profesor");
		godModel.addElement("Redovni profesor");
		godModel.addElement("Profesor emeritus");
		god.setModel(godModel);
		god.getSelectedIndex();
		god.setPreferredSize(dimension);
		panTgs.add(labTgs);
		panTgs.add(god);
		panCen.add(panTgs);
		
		panBtn = new JPanel();
		potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					//uzmemo prosledjenog profesora
					Profesor profesor = collectData();
					if(txtIme.getText().trim().isEmpty() || txtPrz.getText().trim().isEmpty() 
							|| txtDatum.getText().trim().isEmpty() || txtAdresa.getText().trim().isEmpty()
								|| txtTel.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
									|| txtAdresaKanc.getText().trim().isEmpty() || txtBrLicne.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Morate unijeti sva polja!");
					}else {
						
						ProfesorController.getInstance().izmeniProfesora(profesor);
						//System.out.println(profesor);
						dispose();
					}
				}catch(Exception ex) {
					System.out.println("GRESKA");
					ex.printStackTrace();
				}
			}
		});
		
		odustani = new JButton("Odustani");
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
