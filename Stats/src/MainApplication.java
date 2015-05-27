import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MainApplication {

	static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		ArrayList<HockeyPlayer> masterList = DataHandling.loadPlayers();
		ArrayList<HockeyPlayer> filteredList = DataHandling.playerFiltering(
				masterList, scan);

		Statistics leagueStats = DataHandling.calcLeagueStats(filteredList);

		Boolean[] selectedStats = DataHandling.statSelecting(scan);

		HockeyPlayer.calculateRanking(filteredList, leagueStats, selectedStats);

		Collections.sort(filteredList);

		for (HockeyPlayer player : filteredList) {
			System.out.println(player.getName() + " - " + player.getTeam());
		}
	}

}
