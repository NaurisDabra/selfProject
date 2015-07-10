package selfProject;

public class Manager extends Employee {
	public Manager(int ID, String name, String surname, int age, double salary) {
		super(ID, name, surname, age, salary);
		this.setProfession("Manager");
	}

	public void hireEmployee(Employee employee, CarPark carPark) {
		carPark.addEmployee(employee);
		employee.setCarPark(carPark);
	}

	public void fireEmployee(Employee employee, CarPark carPark) {
		carPark.removeEmployee(employee);
		employee.setCarPark(null);
	}
}
