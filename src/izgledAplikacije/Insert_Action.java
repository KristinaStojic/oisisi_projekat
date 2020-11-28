package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class Insert_Action extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Insert_Action() {
		putValue(MNEMONIC_KEY, KeyEvent.VK_I);
		putValue(SHORT_DESCRIPTION, "Izmeni");
		putValue(SMALL_ICON, new ImageIcon("imgs/search.jpg"));
		//putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Pritisnuto dugme");
	

}
}
