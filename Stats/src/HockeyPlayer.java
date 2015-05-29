import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * HockeyPlayer --- Contains the information and statistics of the hockey players
 * @author Nathan Murnaghan
 *
 */

public class HockeyPlayer implements Serializable, Comparable<HockeyPlayer> {

	private static final long serialVersionUID = 4633272108937669018L;
	private String position;
	private String name;
	private String team;
	private int gamesPlayed;
	private int timeOnIce;
	private HashMap<String, Integer> stats;
	private double ranking;

	public String getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}

	public String getTeam() {
		return team;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public int getTimeOnIce() {
		return timeOnIce;
	}

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}

	public int getStats(String key) {
		return stats.get(key);
	}

	/**
	 * Calculates a ranking for each hockey player by comparing their 
	 * statistics to league statistics
	 * @param playerList - Contains all the HockeyPlayer Objects
	 * @param leagueStats - Statistics object containing league statistics
	 * @param selectedStats - User specified statistics to be analyzed
	 */
	public static void calculateRanking(ArrayList<HockeyPlayer> playerList,
			Statistics leagueStats, Boolean[] selectedStats) {

		for (HockeyPlayer player : playerList) {

			double rank = 0;

			for (int i = 0; i < 11; i++) {
				if (selectedStats[i] == true) {
					rank += ((player.getStats(leagueStats.getKeys(i)) * 1.0)
							/ (player.getGamesPlayed() * 1.0) - leagueStats
								.getAverages(leagueStats.getKeys(i)))
							/ leagueStats.getStandardDeviations(leagueStats
									.getKeys(i));
				}
			}

			player.setRanking(rank);

		}
	}

	/**
	 * Sets which object property the collections sort will use
	 */
	public int compareTo(HockeyPlayer o) {
		if (this.getRanking() == o.getRanking()) {
			return 0;
		} else if (this.getRanking() < o.getRanking()) {
			return 1;
		} else {
			return -1;
		}
	}

}
