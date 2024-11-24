package java_mid01.lang.nested.nested.ex1;

//Network 객체 안에서만 사용
public class NetWorkMessage {

	private String content;

	public NetWorkMessage(String content) {
		this.content = content;
	}
	
	public void print() {
		System.out.println(content);
	}
	
}
