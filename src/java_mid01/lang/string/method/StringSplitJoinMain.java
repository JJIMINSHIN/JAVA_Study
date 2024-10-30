package java_mid01.lang.string.method;

public class StringSplitJoinMain {

	public static void main(String[] args) {
		String str = "Apple,Banana,Orange";
		
		// split()
		String[] splitStr = str.split(",");
		for (String s : splitStr) {
			System.out.println(s);
		}
		
		// join()
		String noJoin ="";
		for(int i=0; i<splitStr.length; i++) {
			String string = splitStr[i];
			noJoin += string;
			if( i!=splitStr.length-1) noJoin += "-";
		}
		System.out.println("join()메서드 없이 = "+noJoin); //마지막 - 안넣을거면 또 마지막 루프돌려야함
		
		String joinedStr = String.join("-", "A", "B", "C");
		System.out.println("연결된 문자열: " + joinedStr);
		
		// 문자열 배열 연결
		String result = String.join("-", splitStr);
		System.out.println("result = " + result);
	}

}
