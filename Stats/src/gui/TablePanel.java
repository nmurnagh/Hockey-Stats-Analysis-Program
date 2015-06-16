package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

import data.HockeyPlayer;

/**
 * The table panel located on the right side of the main frame
 * 
 * @author Nathan Murnaghan
 *
 */

public class TablePanel extends JTable {
	
	private JTable table;
	private PlayerTableModel tableModel;
		
	public TablePanel() {
		
		tableModel = new PlayerTableModel();
		table = new JTable(tableModel);

		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
		//Formatting of the table
		setBorder(BorderFactory.createEmptyBorder(12,0,10,10));
		
		TableColumn column = table.getColumnModel().getColumn(0);
		column.setPreferredWidth(50);
		TableColumn column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(150);
		
		for(int i=0;i<17;i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new CustomTableRenderer());
		}
		
		table.setShowGrid(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setRowHeight(25);
		
		table.getTableHeader().setFont(new Font("Arial",Font.PLAIN,15));
		
	}
	
	// Loads in the data set initially 
	public void setData(ArrayList<HockeyPlayer> playerList) {
		tableModel.setData(playerList);
	}
	
	// Loads in the filtered data set after run button push and refreshes
	public void refresh(ArrayList<HockeyPlayer> playerList) {
		tableModel.setData(playerList);
		tableModel.fireTableDataChanged();
	}
	
}

