package izgledAplikacije;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

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
				//this.setAutoCreateRowSorter(true);
				TableRowSorter<AbstractTableModelStudenti> sorter = new TableRowSorter<AbstractTableModelStudenti>(modelStudenti);
				ComparatorSortiranje comp = new ComparatorSortiranje();
				sorter.setComparator(0, comp);
				this.setRowSorter(sorter);
				break;
		case Profesori:
				AbstractTableModelProfesori modelProfesori = new AbstractTableModelProfesori();
				this.setModel(modelProfesori);
				this.setAutoCreateRowSorter(true);
				break;
		
		case Predmeti:
			AbstractTableModelPredmeti modelPredmeti= new AbstractTableModelPredmeti();
			this.setAutoCreateRowSorter(true);
			this.setModel(modelPredmeti	);
			TableRowSorter<AbstractTableModelPredmeti> sorterPred = new TableRowSorter<AbstractTableModelPredmeti>(modelPredmeti);
			ComparatorSortiranjePredmeta compPred = new ComparatorSortiranjePredmeta();
			sorterPred.setComparator(0, compPred);
			this.setRowSorter(sorterPred);
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
