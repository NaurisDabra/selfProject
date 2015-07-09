package selfProject;

public class Cleaner extends Employee {

	public Cleaner() {
	}

	public Cleaner(int ID, String name, String surname, int age, double salary) {
		super(ID, name, surname, age, salary);
	}

	public void cleanVehicle(Vehicle vehicle) {
		if (vehicle.getDirty())
			vehicle.setDirty(false);
		else
			System.out.println("Cleaning not needed");
	}
	public void cleanCarPark() {//TODO
		}
	

}
