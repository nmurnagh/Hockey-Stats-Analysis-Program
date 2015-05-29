import java.util.HashMap;

/**
 * Statistics - A class to hold the league statistics and the keys for the hashmaps
 * @author Nathan Murnaghan
 *
 */
public class Statistics {

	private HashMap<String, Double> averages;
	private HashMap<String, Double> standardDeviations;
	private String[] keys;

	/**
	 * Constructor that creates blank hashmaps with the proper keys
	 */
	public Statistics() {

		averages = new HashMap<String, Double>();
		standardDeviations = new HashMap<String, Double>();
		keys = new String[] { "goals", "assists", "plusminus", "pims", "shots",
				"hits", "blocks", "takeaways", "powerplay", "shorthanded",
				"gameWinning" };

		for (String myKey : keys) {
			averages.put(myKey, 0.0);
			standardDeviations.put(myKey, 0.0);
		}
	}

	public double getAverages(String key) {
		return averages.get(key);
	}

	public void setAverages(String key, Double value) {
		this.averages.put(key, value);
	}

	public double getStandardDeviations(String key) {
		return standardDeviations.get(key);
	}

	public void setStandardDeviations(String key, Double value) {
		this.standardDeviations.put(key, value);
	}

	public String getKeys(int idx) {
		return keys[idx];
	}

}
