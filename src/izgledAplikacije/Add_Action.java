package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;



public class Add_Action extends AbstractAction{

		private static final long serialVersionUID = 1583426086994634757L;

		public Add_Action() {
			
			//putValue(MNEMONIC_KEY,KeyEvent.VK_N);
			putValue(SHORT_DESCRIPTION, "New");
			putValue(SMALL_ICON, new ImageIcon("imgs/insert.jpg"));
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.out.println("Pritisnuto dugme");
		

	}
	
	
	
}
