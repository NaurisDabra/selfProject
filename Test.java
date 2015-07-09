package selfProject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Test{

	public static void main(String[] args) {
		CarPark autoplacis = new CarPark(1, "autoplacis", "Riga", new Manager(1,"Janis", "Ozols", 40, 500.00));
		Manager menedzeris = autoplacis.getManager();
		menedzeris.hireEmployee(new Salesperson(2,"Nauris", "Dabra", 23, 200), autoplacis);
		menedzeris.hireEmployee(new Supplier(3, "Oskars", "Vacietis", 26, 300), autoplacis);
		List<Employee> darbinieki = autoplacis.getEmployeeList();
		List<Salesperson> pardeveji = new ArrayList<Salesperson>();
		List<Supplier> piegadataji = new ArrayList<Supplier>();
		Salesperson pardevejs = null;
		Supplier piegadatajs = null;
        
		for (int i = 0; i < darbinieki.size(); i++) {
//			if (darbinieki.get(i).getClass() == Salesperson.class) {
//				pardeveji.add((Salesperson) darbinieki.get(i));
//				pardevejs = (Salesperson) darbinieki.get(i);
//
//			}
//			if (darbinieki.get(i).getClass() == Supplier.class) {
//				piegadataji.add((Supplier) darbinieki.get(i));
//				piegadatajs = (Supplier) (darbinieki.get(i));
//			}
			Employee e = darbinieki.get(i);
		}

		Vehicle auto1 = new SportsCar(1, "Mustangs kautkads", 50000.0, 2, 0, 250, true);
		Vehicle auto2 = new Car(2, "Honda", 20000.0, 4, 500);
		Vehicle auto3 = new SportsCar(3, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle auto4 = new Car(4, "Honda", 20000.0, 6, 500);
		Vehicle auto5 = new SportsCar(5, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle bike1 = new SportsBike(5, "Suzuki", 10000.0, 100, 200, "lightweight");
		Vehicle bike2 = new SportsBike(6, "Suzuki", 15000.0, 100, 200, "lghtweight");
		piegadatajs.supplyCar(auto1, autoplacis);
		piegadatajs.supplyCar(auto2, autoplacis);
		piegadatajs.supplyCar(auto3, autoplacis);
		piegadatajs.supplyCar(auto4, autoplacis);
		piegadatajs.supplyCar(auto5, autoplacis);
		piegadatajs.supplyCar(bike1, autoplacis);
		piegadatajs.supplyCar(bike2, autoplacis);
		pardevejs.sellVehicle(auto2, autoplacis);
		pardevejs.sellVehicle(auto3, autoplacis);
		pardevejs.sellVehicle(bike1, autoplacis);
		pardevejs.requestCleaning(auto4);
		Cleaner mrCleanIt = new Cleaner(4, "Janis", "Tirais", 50, 100.00);
		menedzeris.hireEmployee(mrCleanIt, autoplacis);
		mrCleanIt.cleanVehicle(auto4);
		mrCleanIt.cleanVehicle(auto1);
		System.out.println(autoplacis);
		List<Vehicle> result=autoplacis.search(90000.0);
		System.out.println("Search results:\nEntries found: "+result.size());
		for(int i=0;i<result.size();i++){
			System.out.println("\n"+result.get(i).toString());}
	}

}
