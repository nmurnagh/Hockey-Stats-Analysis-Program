import java.util.ArrayList;
import java.util.Scanner;

/**
 * Handles all of the input and output of the application
 * @author Nathan Murnaghan
 *
 */
public class InputOutput {

	static final Scanner scan = new Scanner(System.in);

	/**
	 * Gets user input of games played required to be include
	 * in the analysis
	 * @return gamesReq - int containing user specification
	 */
	public static int gamesRequired() {

		System.out
				.println("Input minimum games played to be included in the analysis (Use 1 to include all players)");
		int gamesReq = scan.nextInt();

		return gamesReq;

	}
	
	/**
	 * Gets user input of which statistics should be used in the analysis
	 * @return selectedStats - A boolean array containing an entry corresponding 
	 * to each of the possible statistics
	 */
	public static Boolean[] statSelecting() {

		Boolean[] selectedStats = new Boolean[11];

		scan.nextLine();

		System.out.println("Include goals in the analysis? (y or n)");
		String goal = scan.nextLine().trim().toLowerCase();
		if (goal.equals("y")) {
			selectedStats[0] = true;
		} else {
			selectedStats[0] = false;
		}

		System.out.println("Include assists in the analysis? (y or n)");
		String assist = scan.nextLine().trim().toLowerCase();
		if (assist.equals("y")) {
			selectedStats[1] = true;
		} else {
			selectedStats[1] = false;
		}

		System.out.println("Include plus/minus in the analysis? (y or n)");
		String plusminus = scan.nextLine().trim().toLowerCase();
		if (plusminus.equals("y")) {
			selectedStats[2] = true;
		} else {
			selectedStats[2] = false;
		}

		System.out.println("Include PIMs in the analysis? (y or n)");
		String pims = scan.nextLine().trim().toLowerCase();
		if (pims.equals("y")) {
			selectedStats[3] = true;
		} else {
			selectedStats[3] = false;
		}

		System.out.println("Include shots in the analysis? (y or n)");
		String shot = scan.nextLine().trim().toLowerCase();
		if (shot.equals("y")) {
			selectedStats[4] = true;
		} else {
			selectedStats[4] = false;
		}

		System.out.println("Include hits in the analysis? (y or n)");
		String hit = scan.nextLine().trim().toLowerCase();
		if (hit.equals("y")) {
			selectedStats[5] = true;
		} else {
			selectedStats[5] = false;
		}

		System.out.println("Include blocks in the analysis? (y or n)");
		String block = scan.nextLine().trim().toLowerCase();
		if (block.equals("y")) {
			selectedStats[6] = true;
		} else {
			selectedStats[6] = false;
		}

		System.out.println("Include takeaways in the analysis? (y or n)");
		String takeaway = scan.nextLine().trim().toLowerCase();
		if (takeaway.equals("y")) {
			selectedStats[7] = true;
		} else {
			selectedStats[7] = false;
		}

		System.out
				.println("Include powerplay points in the analysis? (y or n)");
		String ppp = scan.nextLine().trim().toLowerCase();
		if (ppp.equals("y")) {
			selectedStats[8] = true;
		} else {
			selectedStats[8] = false;
		}

		System.out
				.println("Include shorthanded points in the analysis? (y or n)");
		String shp = scan.nextLine().trim().toLowerCase();
		if (shp.equals("y")) {
			selectedStats[9] = true;
		} else {
			selectedStats[9] = false;
		}

		System.out
				.println("Include game winning goals in the analysis? (y or n)");
		String gwg = scan.nextLine().trim().toLowerCase();
		if (gwg.equals("y")) {
			selectedStats[10] = true;
		} else {
			selectedStats[10] = false;
		}

		return selectedStats;

	}
	
	/**
	 * Takes the sorted list of players and outputs it in console
	 * @param playerList - Arraylist of each of the HockeyPlayer objects
	 */
	public static void displayResults(ArrayList<HockeyPlayer> playerList) {

		for (HockeyPlayer player : playerList) {
			System.out.println(player.getName() + " - " + player.getTeam());
		}
	}
}
