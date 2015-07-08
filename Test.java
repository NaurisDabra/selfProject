package selfProject;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		CarPark autoplacis = new CarPark(1, "autoplacis", "Riga", new Manager("Janis", "Ozols", 40, 500.00));
		Manager menedzeris = autoplacis.getManager();
		menedzeris.hireEmployee(new Salesperson("Nauris", "Dabra", 23, 200), autoplacis);
		menedzeris.hireEmployee(new Supplier("Oskars", "Vacietis", 26, 300), autoplacis);
		List<Employee> darbinieki = autoplacis.getEmployeeList();
		List<Salesperson> pardeveji = new ArrayList<Salesperson>();
		List<Supplier> piegadataji = new ArrayList<Supplier>();
		Salesperson pardevejs = null;
		Supplier piegadatajs = null;
		for (int i = 0; i < darbinieki.size(); i++) {
			if (darbinieki.get(i).getClass() == Salesperson.class) {
				pardeveji.add((Salesperson) darbinieki.get(i));
				pardevejs = (Salesperson) darbinieki.get(i);
			
			}
			if (darbinieki.get(i).getClass() == Supplier.class) {
				piegadataji.add((Supplier) darbinieki.get(i));
				piegadatajs = (Supplier) (darbinieki.get(i));
			}

		}
		Vehicle auto1 = new SportsCar(1, "Mustangs kautkads", 20000.0, 250);
		Vehicle auto2 = new FamilyCar(2, "Honda", 20000.0, 500);
		piegadatajs.supplyCar(auto1,autoplacis);
		piegadatajs.supplyCar(auto2,autoplacis);
		
		//pardevejs.sellVehicle(auto2, autoplacis);
		
		System.out.println(autoplacis);
	}

}
