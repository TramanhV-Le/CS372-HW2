import java.util.ArrayList;
/**
 * DESCRIPTION: Calling all other classes in the City's main class, displaying the names, pay, and occupants of buildings.
 * @author tle19
 * Uses already-input names and information to display
 */
public class City {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonClass[] people = { new Police("Frank",58,5558565,Police.Rank.Chief), 
								 new Police("Tabitha",37,5559070,Police.Rank.Sargeant), 
								 new Police("Geoffrey",49,5552345,Police.Rank.Captain),
								 new Police("Ethan",26,5559779,Police.Rank.Patrol),
								 new Teacher("Tracy",21,7771234,8,"Math"),
								 new Teacher("Duncan",52,7774590,11,"English"),
								 new Teacher("Lucas",30,7774590,12,"French"),
								 new Kid("Nini",9,5440805,"Gummy Bears"),
								 new Kid("Esther",4,5441124,"Chocolate"),
								 new Kid("Kristen",15,5441124,"Starburst")};
		Building[] building = {  new CityHall("City Hall","123 Front St."), 
								 new School("Elementary School","987 Back St."),
								 new School("Middle School","453 East Ave."),
								 new School("High School","576 West Ave.")};
		
		/**
		 * DESCRIPTION: Takes the input length of occupants to display the values already assigned in PersonClass.
		 */
		System.out.printf("People in City: \n");
		for(int i=0; i < people.length; i++) {
			System.out.printf("%s, %d, %d \n", people[i].getName(), people[i].getAge(), people[i].getPhone());
		}
		System.out.printf("\nBuildings in City: \n");
		for(int i=0; i < building.length; i++) {
			System.out.printf("%s, %s \n", building[i].name, building[i].address);
		}
		String PolOfc1 = people[0].getName();
		String PolOfc2 = people[1].getName();
		String PolOfc3 = people[3].getName();
		CityHall c = (CityHall) building[0];
		c.addOcc(PolOfc1);
		c.addOcc(PolOfc2);
		c.addOcc(PolOfc3);
		c.showOcc();
		
		String Teach1 = people[4].getName();
		String Teach2 = people[6].getName();
		String Kid1 = people[8].getName();
		String Kid2 = people[9].getName();
		
		School s = (School) building[1];
		s.addOcc(Teach1);
		s.addOcc(Teach2);
		s.addOcc(Kid1);
		s.addOcc(Kid2);
		s.showOcc();
		
		Teacher t1 = (Teacher) people[5];
		t1.pay();
		System.out.printf("\n%s's monthly paycheck values at: %d \n", t1.name, t1.pay());
		Police p1 = (Police) people[2];
		p1.pay();
		System.out.printf("%s's monthly paycheck values at: %d \n", p1.name, p1.pay());
	}

}
