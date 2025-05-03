/**
 * File: Hockey.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Subclass of Athlete representing a hockey player. Includes stick brand.
 */
import java.util.Objects;

public class Hockey extends Athlete {
	private String stickBrand;

	public Hockey(String firstName, char middleInitial, String lastName, int age, String team, String position,
			String stickBrand) {
		super(firstName, middleInitial, lastName, age, team, position);
		setStickBrand(stickBrand);
	}

	public String getStickBrand() {
		return stickBrand;
	}

	public void setStickBrand(String stickBrand) {
		this.stickBrand = validateAndCapitalize(stickBrand, "StickBrand");
	}

	public String toString() {
		return super.toString() + "a hockey player who is " + getAge() + " years old " + athleteDetails()
				+ "His stick brand is " + getStickBrand() + ". ";
	}

	@Override
	public void doThis() {
		System.out.println("I sit in a penalty box. ");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Hockey))
			return false;
		Hockey other = (Hockey) obj;

		return super.equals(other) && Objects.equals(this.getStickBrand(), other.getStickBrand());
	}

}
