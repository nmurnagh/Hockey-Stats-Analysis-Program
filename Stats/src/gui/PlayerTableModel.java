package gui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import data.HockeyPlayer;

/**
 * The table model that is used for the table on the right side of the main frame
 * 
 * @author Nathan Murnaghan
 *
 */

public class PlayerTableModel extends AbstractTableModel {
	
	private ArrayList<HockeyPlayer> playerList;
	private String[] labels;
	
	public PlayerTableModel() {
		
		labels = new String[] {"Rank","Name","Team","Position","GP","G","A","+/-","PIMs","Shots",
				"Hits","Blks","TKA","PPP","SHP","GWG","TOI/G"};
	}
	
	public String getColumnName(int col) {
		return labels[col];
	}
	
	public int getColumnCount() {
		return 17;
	}

	public int getRowCount() {
		return playerList.size();
	}

	public Object getValueAt(int row, int col) {
		
		HockeyPlayer player = playerList.get(row);
		
		switch(col) {
		case 0:
			return row;
		case 1:
			return player.getName();
		case 2:
			return player.getTeam();
		case 3:
			return player.getPosition();
		case 4:
			return player.getGamesPlayed();
		case 5:
			return player.getStats(labels[col]);
		case 6:
			return player.getStats(labels[col]);
		case 7:
			return player.getStats(labels[col]);
		case 8:
			return player.getStats(labels[col]);
		case 9:
			return player.getStats(labels[col]);
		case 10:
			return player.getStats(labels[col]);
		case 11:
			return player.getStats(labels[col]);
		case 12:
			return player.getStats(labels[col]);
		case 13:
			return player.getStats(labels[col]);
		case 14:
			return player.getStats(labels[col]);
		case 15:
			return player.getStats(labels[col]);
		case 16:
			return player.getTimeOnIcePerGame();
		}
		return null;
	}
	
	public void setData(ArrayList<HockeyPlayer> playerList) {
		this.playerList = playerList;
	}
	

}
