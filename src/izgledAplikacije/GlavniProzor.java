package izgledAplikacije;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;



public class GlavniProzor extends JFrame {
	
	private static GlavniProzor instance = null;
	
	private GlavniProzor() {
		Locale.setDefault(new Locale("sr", "RS"));
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
	}
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTabbedPane tabbedPane;
	
	public ResourceBundle resourceBundle;

	MenuBar menu;
	StatusBar status;

	

	
	private void initialise() {
    	Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
    	int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        
        setSize(screenWidth / 4*3  , screenHeight / 4*3);
        setTitle("Studentska služba");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        

        	menu = new MenuBar();
      		this.setJMenuBar(menu);
      		
      		ToolBar tool = new ToolBar();
      		this.add(tool, BorderLayout.NORTH);

      		status = new StatusBar();
      		this.add(status, BorderLayout.SOUTH);
      		
      		tabbedPane = new MyTabbedPane();
      		this.add(tabbedPane, BorderLayout.CENTER);


        
        
this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				JFrame frame=(JFrame) e.getComponent();
				int a=JOptionPane.showConfirmDialog(null, "Da li ste sigurni da zelite da zatvorite aplikaciju ?");
				if(a==JOptionPane.YES_OPTION) {
					try {
						BazaStudenata.getInstance().saveDataStudentTxt();
						BazaProfesora.getInstance().saveDataProfesorTxt();
						BazaPredmeta.getInstance().saveDataPredmetTxt();
						GlavniProzor.getInstance().azurirajPrikaz("DODAJ", -1);
						
					}catch (Exception e2) {
						e2.printStackTrace();
					}
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				}
				else {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
    }
	
	public static GlavniProzor getInstance() {
		if(instance == null) {
			instance = new GlavniProzor();
			instance.initialise();
		}
		return instance;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}
	
	public void azurirajPrikaz(String str, int i) {
		tabbedPane.azurirajPrikazStudenata(str, i);
		tabbedPane.azurirajPrikazProfesora(str, i);
		tabbedPane.azurirajPrikazPredmeta(str, i);
		validate();
	}
 
	public void changeLanguage() {
	
		resourceBundle = ResourceBundle.getBundle("MessageResources.MessageResources", Locale.getDefault());
		setTitle(resourceBundle.getString("Naslov"));
		 
		menu.initMenu();
		status.initStatus();
		tabbedPane.initTab();
	}
	
}
