package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



public class Glavni_prozor extends JFrame {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Glavni_prozor() {
    	Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
    	int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setSize(screenWidth / 4*3  , screenHeight / 4*3);
        setTitle("Studentska služba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        Menu_bar menu = new Menu_bar();
		this.setJMenuBar(menu);
//<<<<<<< HEAD
		
		Tool_bar tool = new Tool_bar();
		this.add(tool, BorderLayout.NORTH);
    	
//=======

		Status_bar status = new Status_bar();
		this.add(status, BorderLayout.SOUTH);
//>>>>>>> 7b8fe3c1e1493cd9798e7e2750993c3696353677
    }
    
}
