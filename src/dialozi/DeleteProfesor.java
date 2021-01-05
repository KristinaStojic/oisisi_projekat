package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ProfesorController;
import izgledAplikacije.GlavniProzor;
import model.Profesor;

public class DeleteProfesor extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected JLabel lblDlt;
	protected JPanel panDlt;
	
	protected JPanel panBtn;
	protected JButton potvrdi;
	protected JButton odustani;
	
	protected BoxLayout boxCen;
	
	public DeleteProfesor(Profesor p) {
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("delProfesor"));
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(null);
		setResizable(true);
		setModal(true);
		
		panDlt = new JPanel();
		lblDlt = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("potvrdaBrisanjaProf"));
		lblDlt.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
		panDlt.add(lblDlt);
		
		
		panBtn = new JPanel();
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("da"));
		odustani = new JButton(GlavniProzor.getInstance().resourceBundle.getString("ne"));
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfesorController.getInstance().izbrisiProfesora(p);
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
