package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import data.HockeyPlayer;

/**
 * The table panel located on the right side of the main frame
 * 
 * @author Nathan Murnaghan
 *
 */

public class TablePanel extends JPanel {
	
	private JTable table;
	private PlayerTableModel tableModel;
		
	public TablePanel() {
		
		tableModel = new PlayerTableModel();
		table = new JTable(tableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
		
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
