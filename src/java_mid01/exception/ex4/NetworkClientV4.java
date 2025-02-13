package java_mid01.exception.ex4;

import java_mid01.exception.ex4.exception.ConnectExceptionV4;
import java_mid01.exception.ex4.exception.SendExceptionV4;

public class NetworkClientV4 {
	
	private final String address;
	public boolean connectError; // 기본값 false
	public boolean sendError;

	public NetworkClientV4(String address) {
		this.address = address;
	}
	
	// 연결 성공
	public void connect() throws ConnectExceptionV4{
		if(connectError) {
			throw new ConnectExceptionV4(address, address + " 서버 연결 실패");
		}
		System.out.println(address+" 서버 연결 성공");
	}
	
	// 전송 성공
	public void send(String data) throws SendExceptionV4{
		if(sendError) {
			throw new SendExceptionV4(data, address + " 서버에 데이터 전송 실패: " +data);
		}
		System.out.println(address+" 서버에 데이터 전송: "+data);
	}
	
	// 연결 해제
	public void disconnect() {
		System.out.println(address+ " 서버 연결 해제");
	}
	
	public void initError(String data) {
		if(data.contains("error1")) 
			connectError = true;
		
		if(data.contains("error2")) 
			sendError = true;
		
	}
	

}
