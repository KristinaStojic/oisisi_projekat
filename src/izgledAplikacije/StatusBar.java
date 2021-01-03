package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StatusBar() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JLabel label = new JLabel(GlavniProzor.getInstance().getResourceBundle().getString("Naslov"));
		
		Date dNow = new Date();
	    SimpleDateFormat ft = new SimpleDateFormat ("hh:mm MM.dd.yyy ");
	    JLabel clock = new JLabel(ft.format(dNow));
	    
	    ActionListener al = new ActionListener(){
		      public void actionPerformed(ActionEvent ae){
		        clock.setText(ft.format(new java.util.Date()));
		      }
		};
		new javax.swing.Timer(1000,al).start();
	
		this.setLayout(new BorderLayout());
		this.add(label, BorderLayout.WEST);
		this.add(clock,BorderLayout.EAST);

	}
}
