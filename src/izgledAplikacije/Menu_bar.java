package izgledAplikacije;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class Menu_bar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Menu_bar() {
		JMenu file = new JMenu("File");
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		file.setMnemonic(KeyEvent.VK_F);
		Icon icon = new ImageIcon("imgs/Plus_sign.jpg");
		JMenuItem miNew = new JMenuItem("New", icon);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		icon = new ImageIcon("imgs/close.jpg");
		JMenuItem miClose = new JMenuItem("Close", icon);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		icon = new ImageIcon("imgs/edit.jpg");
		JMenuItem miEdit = new JMenuItem("Edit", icon);
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		icon = new ImageIcon("imgs/Redx.jpg");
		JMenuItem miDelete = new JMenuItem("Delete", icon);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("imgs/help.jpg");
		JMenuItem miHelp = new JMenuItem("Help", icon);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		icon = new ImageIcon("imgs/about.jpg");
		JMenuItem miAbout = new JMenuItem("About", icon);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}
}
