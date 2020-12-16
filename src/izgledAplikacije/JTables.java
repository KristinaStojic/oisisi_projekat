package izgledAplikacije;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import izgledAplikacije.MyTabbedPane.Tab;

public class JTables extends JTable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JTables(Tab t) {
		switch(t) {
		case Studenti:
				AbstractTableModelStudenti modelStudenti = new AbstractTableModelStudenti();
				this.setModel(modelStudenti);
				break;
		}
	}
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	
}
