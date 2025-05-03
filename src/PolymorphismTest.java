/**
 * File: PolymorphismTest.java
 * Author: Leonardi Montenegro
 * Date: April 17, 2025
 * Description: Main driver class that demonstrates polymorphism using an array of Person objects.
 * Provides a menu to print players, call actions, and list equal players by sport.
 */
import java.util.Scanner;

public class PolymorphismTest {

	public static void main(String[] args) {

		// Creates and stores multiple athlete instances in a Person array
		Person[] people = new Person[100];
		int index = 0;
		people[index++] = new Baseball("Hank", 'H', "Aaron", 30, "Los Angeles Dodgers", "catcher", "cleanup",
				Baseball.Handedness.LEFTHANDED);
		people[index++] = new Football("Terry", 'F', "Bradshaw", 24, "Miami Dolphins", "quarterback",
				Football.Specialty.OFFENSE);
		people[index++] = new Hockey("Mario", 'X', "Lemieux", 29, "Florida Panthers", "goalie", "Bauer");
		people[index++] = new Golf("Tiger", 'T', "Woods", 40, "University of Florida", "Nike");
		people[index++] = new Baseball("Barry", 'B', "Bonds", 32, "Boston Red Sox", "pitcher", "Second",
				Baseball.Handedness.BOTH);
		people[index++] = new Football("Payton", 'A', "Manning", 21, "Pittsburg Steelers", "edge rusher",
				Football.Specialty.DEFENSE);
		people[index++] = new Golf("Wayne", 'X', "Gretzky", 19, "Harvard University", "Longiness");
		people[index++] = new Golf("Phil", 'A', "Mickleson", 40, "Stanford University", "Under Armour");
		people[index++] = new Baseball("Babe", 'G', "Ruth", 35, "New York Yankees", "Outfielder", "leadoff",
				Baseball.Handedness.RIGHTHANDED);
		people[index++] = new Football("Tom", 'E', "Brady", 46, "New England Patriots", "Quarterback",
				Football.Specialty.OFFENSE);
		people[index++] = new Hockey("Sidney", 'R', "Crosby", 36, "Pittsburgh Penguins", "Center", "CCM");
		people[index++] = new Football("Micah", 'D', "Parsons", 24, "Dallas Cowboys", "edge rusher",
				Football.Specialty.DEFENSE);
		people[index++] = new Baseball("Derek", 'A', "Jeter", 49, "New York Yankees", "Shortstop", "second",
				Baseball.Handedness.LEFTHANDED);
		people[index++] = new Baseball("Carlos", 'E', "Gonzalez", 29, "Colorado Rockies", "right fielder", "third",
				Baseball.Handedness.LEFTHANDED);
		people[index++] = new Football("Justin", 'P', "Herbert", 25, "Los Angeles Chargers", "quarterback",
				Football.Specialty.OFFENSE);
		people[index++] = new Hockey("Nathan", 'M', "MacKinnon", 28, "Colorado Avalanche", "center", "CCM");
		people[index++] = new Baseball("Barry", 'B', "Bonds", 32, "Boston Red Sox", "pitcher", "Second",
				Baseball.Handedness.BOTH);
		people[index++] = new Football("Micah", 'D', "Parsons", 24, "Dallas Cowboys", "edge rusher",
				Football.Specialty.DEFENSE);

		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("\n=== Menu ===");
			System.out.println("1. Print all players");
			System.out.println("2. Call doThis() for all players");
			System.out.println("3. List equal players by sport");
			System.out.println("4. Exit");
			System.out.println("Choose an option: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("\nAll Players:");
				for (int i = 0; i < index; i++) {
					System.out.println(people[i]);
				}
				break;

			case 2:
				System.out.println("\nCalling doThis() for each player:");
				for (int i = 0; i < index; i++) {
					if (people[i] instanceof Athlete) {
						((Athlete) people[i]).doThis();
					}
				}
				break;

			case 3:
				printEqualsbySport(people, index);
				break;

			case 4:
				System.out.println("Exiting. Goodbye!");
				break;

			default:
				System.out.println("Invalid option. Please choose 1-4.");

			}

		} while (choice != 4);

		scanner.close();
	}

	// Compares each pair of players by sport and prints those that are equal
	public static void printEqualsbySport(Person[] people, int count) {
		String[] sports = { "Baseball", "Football", "Hockey", "Golf" };
		for (String sport : sports) {
			System.out.println("\nEqual" + sport + "players:");
			boolean found = false;
			for (int i = 0; i < count; i++) {
				if (people[i].getClass().getSimpleName().equals(sport)) {
					for (int j = i + 1; j < count; j++) {
						if (people[j].getClass().getSimpleName().equals(sport)) {
							if (people[i].equals(people[j])) {
								System.out.println(people[i]);
								System.out.println(people[j]);
								System.out.println("---");
								found = true;
							}
						}
					}
				}
			}

			if (!found) {
				System.out.println("No equal players found");
			}
		}
	}
}
