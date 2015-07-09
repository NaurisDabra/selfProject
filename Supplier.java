package selfProject;

public class Supplier extends Employee {

	public Supplier() {
		super();// TODO Auto-generated constructor stub
	}

	public Supplier(String name, String surname, int age, double salary) {
		super(name, surname, age, salary);
		// TODO Auto-generated constructor stub
	}
public void supplyCar(Vehicle vehicle, CarPark carPark){
	carPark.getAllVehicles().add(vehicle);
	carPark.carSold((0.8)*-vehicle.getPrice());
}
}
