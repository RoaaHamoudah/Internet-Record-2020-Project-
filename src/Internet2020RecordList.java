import java.util.Arrays;

public class Internet2020RecordList {

	// attributes.
	public static Internet2020Record[] list; // Make array of Internet2020Record class.
	private int size;

	// no-argument constructor.
	public Internet2020RecordList() {
		list = new Internet2020Record[16];    // Make array from Internet2020Record class
											 // with initial size of 16 when creating object from
											// Internet2020RecordList class.
		size = 0;
	}

	// insertCountry method to insert a new country record into the list.
	public boolean insertCountry(Internet2020Record listCountry) {
		if (size == list.length) {                      // Check if (size == length) in which case
			int newSize = list.length * 2;             // we want to resize the list by doubling the size of the list.
			list = Arrays.copyOf(list, newSize);      // create a copy of the original 'list' array
		} // with the specified 'newSize'.

		if (search(listCountry.getCountryName()) == null) {
			list[size] = listCountry;
			size++;
			return true;
		} else {
			return false;
		}
	}

	// deleteCounter method to delete a country record from the List using the
	// country name.
	public boolean deleteCountry(String countryName) {
		Internet2020Record record = search(countryName);
		if (record != null) {
			int i = 0;
			while (list[i] != record)
				i++;
			for (; i < size - 1; i++) {
				list[i] = list[i + 1];
			}
			list[--size] = null;
			return true;
		}

		return false;
	}

	// search method to search for a specific country record by name.
	public Internet2020Record search(String countryName) {
		for (int i = 0; i < size; i++) {
			if (list[i].getCountryName().equals(countryName)) {
				return list[i];
			}
		}
		return null;
	}

	// display method to display the countries that % of individuals using the
	// Internet is greater than a specific input %.
	public Internet2020Record[] display(double specificPercentage) {
		int count = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != null && (list[i].getPercentageOfInternetUsers()) > specificPercentage) {
				count++;
			}
		}
		if (count == 0) {
			return null;

		}

		Internet2020Record[] result = new Internet2020Record[count];
		int resultIndex = 0;

		for (int i = 0; i < list.length; i++) {
			if (list[i] != null && list[i].getPercentageOfInternetUsers() > specificPercentage) {
				String s = list[i].getCountryName();
				double d = list[i].getPercentageOfInternetUsers();
				result[resultIndex] = new Internet2020Record(s, d);
				resultIndex++;
			}
		}

		return result;

	}
}