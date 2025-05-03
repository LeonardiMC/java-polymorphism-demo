// ---------------- FOOTBALL.JAVA ----------------
/**
 * File: Football.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Subclass of Athlete representing a football player with position and specialty.
 */

public class Football extends Athlete {
	enum Specialty {
		OFFENSE("offense"), DEFENSE("defense"), SPECIAL_TEAMS("special teams");

		private final String description;

		Specialty(String description) {
			this.description = description;
		}

		public String describe() {
			return description;
		}

	}

	private final Specialty specialty;

	public Football(String firstName, char middleInitial, String lastName, int age, String team, String position,
			Specialty specialty) {
		super(firstName, middleInitial, lastName, age, team, position);
		if (specialty == null) {
			throw new IllegalArgumentException("Specialty cannot be null");
		}
		this.specialty = specialty;
	}

	public String describeSpecialty() {
		return specialty.describe();
	}

	public String toString() {
		return super.toString() + "a football player who is " + getAge() + " years old " + athleteDetails()
				+ "His specialty is " + specialty.describe() + ". ";
	}

	public void doThis() {
		System.out.println("I tackle something. ");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Football))
			return false;
		Football other = (Football) obj;

		return super.equals(other) && this.specialty == other.specialty;
	}

}
