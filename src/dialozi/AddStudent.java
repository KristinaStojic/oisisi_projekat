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

import controller.StudentiController;
import listeneri.MyFocusListener1;
import listeneri.MyFocusListener2;
import listeneri.MyFocusListener3;
import listeneri.MyFocusListener4;
import listeneri.MyKeyListener1;
import model.Student;
import model.Student.Status;

public class AddStudent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected Dimension dim;
	
	protected JPanel panCen;
	protected BoxLayout boxc;
	
	protected JPanel panIme;
	protected JLabel labIme;
	protected JTextField txtIme;
	
	protected JPanel panPrz;
	protected JLabel labPrz;
	protected JTextField txtPrz;
	
	protected JPanel panDat;
	protected JLabel labDat;
	protected JTextField txtDat;
	
	protected JPanel panAdr;
	protected JLabel labAdr;
	protected JTextField txtAdr;
	
	protected JPanel panBrt;
	protected JLabel labBrt;
	protected JTextField txtBrt;
	
	protected JPanel panMail;
	protected JLabel labMail;
	protected JTextField txtMail;
	
	protected JPanel panBri;
	protected JLabel labBri;
	protected JTextField txtBri;
	
	protected JPanel panGodu;
	protected JLabel labGodu;
	protected JTextField txtGodu;
	
	protected JPanel panTgs;
	protected JLabel labTgs;
	protected JComboBox<String> god;
	protected DefaultComboBoxModel<String> godModel;
	
	protected JPanel panNfs;
	protected JLabel labNfs;
	protected JComboBox<String> bs;
	protected DefaultComboBoxModel<String> bsModel;
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	public AddStudent() {
		setTitle("Dodavanje studenta");
		setSize(450,600);
		setLocationRelativeTo(null);
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxc = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxc);
		
		panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labIme = new JLabel("Ime*");
		labIme.setPreferredSize(dim);
		txtIme = new JTextField();
		txtIme.setPreferredSize(dim);
		txtIme.addKeyListener(new MyKeyListener1());
		panIme.add(labIme);
		panIme.add(txtIme);
		panCen.add(panIme);
		
		panPrz = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labPrz = new JLabel("Prezime*");
		labPrz.setPreferredSize(dim);
		txtPrz = new JTextField();
		txtPrz.setPreferredSize(dim);
		txtPrz.addKeyListener(new MyKeyListener1());
		panPrz.add(labPrz);
		panPrz.add(txtPrz);
		panCen.add(panPrz);
		
		panDat = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labDat = new JLabel("Datum rođenja*");
		labDat.setPreferredSize(dim);
		txtDat = new JTextField();
		txtDat.setPreferredSize(dim);
		txtDat.addFocusListener(new MyFocusListener1());
		panDat.add(labDat);
		panDat.add(txtDat);
		panCen.add(panDat);
		
		panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdr = new JLabel("Adresa stanovanja*");
		labAdr.setPreferredSize(dim);
		txtAdr = new JTextField();
		txtAdr.setPreferredSize(dim);
		panAdr.add(labAdr);
		panAdr.add(txtAdr);
		panCen.add(panAdr);
		
		panBrt = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBrt = new JLabel("Broj telefona*");
		labBrt.setPreferredSize(dim);
		txtBrt = new JTextField();
		txtBrt.setPreferredSize(dim);
		txtBrt.addFocusListener(new MyFocusListener2());
		panBrt.add(labBrt);
		panBrt.add(txtBrt);
		panCen.add(panBrt);
		
		panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labMail = new JLabel("E-mail adresa*");
		labMail.setPreferredSize(dim);
		txtMail = new JTextField();
		txtMail.setPreferredSize(dim);
		panMail.add(labMail);
		panMail.add(txtMail);
		panCen.add(panMail);
		
		panBri = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBri = new JLabel("Broj indeksa*");
		labBri.setPreferredSize(dim);
		txtBri = new JTextField();
		txtBri.setPreferredSize(dim);
		txtBri.addFocusListener(new MyFocusListener3());
		panBri.add(labBri);
		panBri.add(txtBri);
		panCen.add(panBri);
		
		panGodu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labGodu = new JLabel("Godina upisa*");
		labGodu.setPreferredSize(dim);
		txtGodu = new JTextField();
		txtGodu.setPreferredSize(dim);
		txtGodu.addFocusListener(new MyFocusListener4());
		panGodu.add(labGodu);
		panGodu.add(txtGodu);
		panCen.add(panGodu);
		
		panTgs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTgs = new JLabel("Trenutna godina studija*");
		labTgs.setPreferredSize(dim);
		god = new JComboBox<String>();
		godModel = new DefaultComboBoxModel<String>();
		godModel.addElement("I (Prva)");
		godModel.addElement("II (Druga)");
		godModel.addElement("III (Treća)");
		godModel.addElement("IV (Četvrta)");
		godModel.addElement("V (Master)");
		godModel.addElement("VI (Doktorske studije)");
		god.setModel(godModel);
		god.setSelectedIndex(0);
		god.setPreferredSize(dim);
		//god.setEditable(true);
		panTgs.add(labTgs);
		panTgs.add(god);
		panCen.add(panTgs);
		
		panNfs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNfs = new JLabel("Način finansiranja*");
		labNfs.setPreferredSize(dim);
		bs = new JComboBox<String>();
		bsModel = new DefaultComboBoxModel<String>();
		bsModel.addElement("Budžet");
		bsModel.addElement("Samofinansiranje");
		bs.setModel(bsModel);
		bs.setSelectedIndex(0);
		bs.setPreferredSize(dim);
		//bs.setEditable(true);
		panNfs.add(labNfs);
		panNfs.add(bs);
		panCen.add(panNfs);
		
		panBtn = new JPanel();
		
		potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Student student = collectData();
					if(txtIme.getText().trim().isEmpty() || txtPrz.getText().trim().isEmpty() 
							|| txtDat.getText().trim().isEmpty() || txtAdr.getText().trim().isEmpty()
								|| txtBrt.getText().trim().isEmpty() || txtMail.getText().trim().isEmpty()
									|| txtBri.getText().trim().isEmpty() || txtGodu.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Morate unijeti sva polja!");
					}else {
						StudentiController.getInstance().dodajStudenta(student);
						
						dispose();
					}
				}catch(Exception ex) {
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
	
	public Student collectData() {		
		String ime = txtIme.getText();
		String prezime = txtPrz.getText();
		String datumRodjenja = txtDat.getText();
		String adresaStanovanja = txtAdr.getText();
		String brojTelefona = txtBrt.getText();
		String emailAdresa = txtMail.getText();
		String brojIndeksa = txtBri.getText();
		int godinaUpisa = 0;
		if(!txtGodu.getText().trim().isEmpty()) {
			godinaUpisa = Integer.parseInt(txtGodu.getText());
		}
		int godi = god.getSelectedIndex();
		int trenutnaGodinaStudija = godi + 1;
		double prosjek = 0.0;
		Status s;
		int id = bs.getSelectedIndex();
		if(id == 0) {
			s = Status.B;
		}else {
			s = Status.S;
		}
		
		Student st = new Student(ime, prezime, datumRodjenja, adresaStanovanja, brojTelefona, emailAdresa, 
							brojIndeksa, godinaUpisa, trenutnaGodinaStudija, s, prosjek, null, null);
		return st;
	}
	
}
