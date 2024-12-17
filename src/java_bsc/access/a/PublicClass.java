package java_bsc.access.a;

public class PublicClass {
	public static void main(String args[]) {
		PublicClass publicClass = new PublicClass();
		DefaultClass1 class1 = new DefaultClass1();
		DefaultClass2 class2 = new DefaultClass2();

	}
	public PublicClass(){
		System.out.println("PublicClass!!!");
	}
	
}
class DefaultClass1{
	DefaultClass1(){
		System.out.println("DefaultClass1!!");
	}
}
class DefaultClass2{
	DefaultClass2(){
		System.out.println("DefaultClass2!!");
	}
}
