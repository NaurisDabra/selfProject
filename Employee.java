package selfProject;

import java.util.List;

//TODO @Entity
public abstract class Employee {
	private String name;
	// TODO @OneToOne(fetch=FetchType.LAZY)
	// TODO CarPark carPark;
	private String surname;
	private int age;
	private double salary;
	private int ID;
	private CarPark carPark;
	private String profession;
	// TODO @Id @GeneratedValue(strategy=GenerationType.IDENTITY
	// TODO private long ID;
	public Employee() {
	}

	public Employee(int ID, String name, String surname, int age, double salary) {
		this.ID=ID;
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.salary = salary;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
  public void setCarPark(CarPark carPark){
	  this.carPark=carPark;
  }
  public CarPark getCarPark(){
	  return carPark;
  }
  public void setProfession(String profession){
	  this.profession=profession;
  }
  public String getProfession(){
	  return profession;
  }
	public String toString() {
		return "ID: "+ID+"\nName: " + name + "\nSurname: " + surname + "\nAge: " + age + "\nSalary: " + salary;
	}
}
