package selfProject;

public class Supplier extends Employee {

	public Supplier() {
		super();// TODO Auto-generated constructor stub
	}

	public Supplier(int ID, String name, String surname, int age, double salary) {
		super(ID, name, surname, age, salary);
		this.setProfession("Supplier");
		// TODO Auto-generated constructor stub
	}

	public void supplyCar(Vehicle vehicle) {
		this.getCarPark().getAllVehicles().add(vehicle);
		this.getCarPark().carSold((0.8) * -vehicle.getPrice());
	}
}
