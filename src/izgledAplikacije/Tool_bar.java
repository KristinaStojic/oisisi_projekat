package izgledAplikacije;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import com.sun.glass.events.KeyEvent;

public class Tool_bar extends JToolBar{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Tool_bar() {
	
	Add_Action dodaj = new Add_Action();
	JButton btn1 = new JButton(dodaj);
	btn1.setToolTipText("Dodaj");
	add(btn1);
	
	btn1.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
    KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK), "Dodaj");
	addSeparator();
	
	
	Insert_Action izmeni = new Insert_Action();
	JButton btn2 = new JButton(izmeni);
	btn2.setToolTipText("Izmeni");
	btn2.setIcon(new ImageIcon("imgs/olovka.jpg"));
	add(btn2);
	btn2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	        KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK), "Izmeni");
	addSeparator();
	
	
	

	Delete_Action izbrisi = new Delete_Action();
	JButton btn3 = new JButton(izbrisi);
	btn3.setToolTipText("Obrisi");
	add(btn3);
	btn3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
	        KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK), "Obrisi");
	setFloatable(false);
	
	
	
	JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);
	panBottom.add(Box.createGlue());
	JTextField trazi = new JTextField();
	panBottom.add(trazi);
	trazi.setMaximumSize(new Dimension(5000,100));
	add(panBottom);
	
	
	JButton Btn4 = new JButton();
	Btn4.setToolTipText("Pretrazi");
	Btn4.setIcon(new ImageIcon("imgs/search.jpg"));
	add(Btn4);
	
	JToolBar toolbar = new JToolBar();
	toolbar.add(dodaj);
	
	setVisible(true);
	}
}
