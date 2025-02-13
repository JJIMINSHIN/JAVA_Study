package java_mid01.exception.ex4;

public class NetworkServiceV5 {
	public void sendMessage(String data) {

		String address = "http://example.com";

		try(NetworkClientV5 client = new NetworkClientV5(address)) {
			client.initError(data); // 에러 호출

			client.connect();
			client.send(data);
		}catch(Exception e) {
			System.out.println("[예외 확인]: "+e.getMessage());
			throw e;
		}
	}

}
