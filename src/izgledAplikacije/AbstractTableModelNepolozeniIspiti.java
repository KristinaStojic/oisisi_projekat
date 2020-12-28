package izgledAplikacije;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozeniIspiti;

public class AbstractTableModelNepolozeniIspiti extends AbstractTableModel{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaNepolozeniIspiti.getInstance().getNepolozeni().size();
	}

	@Override
	public int getColumnCount() {
		return BazaNepolozeniIspiti.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaNepolozeniIspiti.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaNepolozeniIspiti.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
