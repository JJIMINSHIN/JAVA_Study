package java_mid01.lang.object.tostring;

public class Dog {
	private String dogName;
	private int age;
	
	public Dog(String dogName, int age) {
		this.dogName = dogName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [dogName=" + dogName + ", age=" + age + "]";
	}
	
	/* IDE 도움 없이
	 * @Override public String toString() { return "dogNAme = "+
	 * dogName+" / "+" age = "+age; }
	 */
	
	
}
