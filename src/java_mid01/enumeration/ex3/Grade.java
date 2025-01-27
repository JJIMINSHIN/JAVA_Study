package java_mid01.enumeration.ex3;

public enum Grade {
	BASIC, GOLD, DIAMOND
}

/*
 * enum 사용시 아래의 자바코드와 거의 같다
public class Grade extends Enum {
 	public static final Grade BASIC = new Grade();
 	public static final Grade GOLD = new Grade();
 	public static final Grade DIAMOND = new Grade();
 
 	//private 생성자 추가
 	private Grade() {}
}
 */