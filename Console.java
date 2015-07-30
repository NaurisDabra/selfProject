package selfProject;

import java.util.Scanner;

public class Console {
	int num;
	public Console() {
		
	}
	public void main(String args[]){
		System.out.println("Chose action:");
		System.out.println("1 - Add carpark");
		System.out.println("2 - Add employee");
		System.out.println("3 - Add car");
		System.out.println("4 - Sell car");
		//System.out.println("5 - Exit");
		while(true){
		
		try{
		Scanner in = new Scanner(System.in);
		num = in.nextInt();
		if(num<1||num>4)
			throw new Exception();
		break;}
		catch(Exception e)
		{System.out.println("Must enter number from 1 to 4");
		}
		}
		switch(num){
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		}
		
	}
}
