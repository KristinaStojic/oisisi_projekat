package izgledAplikacije;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.Predmet;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private List<Predmet> predmeti = new ArrayList<Predmet>();

    public AbstractTableModelPredmeti() {
		//predmeti = BazaPredmeta.getInstance().getPredmeti();
		/*for(Predmet p: predmeti) {
			System.out.println(p.getNaziv_predmeta());
		}*/
	}
	
	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		
	}

	
	@Override
    public Class<?> getColumnClass(int columnIndex) {
        /*if (BazaPredmeta.getInstance().getPredmeti().size() == 0) {
            return Object.class;
        }
        return BazaPredmeta.getInstance().getValueAt(0, columnIndex).getClass();*/
		
	    if(columnIndex == 2 || columnIndex == 3) {
			return Integer.class;
		}else {
			return String.class;
		}
    }
	

}
