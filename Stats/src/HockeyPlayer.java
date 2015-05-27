import java.io.Serializable;

public class HockeyPlayer implements Serializable {

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