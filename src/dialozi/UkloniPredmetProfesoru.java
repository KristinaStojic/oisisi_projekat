package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ProfesorController;
import izgledAplikacije.GlavniProzor;
import model.Predmet;
import model.Profesor;

public class UkloniPredmetProfesoru extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JPanel panDlt;
	JPanel panBtn;
	JLabel lblDlt;
	JButton potvrdi;
	JButton odustani;
	
	public UkloniPredmetProfesoru(Profesor profesor, ArrayList<Predmet> predmeti) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("ukloniPredmet"));
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(GlavniProzor.getInstance());
		setResizable(true);
		setModal(true);
		
		panDlt = new JPanel();
		lblDlt = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("potvrda"));
		lblDlt.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
		panDlt.add(lblDlt);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("da"));
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("ne"));
		
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesorController.getInstance().ukloniPredmete(profesor, predmeti);
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
