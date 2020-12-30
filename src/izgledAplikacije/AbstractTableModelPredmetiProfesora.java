package izgledAplikacije;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmetiProfesora;

public class AbstractTableModelPredmetiProfesora extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return BazaPredmetiProfesora.getInstance().getPredmetiProfesora().size();
	}

	@Override
	public int getColumnCount() {
		return BazaPredmetiProfesora.getInstance().getColumnCount();
	}

	public String getColumnName(int column) {
		return BazaPredmetiProfesora.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmetiProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
