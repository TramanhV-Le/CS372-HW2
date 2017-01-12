import java.util.ArrayList;
/**
 * DESCRIPTION: Allows City Hall to have a name and address
 * @author tle19
 * @see Building
 */
public class CityHall extends Building {
	public CityHall(String newName, String newAddress){
		name = newName;
		address = newAddress;
	}
	public ArrayList<String>occupants = new ArrayList<String>();
	/**
	 * DESCRIPTION: Takes the array list and allow occupants to be added and display their names.
	 * @param name
	 */
	public void addOcc(String name) {
		if(occupants.contains(name)) {}
		else 
			occupants.add(name);
	}
	public void removeOcc(String name) {
		occupants.remove(name);
	}
	public void showOcc() {
		System.out.printf("\nNumber of occupants in City Hall: \n");
		for(String oc:occupants)
			System.out.printf(" %s \n",oc);
	}

}
