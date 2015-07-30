package selfProject;

public class Manager extends Employee {
	public Manager(int ID, String name, String surname, int age, double salary, CarPark carPark) {
		super(ID, name, surname, age, salary);
		this.setProfession("Manager");
		System.out.println(carPark);
		this.setCarPark(carPark);
	}

	public void hireEmployee(Employee employee) {
		this.getCarPark().addEmployee(employee);
		employee.setCarPark(this.getCarPark());
	}

	public void fireEmployee(Employee employee) {
		this.getCarPark().removeEmployee(employee);
		employee.setCarPark(null);
	}
	
}
