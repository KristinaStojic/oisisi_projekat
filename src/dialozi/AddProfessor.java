package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfesorController;
import controller.StudentiController;
import model.Profesor;
import model.Student;
import model.Student.Status;

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
	
	protected JPanel panTitula;
	protected JLabel labTitula;
	protected JTextField txtTitula;
	
	protected JPanel panZvanje;
	protected JLabel labZvanje;
	protected JTextField txtZvanje;
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	public AddProfessor() {
		setTitle("Dodavanje profesora");
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
		txtIme.setPreferredSize(dimension);
		panIme.add(labIme);
		panIme.add(txtIme);
		panCen.add(panIme);
		
		
		panPrz = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labPrz = new JLabel("Prezime*");
		labPrz.setPreferredSize(dimension);
		txtPrz = new JTextField();
		txtPrz.setPreferredSize(dimension);
		panPrz.add(labPrz);
		panPrz.add(txtPrz);
		panCen.add(panPrz);

		panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labDatum = new JLabel("Datum rođenja*");
		labDatum.setPreferredSize(dimension);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dimension);
		panDatum.add(labDatum);
		panDatum.add(txtDatum);
		panCen.add(panDatum);
		
		
		
		panAdresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdresa = new JLabel("Adresa stanovanja*");
		labAdresa.setPreferredSize(dimension);
		txtAdresa = new JTextField();
		txtAdresa.setPreferredSize(dimension);
		panAdresa.add(labAdresa);
		panAdresa.add(txtAdresa);
		panCen.add(panAdresa);
		
		
		panTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTel = new JLabel("Kontakt telefon*");
		labTel.setPreferredSize(dimension);
		txtTel = new JTextField();
		txtTel.setPreferredSize(dimension);
		panTel.add(labTel);
		panTel.add(txtTel);
		panCen.add(panTel);
		
		
		panEmail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labEmail = new JLabel("Email adresa*");
		labEmail.setPreferredSize(dimension);
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(dimension);
		panEmail.add(labEmail);
		panEmail.add(txtEmail);
		panCen.add(panEmail);
		
		
		
		panAdresaKanc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdresaKanc = new JLabel("Adresa kancelarije*");
		labAdresaKanc.setPreferredSize(dimension);
		txtAdresaKanc = new JTextField();
		txtAdresaKanc.setPreferredSize(dimension);
		panAdresaKanc.add(labAdresaKanc);
		panAdresaKanc.add(txtAdresaKanc);
		panCen.add(panAdresaKanc);
		
		
		
		panBrLicne = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBrLicne = new JLabel("Broj lične karte*");
		labBrLicne.setPreferredSize(dimension);
		txtBrLicne = new JTextField();
		txtBrLicne.setPreferredSize(dimension);
		panBrLicne.add(labBrLicne);
		panBrLicne.add(txtBrLicne);
		panCen.add(panBrLicne);
		
		
		panTitula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTitula = new JLabel("Titula*");
		labTitula.setPreferredSize(dimension);
		txtTitula = new JTextField();
		txtTitula.setPreferredSize(dimension);
		panTitula.add(labTitula);
		panTitula.add(txtTitula);
		panCen.add(panTitula);
		
		
		
		panZvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labZvanje = new JLabel("Zvanje*");
		labZvanje.setPreferredSize(dimension);
		txtZvanje = new JTextField();
		txtZvanje.setPreferredSize(dimension);
		panZvanje.add(labZvanje);
		panZvanje.add(txtZvanje);
		panCen.add(panZvanje);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			Profesor profesor = collectData();
			ProfesorController.getInstance().dodajProfesora(profesor);
			
			dispose();
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
		 String titula = txtTitula.getText();
		 String zvanje = txtZvanje.getText();
		 
		 
		Profesor prof = new Profesor(prezime, ime, datum_rodjenja, adresa_stanovanja, kontakt_telefon,
			 email_adresa, adresa_kancelarije, broj_licne_karte, titula, zvanje, null);
		return prof;
	}
}
