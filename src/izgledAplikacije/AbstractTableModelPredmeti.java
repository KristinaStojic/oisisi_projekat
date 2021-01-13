package izgledAplikacije;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.Predmet;
import model.Predmet.Semestar;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Predmet> predmeti = new ArrayList<Predmet>();

    public AbstractTableModelPredmeti() {
		predmeti = BazaPredmeta.getInstance().getPredmeti();
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
		//return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
		Predmet p = this.predmeti.get(rowIndex);
		switch(columnIndex) {
		case 0:
			return p.getSifra_predmeta();
		case 1:
			return p.getNaziv_predmeta();
		case 2:
			return p.getBroj_ESPB();
		case 3:
			return p.getGodina_izvodjenja();
		case 4:
			if(p.getSemestar() == Semestar.Zimski) {
				return "Zimski";
			}
			else {
				return "Letnji";
			}
			
			//return p.getSemestar();
		default:
			return null;
		}
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
