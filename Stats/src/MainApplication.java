import java.util.ArrayList;
import java.util.Collections;

public class MainApplication {

	public static void main(String[] args) {

		// Loads in database of player statistics
		ArrayList<HockeyPlayer> masterList = DataHandling.loadPlayers();

		// Filters out players by users specifications
		ArrayList<HockeyPlayer> filteredList = DataHandling
				.playerFiltering(masterList);

		// Calculates league averages and standard deviations with filtered list
		Statistics leagueStats = DataHandling.calcLeagueStats(filteredList);

		// Gets user to select which statistics to include in a ranking
		Boolean[] selectedStats = InputOutput.statSelecting();

		// Calculates player ranking
		HockeyPlayer.calculateRanking(filteredList, leagueStats, selectedStats);

		// Sorts arraylist by ranking
		Collections.sort(filteredList);

		// Outputs results
		InputOutput.displayResults(filteredList);

	}

}
