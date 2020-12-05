package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

public class Delete_Action extends AbstractAction{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Delete_Action() {
		
		//putValue(MNEMONIC_KEY,KeyEvent.VK_D);
		putValue(SHORT_DESCRIPTION, "Delete");
		putValue(SMALL_ICON, new ImageIcon("imgs/delete.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Pritisnuto dugme");
	

}
}
