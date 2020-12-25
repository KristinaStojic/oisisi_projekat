package listeneri;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFocusListener5 implements FocusListener {

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		
		JTextField txt = (JTextField) e.getComponent();
		Pattern pattern = Pattern.compile("[A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*[0-9]*[,_ ][A-Z|a-z|ž|Ž|Đ|đ|Š|š|ć|Ć|č|Č_ ]*");

		if(!pattern.matcher(txt.getText()).matches() && !txt.getText().trim().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravnu adresu u formatu NAZIV_ULICE BROJ, NAZIV_GRADA");
			txt.setText("");
			txt.requestFocus();
		}
	}

}
