
public class Internet2020Record {

	// attributes.
	private String countryName;
	private double percentageOfInternetUsers;

	// argument constructor.
	public Internet2020Record(String countryName, double percentageOfInternetUsers) {
		super();
		this.countryName = countryName;
		this.percentageOfInternetUsers = percentageOfInternetUsers;
	}

	// getters and setters.
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public double getPercentageOfInternetUsers() {
		return percentageOfInternetUsers;
	}

	public void setPercentageOfInternetUsers(double percentageOfInternetUsers) {
		if (percentageOfInternetUsers < 0)
			System.out.println("Error : the percentage of internet users can not be -ve!!! ");
		else
			this.percentageOfInternetUsers = percentageOfInternetUsers;
	}

	// to string method (override).
	@Override
	public String toString() {
		return countryName + "," + percentageOfInternetUsers;
	}

}
