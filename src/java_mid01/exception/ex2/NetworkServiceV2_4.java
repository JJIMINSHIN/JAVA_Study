package java_mid01.exception.ex2;

public class NetworkServiceV2_4 {
	
	public void sendMessage(String data) throws NetWorkClientExceptionV2 {
		
		String address= "http://example.com";
		NetworkClientV2 client = new NetworkClientV2(address);
		client.initError(data); // 에러 호출
		
		try {
			client.connect();
			client.send(data);
		} catch (NetWorkClientExceptionV2 e) {
			System.out.println("[오류] 코드: "+e.getErrorCode()+", 메세지: "+e.getMessage());
			return;
		}
		client.disconnect();
	}
}
