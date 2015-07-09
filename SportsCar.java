package selfProject;

public class SportsCar extends Car {
	private float maxSpeed;
	private boolean streetLegal;

	public SportsCar() {
		// TODO Auto-generated constructor stub
	}

	public SportsCar(int ID, String name, double price, int numberOfSeats, float trunkVolume, float maxSpeed,
			boolean streetLegal) {
		super(ID, name, price, numberOfSeats, trunkVolume);
		this.maxSpeed = maxSpeed;
		this.streetLegal = streetLegal;
		// TODO Auto-generated constructor stub
	}

	public String getStreetLegal() {
		if (streetLegal)
			return "Is street legal";
		return "Isn't street legal";
	}

	public String toString() {
		return super.toString() + "\nMax Speed: " + maxSpeed + "\n" + getStreetLegal();
	}
}
