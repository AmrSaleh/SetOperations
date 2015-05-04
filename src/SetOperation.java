

//a class that contains static methods to do some operations on the sets
public class SetOperation {

	// method that returns a set of the intersection of the given two sets
	public static MySet intersectionOf(MySet firstSet, MySet anotherSet) {

		MySet intersection = new MySet();

		for (int i = 0; i < firstSet.getSize(); i++) {
			if (anotherSet.contain(firstSet.getElement(i))) {
				intersection.addElement(firstSet.getElement(i));
			}
		}

		intersection.makeUnique();
		return intersection;
	}

	// method that returns a set of the union of the given twi sets
	public static MySet unionOf(MySet firstSet, MySet anotherSet) {

		MySet union = new MySet();

		for (int i = 0; i < firstSet.getSize(); i++) {

			union.addElement(firstSet.getElement(i));

		}
		for (int j = 0; j < anotherSet.getSize(); j++) {

			union.addElement(anotherSet.getElement(j));

		}

		union.makeUnique();
		return union;
	}

	// method that returns the compliment set of the first given set ,using the
	// second given set as the universe
	public static MySet complimentOf(MySet theSet, MySet Universe) {

		MySet compliment = new MySet();

		for (int i = 0; i < Universe.getSize(); i++) {
			if (theSet.contain(Universe.getElement(i))) {

			} else {
				compliment.addElement(Universe.getElement(i));
			}
		}

		compliment.makeUnique();
		return compliment;
	}

}
