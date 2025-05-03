
/**
 * File: Person.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Abstract class that stores basic personal information like name and age.
 */
import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class Person {
	private String firstName;
	private char middleInitial;
	private String lastName;
	private int age;

	// Constructor to initialize a Person's full name and age
	public Person(String firstName, char middleInitial, String lastName, int age) {
		setFullName(firstName, middleInitial, lastName);
		setAge(age);
	}

	public void setFullName(String firstName, char middleInitial, String lastName) {
		setFirstName(firstName);
		setMiddleInitial(middleInitial);
		setLastName(lastName);
	}

	public String getFullName() {
		if (middleInitial == 'X') {
			return firstName + " " + lastName + " ";
		} else {
			return firstName + " " + middleInitial + ". " + lastName + " ";
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = validateAndCapitalize(firstName, "firstName");
	}

	public char getMiddleInitial() {
		return middleInitial;

	}

	public void setMiddleInitial(char middleInitial) {
		if (!Character.isLetter(middleInitial)) {
			this.middleInitial = 'X';
		} else {
			this.middleInitial = Character.toUpperCase(middleInitial);
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = validateAndCapitalize(lastName, "lastName");
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 15 && age <= 70) {
			this.age = age;
		} else {
			throw new IllegalArgumentException("Age must be between 15 and 70");
		}
	}

	/**
	 * Formats the input name fields to proper case and validates their contents.
	 */
	protected String validateAndCapitalize(String input, String fieldName) {
		if (input == null || input.trim().isEmpty()) {
			return "Unknown";
		} else {
			if (!input.matches("[a-zA-Z ]+")) {
				throw new IllegalArgumentException(fieldName + "must contain only letters and spaces.");
			}
			// Capitalize each word
			return Arrays.stream(input.trim().split("\\s+")).filter(word -> !word.isEmpty())
					.map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
					.collect(Collectors.joining(" "));
		}
	}

	@Override
	public String toString() {
		return getFullName() + ": ";
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;

		return this.getFirstName().equals(other.getFirstName()) && this.getMiddleInitial() == other.getMiddleInitial()
				&& this.getLastName().equals(other.getLastName()) && this.getAge() == other.getAge();
	}

}
