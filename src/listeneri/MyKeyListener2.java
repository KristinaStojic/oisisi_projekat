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
		
		num++;
		char c = e.getKeyChar();
		unos += c;
		if(num == 10) {
			Pattern pattern = Pattern.compile("[0-3][0-9][-](0[1-9]|1[012])[-][0-2][0-9][0-9][0-9]");
					
			if(!pattern.matcher(unos).matches()) {
				JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd-mm-yyyy!");
				num = 0;
				JTextField txt = (JTextField) e.getComponent();
				txt.setText("");
			}
		}/*else if(num > 10) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			num = 0;
			JTextField txt = (JTextField) e.getComponent();
			txt.setText("");
		}
		/*if((c == KeyEvent.VK_DELETE) || (c == KeyEvent.VK_BACK_SPACE)) {
			num--;
		}
		
		if((num == 1) && (c != '0') && (c != '1') && (c != '2') && (c != '3')){
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!" + num);
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 2) && (c != '0') && (c != '1') && (c != '2') && (c != '3') && (c != '4') && (c != '5') && (c != '6') && (c != '7') && (c != '8') && (c != '9')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!" + num);
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 3) && (c != '.')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!" + num);
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 4) && (c != '0') && (c != '1')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 5) && (c != 0) && (c != '1') && (c != '2') && (c != '3') && (c != '4') && (c != '5') && (c != '6') && (c != '7') && (c != '8') && (c != '9')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 6) && (c != '.')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 7) && (c != '0') && (c != '1') && (c != '2')){
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 8) && (c != 0) && (c != '1') && (c != '2') && (c != '3') && (c != '4') && (c != '5') && (c != '6') && (c != '7') && (c != '8') && (c != '9')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 9) && (c != 0) && (c != '1') && (c != '2') && (c != '3') && (c != '4') && (c != '5') && (c != '6') && (c != '7') && (c != '8') && (c != '9')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else if((num == 10) && (c != 0) && (c != '1') && (c != '2') && (c != '3') && (c != '4') && (c != '5') && (c != '6') && (c != '7') && (c != '8') && (c != '9')) {
			JOptionPane.showMessageDialog(null, "Molimo unesite ispravan datum u formatu dd.mm.yyyy!");
			JTextField txt = (JTextField) e.getComponent();
			txt.setText(txt.getText().substring(0, txt.getText().length() - 1));
			num--;
		}else {
			num = 0;
		}*/
	}

	
	
}
