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

public class AddPredmet  extends JDialog {

	protected Dimension dimension;
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
	
	protected JPanel panProfesor;
	protected JLabel labProfesor;
	protected JTextField txtProfesor;
	
	protected JPanel panESPB;
	protected JLabel labESPB;
	protected JTextField txtESPB;
	
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	public AddPredmet() {
		
		
		setTitle("Dodavanje predmeta");
		setSize(450,600);
		setLocationRelativeTo(null);
		setModal(true);
		
		dimension = new Dimension(150, 20);
		
		panCen = new JPanel();
		boxcen = new BoxLayout(panCen, BoxLayout.Y_AXIS);
		panCen.setLayout(boxcen);
		
		
		panSifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSifra = new JLabel("Sifra predmeta*");
		labSifra.setPreferredSize(dimension);
		txtSifra = new JTextField();
		txtSifra.setPreferredSize(dimension);
		panSifra.add(labSifra);
		panSifra.add(txtSifra);
		panCen.add(panSifra);
		
		panNaziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labNaziv = new JLabel("Naziv predmeta*");
		labNaziv.setPreferredSize(dimension);
		txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dimension);
		panNaziv.add(labNaziv);
		panNaziv.add(txtNaziv);
		panCen.add(panNaziv);
		
		
		panSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labSemestar = new JLabel("Semestar*");
		labSemestar.setPreferredSize(dimension);
		txtSemestar = new JTextField();
		txtSemestar.setPreferredSize(dimension);
		panSemestar.add(labSemestar);
		panSemestar.add(txtSemestar);
		panCen.add(panSemestar);
		
		
		panGodina = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labGodina = new JLabel("Godina*");
		labGodina.setPreferredSize(dimension);
		txtGodina = new JTextField();
		txtGodina.setPreferredSize(dimension);
		panGodina.add(labGodina);
		panGodina.add(txtGodina);
		panCen.add(panGodina);
		
		
		
		panProfesor = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labProfesor = new JLabel("Predmetni profesor*");
		labProfesor.setPreferredSize(dimension);
		txtProfesor = new JTextField();
		txtProfesor.setPreferredSize(dimension);
		panProfesor.add(labProfesor);
		panProfesor.add(txtProfesor);
		panCen.add(panProfesor);
		
		
		
		panESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		labESPB = new JLabel("Broj ESPB bodova*");
		labESPB.setPreferredSize(dimension);
		txtESPB = new JTextField();
		txtESPB.setPreferredSize(dimension);
		panESPB.add(labESPB);
		panESPB.add(txtESPB);
		panCen.add(panESPB);
		
		panBtn = new JPanel();
		potvrdi = new JButton("Potvrdi");
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
}
