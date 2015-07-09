package selfProject;

import java.util.ArrayList;
import java.util.List;

public class CarPark {
	// TODO @Id @GeneratedValue(strategy=GenerationType.IDENTITY
	// TODO private long ID;
	private int ID;
	private String name;
	private String address;
	private List<Vehicle> allVehicles;
	private Manager manager;
	private List<Employee> employeeList;
	private double profit;

	public CarPark() {
	}

	public CarPark(int ID, String name, String address, List<Vehicle> allVehicles, Manager manager,
			List<Employee> employeeList) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.allVehicles = new ArrayList<Vehicle>(allVehicles);
		this.manager = manager;
		this.employeeList = new ArrayList<Employee>(employeeList);
		profit = 0;
	}

	public CarPark(int ID, String name, String address, Manager manager) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.allVehicles = new ArrayList<Vehicle>();
		this.manager = manager;
		this.employeeList = new ArrayList<Employee>();
		employeeList.add(manager);
		profit = 0;
	}

	public boolean removeVehicle(Vehicle vehicle) {
		boolean result = allVehicles.remove(vehicle);
		return result;
	}

	public List<Vehicle> getAllVehicles() {
		return allVehicles;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void addEmployee(Employee employee) {
		getEmployeeList().add(employee);
	}

	public void removeEmployee(Employee employee) {
		getEmployeeList().remove(employee);
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String printVehicles() {
		String text = "";
		for (int i = 0; i < allVehicles.size(); i++)
			text += allVehicles.get(i).toString() + "\n\n";
		return text;
	}

	public String printEmployees() {
		String text = "";
		for (int i = 0; i < employeeList.size(); i++)
			text += employeeList.get(i).toString() + "\n\n";
		return text;
	}

	public void carSold(double price) {
		profit += price;
	}
   public List<Vehicle> search(double price){
	  
	   List<Vehicle> result=new ArrayList<Vehicle>();
	  
	   for(int i=0; i<allVehicles.size();i++)
		   if(allVehicles.get(i).getPrice()<price)
			   result.add(allVehicles.get(i));
	   return result;
			   
   }
	public String toString() {
		return "Nosaukums: " + name + "\nAdresse: " + address + "\n\nHas earned: " + profit + "\n\nMenedzeris: \n"
				+ manager + "\n\nDarbinieki:\n" + printEmployees() + "\nAuto:\n" + printVehicles();
	}
}
