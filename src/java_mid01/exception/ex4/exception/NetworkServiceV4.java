package java_mid01.exception.ex4.exception;

import java_mid01.exception.ex3.exception.ConnectExceptionV3;
import java_mid01.exception.ex3.exception.SendExceptionV3;
import java_mid01.exception.ex4.NetworkClientV4;

public class NetworkServiceV4 {
	
	public void sendMessage(String data){
		
		String address= "http://example.com";
		NetworkClientV4 client = new NetworkClientV4(address);
		client.initError(data); // 에러 호출
		
		try {
			client.connect();
			client.send(data);
		} finally {
			client.disconnect();
		}
	}
}
