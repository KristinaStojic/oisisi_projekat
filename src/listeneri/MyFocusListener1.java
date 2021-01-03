package listeneri;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import izgledAplikacije.GlavniProzor;

public class MyFocusListener1 implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		Pattern pattern = Pattern.compile("[0-3][0-9][.](0[1-9]|1[012])[.][0-2][0-9][0-9][0-9][.]");
		
		if(!pattern.matcher(txt.getText()).matches()  && !txt.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, GlavniProzor.getInstance().getResourceBundle().getString("ispravanDatum"));
			txt.setText("");
			txt.requestFocus();
		}
	}

}
