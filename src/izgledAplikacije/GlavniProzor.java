package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;



public class GlavniProzor extends JFrame {
	
	private static GlavniProzor instance = null;
	
	private GlavniProzor() {
		initialise();
	}
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected MyTabbedPane tabbedPane;
	
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
		
		ToolBar tool = new ToolBar();
		this.add(tool, BorderLayout.NORTH);

		StatusBar status = new StatusBar();
		this.add(status, BorderLayout.SOUTH);
		
		tabbedPane = new MyTabbedPane();
		this.add(tabbedPane, BorderLayout.CENTER);
		
    }
	
	public static GlavniProzor getInstance() {
		if(instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
	}
	
	public void azurirajPrikaz(String str, int i) {
		tabbedPane.azurirajPrikazStudenata(str, i);
		tabbedPane.azurirajPrikazProfesora(str, i);
		validate();
	}
 
	
}
