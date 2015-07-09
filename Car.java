package selfProject;

public class Car extends Vehicle {
	private int numberOfSeats;
	private float trunkVolume;

	public Car() {
		// TODO Auto-generated constructor stub
	}

	public Car(int ID, String name, double price, int numberOfSeats, float trunkVolume) {
		super(ID, name, price);
		this.trunkVolume = trunkVolume;
		this.numberOfSeats = numberOfSeats;
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return super.toString() + "\nNumber of seats: " + numberOfSeats + "\ntrunkVolume: " + trunkVolume;
	}

}
