package dialozi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import controller.StudentiController;
import izgledAplikacije.AbstractTableModelNepolozeniIspiti;
import izgledAplikacije.AbstractTableModelOcjena;
import izgledAplikacije.GlavniProzor;
import listeneri.MyFocusListener1;
import listeneri.MyFocusListener2;
import listeneri.MyFocusListener4;
import listeneri.MyFocusListener5;
import listeneri.MyFocusListener6;
import listeneri.MyKeyListener1;
import model.BazaNepolozeniIspiti;
import model.BazaOcjena;
import model.BazaStudenata;
import model.Ocena;
import model.Student;
import model.Student.Status;

public class EditStudent extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel informacijePanel = new JPanel();
	JPanel polozeniPanel = new JPanel();
	JPanel nepolozeniPanel = new JPanel();
	
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
	
	protected JPanel polPan;
	protected JPanel status;
	protected JLabel prosjecnaLab;
	protected JLabel espbLab;
	protected JButton ponistiOcjenu;
	
	protected JPanel nepolPanel;
	protected JButton dodaj;
	protected JButton obrisi;
	protected JButton polaganje;
	protected JPanel status2;
	static JTable polozeniTabela;
	protected AbstractTableModelOcjena polozeniModel;
	JScrollPane pane1;

	static JTable nepolozeniTabela;
	protected AbstractTableModelNepolozeniIspiti nepolozeniModel;
	JScrollPane pane2;
	AddPredmetToStudent addPredmetToStudent;
	
	protected int ESPB;
	protected double  prosjek;
	
	public EditStudent(Student s) {
		
		JTabbedPane pane = new JTabbedPane();
		
		setResizable(false);
		
		informacijePanel = informacijeIzmjena(s);
		pane.add(GlavniProzor.getInstance().resourceBundle.getString("editInfoTab"),informacijePanel);
		
		polozeniPanel = polozeniIzmjena();
		pane.add(GlavniProzor.getInstance().resourceBundle.getString("editPolozeniTab"),polozeniPanel);
		
		nepolozeniPanel = nepolozeniIzmjena();
		pane.add(GlavniProzor.getInstance().resourceBundle.getString("editNepolozeniTab"),nepolozeniPanel);
		
		add(pane);
		
	}
	
	private JPanel polozeniIzmjena() {
		polPan = new JPanel();
		
		ponistiOcjenu = new JButton(GlavniProzor.getInstance().resourceBundle.getString("ponistiOcjenu"));
		ponistiOcjenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(polozeniTabela.getSelectedRow() != -1) {
					PonistiOcjenu ponistiOcjenu = new PonistiOcjenu(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent(), BazaOcjena.getInstance().getOcene().get(polozeniTabela.getSelectedRow()));
					ponistiOcjenu.setVisible(true);

					azurirajPrikazNepolozenihPredmeta("DODAT", -1);
					try {
						double suma = 0;
						ESPB = 0;
						for(Ocena o : GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getPolozeniIspiti()) {
							suma += o.getOcena();
							ESPB += o.getPredmet().getBroj_ESPB();
						}
						
						prosjek = suma/GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getPolozeniIspiti().size();
						if(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getPolozeniIspiti().size() == 0) {
							prosjek = 0.0;
						}
						}catch(NullPointerException ex) {}
					
					prosjecnaLab.setText(GlavniProzor.getInstance().resourceBundle.getString("polProsjecna") + Math.round(prosjek * 100.0) / 100.0);
					espbLab.setText(GlavniProzor.getInstance().resourceBundle.getString("polUkupnoEspb") + ESPB);

					azurirajPrikazPolozenihPredmeta("SKLONJEN", -1);
				}else {
					JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("morateIzabratiPredmet"));
				}
			}
		});
		
		polozeniTabela = new JTable();
		polozeniModel = new AbstractTableModelOcjena();
		polozeniTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		polozeniTabela.setModel(polozeniModel);
		polozeniTabela.setShowHorizontalLines(false);
		polozeniTabela.setAutoCreateRowSorter(true);
		pane1 = new JScrollPane(polozeniTabela);
		
		prosjecnaLab = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("polProsjecna") + prosjek);;
		
		
		espbLab = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("polUkupnoEspb") + ESPB);
		
		status = new JPanel();
		status.setBorder(BorderFactory.createLineBorder(Color.BLACK));//dodaj na dno stranice??
		
		setLayout();
		
		return polPan;
	}
	
	
	private JPanel nepolozeniIzmjena() {
		nepolPanel = new JPanel();
		
		dodaj = new JButton(GlavniProzor.getInstance().resourceBundle.getString("nepDodaj"));
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				addPredmetToStudent = new AddPredmetToStudent(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent());
				addPredmetToStudent.setVisible(true);
				azurirajPrikazNepolozenihPredmeta("DODAT", -1);
			}
		});
		obrisi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("nepObrisi"));
		obrisi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nepolozeniTabela.getSelectedRow() != -1) {
					MovePredmetFromStudent movePredmetFromStudent = new MovePredmetFromStudent(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent(),BazaNepolozeniIspiti.getInstance().getNepolozeni().get(nepolozeniTabela.getSelectedRow()));
					movePredmetFromStudent.setVisible(true);
					//addPredmetToStudent.azurirajListuMogucihPredmeta(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent());
					azurirajPrikazNepolozenihPredmeta("UKLONJEN", -1);
					 
					
				}else {
					JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("morateIzabratiPredmet"));
				}
			}
		});
		polaganje = new JButton(GlavniProzor.getInstance().resourceBundle.getString("nepPolaganje"));
		polaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(nepolozeniTabela.getSelectedRow() != -1) {
					UpisOcene upisOcene = new UpisOcene(GlavniProzor.getInstance().tabbedPane.getIzabraniStudent(),BazaNepolozeniIspiti.getInstance().getNepolozeni().get(nepolozeniTabela.getSelectedRow()));
					upisOcene.setVisible(true);
					
					azurirajPrikazNepolozenihPredmeta("UKLONJEN", -1);
					try {
						double suma = 0;
						ESPB = 0;
						for(Ocena o : GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getPolozeniIspiti()) {
							suma += o.getOcena();
							ESPB += o.getPredmet().getBroj_ESPB();
						}
						
						prosjek = suma/GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getPolozeniIspiti().size();
						
						}catch(NullPointerException ex) {}
					
					prosjecnaLab.setText(GlavniProzor.getInstance().resourceBundle.getString("polProsjecna") + Math.round(prosjek * 100.0) / 100.0);
					espbLab.setText(GlavniProzor.getInstance().resourceBundle.getString("polUkupnoEspb") + ESPB);
					GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().setProsjecnaOcjena(prosjek);
					azurirajPrikazPolozenihPredmeta("DODAT", -1);
					
					
				}else {
					JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("morateIzabratiPredmet"));
				}
				
			}
			
		});
		nepolozeniTabela = new JTable();
		nepolozeniModel = new AbstractTableModelNepolozeniIspiti();
		nepolozeniTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		nepolozeniTabela.setModel(nepolozeniModel);
		nepolozeniTabela.setShowHorizontalLines(false);
		nepolozeniTabela.setAutoCreateRowSorter(true);
		pane2 = new JScrollPane(nepolozeniTabela);
		
		
		status2 = new JPanel();
		status2.setBorder(BorderFactory.createLineBorder(Color.BLACK));//dodaj na dno stranice??
		
		setLayout2();
		
		return nepolPanel;
	}
	
	private void setLayout() {
		polPan.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(5, 5, 20, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		polPan.add(ponistiOcjenu, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 4;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.anchor = GridBagConstraints.CENTER;
		polPan.add(pane1, gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		gc.gridheight = 2;
		gc.insets = new Insets(1, 90, 1, 1);
		gc.anchor = GridBagConstraints.WEST;
		polPan.add(prosjecnaLab, gc);
		
		gc.gridx = 1;
		gc.gridy = 7;
		gc.gridheight = 2;
		gc.insets = new Insets(1, 90, 1, 1);
		gc.anchor = GridBagConstraints.WEST;
		polPan.add(espbLab, gc);
		
	}
	
	
	//izgled taba nepolozeni
	private void setLayout2() {
		nepolPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.insets = new Insets(5, 5, 20, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		nepolPanel.add(dodaj, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(5, 5, 20, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		nepolPanel.add(obrisi, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.insets = new Insets(5, 78, 20, 0);
		gc.anchor = GridBagConstraints.NORTHWEST;
		nepolPanel.add(polaganje, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 2;
		gc.gridheight = 4;
		gc.insets = new Insets(2, 2, 2, 2);
		gc.anchor = GridBagConstraints.CENTER;
		nepolPanel.add(pane2, gc);
		
	}
	
	private JPanel informacijeIzmjena(Student s) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("editStudent"));
		setSize(550,600);
		setLocationRelativeTo(null);
		setModal(true);
		
		dim = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxc = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxc);
		
		try {
			double suma = 0;
		
			for(Ocena o : s.getPolozeniIspiti()) {
				suma += o.getOcena();
				ESPB += o.getPredmet().getBroj_ESPB();
			}
			
			prosjek = suma/s.getPolozeniIspiti().size();
		}catch(NullPointerException e) {}
		
		panIme = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labIme = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newIme"));
		labIme.setPreferredSize(dim);
		txtIme = new JTextField(s.getImeStudenta());
		txtIme.setPreferredSize(dim);
		txtIme.addKeyListener(new MyKeyListener1());
		panIme.add(labIme);
		panIme.add(txtIme);
		panCen.add(panIme);
		
		panPrz = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labPrz = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newPrezime"));
		labPrz.setPreferredSize(dim);
		txtPrz = new JTextField(s.getPrezimeStudenta());
		txtPrz.setPreferredSize(dim);
		txtPrz.addKeyListener(new MyKeyListener1());
		panPrz.add(labPrz);
		panPrz.add(txtPrz);
		panCen.add(panPrz);
		
		panDat = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labDat = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newDatumRodjenja"));
		labDat.setPreferredSize(dim);
		txtDat = new JTextField(s.getDatumRodjenjaStudenta());
		txtDat.setPreferredSize(dim); 
		txtDat.addFocusListener(new MyFocusListener1());
		panDat.add(labDat);
		panDat.add(txtDat);
		panCen.add(panDat);
		
		panAdr = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labAdr = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newAdresaStanovanja"));
		labAdr.setPreferredSize(dim);
		txtAdr = new JTextField(s.getAdresaStudenta());
		txtAdr.setPreferredSize(dim);
		txtAdr.addFocusListener(new MyFocusListener5());
		panAdr.add(labAdr);
		panAdr.add(txtAdr);
		panCen.add(panAdr);
		
		panBrt = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBrt = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newBrojTelefona"));
		labBrt.setPreferredSize(dim);
		txtBrt = new JTextField(s.getKontaktTelefon());
		txtBrt.setPreferredSize(dim);
		txtBrt.addFocusListener(new MyFocusListener2());
		panBrt.add(labBrt);
		panBrt.add(txtBrt);
		panCen.add(panBrt);
		
		panMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labMail = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newEmail"));
		labMail.setPreferredSize(dim);
		txtMail = new JTextField(s.getEmailAdresa());
		txtMail.setPreferredSize(dim);
		txtMail.addFocusListener(new MyFocusListener6());
		panMail.add(labMail);
		panMail.add(txtMail);
		panCen.add(panMail);
		
		panBri = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labBri = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newBrojInd"));
		labBri.setPreferredSize(dim);
		txtBri = new JTextField(s.getBrojIndeksa());
		txtBri.setPreferredSize(dim);
		panBri.add(labBri);
		panBri.add(txtBri);
		panCen.add(panBri);
		
		panGodu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labGodu = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newGodinaUpisa"));
		labGodu.setPreferredSize(dim);
		txtGodu = new JTextField(String.valueOf(s.getGodinaUpisa()));
		txtGodu.setPreferredSize(dim);
		txtGodu.addFocusListener(new MyFocusListener4());
		panGodu.add(labGodu);
		panGodu.add(txtGodu);
		panCen.add(panGodu);
		
		panTgs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labTgs = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newTrenutnaGodinaStudija"));
		labTgs.setPreferredSize(dim);
		god = new JComboBox<String>();
		godModel = new DefaultComboBoxModel<String>();
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxPrva"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDruga"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxTreca"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxCetvrta"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxPeta"));
		godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxSesta"));
		god.setModel(godModel);
		god.setSelectedIndex(s.getTrenutnaGodinaStudija() - 1);
		god.setPreferredSize(dim);
		//god.setEditable(true);
		panTgs.add(labTgs);
		panTgs.add(god);
		panCen.add(panTgs);
		
		panNfs = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNfs = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newNacinFinansiranja"));
		labNfs.setPreferredSize(dim);
		bs = new JComboBox<String>();
		bsModel = new DefaultComboBoxModel<String>();
		bsModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxBudzet"));
		bsModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxSamofinansiranje"));
		bs.setModel(bsModel);
		if(s.getStatus() == Status.B) {
			bs.setSelectedIndex(0);
		}else {
			bs.setSelectedIndex(1);
		}
		bs.setPreferredSize(dim);
		//bs.setEditable(true);
		panNfs.add(labNfs);
		panNfs.add(bs);
		panCen.add(panNfs);
		
		panBtn = new JPanel();
		
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				/*try {
					
					if(txtIme.getText().trim().isEmpty() || txtPrz.getText().trim().isEmpty() 
							|| txtDat.getText().trim().isEmpty() || txtAdr.getText().trim().isEmpty()
								|| txtBrt.getText().trim().isEmpty() || txtMail.getText().trim().isEmpty()
									|| txtBri.getText().trim().isEmpty() || txtGodu.getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("svaPolja"));
					}else {
						Student student = collectData();
						student.setId(s.getId());
						boolean postoji = false;
						for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
							if((student.getBrojIndeksa().equals(BazaStudenata.getInstance().getStudenti().get(i).getBrojIndeksa()))
									&& student.getId() != BazaStudenata.getInstance().getStudenti().get(i).getId()) {
								JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("postojiIndeks"));
								postoji = true;
							}
						}
						if(!postoji) {
							Pattern datum = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
							Pattern adresa = Pattern.compile("[A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*[0-9]*[,_ ][A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*");
							Pattern telefon = Pattern.compile("[0-9]{3}[/][0-9]{6,7}");
							Pattern mejl = Pattern.compile("[a-z|0-9|_|.]+[a-z|0-9][@]([a-z]+[.][a-z]+)+");
							Pattern godina = Pattern.compile("[0-9]{4}");
							boolean ispravan_unos = false;
							if(datum.matcher(student.getDatumRodjenjaStudenta()).matches() && adresa.matcher(student.getAdresaStudenta()).matches()
									&& telefon.matcher(student.getKontaktTelefon()).matches() && mejl.matcher(student.getEmailAdresa()).matches()
									&& godina.matcher(String.valueOf(student.getGodinaUpisa())).matches()) {
								ispravan_unos = true;
							}
							if(!ispravan_unos) {
								JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("neispravanUnos"));
							}else {
								StudentiController.getInstance().izmeniStudenta(student);
								dispose();
							}
						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}*/
				Student student;
				try {
					student = collectData();
					StudentiController.getInstance().izmeniStudenta(student);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
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
						|| txtDat.getText().trim().isEmpty() || txtAdr.getText().trim().isEmpty()
							|| txtBrt.getText().trim().isEmpty() || txtMail.getText().trim().isEmpty()
								|| txtBri.getText().trim().isEmpty() || txtGodu.getText().trim().isEmpty()) {
					sve_uneseno = false;
				}else {
					sve_uneseno = true;
				}
				Pattern datum = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
				Pattern adresa = Pattern.compile("[A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*[0-9]*[,_ ][A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*");
				Pattern telefon = Pattern.compile("[0-9]{3}[/][0-9]{6,7}");
				Pattern mejl = Pattern.compile("[a-z|0-9|_|.]+[a-z|0-9][@]([a-z]+[.][a-z]+)+");
				Pattern godina = Pattern.compile("[0-9]{4}");
				boolean ispravan_unos = false;
				if(datum.matcher(txtDat.getText()).matches() && adresa.matcher(txtAdr.getText()).matches()
						&& telefon.matcher(txtBrt.getText()).matches() && mejl.matcher(txtMail.getText()).matches()
							&& godina.matcher(txtGodu.getText()).matches()) {
					ispravan_unos = true;
				}
				boolean postoji = false;
				for(int i = 0; i < BazaStudenata.getInstance().getStudenti().size(); i++) {
					if((txtBri.getText().equals(BazaStudenata.getInstance().getStudenti().get(i).getBrojIndeksa()))
							&& BazaStudenata.getInstance().getStudenti().get(i).getId() != GlavniProzor.getInstance().tabbedPane.getIzabraniStudent().getId()) {
						postoji = true;
						txtBri.setToolTipText("Uneseni broj indeksa vec postoji!");
						JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("postojiIndeks"));
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
				
			txtAdr.addKeyListener(provjera);
			txtBri.addKeyListener(provjera);
			txtBrt.addKeyListener(provjera);
			txtDat.addKeyListener(provjera);
			txtGodu.addKeyListener(provjera);
			txtIme.addKeyListener(provjera);
			txtMail.addKeyListener(provjera);
			txtPrz.addKeyListener(provjera);
		
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
		return panCen;
	}
	
	private Student collectData() throws ParseException {		
		String ime = Character.toUpperCase(txtIme.getText().charAt(0)) + txtIme.getText().substring(1, txtIme.getText().length()).toLowerCase();
		String prezime = Character.toUpperCase(txtPrz.getText().charAt(0)) + txtPrz.getText().substring(1, txtPrz.getText().length()).toLowerCase();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy.");
		Date datumRodjenja = formatter.parse(txtDat.getText());
		String adresaStanovanja = txtAdr.getText();
		String brojTelefona = txtBrt.getText();
		String emailAdresa = txtMail.getText();
		String brojIndeksa = txtBri.getText().substring(0,2).toUpperCase() + txtBri.getText().substring(2,txtBri.getText().length());
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
	
	public void azurirajPrikazNepolozenihPredmeta(String akcija, int vrijednost) {
		AbstractTableModelNepolozeniIspiti model = (AbstractTableModelNepolozeniIspiti) nepolozeniTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
	public void azurirajPrikazPolozenihPredmeta(String akcija, int vrijednost) {
		AbstractTableModelOcjena model = (AbstractTableModelOcjena) polozeniTabela.getModel();
		model.fireTableDataChanged();
		validate();
	}
	
}
