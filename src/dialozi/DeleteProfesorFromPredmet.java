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
		
		setTitle("Ukloni profesora");
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);
		
		panDlt = new JPanel();
		lblDlt = new JLabel("Da li ste sigurni?");
		lblDlt.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
		panDlt.add(lblDlt);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton("DA");
		odustani = new JButton("NE");
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PredmetController.getInstance().ukloniProfesoraPredmetu(prof, pred);
				prof.getPredmetiProfesora().remove(pred);
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
