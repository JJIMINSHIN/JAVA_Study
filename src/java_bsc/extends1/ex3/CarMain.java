package java_bsc.extends1.ex3;

public class CarMain {
	
	public static void main(String args[]) {
		ElectricCar electriCar = new ElectricCar();
		electriCar.move();
		electriCar.charge();
		electriCar.openDoor();
		
		GasCar gasCar = new GasCar();
		gasCar.move();
		gasCar.fillUp();
		gasCar.openDoor();
		
		HydrogenCar hydrogenCar = new HydrogenCar();
		hydrogenCar.move();
		hydrogenCar.fillHydrogen();
		hydrogenCar.openDoor();
	}
}
