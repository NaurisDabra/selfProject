package selfProject;

public class SportsCar extends Vehicle {
private float maxSpeed;

	public SportsCar() {
		// TODO Auto-generated constructor stub
	}

	public SportsCar(int ID, String name, double price, float maxSpeed) {
		super(ID, name, price);
		this.maxSpeed=maxSpeed;
		// TODO Auto-generated constructor stub
	}
public String toString(){
	return super.toString()+"\nMax Speed: "+maxSpeed;
}
}
