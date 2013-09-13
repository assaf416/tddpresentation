package reader.helpers;


import java.util.List;
import reader.model.*;
import javax.swing.table.AbstractTableModel;


@SuppressWarnings("serial")
public class ArticlesTableModel extends AbstractTableModel {
	
	
	
	private String[] columnNames = { "Author", "Title", "Link" }; 
	private Object[][] data = {}; // ...//same as before...

	public ArticlesTableModel( List<FeedMessage> data){
		Object[][] ret= {};
		FeedMessage msg;
		System.out.println("UUUUUU ======== UUUUUUU");
		for (int i=1;i<10;i++){
			msg = data.get(i);
			ret[i][0] = new String[]{msg.getAuthor(),msg.getTitle(),msg.getLink()};
			
			
			System.out.println("MESSAGE:");
			System.out.println(msg.toString());
			System.out.println("------------");
		}
		
		
		
//		this.data = data;
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.length;
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
		fireTableCellUpdated(row, col);
	}

}
