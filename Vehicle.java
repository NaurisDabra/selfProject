package selfProject;

public class Vehicle {
	// TODO @Id @GeneratedValue(strategy=GenerationType.IDENTITY
	// TODO private long ID;
	private int ID;
	private String name;
	private double price;
	private boolean dirty;

	// TODO @OneToOne(fetch=FetchType.LAZY)
	// TODO CarPark carPark;
	public Vehicle() {
		dirty = false;
	}

	public Vehicle(int ID, String name, double price) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.dirty = false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean getDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public String toString() {
		return "ID: " + ID + "\nName: " + name + "\nPrice: " + price;
	}
}
