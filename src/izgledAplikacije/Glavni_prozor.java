package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class Glavni_prozor extends JFrame {
	
	private static Glavni_prozor instance = null;
	
	private Glavni_prozor() {
		initialise();
	}
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private void initialise() {
    	Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
    	int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setSize(screenWidth / 4*3  , screenHeight / 4*3);
        setTitle("Studentska slu�ba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        MenuBar menu = new MenuBar();
		this.setJMenuBar(menu);
		
		Tool_bar tool = new Tool_bar();
		this.add(tool, BorderLayout.NORTH);

		Status_bar status = new Status_bar();
		this.add(status, BorderLayout.SOUTH);
		
		MyTabbedPane tabbedPane = new MyTabbedPane();
		this.add(tabbedPane, BorderLayout.CENTER);
		
		tabbedPane = new MyTabbedPane();
		add(tabbedPane, BorderLayout.CENTER);
    }
	
	public static Glavni_prozor getInstance() {
		if(instance == null) {
			instance = new Glavni_prozor();
		}
		return instance;
	}
    
}
