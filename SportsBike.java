package selfProject;

import java.util.Arrays;

public class SportsBike extends Bike {
	private int maxSpeed;
	private String classification;
	private final static String[] possibleClassifications = { "lightweight", "middleweight", "superbike" };

	public SportsBike() {
		// TODO Auto-generated constructor stub
	}

	public SportsBike(int ID, String name, double price, int engineVolume, int maxSpeed, String classification) {
		super(ID, name, price, engineVolume);
		this.maxSpeed = maxSpeed;
		if (Arrays.asList(possibleClassifications).contains(classification))
			this.classification = classification;
		else
			this.classification = "unknown";
		// TODO Auto-generated constructor stub
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		if (Arrays.asList(possibleClassifications).contains(classification))
			this.classification = classification;
		else
			this.classification = "unknown";
	}

	public String toString() {
		return super.toString() + " of " + classification + " type with max speed of " + maxSpeed;
	}
}
