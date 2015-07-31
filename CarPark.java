package selfProject;

import java.util.ArrayList;
import java.util.List;

public class CarPark{
	// TODO @Id @GeneratedValue(strategy=GenerationType.IDENTITY
	// TODO private long ID;
	private int ID;
	private String name;
	private String address;
	private List<Vehicle> allVehicles;
	private Manager manager;
	private List<Manager> managerList;
	private double profit;
	private List<Salesperson> salepersonList;
	private List<Cleaner> cleanerList;
	private List<Supplier> supplierList;
	private final String[] professions = { "Manager", "Salesperson", "Supplier", "Cleaner" };
	private final int MANAGER=0, SALESPERSON=1, SUPPLIER=2, CLEANER=3;
	// private List<Class> employeeTypes;
	public CarPark() {
	}

	public CarPark(int ID, String name, String address, Manager manager) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.allVehicles = new ArrayList<Vehicle>();
		this.manager = manager;
		managerList = new ArrayList<Manager>();
		managerList.add(manager);
		salepersonList = new ArrayList<Salesperson>();
		cleanerList = new ArrayList<Cleaner>();
		supplierList = new ArrayList<Supplier>();
		profit = 0;
		// employeeTypes = new ArrayList<Class>();
	}

	public CarPark(int ID, String name, String address) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.allVehicles = new ArrayList<Vehicle>();
	
		managerList = new ArrayList<Manager>();
	
		salepersonList = new ArrayList<Salesperson>();
		cleanerList = new ArrayList<Cleaner>();
		supplierList = new ArrayList<Supplier>();
		profit = 0;
		// employeeTypes = new ArrayList<Class>();
	}
	public void addManager(Manager manager){
		managerList.add(manager);
	}
	// public CarPark(int ID, String name, String address, Manager manager) {
	// this.ID = ID;
	// this.name = name;
	// this.address = address;
	// this.allVehicles = new ArrayList<Vehicle>();
	// this.manager = manager;
	// this.employeeList = new ArrayList<Employee>();
	// employeeList.add(manager);
	// profit = 0;
	// }

	public boolean removeVehicle(Vehicle vehicle) {
		boolean result = allVehicles.remove(vehicle);
		return result;
	}

	/*
	 * public List<Class> returnEmployeeByType(Class klase){ Class jauna =
	 * klase.getClass(); List<Class<>> result = new ArrayList<Class>(); for(int
	 * i=0;i<employeeList.size();i++){ if(employeeList.get(i).getClass()==klase)
	 * result.add(employeeList.get(i)); } return result; }
	 */
	public List<Vehicle> getAllVehicles() {
		return allVehicles;
	}

	public List<Manager> getManagerList() {
		return managerList;
	}

	public List<Salesperson> getSalepersonList() {
		return salepersonList;
	}

	public List<Supplier> getSupplierList() {
		return supplierList;
	}

	public List<Cleaner> getCleanerList() {
		return cleanerList;
	}

	public void addEmployee(Employee employee) {
		if (employee.getProfession() == professions[MANAGER])
			managerList.add((Manager) employee);
		if (employee.getProfession() == professions[SALESPERSON])
			salepersonList.add((Salesperson) employee);
		if (employee.getProfession() == professions[SUPPLIER])
			supplierList.add((Supplier) employee);
		if (employee.getProfession() == professions[CLEANER])
			cleanerList.add((Cleaner) employee);

	}

	public void removeEmployee(Employee employee) {
		if (employee.getProfession() == professions[MANAGER])
			managerList.remove(employee);
		if (employee.getProfession() == professions[SALESPERSON])
			salepersonList.remove(employee);
		if (employee.getProfession() == professions[SUPPLIER])
			supplierList.remove(employee);
		if (employee.getProfession() == professions[CLEANER])
			cleanerList.remove(employee);
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String printVehicles() {
		String text = "";
		if(allVehicles.size()>0){
			text="Vehicles:\n";
		for (int i = 0; i < allVehicles.size(); i++)
			text += allVehicles.get(i).toString() + "\n\n";}
		return text;
	}
	
	public String printEmployeeList(List employee){
		String text="";
		if(!employee.isEmpty())
			text=((Employee) employee.get(0)).getProfession()+"\n";
		for(int i=0;i<employee.size();i++)
			text+=employee.get(i).toString()+"\n\n";
		return text;
	}
	
	public String printEmployees() {
		String text = "";
	
		text+=printEmployeeList(managerList);
		text+=printEmployeeList(salepersonList);
		text+=printEmployeeList(supplierList);
		text+=printEmployeeList(cleanerList);
		
		return text;
	}

	public void carSold(double price) {
		profit += price;
	}

	public List<Vehicle> search(double price) {

		List<Vehicle> result = new ArrayList<Vehicle>();

		for (int i = 0; i < allVehicles.size(); i++)
			if (allVehicles.get(i).getPrice() < price)
				result.add(allVehicles.get(i));
		return result;

	}

	public String toString() {
		return "Nosaukums: " + name + "\nAdresse: " + address + "\n\nHas earned: " + profit + "\n\nMenedzeris: \n"
				+ manager + "\n\nDarbinieki:\n" + printEmployees() +  printVehicles();
	}
}
