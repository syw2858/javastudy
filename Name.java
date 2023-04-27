
public class Name {
	String firstName; // 이름
	String lastName; // 성
	Name(String firstName, String lastName) { 
	this.firstName = firstName;
	this.lastName = lastName;
	}
	public boolean equals(Object obj) { 
		if (!(obj instanceof Name)) 
		return false; 
		Name name = (Name) obj; 
		if (firstName.equals(name.firstName) && lastName.equals(name.lastName)) 
		return true; 
		else 
		return false; 
	}
	public int hashCode() { 
		return firstName.hashCode() + lastName.hashCode(); 
	}
}
