package listeneri;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFocusListener4 implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern pattern = Pattern.compile("[0-9]{4}");
		
		if(!pattern.matcher(txt.getText()).matches()) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravnu godinu!");
			txt.setText("");
			txt.requestFocus();
		}
	}
	
}
