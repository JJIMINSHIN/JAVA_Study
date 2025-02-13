package java_mid01.exception.ex2;

public class NetworkServiceV2_1 {
	
	public void sendMessage(String data) throws NetWorkClientExceptionV2 {
		
		String address= "http://example.com";
		NetworkClientV2 client = new NetworkClientV2(address);
		client.initError(data); // 에러 호출
		
		client.connect();
		client.send(data);
		client.disconnect();
		
	}

}
