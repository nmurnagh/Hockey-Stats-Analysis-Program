package gui;

import java.util.EventObject;

/**
 * Holds the data extracted from the input panel
 * 
 * @author Nathan Murnaghan
 *
 */
public class InputPanelEvent extends EventObject {
	
	private Integer minGames;
	private Boolean[] selectedStats;

	public InputPanelEvent(Object source, Integer minGames, Boolean[] selectedStats) {
		super(source);
		this.minGames = minGames;
		this.selectedStats = selectedStats;
		
	}

	public Integer getMinGames() {
		return minGames;
	}

	public Boolean[] getSelectedStats() {
		return selectedStats;
	}
	
	

}
