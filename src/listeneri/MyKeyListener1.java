package listeneri;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyKeyListener1 implements KeyListener {

	@Override
	public void keyTyped(KeyEvent e) {
		
				
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		
		char c = e.getKeyChar();
		
		if (!Character.isLetter(c) && !(c ==KeyEvent.VK_BACK_SPACE) && !(c == KeyEvent.VK_SPACE) && !(c == KeyEvent.VK_CAPS_LOCK)) {
			JOptionPane.showMessageDialog(null, "Dozvoljen je unos samo slova!");
			//JTextField txt = (JTextField) e.getComponent();
			//txt.setText(txt.getText().substring(0, txt.getText().length()));
		
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		JTextField txt = (JTextField) e.getComponent();
		if (txt.getText().length() == 15) {
			JOptionPane.showMessageDialog(null, "Možete unijeti maksimalno 15 karaktera!");
			txt.setText(txt.getText().substring(0, 13));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
