package java_mid01.lang.nested.inner;


public class InnerOuter {
	private static int outClassValue = 3;
	private int outInstanceValue = 2;
	
	class Inner{
		private int nestedInstanceValue=1;
		
		public void print() {
			
			// 자신의 멤버에 접근
			System.out.println(nestedInstanceValue);
			
			// 외부 클래스의 인스턴스 멤버에 접근 가능, private도 접근 가능
			System.out.println(outInstanceValue);
			
			// 외부 클래스의 인스턴스 멤버에 접근 가능, private도 접근 가능
			System.out.println(InnerOuter.outClassValue);
			
		}
	}

}
