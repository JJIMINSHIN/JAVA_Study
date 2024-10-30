package java_mid01.lang.string.builder;

// 메서드 체이닝 적용
public class StringBuilderMain1_2 {
	public static void main(String args[]) {
		StringBuilder sb = new StringBuilder();
		
		String str = sb.append("A").append("B").append("C").append("D")
						.insert(4, "Java")
						.delete(4, 8)
						.reverse()
						.toString();
		
		System.out.println("String = "+str);
		
	}

}
