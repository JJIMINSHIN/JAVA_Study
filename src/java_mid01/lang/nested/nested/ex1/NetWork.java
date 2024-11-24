package java_mid01.lang.nested.nested.ex1;

public class NetWork {

	public void sendMessage(String text) {
		NetWorkMessage networkMessage = new NetWorkMessage(text);
		networkMessage.print();
	}
	
}
