import java.util.ArrayList;
import java.util.Scanner;
/**
 * DESCRIPTION: Allows input from PersonClass and allows pay to be implemented
 * @author tle19
 * @see Employee
 */
public class Police extends PersonClass implements Employee {
	
	public Police(String newName, int newAge, int newPhone, Rank r) {
		name = newName;
		age = newAge;
		phoneNum = newPhone;
		role = r; 
	}
	

	public enum Rank {Patrol, Sargeant, Captain, Chief};
	private Rank role;
	public Rank getRole() {return role;}
	public void setRole(Rank r){role = r;}
	
	
	public int pay(){
		int pay = 1500;
		return pay;
	} 
	public int id() {
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		return id;
	}
	public static Object getScaledInstance(int imageWidth, int imageHeight) {
		// TODO Auto-generated method stub
		return null;
	}
}
