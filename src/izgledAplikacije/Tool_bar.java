package izgledAplikacije;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Tool_bar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tool_bar() {
	
	//setBorder(BorderFactory.createLineBorder(Color.BLACK);
		
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
	setFloatable(false);
	
	
	
	JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);
	panBottom.add(Box.createGlue());
	panBottom.add(Box.createHorizontalStrut(1060));
	JTextField trazi = new JTextField();
	panBottom.add(trazi);
	add(panBottom);
	
	
	JButton Btn4 = new JButton();
	Btn4.setToolTipText("Pretrazi");
	Btn4.setIcon(new ImageIcon("imgs/search.jpg"));
	add(Btn4);
	
	setVisible(true);
	}
}
