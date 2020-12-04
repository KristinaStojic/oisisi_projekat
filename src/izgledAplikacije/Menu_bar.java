package izgledAplikacije;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		Add_Action dodaj = new Add_Action();
		//Icon icon = new ImageIcon("imgs/Plus_sign.jpg");
		JMenuItem miNew = new JMenuItem();
		miNew.setAction(dodaj);
		miNew.setText("New");
		//miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		Icon icon = new ImageIcon("imgs/close.jpg");
		JMenuItem miClose = new JMenuItem("Close", icon);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		//icon = new ImageIcon("imgs/edit.jpg");
		JMenuItem miEdit = new JMenuItem();
		//miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		Insert_Action ed = new Insert_Action();
		miEdit.setAction(ed);
		miEdit.setText("Edit");
		//icon = new ImageIcon("imgs/Redx.jpg");
		JMenuItem miDelete = new JMenuItem();
		Delete_Action del = new Delete_Action();
		miDelete.setAction(del);
		miDelete.setText("Delete");
		//miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("imgs/help.jpg");
		JMenuItem miHelp = new JMenuItem("Help", icon);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help(Glavni_prozor.getInstance());
				help.setVisible(true);
			}
			
		});
		icon = new ImageIcon("imgs/about.jpg");
		JMenuItem miAbout = new JMenuItem("About", icon);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				About about = new About(Glavni_prozor.getInstance());
				about.setVisible(true);
			}
			
		});
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		add(file);
		add(edit);
		add(help);
	}
}
