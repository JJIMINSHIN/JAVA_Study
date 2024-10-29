package java_bsc.extends1.overriding;

public class CarMain {
	
	public static void main(String args[]) {
		ElectricCar electriCar = new ElectricCar();
		electriCar.move();
		electriCar.charge();
		electriCar.openDoor();
		
		GasCar gasCar = new GasCar();
		gasCar.move();

	}
}
