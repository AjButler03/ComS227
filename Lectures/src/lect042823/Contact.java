package lect042823;

public class Contact implements Comparable<Contact>{
	private String firstName;
	private String lastName;
	
	
	public Contact(String first, String last) {
		firstName = first;
		lastName = last;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		return "\n" + lastName + ", " + firstName;
	}
	
	/**
	 * comparing this instantiated contact object with another passed in contact object
	 * if This >  contact return positive
	 * if this == contact return 0
	 * if this <  contact return negative
	 * 
	 */
	@Override
	public int compareTo(Contact contact) {
		return lastName.compareTo(contact.getLastName());
	}
}
