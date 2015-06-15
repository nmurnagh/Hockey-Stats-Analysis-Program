package data;

import java.io.DataInput;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * DataHandling --- Handles data manipulation
 * 
 * @author Nathan Murnaghan
 */

public class DataHandling {

	/**
	 * Loads in player statistic database
	 * 
	 * @exception FileNotFound, IO, ClassNotFound
	 * @return ArrayList playerList containing all HockeyPlayer objects
	 */
	
	public static ArrayList<HockeyPlayer> loadPlayers() {
		ArrayList<HockeyPlayer> playerList = new ArrayList<HockeyPlayer>();

		try {
			ObjectInputStream os = new ObjectInputStream(DataHandling.class.getResourceAsStream("stats.ser"));

			int num = os.readInt();

			for (int i = 0; i < num; i++) {
				playerList.add((data.HockeyPlayer) os.readObject());
			}

			os.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return playerList;

	}

	/**
	 * Accepts masterList and filters it based on games played
	 * 
	 * @param masterList - A list of all the HockeyPlayer Objects
	 * @param minGames - minimum number of games required to be included in the list
	 * @return filteredList - A list with HockeyPlayer objects that have played
	 *         more than a user specified number of games
	 */
	public static ArrayList<HockeyPlayer> playerFiltering(
			ArrayList<HockeyPlayer> masterList, Integer minGames) {

		ArrayList<HockeyPlayer> filteredList = new ArrayList<HockeyPlayer>();

		for (HockeyPlayer player : masterList) {
			if (player.getGamesPlayed() >= minGames) {
				filteredList.add(player);
			}
		}

		return filteredList;
	}

	/**
	 * Calculates league average and standard deviation for each statistic
	 * 
	 * @param playerList - List of HockeyPlayer objects to extract statistics from
	 * @return leagueStats - A Statistics object containing the calculated
	 *         averages and standard deviations
	 */
	public static Statistics calcLeagueStats(ArrayList<HockeyPlayer> playerList) {

		Statistics leagueStats = new Statistics();

		// Calculates and sets league averages
		Integer[] counter = new Integer[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }; 

		for (HockeyPlayer player : playerList) {
			for (int i = 0; i < 11; i++) {
				counter[i] += player.getStats(leagueStats.getKeys(i));
			}
			counter[11] += player.getGamesPlayed();
		}

		for (int i = 0; i < 11; i++) {
			leagueStats.setAverages(leagueStats.getKeys(i), (counter[i] * 1.0
					/ counter[11] * 1.0));
		}

		// Calculates and sets standard deviation using averages
		Double[] stdcounter = new Double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0 }; // counter for each statistic

		for (HockeyPlayer player : playerList) {
			for (int i = 0; i < 11; i++) {
				stdcounter[i] += Math.pow(
						(player.getStats(leagueStats.getKeys(i)) * 1.0)
								/ (player.getGamesPlayed() * 1.0)
								- leagueStats.getAverages(leagueStats
										.getKeys(i)), 2);
			}
		}

		for (int i = 0; i < 11; i++) {
			leagueStats.setStandardDeviations(leagueStats.getKeys(i),
					Math.sqrt(stdcounter[i] / playerList.size()));
		}

		return leagueStats;
	}

}
