import java.util.ArrayList;
/**
 * DESCRIPTION: Allows implementation for the School's address and name, as well as the people in School
 * @author tle19
 * @see Building
 */
public class School extends Building {
		public School(String newName, String newAddress){
			name = newName;
			address = newAddress;
		}
		public ArrayList<String>occupants = new ArrayList<String>();
		
		/**
		 * DESCRIPTION: Method calls the name of the occupants and their location.
		 * @param name
		 */	
		public void addOcc(String name) {
			occupants.add(name);
		}
		public void showOcc() {
			System.out.printf("\nNumber of occupants in School: \n");
			for(String oc:occupants)
				System.out.printf(" %s \n",oc);
		}

	}

