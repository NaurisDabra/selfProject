package selfProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;

public class Test {
	static CarPark autoplacis;
	static Manager menedzeris;

	public static void main(String[] args) {
		 autoplacis= new CarPark(1, "autoplacis", "Riga" );
			menedzeris=new Manager(1, "Janis", "Ozols", 40, 500.00, autoplacis);
			
		menedzeris.hireEmployee(new Salesperson(2, "Nauris", "Dabra", 23, 200));
		menedzeris.hireEmployee(new Supplier(3, "Oskars", "Vacietis", 26, 300));
		menedzeris.hireEmployee(new Cleaner(4, "Janis", "Tirais", 50, 100.00));

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
		menuStart();
		/*
		 * System.out.println(autoplacis); List<Vehicle> result =
		 * autoplacis.search(90000.0); System.out.println(
		 * "Search results:\nEntries found: " + result.size()); for (int i = 0;
		 * i < result.size(); i++) { System.out.println("\n" +
		 * result.get(i).toString()); }
		 */
	}

	public static void menuStart() {
		System.out.println("Welcome to database \nUse as a: \n1)Employee\n2)Customer");
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int choice = -1;
		while (choice == -1)
			try {
				choice = in.nextInt();
				if (choice < 1 || choice > 2)
					throw new Exception();
				break;
			} catch (Exception e) {
				System.out.println("Enter 1 or 2");
				choice=-1;
			}
		switch (choice) {
		case 1:
			menuEmployee();
			break;
		case 2:
			menuCustomer();
			break;
		}
	}

	public static void menuEmployee() {
		System.out.println("Select your job: \n1)Manager\n2)Salesperson\n3)Supplier\n4)Cleaner");
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int choice = -1;
		while (choice == -1) {
			try {
				choice = in.nextInt();
				if (choice < 1 && choice > 4)
					throw new IOException();
				break;
			} catch (IOException e) {
				System.out.println("Enter number between 1 and 4");
			}
		}
		switch (choice) {
		case 1:
			menuManager();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;

		}

	}

	public static void menuCustomer() {

		Scanner in = new Scanner(new InputStreamReader(System.in));
		int choice;
		choice = -1;
		while (choice != -2) {
			System.out.println("Select search parameter:\n1)Maximum price\n0)Exit to main menu");
			while (choice == -1) {
				try {
					choice = in.nextInt();
					if (choice < 0 || choice > 1)
						throw new Exception();

				} catch (Exception e) {
					System.out.println("Entered incorrect value");
					choice =-1;
				}
			}
			switch (choice) {
			case 0:
				choice = -2;
				menuStart();
				break;
			case 1:
				System.out.println("Enter maximum price");
				double price = 0;
				try {
					price = in.nextDouble();
				} catch (Exception e) {
					System.out.println("Entered incorrect value");
					choice = -1;
					break;
				}
				List<Vehicle> result = autoplacis.search(price);
				System.out.println("Search results:\nEntries found: " + result.size());
				for (int i = 0; i < result.size(); i++) {
					System.out.println("\n" + result.get(i).toString());
				}
				choice = -1;
				break;

			}
		}
	}

	public static void menuManager() {
		Scanner in = new Scanner(new InputStreamReader(System.in));
		int choice, age;
		double salary;
		String name="", surname="";
		choice = -1;

		while (choice != -2) {
			System.out.println("Chose: \n1)Hire employee\n2)Fire employee\n0)Exit to main menu)");
			while (choice == -1) {
				try {
					choice = in.nextInt();
					if (choice < 0 || choice > 4)
						throw new IOException();

				} catch (IOException e) {
					System.out.println("Entered incorrect value");
				}
			

			switch (choice) {
			case 0:
				choice = -2;
				menuStart();
				break;
			case 1:
				while (true) {
					System.out.println("Enter the employee's name");
					try {
						name = in.nextLine();
						break;
					} catch (Exception e) {
						System.out.println("Incorrect value");
					}
				}
					while (true) {
						System.out.println("Enter the employee's surname");
						try {
							surname = in.nextLine();
							break;
						} catch (Exception e) {
							System.out.println("Incorrect value");
						}
					}
					while (true) {
						System.out.println("Enter the employee's age");
						try {
							age = in.nextInt();
							if (age < 10)
								throw new Exception();
							break;
						} catch (Exception e) {
							System.out.println("Incorrect value");
						}
					}
					while (true) {
						System.out.println("Enter the employee's salary");
						try {
							salary = in.nextDouble();
							if (salary < 0)
								throw new Exception();
							break;
						} catch (Exception e) {
							System.out.println("Incorrect value");
						}

					}
					int prof;
					while (true) {
						System.out.println(
								"Chose employee's profesion: \n1)Manager2)\nSalesperson\n3)Supplier\n4)Cleaner");
						try {
							prof = in.nextInt();
							if (prof < 1 || prof > 4)
								throw new Exception();
							break;
						} catch (Exception e) {
							System.out.println("Incorrect value");
						}

					}

					switch (prof) {
					case 1:
					
						menedzeris.hireEmployee(new Manager(autoplacis.getManagerList().size(),name, surname, age, salary, autoplacis));
						break;

					case 2:
						
						menedzeris.hireEmployee(new Salesperson(autoplacis.getManagerList().size(),name, surname, age, salary));
						
						break;

					case 3:
						
						menedzeris.hireEmployee(new Supplier(autoplacis.getManagerList().size(),name, surname, age, salary));
						
						break;

					case 4:
				
						menedzeris.hireEmployee(new Cleaner(autoplacis.getManagerList().size(),name, surname, age, salary));
						
						break;

					}
					
				
			case 2:
				autoplacis.toString();

			}}
		}
	}
}
