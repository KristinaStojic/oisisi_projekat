package izgledAplikacije;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

public class InsertAction extends AbstractAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InsertAction() {
		
		//putValue(MNEMONIC_KEY,KeyEvent.VK_I);
		putValue(SHORT_DESCRIPTION, "Edit");
		putValue(SMALL_ICON, new ImageIcon("imgs" + File.separator +"search.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("Pritisnuto dugme");
	

}
}
