package dialozi;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

import controller.PredmetController;
import controller.ProfesorController;
import izgledAplikacije.AbstractTableModelPredmetiProfesora;
import izgledAplikacije.GlavniProzor;
import listeneri.MyFocusListener1;
import listeneri.MyFocusListener2;
import listeneri.MyFocusListener6;
import listeneri.MyKeyListener1;
import listeneri.MyKeyListener2;
import model.BazaPredmetiProfesora;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;
import model.Profesor.Titula;
import model.Profesor.Zvanje;

public class EditProfesor extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	JPanel informacijePanel = new JPanel();
	JPanel predmetiPanel = new JPanel();
	
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
	
	
	protected JPanel predPanel;
	protected JButton dodajPredmet;
	protected JButton ukloniPredmet;
	static JTable predmetTabela;
	protected AbstractTableModelPredmetiProfesora predmetiProfesoraModel;
	JScrollPane pane;
	
	 public EditProfesor(Profesor p) {
		
		 
		 JTabbedPane pane = new JTabbedPane();
			
			setResizable(false);
				
			informacijePanel = informacijeIzmjena(p);
			//pane.add("Info",informacijePanel);
			pane.add(GlavniProzor.getInstance().resourceBundle.getString("editInfo"),informacijePanel);

			predmetiPanel = predmetiProfIzmjena(p);
			//pane.add("Predmeti",predmetiPanel);
			pane.add(GlavniProzor.getInstance().resourceBundle.getString("profPredmeti"),predmetiPanel);

			add(pane);
	}
	
	 
	 private JPanel informacijeIzmjena(Profesor p) {
		// setTitle("Izmeni profesora");
		 setTitle(GlavniProzor.getInstance().resourceBundle.getString("izmeniProf"));

			setSize(550,600);
			setLocationRelativeTo(null);
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
			txtIme.setText(p.getIme());
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
			txtPrz.setText(p.getPrezime());
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
			txtDatum.setText(p.getDatumRodjenja());
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
			txtAdresa.setText(p.getAdresaStanovanja());
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
			txtTel.setText(p.getKontaktTelefon());
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
			txtEmail.setText(p.getEmailAdresa());
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
			txtAdresaKanc.setText(p.getAdresaKancelarije());
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
			txtBrLicne.setText(p.getBrojLicneKarte());
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
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxBSc"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxMSc"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxMr"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDr"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxProf"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxProfDr"));
			titModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDiplIng"));
			tit.setModel(titModel);
			//napravi da prikaze titulu profesora koji je oznacen
			//tit.setSelectedItem(profesor.getTitula());
			tit.setPreferredSize(dimension);
			panTitula.add(labTitula);
			panTitula.add(tit);
			panCen.add(panTitula);
			
			
			
			panTgs = new JPanel(new FlowLayout(FlowLayout.CENTER));
			//labTgs = new JLabel("Zvanje*");
			labTgs = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("newZvanje"));
			labTgs.setPreferredSize(dimension);
			god = new JComboBox<String>();
			godModel = new DefaultComboBoxModel<String>();
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxSaradnik"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxAsistent"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxAsistentSaDoktoratom"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxDocent"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxVanredni"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxRedovniProfesor"));
			godModel.addElement(GlavniProzor.getInstance().resourceBundle.getString("newBoxEmeritus"));
			god.setModel(godModel);
			god.getSelectedIndex();
			god.setPreferredSize(dimension);
			panTgs.add(labTgs);
			panTgs.add(god);
			panCen.add(panTgs);
			
			panBtn = new JPanel();
			potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));

			potvrdi.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					Profesor profesor = collectData();
					profesor.setId(p.getId());
					ProfesorController.getInstance().izmeniProfesora(profesor);
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
							|| txtDatum.getText().trim().isEmpty() || txtAdresa.getText().trim().isEmpty()
							|| txtTel.getText().trim().isEmpty() || txtEmail.getText().trim().isEmpty()
								|| txtAdresaKanc.getText().trim().isEmpty() || txtBrLicne.getText().trim().isEmpty()) {
						sve_uneseno = false;
					}else {
						sve_uneseno = true;
					}
					Pattern datum = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
					Pattern telefon = Pattern.compile("[0-9]{3}[/][0-9]{6,7}");
					Pattern mejl = Pattern.compile("[a-z|0-9|_|.]+[a-z|0-9][@]([a-z]+[.][a-z]+)+");
					Pattern brLicne = Pattern.compile("[A-Z|0-9]*");
					boolean ispravan_unos = false;
					if(datum.matcher(txtDatum.getText()).matches() && (txtAdresa.getText() != "")
							&& telefon.matcher(txtTel.getText()).matches() && mejl.matcher(txtEmail.getText()).matches()
							&& (txtAdresa.getText() != "") && brLicne.matcher(txtBrLicne.getText()).matches()) {
						ispravan_unos = true;
					}
					boolean postoji = false;
					for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
						if((txtBrLicne.getText().equals(BazaProfesora.getInstance().getProfesori().get(i).getBrojLicneKarte()))
								&& p.getId() != BazaProfesora.getInstance().getProfesori().get(i).getId()) {
							txtBrLicne.setToolTipText(GlavniProzor.getInstance().getResourceBundle().getString("postojiLicna"));
							postoji = true;
						}else {
							txtBrLicne.setToolTipText(null);

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
				txtDatum.addKeyListener(provjera);
				txtBrLicne.addKeyListener(provjera);
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
			
			return panCen;
	 }
	 
	 
	 
	 private JPanel predmetiProfIzmjena(Profesor p) {
		 	predPanel = new JPanel();
			
		    //dodajPredmet = new JButton("Dodaj predmet");
		    dodajPredmet = new JButton(GlavniProzor.getInstance().resourceBundle.getString("addPredmet1"));
		    dodajPredmet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					AddPredmetToProfesor pp = new AddPredmetToProfesor(GlavniProzor.getInstance().tabbedPane.getIzabraniProfesor());
					
					pp.setVisible(true);
					azurirajPrikazPredmetaProfesora("DODAT", -1);
					
				}
			});
		    //ukloniPredmet = new JButton("Ukloni predmet");
		    ukloniPredmet = new JButton(GlavniProzor.getInstance().resourceBundle.getString("ukloniPredmet"));

		    ukloniPredmet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(predmetTabela.getSelectedRow() != -1) {
						ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
						for(int i = 0; i < predmetTabela.getSelectedRows().length; i++) {
							Predmet pr = BazaPredmetiProfesora.getInstance().getPredmetiProfesora().get(predmetTabela.getSelectedRows()[i]);
							predmeti.add(pr);
						}
						UkloniPredmetProfesoru ukloniPredmetProfesoru = new UkloniPredmetProfesoru(GlavniProzor.getInstance().tabbedPane.getIzabraniProfesor(), predmeti);
						PredmetController.getInstance().ukloniProfPredmetima(predmeti);
						ukloniPredmetProfesoru.setVisible(true);
						azurirajPrikazPredmetaProfesora("UKLONJENO", -1);
					}else {
						JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("morateIzabratiPredmet"));

					}
				}
			});
		    
		    predmetTabela = new JTable();
		    predmetTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		    predmetiProfesoraModel = new AbstractTableModelPredmetiProfesora();
		    predmetTabela.setModel(predmetiProfesoraModel);
		    predmetTabela.setShowHorizontalLines(false);
		    predmetTabela.setAutoCreateRowSorter(true);
			pane = new JScrollPane(predmetTabela);
			
			
			///status = new JPanel();
			//status.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			
			setLayout();
			
			return predPanel;
	 }
	 
	 
	 private void setLayout() {
		 predPanel.setLayout(new GridBagLayout());
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.gridx = 0;
			gc.gridy = 0;
			gc.insets = new Insets(5, 5, 20, 0);
			gc.anchor = GridBagConstraints.NORTHWEST;
			predPanel.add(dodajPredmet, gc);
			
			gc.gridx = 1;
			gc.gridy = 0;
			gc.insets = new Insets(5, 25, 20, 0);
			gc.anchor = GridBagConstraints.NORTHWEST;
			predPanel.add(ukloniPredmet, gc);
			
			gc.gridx = 0;
			gc.gridy = 1;
			gc.gridwidth = 2;
			gc.gridheight = 4;
			gc.insets = new Insets(2, 2, 2, 2);
			gc.anchor = GridBagConstraints.CENTER;
			predPanel.add(pane, gc);
			
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
	 
	 public void azurirajPrikazPredmetaProfesora(String akcija, int vrijednost) {
			AbstractTableModelPredmetiProfesora model = (AbstractTableModelPredmetiProfesora) predmetTabela.getModel();
			model.fireTableDataChanged();
			validate();
		}
	 
		
}
