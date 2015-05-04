import java.util.ArrayList;

//This class is a representation of sets using the arrayList dataStructure
public class MySet {

	ArrayList<String> theSet;

	// Constructor
	public MySet() {
		theSet = new ArrayList<String>();
	}

	// adding a single element
	public void addElement(String element) {
		theSet.add(element);
	}

	// adding an array of elements
	public void addArrayOfElements(String[] elements) {
		for (int i = 0; i < elements.length; i++) {
			theSet.add(elements[i]);
		}
	}

	// a method that removes all duplicates and also removes empty elements
	public void makeUnique() {
		for (int i = 0; i < theSet.size(); i++) {

			for (int j = i + 1; j < theSet.size(); j++) {
				if (theSet.get(i).equals(theSet.get(j))) {
					theSet.remove(j);
					j--;
				}
			}
		}

		for (int k = 0; k < theSet.size(); k++) {
			if (theSet.get(k).equals("")) {
				theSet.remove(k);
				k--;
			}
		}
	}

	// gets the element at that index
	public String getElement(int i) {
		return theSet.get(i);
	}

	// removes the element at that index
	public void removeElement(int i) {
		theSet.remove(i);

	}

	// removes all elements
	public void clear() {
		theSet.clear();

	}

	// changes the element at that index to the new string value
	public void setElement(int i, String newElement) {
		theSet.set(i, newElement);

	}

	// checks if the element exists in the set
	public boolean contain(String element) {
		if (theSet.contains(element)) {
			return true;
		}

		return false;
	}

	// returns the size of the set
	public int getSize() {

		return theSet.size();
	}

	// returns the index of that element in the set
	public int indexOf(String element) {
		return theSet.indexOf(element);
	}

	// returns a string containing all the elements in the set
	public String toString() {
		String output = "{";

		for (int i = 0; i < theSet.size(); i++) {
			output = output + theSet.get(i);

			if (i < theSet.size() - 1) {
				output = output + ", ";
			}
		}

		output = output + "}";
		return output;
	}

}
