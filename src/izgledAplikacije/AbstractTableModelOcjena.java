package izgledAplikacije;

import javax.swing.table.AbstractTableModel;

import model.BazaOcjena;

public class AbstractTableModelOcjena extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaOcjena.getInstance().getOcene().size();
	}

	@Override
	public int getColumnCount() {
		return BazaOcjena.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaOcjena.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaOcjena.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
