import java.util.ArrayList;
import java.util.Scanner;
/**
 * DESCRIPTION: Allows input from PersonClass and allows pay to be implemented
 * @author tle19
 * @see Employee
 */
public class Teacher extends PersonClass implements Employee {
	int grade;
	String certification;
	
	public Teacher(String newName, int newAge, int newPhone, int newGrade, String newCert) {
		name = newName;
		age = newAge;
		phoneNum = newPhone;
		grade = newGrade;
		certification = newCert;	
	}
	private ArrayList<String>employee = new ArrayList<String>();
	
	public int pay(){
		int pay = 1650;
		return pay;
	} 
	public int id() {
		Scanner input = new Scanner(System.in);
		int id = input.nextInt();
		return id;
	}
	
}
