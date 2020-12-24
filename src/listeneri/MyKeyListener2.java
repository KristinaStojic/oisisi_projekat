package listeneri;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyKeyListener2 implements KeyListener{
	
	int num = 0;
	String unos;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		if (e.isActionKey() || e.getKeyCode() == KeyEvent.VK_ENTER
				|| e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			return;
		}
		
		JTextField txt = (JTextField) e.getComponent();
		if(txt.getText().length() == 10) {
			Pattern pattern = Pattern.compile("[0-3][0-9][-](0[1-9]|1[012])[-][0-2][0-9][0-9][0-9]");
					
			if(!pattern.matcher(txt.getText()).matches()) {
				JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd-mm-yyyy!");
				num = 0;
				JTextField txt1 = (JTextField) e.getComponent();
				txt1.setText("");
			}
		}
	}

	
	
}
