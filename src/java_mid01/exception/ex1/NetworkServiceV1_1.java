package java_mid01.exception.ex1;

public class NetworkServiceV1_1 {
	
	public void sendMessage(String data) {
		String address= "http://example.com";
		NetworkClientV1 client = new NetworkClientV1(address);
		client.initError(data); // 에러 호출
		
		client.connect();
		client.send(data);
		client.disconnect();
		
	}

}
