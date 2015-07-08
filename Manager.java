package selfProject;

public class Manager extends Employee {
public Manager(String name, String surname, int age, double salary){
	super(name, surname, age, salary);
}
	public void hireEmployee(Employee employee, CarPark carPark){
		carPark.addEmployee(employee);
	}
	public void fireEmployee(Employee employee, CarPark carPark){
		carPark.removeEmployee(employee);
	}
}
