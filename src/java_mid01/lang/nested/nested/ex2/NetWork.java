package java_mid01.lang.nested.nested.ex2;

public class NetWork {

	public void sendMessage(String text) {
		NetWorkMessage networkMessage = new NetWorkMessage(text);
		networkMessage.print();
	}
	
	private static class NetWorkMessage {

		private String content;

		public NetWorkMessage(String content) {
			this.content = content;
		}
		
		public void print() {
			System.out.println(content);
		}
		
	}
}
