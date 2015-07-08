package selfProject;

public class Vehicle {
private int ID;
private String name;
private double price;
public Vehicle(){}
public Vehicle(int ID, String name, double price){
	this.ID=ID;
	this.name=name;
	this.price=price;
}
public String getName(){
	return name;
}
public void setName(String name){
	this.name=name;
}
public double getPrice(){
	return price;
}
public void setPrice(double price){
	this.price=price;
}
public String toString(){
	return "ID: "+ID+"\nName: "+name+"\nPrice: "+price;
}
}
