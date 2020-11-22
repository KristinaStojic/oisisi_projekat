package izgledAplikacije;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class Tool_bar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tool_bar() {
	JButton btn1 = new JButton();
	btn1.setToolTipText("Dodaj");
	btn1.setIcon(new ImageIcon("imgs/insert.jpg"));
	add(btn1);

	addSeparator();

	JButton btn2 = new JButton();
	btn2.setToolTipText("Izmeni");
	btn2.setIcon(new ImageIcon("imgs/olovka.jpg"));
	add(btn2);

	addSeparator();

	JButton Btn3 = new JButton();
	Btn3.setToolTipText("Obrisi");
	Btn3.setIcon(new ImageIcon("imgs/delete.jpg"));
	add(Btn3);
	
	addSeparator();
	
	setFloatable(false);
	}
}
