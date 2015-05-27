import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DataHandling {
	
	public static ArrayList<HockeyPlayer> loadPlayers() {
		ArrayList<HockeyPlayer> playerList = new ArrayList<HockeyPlayer>();
		
		try {
			FileInputStream fs = new FileInputStream("stats.ser");
			ObjectInputStream os = new ObjectInputStream(fs);
			
			int num = os.readInt();
			
			for(int i=0; i < num; i++) {
				playerList.add((HockeyPlayer)os.readObject());
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
	
	public static ArrayList<HockeyPlayer> playerFiltering(ArrayList<HockeyPlayer> masterList, Scanner scan) {
		
		ArrayList<HockeyPlayer> filteredList = new ArrayList<HockeyPlayer>();
		
		System.out.println("Input minimum games played to be included in the analysis (Use 1 to include all players)");
		int gamesReq = scan.nextInt();
		
		for(HockeyPlayer player: masterList) {
			if(player.getGamesPlayed() >= gamesReq) {
				filteredList.add(player);
			}
		}
		
		return filteredList;
	}
	
	public static Statistics calcLeagueStats(ArrayList<HockeyPlayer> playerList) {
		
		Statistics leagueStats = new Statistics();
		
		int goals = 0;
		int assists = 0;
		int plusminus = 0;
		int pims = 0;
		int shots = 0;
		int hits = 0;
		int blocks = 0;
		int takeaways = 0;
		int powerplay = 0;
		int shorthanded = 0;
		int gameWinning = 0;
		int gamesPlayed = 0;
		
		for (HockeyPlayer player: playerList) {
			goals += player.getGoals();
			assists += player.getAssists();
			plusminus += player.getPlusminus();
			pims += player.getPims();
			shots += player.getShots();
			hits += player.getHits();
			blocks += player.getBlocks();
			takeaways += player.getTakeaways();
			powerplay += player.getPowerplay();
			shorthanded += player.getShorthanded();
			gameWinning += player.getGameWinning();
			gamesPlayed += player.getGamesPlayed();
		}
		
		leagueStats.setAvgGoals((goals*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgAssists((assists*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgPlusminus((plusminus*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgPims((pims*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgShots((shots*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgHits((hits*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgBlocks((blocks*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgTakeaways((takeaways*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgPowerplay((powerplay*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgShorthanded((shorthanded*1.0)/(gamesPlayed*1.0));
		leagueStats.setAvgGameWinning((gameWinning*1.0)/(gamesPlayed*1.0));
		
		double stdgoals = 0;
		double stdassists = 0;
		double stdplusminus = 0;
		double stdpims = 0;
		double stdshots = 0;
		double stdhits = 0;
		double stdblocks = 0;
		double stdtakeaways = 0;
		double stdpowerplay = 0;
		double stdshorthanded = 0;
		double stdgameWinning = 0;
		
		for (HockeyPlayer player: playerList) {
			stdgoals += Math.pow((player.getGoals()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgGoals(),2);
			stdassists += Math.pow((player.getAssists()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgAssists(),2);
			stdplusminus += Math.pow((player.getPlusminus()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPlusminus(),2);
			stdpims += Math.pow((player.getPims()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPims(),2);
			stdshots += Math.pow((player.getShots()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgShots(),2);
			stdhits += Math.pow((player.getHits()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgHits(),2);
			stdblocks += Math.pow((player.getBlocks()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgBlocks(),2);
			stdtakeaways += Math.pow((player.getTakeaways()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgTakeaways(),2);
			stdpowerplay += Math.pow((player.getPowerplay()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgPowerplay(),2);
			stdshorthanded += Math.pow((player.getShorthanded()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgShorthanded(),2);
			stdgameWinning += Math.pow((player.getGameWinning()*1.0)/(player.getGamesPlayed()*1.0) - leagueStats.getAvgGameWinning(),2);
		}
		
		leagueStats.setStdGoals(Math.sqrt(stdgoals/playerList.size()));
		leagueStats.setStdAssists(Math.sqrt(stdassists/playerList.size()));
		leagueStats.setStdPlusminus(Math.sqrt(stdplusminus/playerList.size()));
		leagueStats.setStdPims(Math.sqrt(stdpims/playerList.size()));
		leagueStats.setStdShots(Math.sqrt(stdshots/playerList.size()));
		leagueStats.setStdHits(Math.sqrt(stdhits/playerList.size()));
		leagueStats.setStdBlocks(Math.sqrt(stdblocks/playerList.size()));
		leagueStats.setStdTakeaways(Math.sqrt(stdtakeaways/playerList.size()));
		leagueStats.setStdPowerplay(Math.sqrt(stdpowerplay/playerList.size()));
		leagueStats.setStdShorthanded(Math.sqrt(stdshorthanded/playerList.size()));
		leagueStats.setStdGameWinning(Math.sqrt(stdgameWinning/playerList.size()));
		
		return leagueStats;
	}

	public static Boolean[] statSelecting(Scanner scan) {
		
		Boolean[] selectedStats = new Boolean[11];
		
		scan.nextLine();
		
		System.out.println("Include goals in the analysis? (y or n)");
		String goal = scan.nextLine().trim().toLowerCase();
		if(goal.equals("y")) {
			selectedStats[0] = true;
		} else {
			selectedStats[0] = false;
		}
		
		System.out.println("Include assists in the analysis? (y or n)");
		String assist = scan.nextLine().trim().toLowerCase();
		if(assist.equals("y")) {
			selectedStats[1] = true;
		} else {
			selectedStats[1] = false;
		}
		
		System.out.println("Include plus/minus in the analysis? (y or n)");
		String plusminus = scan.nextLine().trim().toLowerCase();
		if(plusminus.equals("y")) {
			selectedStats[2] = true;
		} else {
			selectedStats[2] = false;
		}
		
		System.out.println("Include PIMs in the analysis? (y or n)");
		String pims = scan.nextLine().trim().toLowerCase();
		if(pims.equals("y")) {
			selectedStats[3] = true;
		} else {
			selectedStats[3] = false;
		}
		
		System.out.println("Include shots in the analysis? (y or n)");
		String shot = scan.nextLine().trim().toLowerCase();
		if(shot.equals("y")) {
			selectedStats[4] = true;
		} else {
			selectedStats[4] = false;
		}
		
		System.out.println("Include hits in the analysis? (y or n)");
		String hit = scan.nextLine().trim().toLowerCase();
		if(hit.equals("y")) {
			selectedStats[5] = true;
		} else {
			selectedStats[5] = false;
		}
		
		System.out.println("Include blocks in the analysis? (y or n)");
		String block = scan.nextLine().trim().toLowerCase();
		if(block.equals("y")) {
			selectedStats[6] = true;
		} else {
			selectedStats[6] = false;
		}
		
		System.out.println("Include takeaways in the analysis? (y or n)");
		String takeaway = scan.nextLine().trim().toLowerCase();
		if(takeaway.equals("y")) {
			selectedStats[7] = true;
		} else {
			selectedStats[7] = false;
		}
		
		System.out.println("Include powerplay points in the analysis? (y or n)");
		String ppp = scan.nextLine().trim().toLowerCase();
		if(ppp.equals("y")) {
			selectedStats[8] = true;
		} else {
			selectedStats[8] = false;
		}
		
		System.out.println("Include shorthanded points in the analysis? (y or n)");
		String shp = scan.nextLine().trim().toLowerCase();
		if(shp.equals("y")) {
			selectedStats[9] = true;
		} else {
			selectedStats[9] = false;
		}
		
		System.out.println("Include game winning goals in the analysis? (y or n)");
		String gwg = scan.nextLine().trim().toLowerCase();
		if(gwg.equals("y")) {
			selectedStats[10] = true;
		} else {
			selectedStats[10] = false;
		}
		
		return selectedStats;
		
	}
}
