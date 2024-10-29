package java_mid01.lang.object.equals;

public class EqualsMain1 {

	public static void main(String args[]) {
		UserV1 user1 = new UserV1("id-100");
		UserV1 user2 = new UserV1("id-100");

		System.out.println("identity = "+(user1 == user2));// false
		System.out.println("equality = "+(user1.equals(user2)));// false
	}
}
