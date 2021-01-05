package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentiController;
import izgledAplikacije.GlavniProzor;
import model.Predmet;
import model.Student;

public class MovePredmetFromStudent extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JPanel panDlt;
	JPanel panBtn;
	JLabel lblDlt;
	JButton potvrdi;
	JButton odustani;
	
	public MovePredmetFromStudent(Student student, Predmet predmet) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("uklanjanjePredmeta"));
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);
		
		panDlt = new JPanel();
		lblDlt = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("potvrdaUklanjanjaPredmeta"));
		lblDlt.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
		panDlt.add(lblDlt);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("da"));
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("ne"));
		
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				StudentiController.getInstance().ukloniPredmet(student, predmet);
				dispose();
			}
		});
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		panBtn.add(potvrdi);
		panBtn.add(odustani);
		
		add(panDlt, BorderLayout.CENTER);
		add(panBtn, BorderLayout.SOUTH);
	}
	
}
