package java_mid02.generic.ex4;

public class GenericMethod {
	
	public static Object objMethod(Object obj) {
		System.out.println("obj print : "+obj);
		return obj;
	}

	public static<T> T genericMethod(T t) {
		System.out.println("generic print : "+t);
		return t;
	}
	
	public static <T extends Number> T numberMethod(T t) {
		System.out.println("bound print : "+t);
		return t;
	}
	
}
