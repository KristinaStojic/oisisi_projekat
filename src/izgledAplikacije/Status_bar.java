package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Status_bar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Status_bar() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel label = new JLabel("Studentska sluzba");
		
		Date dNow = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm MM.dd.yyy ");
	    JLabel clock = new JLabel(ft.format(dNow));
	    
	
		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.WEST);
		this.add(clock,BorderLayout.EAST);

	}
}
