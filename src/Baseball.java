
/**
 * File: Baseball.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Subclass of Athlete representing a baseball player. Adds batting position and handedness.
 */
import java.util.Objects;

public class Baseball extends Athlete {

	// Enum representing left, right, or both-handed players
	enum Handedness {
		LEFTHANDED("left-handed"), RIGHTHANDED("right-handed"), BOTH("both-handed");

		private final String description;

		Handedness(String description) {
			this.description = description;
		}

		public String describe() {
			return description;
		}
	}

	private final Handedness handedness;
	private String battingPosition;

	public Baseball(String firstName, char middleInitial, String lastName, int age, String team, String position,
			String battingPosition, Handedness handedness) {
		super(firstName, middleInitial, lastName, age, team, position);
		this.setBattingPosition(battingPosition);
		if (handedness == null) {
			throw new IllegalArgumentException("Handedness cannot be null");
		}
		this.handedness = handedness;
	}

	public String getBattingPosition() {
		return battingPosition;
	}

	public void setBattingPosition(String battingPosition) {
		this.battingPosition = validateAndCapitalize(battingPosition, "BattingPosition");
	}

	public String describeHandedness() {
		return handedness.describe();
	}

	public String toString() {
		return super.toString() + "a baseball player who is " + getAge() + " years old " + athleteDetails()
				+ "His batting position is " + getBattingPosition() + " and is " + handedness.describe() + ". ";
	}

	@Override
	public void doThis() {
		System.out.println("I hit something. ");

	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Baseball))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Baseball other = (Baseball) obj;
		return super.equals(other) && Objects.equals(this.getBattingPosition(), other.getBattingPosition())
				&& this.handedness == other.handedness;
	}

}
