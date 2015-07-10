package selfProject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		CarPark autoplacis = new CarPark(1, "autoplacis", "Riga", new Manager(1, "Janis", "Ozols", 40, 500.00));
		Manager menedzeris = autoplacis.getManager();

		menedzeris.hireEmployee(new Salesperson(2, "Nauris", "Dabra", 23, 200), autoplacis);
		menedzeris.hireEmployee(new Supplier(3, "Oskars", "Vacietis", 26, 300), autoplacis);
		menedzeris.hireEmployee(new Cleaner(4, "Janis", "Tirais", 50, 100.00), autoplacis);

		List<Salesperson> pardeveji = autoplacis.getSalepersonList();
		List<Supplier> piegadataji = autoplacis.getSupplierList();
		List<Cleaner> tiritaji = autoplacis.getCleanerList();

		Cleaner mrCleanIt = tiritaji.get(0);
		Salesperson pardevejs = pardeveji.get(0);
		Supplier piegadatajs = piegadataji.get(0);

		Vehicle auto1 = new SportsCar(1, "Mustangs kautkads", 50000.0, 2, 0, 250, true);
		Vehicle auto2 = new Car(2, "Honda", 20000.0, 4, 500);
		Vehicle auto3 = new SportsCar(3, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle auto4 = new Car(4, "Honda", 20000.0, 6, 500);
		Vehicle auto5 = new SportsCar(5, "Ferrari", 200000.0, 2, 0, 300, false);
		Vehicle bike1 = new SportsBike(5, "Suzuki", 10000.0, 100, 200, "lightweight");
		Vehicle bike2 = new SportsBike(6, "Suzuki", 15000.0, 100, 200, "lghtweight");

		piegadatajs.supplyCar(auto1);
		piegadatajs.supplyCar(auto2);
		piegadatajs.supplyCar(auto3);
		piegadatajs.supplyCar(auto4);
		piegadatajs.supplyCar(auto5);
		piegadatajs.supplyCar(bike1);
		piegadatajs.supplyCar(bike2);

		pardevejs.sellVehicle(auto2);
		pardevejs.sellVehicle(auto3);
		pardevejs.sellVehicle(bike1);
		pardevejs.requestCleaning(auto4);

		mrCleanIt.cleanVehicle(auto4);
		mrCleanIt.cleanVehicle(auto1);

		System.out.println(autoplacis);
		List<Vehicle> result = autoplacis.search(90000.0);
		System.out.println("Search results:\nEntries found: " + result.size());
		for (int i = 0; i < result.size(); i++) {
			System.out.println("\n" + result.get(i).toString());
		}
	}

}
