import java.util.ArrayList;
import java.util.Scanner;

//this class contains the user interface 
public class DriverClass {
	static Scanner sc = new Scanner(System.in);

	// the universe set of all sets
	static MySet Universe = new MySet();

	// a list containing all the sets that will be entered
	static ArrayList<MySet> allSets = new ArrayList<MySet>();

	// the main method
	public static void main(String[] args) {
		try {
			runConsole();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// this method contains the UI separated than the main method
	public static void runConsole() {

		String temp;
		

		try {
			boolean repeat = true;
			while (repeat == true) {

				System.out.println("Please enter the universe comma separated");
				temp = sc.nextLine();

				temp = temp.replaceAll(" ", "");

				Universe.addArrayOfElements(temp.split(","));

				Universe.makeUnique();

				if (Universe.getSize() > 0) {
					repeat = false;
				} else {
					System.out.println("Wrong input, try again");
				}

			}

		} catch (Exception e) {
			// System.err.println("ERROR IN INPUT");
			e.printStackTrace();
		}

		try {
			boolean repeat = true;
			while (repeat == true) {

				System.out.println("\nMain menu\n=========");
				System.out.println("The Universe is " + Universe.toString());
				System.out.println("\nWhat would you like to do: ");

				System.out.println("\n1- Edit Universe.\n2- Add a Set.\n3- View all Set.\n4- Delete a Set.\n5- Make an operation.\n6- Exit program.");
				int answer = -1;
				try {
					answer = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {

				}
				if (answer == 1) {
					editUniverse();
				} else if (answer == 2) {
					addSet();
				} else if (answer == 3) {

					viewallSets();
					System.out.println("Press enter to continue\n");
					sc.nextLine();
				} else if (answer == 4) {
					deleteSet();
				} else if (answer == 5) {
					makeOperation();
				} else if (answer == 6) {
					repeat = false;

				} else {
					System.out.println("wrong answer, try again");
				}

			}
			System.out.println("\nProgram Ended");

		} catch (Exception e) {
			// System.err.println("ERROR IN INPUT");
			e.printStackTrace();
		}
	}

	// a method that allows the user to edit the universe
	private static void editUniverse() {

		try {
			boolean repeat = true;
			while (repeat == true) {

				System.out.println("Edit Universe\n==============");
				System.out.println("The Universe is " + Universe.toString());
				System.out.println("What would you like to do:\n");
				System.out.println("1- enter new universe\n2- add elements\n3- go back");

				int answer = -1;
				try {
					answer = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {

				}
				if (answer == 1) {
					boolean rep = true;
					Universe.clear();
					do {
						System.out.println("Please enter the universe comma separated");

						String temp = sc.nextLine();

						temp = temp.replaceAll(" ", "");

						Universe.addArrayOfElements(temp.split(","));

						Universe.makeUnique();

						if (Universe.getSize() > 0) {
							rep = false;
						} else {
							System.out.println("Wrong input, try again");
						}
					} while (rep == true);
				} else if (answer == 2) {

					boolean rep = true;

					do {
						System.out.println("Please enter the new elements comma separated");

						String temp = sc.nextLine();

						temp = temp.replaceAll(" ", "");

						Universe.addArrayOfElements(temp.split(","));

						Universe.makeUnique();

						if (Universe.getSize() > 0) {
							rep = false;
						} else {
							System.out.println("Wrong input, try again");
						}
					} while (rep == true);

				} else if (answer == 3) {
					repeat = false;

				} else {
					System.out.println("wrong answer, try again");
				}

			}

		} catch (Exception e) {
			// System.err.println("ERROR IN INPUT");
			e.printStackTrace();
		}

	}

	// a method that allows the user to add a new set
	private static void addSet() {
		try {

			MySet newSet = new MySet();
			boolean rep = true;

			do {
				System.out.println("Making new Set: ");
				System.out.println("Note: all elements must exist in the Universe");
				System.out.println("The Universe is " + Universe.toString());
				System.out.println("Please enter the set elements comma separated");

				String temp = sc.nextLine();

				temp = temp.replaceAll(" ", "");

				newSet.clear();
				newSet.addArrayOfElements(temp.split(","));

				newSet.makeUnique();

				if (newSet.getSize() > 0) {
					rep = false;
					for (int i = 0; i < newSet.getSize(); i++) {
						if (!Universe.contain(newSet.getElement(i))) {
							System.out.println("elements does not exist in Universe, try again");
							rep = true;
							break;
						}
					}

				} else {
					System.out.println("Wrong input, try again");
				}
			} while (rep == true);
			System.out.println("Set saved\n");
			System.out.println("Press enter to continue\n");
			sc.nextLine();
			allSets.add(newSet);

		} catch (Exception e) {
			// System.err.println("ERROR IN INPUT");
			e.printStackTrace();
		}
	}

	// a method that allows the user to view all sets
	private static void viewallSets() {

		System.out.println("All Sets\n==========\n");
		if (allSets.size() < 1) {
			System.out.println("There are no sets");
		}
		for (int i = 0; i < allSets.size(); i++) {
			System.out.println("Set no. " + i + " " + allSets.get(i).toString());
		}

	}

	// a method that allows the user to delete an existing set
	private static void deleteSet() {
		System.out.println("Delete a Set\n============\n");

		if (allSets.size() < 1) {
			System.out.println("There are no sets to be deleted");
		} else {

			boolean rep = true;

			do {
				viewallSets();
				System.out.println("\nPlease enter the no. of the Set you want to delete");

				int answer = -1;
				try {
					answer = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {

				}

				if (answer >= 0 && answer < allSets.size()) {
					System.out.println("Set deleted");
					allSets.remove(answer);
					rep = false;
				} else {
					System.out.println("wrong entry, nothing deleted");
					rep = false;
				}

			} while (rep == true);

		}
		System.out.println("Press enter to continue\n");
		sc.nextLine();

	}

	// an inner method that allows the user to select a specific set and return
	// its index to perform further operations on it
	private static int selectSet() {
		System.out.println("Select a Set\n============\n");
		int answer = -1;
		if (allSets.size() < 1) {
			System.out.println("There are no sets to be selected");
		} else {

			boolean rep = true;

			do {
				viewallSets();
				System.out.println("\nPlease enter the no. of the Set you want to select");

				answer = -1;
				try {
					answer = Integer.parseInt(sc.nextLine());
				} catch (Exception e) {

				}

				if (answer >= 0 && answer < allSets.size()) {
					System.out.println("Set no. " + answer + " selected");

					rep = false;
				} else {
					System.out.println("wrong entry, try again");
					// rep=false;
					answer = -1;
				}

			} while (rep == true);

		}
		return answer;

	}

	// a method that allows the user to make operations on the existing sets
	private static void makeOperation() {

		if (allSets.size() < 1) {
			System.out.println("\nThere are no sets to perform operations on.");
			sc.nextLine();
		} else {
			try {
				boolean repeat = true;
				while (repeat == true) {

					System.out.println("\nMake Operation\n=========");
					System.out.println("The Universe is " + Universe.toString());
					System.out.println("\nChoose an Operation: ");

					System.out.println("\n1- Get the compliment of a Set.\n2- Get intersection of 2 Sets.\n3- Get union of 2 Sets.\n4- Go back.");
					int answer = -1;
					try {
						answer = Integer.parseInt(sc.nextLine());
					} catch (Exception e) {

					}
					if (answer == 1) {
						int theSelectedSet = selectSet();
						System.out.println("\nFor the Set " + allSets.get(theSelectedSet).toString());
						System.out.println("The compliment is " + SetOperation.complimentOf(allSets.get(theSelectedSet), Universe));

						System.out.println("Press enter to continue\n");
						sc.nextLine();
					} else if (answer == 2) {
						int set1, set2;
						System.out.println("\nSelect first set\n----------------\n");
						set1 = selectSet();
						System.out.println("\nSelect Second Set\n");
						set2 = selectSet();

						System.out.println("\nFor the Sets " + allSets.get(set1).toString() + " and " + allSets.get(set2).toString());
						System.out.println("The intersection is " + SetOperation.intersectionOf(allSets.get(set1), allSets.get(set2)));

						System.out.println("Press enter to continue\n");
						sc.nextLine();
					} else if (answer == 3) {
						int set1, set2;
						System.out.println("\nSelect first set\n----------------\n");
						set1 = selectSet();
						System.out.println("\nSelect Second Set\n----------------\n");
						set2 = selectSet();

						System.out.println("\nFor the Sets " + allSets.get(set1).toString() + " and " + allSets.get(set2).toString());
						System.out.println("The Union is " + SetOperation.unionOf(allSets.get(set1), allSets.get(set2)));

						System.out.println("Press enter to continue\n");
						sc.nextLine();
					} else if (answer == 4) {
						repeat = false;

					} else {
						System.out.println("wrong answer, try again");
					}

				}

			} catch (Exception e) {
				// System.err.println("ERROR IN INPUT");
				e.printStackTrace();
			}
		}
	}
}
