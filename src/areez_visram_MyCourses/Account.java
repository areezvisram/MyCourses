package areez_visram_MyCourses;

/*Name: Areez Visram
Date: Tuesday, June 11th 2018
ICS4U1 - Kosh
ISU - My Courses*/

//Account object that extends from Register Screen
public class Account extends Register_Screen {
	
	//Variable Declaration
	//Identifier
	private final String username;
	private String password;
	
	//Constructor for the Account object
	public Account (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	//Getter for the username field
	public String getusername () {
		return username;
	}

	//Getter for the password field
	public String getpassword() {
		return password;
	}
	
	//Setter for the password field
	public void setpassword(String password) {
		this.password = password;
	}
}
