// ---------------- GOLF.JAVA ----------------
/**
 * File: Golf.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Subclass of Athlete representing a golfer. Adds sponsor information.
 */
import java.util.Objects;

public class Golf extends Athlete {
	private String mainSponsor;

	public Golf(String firstName, char middleInitial, String lastName, int age, String team, String mainSponsor) { 
		super(firstName, middleInitial, lastName, age, team, "Golfer");
		setMainSponsor(mainSponsor);
	}

	public String getMainSponsor() {
		return mainSponsor;
	}

	// Validates sponsor string, defaults to "Unknown" if invalid
	public void setMainSponsor(String mainSponsor) {
		if (mainSponsor == null || mainSponsor.trim().isEmpty()) {
			this.mainSponsor = "Unknown";
		} else {
			if (!mainSponsor.matches("[a-zA-Z0-9 .'-]+")) {
				throw new IllegalArgumentException(
						"Main sponsor can only contain letters, numbers, spaces, dots, apostrophes, or hyphens.");
			}
			this.mainSponsor = mainSponsor.trim();
		}
	}

	public String toString() {
		return super.toString() + "a golfer who is " + getAge() + " years old" + athleteDetails()
				+ "He is sponsored by " + getMainSponsor() + ". ";
	}

	@Override
	public void doThis() {
		System.out.println("I putt it in the hole. ");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Golf))
			return false;
		Golf other = (Golf) obj;

		return super.equals(other) && Objects.equals(this.getMainSponsor(), other.getMainSponsor());
	}
}
