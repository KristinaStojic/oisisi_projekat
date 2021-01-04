package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import izgledAplikacije.GlavniProzor;
import model.Predmet;
import model.Student;

public class UpisOcene extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Dimension dimension;
	protected JPanel panCen;
	protected BoxLayout boxcen;
	
	
	protected JPanel panSifra;
	protected JLabel labSifra;
	protected JTextField txtSifra;
	
	protected JPanel panNaziv;
	protected JLabel labNaziv;
	protected JTextField txtNaziv;
	
	protected JPanel panDatum;
	protected JLabel labDatum;
	protected JTextField txtDatum;
	
	
	protected JPanel panOcena;
	protected JLabel labOcena;
	protected JComboBox<String> ocena;
	protected DefaultComboBoxModel<String> ocenaModel;
	
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	protected EditStudent editstudent;
	
	public UpisOcene(Student student, Predmet p) {
		
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("unosOcene"));
		setSize(320,420);
		setLocationRelativeTo(null);
		setModal(true);
		
		dimension = new Dimension(150, 20);
		
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		
		panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSifra = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("sifraOcene"));
		labSifra.setPreferredSize(dimension);
		txtSifra = new JTextField();
		txtSifra.setText(p.getSifra_predmeta());
		txtSifra.setPreferredSize(dimension);
		txtSifra.setEditable(false);
		panSifra.add(labSifra);
		panSifra.add(txtSifra);
		panCen.add(panSifra);
		
		
		
		panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNaziv = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("polaganjeNaziv"));
		labNaziv.setPreferredSize(dimension);
		txtNaziv = new JTextField();
		txtNaziv.setText(p.getNaziv_predmeta());
		txtNaziv.setPreferredSize(dimension);
		txtNaziv.setEditable(false);
		panNaziv.add(labNaziv);
		panNaziv.add(txtNaziv);
		panCen.add(panNaziv);
		
		
		panOcena = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labOcena = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("polaganjeOcena"));
		labOcena.setPreferredSize(dimension);
		ocena = new JComboBox<String>();
		ocenaModel = new DefaultComboBoxModel<String>();
		ocenaModel.addElement("6");
		ocenaModel.addElement("7");
		ocenaModel.addElement("8");
		ocenaModel.addElement("9");
		ocenaModel.addElement("10");
		ocena.setModel(ocenaModel);
		ocena.setPreferredSize(dimension);
		panOcena.add(labOcena);
		panOcena.add(ocena);
		panCen.add(panOcena);
		
		
		panDatum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labDatum = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("polaganjeDatum"));
		labDatum.setPreferredSize(dimension);
		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dimension);
		//txtDatum.addFocusListener(new MyFocusListener1());
		panDatum.add(labDatum);
		panDatum.add(txtDatum);
		panCen.add(panDatum);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("btnPotvrdi"));
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtDatum.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("svaPolja"));
				}else {
					Pattern datum1 = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
					boolean ispravan_unos = false;
					if(datum1.matcher(txtDatum.getText()).matches()) {
						ispravan_unos = true;
					}
					if(!ispravan_unos) {
						JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().resourceBundle.getString("ispravanDatum"));
						txtDatum.setText("");
						txtDatum.requestFocus();
					}
					else {
						
					
					
					for(int i=0;i<student.getNepolozeniIspiti().size();i++) {
						if(student.getNepolozeniIspiti().get(i).getSifra_predmeta().equals(p.getSifra_predmeta())) {
							
							PredmetController.getInstance().izbrisiNepolozeni(p, student);
							
							DateFormat datformat = new SimpleDateFormat("dd.MM.yyyy.");
							Date datumPolaganja = null;
							try {
						    datumPolaganja = datformat.parse(txtDatum.getText());
							}
							catch(ParseException ex) {
								ex.printStackTrace();
							}
							int ocjena = 0;
							int id = ocena.getSelectedIndex();
							if(id == 0) {
								 ocjena = 6;
							}else if(id == 1) {
								ocjena = 7;
							}else if(id == 2) {
								ocjena = 8;
							}else if(id == 3) {
								ocjena = 9;
							}else if(id == 4) {
								ocjena = 10;
							}
							PredmetController.getInstance().dodajPolozeni(p, student, ocjena, datumPolaganja);
							
							dispose();
							
						}
						
					}
				}
				}
			}
		});
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
	
	

	
}




