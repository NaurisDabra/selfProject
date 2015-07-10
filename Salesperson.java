package selfProject;

import java.util.ArrayList;
import java.util.List;

public class Salesperson extends Employee {
	private int vehicleCount;
	private List<Vehicle> soldVehicles;

	public Salesperson() {
		super();
		soldVehicles = new ArrayList<Vehicle>();// TODO Auto-generated
												// constructor stub
	}

	public Salesperson(int ID, String name, String surname, int age, double salary) {
		super(ID, name, surname, age, salary);
		soldVehicles = new ArrayList<Vehicle>();
		this.setProfession("Salesperson");
		// TODO Auto-generated constructor stub
	}

	public int getCarCount() {
		return vehicleCount;
	}

	public void setCarCount(int carCount) {
		this.vehicleCount = carCount;
	}

	public List<Vehicle> getSoldVehicles() {
		return soldVehicles;
	}

	public void setSoldVehicles(List<Vehicle> soldVehicles) {
		this.soldVehicles = new ArrayList<Vehicle>(soldVehicles);
	}

	public void sellVehicle(Vehicle vehicle) {
		soldVehicles.add(vehicle);
		vehicleCount++;
		this.getCarPark().carSold(vehicle.getPrice());
		boolean result = this.getCarPark().removeVehicle(vehicle);
		if (result) {
			System.out.println("Vehicle removed");
		} else
			System.out.println("Failed to remove vehicle");
	}

	public void requestCleaning(Vehicle vehicle) {
		vehicle.setDirty(true);
	}

	public String toString() {
		return super.toString() + "\nHas sold " + vehicleCount + " vehicles";
	}
}
