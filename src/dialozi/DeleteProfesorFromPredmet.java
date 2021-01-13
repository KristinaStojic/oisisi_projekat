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

import controller.PredmetController;
import izgledAplikacije.GlavniProzor;
import model.Predmet;
import model.Profesor;

public class DeleteProfesorFromPredmet extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panDlt;
	JPanel panBtn;
	JLabel lblDlt;
	JButton potvrdi;
	JButton odustani;
	
	public DeleteProfesorFromPredmet(Profesor prof, Predmet pred, JButton plus, JButton minus) {
		
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("delProfFromPredm"));
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(null);
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
				PredmetController.getInstance().ukloniProfesoraPredmetu(prof, pred);
				prof.getPredmetiProfesora().remove(pred);
				//ProfesorController.getInstance().izbrisiPredmetProfesoru(prof, pred);
				//BazaProfesora.getInstance().izbrisiPredmetsaProfesora(pred);
				if(prof.getPredmetiProfesora() != null) {
					plus.setEnabled(true);
					minus.setEnabled(false);
				}else {
					plus.setEnabled(false);
					minus.setEnabled(true);
				}
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
