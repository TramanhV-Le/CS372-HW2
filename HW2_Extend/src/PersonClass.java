/**
 * DESCRIPTION: Allows input for the Police, Teacher, and Kid class and their information to run in City class.
 * @author tle19
 *
 */
public abstract class PersonClass {
	String name;
	int age;
	int phoneNum;

	public void setName(String newName) {
		name = newName;
	}
	public String getName() {
		return name;
	}
	public void setAge(int newAge) 	{
		age = newAge;
	}
	public int getAge()	{
		return age;
	}
	public void setPhone(int newPhone) 	{
		phoneNum = newPhone;
	}
	public int getPhone()	{
		return phoneNum;
	}
	
}
