package listeneri;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyKeyListener2 implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) e.getComponent();
		if (txt.getText().length() == 10) {
			JOptionPane.showMessageDialog(null, "Možete unijeti maksimalno 10 karaktera!");
			txt.setText(txt.getText().substring(0, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		
		JTextField txt = (JTextField) e.getComponent();
		Pattern pattern = Pattern.compile("[A-Z|0-9]*");
				
		if(!pattern.matcher(txt.getText()).matches()) {
			JOptionPane.showMessageDialog(null, "Dozvoljen je samo unos velikih slova i brojeva!");
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
		}

	}

}
