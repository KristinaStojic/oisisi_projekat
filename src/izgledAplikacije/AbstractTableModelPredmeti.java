package izgledAplikacije;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaStudenata;

public class AbstractTableModelPredmeti extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
        if (BazaPredmeta.getInstance().getPredmeti().isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }
	

}
