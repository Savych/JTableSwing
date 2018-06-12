import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class PersonModel implements TableModel {
	private ArrayList<TableModelListener> listeners;
	
	public PersonModel() {
		listeners = new ArrayList<TableModelListener>();
	}
	
	@Override
	public void addTableModelListener(TableModelListener l) {	
		listeners.add(l);
	}

	@Override
	public Class<?> getColumnClass(int arg0) {
		return String.class;
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public String getColumnName(int index) {
		switch(index) {
		case 0:
			return "Name";
		case 1:
			return "Surname";
		} return null;
	}

	@Override
	public int getRowCount() {
		return Main.persons.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0:
			return Main.persons.get(row).getName();
		case 1: 
			return Main.persons.get(row).getSurname();
		} return null;
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return true;
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	@Override
	public void setValueAt(Object value, int row, int col) {
		switch(col) {
		case 0:
			Main.persons.get(row).setName((String) value);
			break;
		case 1:
			Main.persons.get(row).setSurname((String) value);
			break;
		}
	}	
}
