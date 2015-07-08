package selfProject;

public abstract class Employee {
private String name;
private String surname;
private int age;
double salary;

public Employee(){}
public Employee(String name, String surname, int age, double salary){
	this.name=name;
	this.surname=surname;
	this.age=age;
	this.salary=salary;
}
public String getName(){
	return name;
}
public void setName(String name){
	this.name=name;
}
public String getSurname(){
	return surname;
}
public void setSurname(String surname){
	this.surname=surname;
}
public int getAge(){
	return age;
}
public void setAge(int age){
	this.age=age;
}
public double getSalary(){
	return salary;
}
public void setSalary(double salary){
	this.salary=salary;
}
public String toString(){
	return "Name: "+name+"\nSurname: "+ surname+"\nAge: "+age+"\nSalary: "+salary;
}
}
