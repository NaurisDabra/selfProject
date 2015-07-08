package selfProject;

public class FamilyCar extends Vehicle {
float trunkVolume;
	public FamilyCar() {
		// TODO Auto-generated constructor stub
	}

	public FamilyCar(int ID, String name, double price, float trunkVolume) {
		super(ID, name, price);
		this.trunkVolume=trunkVolume;
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return super.toString()+"\nTrunk volume: "+trunkVolume;
	}
}
