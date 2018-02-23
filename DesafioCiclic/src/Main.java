import java.util.HashMap;


/**
 *	Main class that initializes the hash and communicates with the UserInteraction class.
 * @author Victor
 */
public class Main {
	
	/**
	 * Method that initializes the hash with default values.
	 * @return The initialized hash
	 */
	private static HashMap<String, Beer> startHashDefault(){
		HashMap<String, Beer> hash = new HashMap<>();
		
		hash.put("PILSEN", new Beer("PILSEN", -2, 4));
		hash.put("WEIZENBIER", new Beer("WEIZENBIER", -4, 6));
		hash.put("IPA", new Beer("IPA", -7, 10));
		hash.put("IMPERIAL STOUT", new Beer("IMPERIAL STOUT", -10, 13));
		
		return hash;
	}

	/**
	 * Main method.
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Beer> hash = startHashDefault();
		UserInteraction ui = new UserInteraction(hash);
		
		ui.printUsage();
		
		int exit = 0;
		while(exit != -1){
			exit = ui.readInput();
		}
	}

}
