package listeneri;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFocusListener3 implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern pattern = Pattern.compile("[A-Za-z]{2}[-][0-9]{1,3}[-][0-9]{4}");
		
		if(!pattern.matcher(txt.getText()).matches()  && !txt.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan broj indeksa u formatu 'RA-XXX-YYY'!");
			txt.setText("");
			txt.requestFocus();
		}
	}

	
	
}
