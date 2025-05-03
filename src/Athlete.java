/**
 * File: Athlete.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Abstract class extending Person and implementing SportAction. Adds team and position attributes.
 */
import java.util.Objects;

public abstract class Athlete extends Person implements SportAction {
	private String team;
	private String position;

	// Constructor initializes personal details plus team and position
	public Athlete(String firstName, char middleInitial, String lastName, int age, String team, String position) {
		super(firstName, middleInitial, lastName, age);
		this.setTeam(team);
		this.setPosition(position);
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = validateAndCapitalize(team, "Team");
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = validateAndCapitalize(position, "Position");
	}

	public String athleteDetails() {
		return "and plays for the " + getTeam() + " as a " + getPosition() + ". ";
	}

	public abstract void doThis();

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Athlete))
			return false;

		Athlete other = (Athlete) obj;

		return super.equals(other) && Objects.equals(this.getTeam(), other.getTeam())
				&& Objects.equals(this.getPosition(), other.getPosition());
	}

}
