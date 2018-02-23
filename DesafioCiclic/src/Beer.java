/**
 * 
 */

/**
 *	Class containing the Beer attributes.
 * @author Victor
 */
public class Beer {
	private String name;
	private int maxTemp, minTemp;
	
	public Beer(String name, int minTemp, int maxTemp){
		this.name = name;
		this.maxTemp = maxTemp;
		this.minTemp = minTemp;
	}
	
	public int getMinTemp(){
		return minTemp;
	}
	
	public int getMaxTemp(){
		return maxTemp;
	}
	
	public String getName(){
		return name;
	}
}
