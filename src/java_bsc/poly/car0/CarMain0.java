package java_bsc.poly.car0;

public class CarMain0 {
	public static void main(String args[]) {
		Driver driver = new Driver();
		K3Car k3Car = new K3Car();
		driver.setK3Car(k3Car);
		driver.drive();

		System.out.println("==== MODEL 추가 ====");
		// 추가
		Model3Car model3Car = new Model3Car();
		driver.setK3Car(null); //객체 초기화
		driver.setModel3Car(model3Car);
		driver.drive();
	}
}
