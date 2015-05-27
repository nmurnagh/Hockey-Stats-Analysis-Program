import java.io.Serializable;
import java.util.ArrayList;

public class HockeyPlayer implements Serializable, Comparable<HockeyPlayer> {

	private static final long serialVersionUID = 4633272108937669018L;
	
	//Declarations
	private String position;
	private String name;
	private String team;
	private int gamesPlayed;
	private int goals;
	private int assists;
	private int plusminus;
	private int pims;
	private int shots;
	private int hits;
	private int blocks;
	private int takeaways;
	private int powerplay;
	private int shorthanded;
	private int gameWinning;
	private int timeOnIce;
	private double ranking;
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getPlusminus() {
		return plusminus;
	}
	public void setPlusminus(int plusminus) {
		this.plusminus = plusminus;
	}
	public int getPims() {
		return pims;
	}
	public void setPims(int pims) {
		this.pims = pims;
	}
	public int getShots() {
		return shots;
	}
	public void setShots(int shots) {
		this.shots = shots;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getBlocks() {
		return blocks;
	}
	public void setBlocks(int blocks) {
		this.blocks = blocks;
	}
	public int getTakeaways() {
		return takeaways;
	}
	public void setTakeaways(int takeaways) {
		this.takeaways = takeaways;
	}
	public int getPowerplay() {
		return powerplay;
	}
	public void setPowerplay(int powerplay) {
		this.powerplay = powerplay;
	}
	public int getShorthanded() {
		return shorthanded;
	}
	public void setShorthanded(int shorthanded) {
		this.shorthanded = shorthanded;
	}
	public int getGameWinning() {
		return gameWinning;
	}
	public void setGameWinning(int gameWinning) {
		this.gameWinning = gameWinning;
	}
	public int getTimeOnIce() {
		return timeOnIce;
	}
	public void setTimeOnIce(int timeOnIce) {
		this.timeOnIce = timeOnIce;
	}
	public double getRanking() {
		return ranking;
	}
	public void setRanking(double ranking) {
		this.ranking = ranking;
	}
	
	public static void calculateRanking(ArrayList<HockeyPlayer> playerList, Statistics leagueStats, Boolean[] selectedStats) {
		
		for(HockeyPlayer player: playerList) {
			
			double rank = 0;
			
			if (selectedStats[0] = true) {
				rank += ((player.getGoals()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgGoals())/ leagueStats.getStdGoals();
			}
			if (selectedStats[1] = true) {
				rank += ((player.getAssists()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgAssists())/ leagueStats.getStdAssists();
			}
			if (selectedStats[2] = true) {
				rank += ((player.getPlusminus()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPlusminus())/ leagueStats.getStdPlusminus();
			}
			if (selectedStats[3] = true) {
				rank += ((player.getPims()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPims())/ leagueStats.getStdPims();
			}
			if (selectedStats[4] = true) {
				rank += ((player.getShots()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgShots())/ leagueStats.getStdShots();
			}
			if (selectedStats[5] = true) {
				rank += ((player.getHits()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgHits())/ leagueStats.getStdHits();
			}
			if (selectedStats[6] = true) {
				rank += ((player.getBlocks()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgBlocks())/ leagueStats.getStdBlocks();
			}
			if (selectedStats[7] = true) {
				rank += ((player.getTakeaways()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgTakeaways())/ leagueStats.getStdTakeaways();
			}
			if (selectedStats[8] = true) {
				rank += ((player.getPowerplay()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPowerplay())/ leagueStats.getStdPowerplay();
			}
			if (selectedStats[9] = true) {
				rank += ((player.getShorthanded()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgShorthanded())/ leagueStats.getStdShorthanded();
			}
			if (selectedStats[10] = true) {
				rank += ((player.getGameWinning()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgGameWinning())/ leagueStats.getStdGameWinning();
			}
			
			player.setRanking(rank);
			
		}
	}

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
