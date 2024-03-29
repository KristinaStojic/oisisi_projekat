package dialozi;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.PredmetController;
import izgledAplikacije.GlavniProzor;
import model.BazaStudenata;
import model.Predmet;

public class DeletePredmet extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbldlt;
	protected JPanel pandlt;
	
	
	protected JPanel panBtn;
	private JButton potvrdi;
	private JButton odustani;
	
	protected BoxLayout boxcen;
	
	public DeletePredmet(Predmet p) {
		setTitle("Brisanje predmeta");
		setSize(new Dimension(420, 150));
		setLocationRelativeTo(GlavniProzor.getInstance());
		setResizable(false);
		setModal(true);
				
		//setTitle("Brisanje predmeta");
		setTitle(GlavniProzor.getInstance().resourceBundle.getString("delPredmet"));
		
		pandlt = new JPanel();
		//lbldlt = new JLabel("Da li ste sigurni da zelite da obrisete predmet?");
		lbldlt = new JLabel(GlavniProzor.getInstance().resourceBundle.getString("potvrdaBrisanjaPredm"));

		
		//https://www.oreilly.com/library/view/java-awt-reference/9781565922402/06_chapter-03.html
		lbldlt.setFont(new Font("TimesNewRoman", Font.PLAIN, 17));
		pandlt.add(lbldlt);
		
		
		
		panBtn = new JPanel();
		/*potvrdi = new JButton("DA");
		odustani=new JButton("NE");*/
		potvrdi = new JButton(GlavniProzor.getInstance().resourceBundle.getString("da"));
		odustani=new JButton(GlavniProzor.getInstance().resourceBundle.getString("ne"));
		
		potvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			//PredmetController.getInstance().izbrisiPredmet(p);
			BazaStudenata.getInstance().izbrisiNepolozeniPredmet(p);
			PredmetController.getInstance().izbrisiPredmet(p);

			dispose();
		}
			
		});
		
		
		odustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
			
		
		panBtn.add(potvrdi);
		panBtn.add(Box.createRigidArea(new Dimension(70,25)));
		panBtn.add(odustani);
		//panel.add(panBtn);
		
		add(pandlt, BorderLayout.CENTER);
		add(panBtn,BorderLayout.SOUTH);
		
	}
	
	
	
	
}
