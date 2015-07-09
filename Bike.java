package selfProject;

public abstract class Bike extends Vehicle {
	private int engineVolume;

	public Bike() {
		// TODO Auto-generated constructor stub
	}

	public Bike(int ID, String name, double price, int engineVolume) {
		super(ID, name, price);
		this.engineVolume = engineVolume;
		// TODO Auto-generated constructor stub
	}

	public void setEngineVolume(int engineVolume) {
		this.engineVolume = engineVolume;
	}

	public int getEngineVolume() {
		return engineVolume;
	}

	public String toString() {
		return super.toString() + "\nIs a bike with " + engineVolume + "cc engine volume";
	}
}
