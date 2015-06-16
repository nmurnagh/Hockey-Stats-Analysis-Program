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
	private int positionFilter;
	private String analysisType;

	public InputPanelEvent(Object source, Integer minGames, Boolean[] selectedStats, int positionFilter, String analysisType) {
		super(source);
		this.minGames = minGames;
		this.selectedStats = selectedStats;
		this.positionFilter = positionFilter;
		this.analysisType = analysisType;
	}

	public Integer getMinGames() {
		return minGames;
	}

	public Boolean[] getSelectedStats() {
		return selectedStats;
	}
	
	public int getPositionFilter() {
		return positionFilter;
	}

	public String getAnalysisType() {
		return analysisType;
	}

}
