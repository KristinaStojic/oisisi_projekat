package izgledAplikacije;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import dialozi.About;
import dialozi.Help;

public class MenuBar extends JMenuBar{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	About about;
	JMenu file;
	JMenuItem miNew;
	JMenuItem miClose;
	JMenu edit;
	JMenuItem miEdit;
	JMenuItem miDelete;
	JMenu help;
	JMenuItem miAbout;
	JMenuItem miHelp;
	JMenu administracija;
	JMenuItem mniSrpski;
	JMenuItem mniEngleski;
	
	public MenuBar() {
		file = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("mnuFile"));

		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		file.setMnemonic(KeyEvent.VK_F);
		AddAction dodaj = new AddAction();
		//Icon icon = new ImageIcon("imgs/Plus_sign.jpg");
		miNew = new JMenuItem();
		miNew.setAction(dodaj);
		miNew.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniNew"));
		miNew.setMnemonic(KeyEvent.VK_N);
		//miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

		Icon icon = new ImageIcon("imgs" + File.separator + "close.jpg");

		miClose = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniClose"), icon);

		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int izbor=JOptionPane.showConfirmDialog(null, GlavniProzor.getInstance().getResourceBundle().getString("potvrdaZatvaranja"));
				if(izbor==JOptionPane.YES_OPTION) {
					System.exit(-1);
				}
			}
		});
		file.add(miNew);
		file.addSeparator();
		file.add(miClose);
		
		
		edit = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("mnuEdit"));
		edit.setMnemonic(KeyEvent.VK_E);
		icon = new ImageIcon("imgs" + File.separator + "edit.jpg");
		miEdit = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniEdit"), icon);

		//miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		InsertAction ed = new InsertAction();
		miEdit.setAction(ed);
		miEdit.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniEdit"));
		miEdit.setMnemonic(KeyEvent.VK_E);
		//icon = new ImageIcon("imgs/Redx.jpg");

		miDelete = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniDelete"), icon);

		DeleteAction del = new DeleteAction();
		miDelete.setAction(del);
		miDelete.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniDelete"));
		miDelete.setMnemonic(KeyEvent.VK_D);
		//miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);

		help = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("mnuHelp"));
		help.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("imgs" + File.separator + "help.jpg");
		//miHelp = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniHelp"), icon);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("imgs" + File.separator + "help.jpg");
		miHelp = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniHelp"), icon);

		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Help help = new Help(GlavniProzor.getInstance());
				help.setVisible(true);
			}
			
		});
		miHelp.setMnemonic(KeyEvent.VK_H);
		icon = new ImageIcon("imgs" + File.separator + "about.jpg");

		miAbout = new JMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniAbout"), icon);

		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		miAbout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				about = new About(GlavniProzor.getInstance());
				about.setVisible(true);
			}
			
		});
		miAbout.setMnemonic(KeyEvent.VK_A);
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		
		
		administracija = new JMenu(GlavniProzor.getInstance().getResourceBundle().getString("mnuAdministracija"));
		
		mniSrpski = new JCheckBoxMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniSrpski"));
		mniSrpski.setSelected(true);
		mniSrpski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("sr", "RS"));
				GlavniProzor.getInstance().changeLanguage();
			}
		});
		
		
		mniEngleski = new JCheckBoxMenuItem(GlavniProzor.getInstance().getResourceBundle().getString("mniEngleski"));
		mniEngleski.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Locale.setDefault(new Locale("en", "US"));
				GlavniProzor.getInstance().changeLanguage();
				
			}
		});
		administracija.add(mniSrpski);
		administracija.add(mniEngleski);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(mniSrpski);
		bg.add(mniEngleski);
		
		add(file);
		add(edit);
		add(help);
		add(administracija);
	}
	
	public void initMenu() {
		file.setText(GlavniProzor.getInstance().getResourceBundle().getString("mnuFile"));
		miNew.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniNew"));
		miClose.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniClose"));
		edit.setText(GlavniProzor.getInstance().getResourceBundle().getString("mnuEdit"));
		miEdit.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniEdit"));
		miDelete.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniDelete"));
		help.setText(GlavniProzor.getInstance().getResourceBundle().getString("mnuHelp"));
		miAbout.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniAbout"));
		miHelp.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniHelp"));
		administracija.setText(GlavniProzor.getInstance().getResourceBundle().getString("mnuAdministracija"));
		mniSrpski.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniSrpski"));
		mniEngleski.setText(GlavniProzor.getInstance().getResourceBundle().getString("mniEngleski"));
	}
}
