package java_bsc.extends1.ex2;

public class CarMain {
	
	public static void main(String args[]) {
		ElectricCar electriCar = new ElectricCar();
		electriCar.move();
		electriCar.charge();
		
		GasCar gasCar = new GasCar();
		gasCar.move();
		gasCar.fillUp();
		
	}
}
