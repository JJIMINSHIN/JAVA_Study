package java_mid01.lang.wrapper;

public class MyIntegerNullMain0 {

	public static void main(String args[]) {
		int[] intArr = { -1, 0, 1, 2, 3 };

		System.out.println(findValue(intArr, -1)); // -1
		System.out.println("================");
		System.out.println(findValue(intArr, 0));
		System.out.println("================");
		System.out.println(findValue(intArr, 1));
		System.out.println("================");
		System.out.println(findValue(intArr, 100)); // -1
	}

	public static int findValue(int[] intArr, int target) {
		for(int v : intArr) {
			if(v == target) return v;
		}
		return -1;
	}
}
