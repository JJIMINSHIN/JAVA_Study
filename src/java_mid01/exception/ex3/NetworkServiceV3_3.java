package java_mid01.exception.ex3;

import java_mid01.exception.ex3.exception.ConnectExceptionV3;
import java_mid01.exception.ex3.exception.NetworkClientV3;
import java_mid01.exception.ex3.exception.SendExceptionV3;

public class NetworkServiceV3_3 {
	
	public void sendMessage(String data){
		
		String address= "http://example.com";
		NetworkClientV3 client = new NetworkClientV3(address);
		client.initError(data); 
		
		try {
			client.connect();
			client.send(data);
		} catch (ConnectExceptionV3 |SendExceptionV3  e) {
			System.out.println("[연결/네트워크 오류] 주소: "+e.getMessage()+", 메세지: "+e.getMessage());
		}finally {
			client.disconnect();
		}
	}
}
