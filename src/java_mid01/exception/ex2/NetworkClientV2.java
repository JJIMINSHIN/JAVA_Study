package java_mid01.exception.ex2;

public class NetworkClientV2 {
	
	private final String address;
	public boolean connectError; // 기본값 false
	public boolean sendError;

	public NetworkClientV2(String address) {
		this.address = address;
	}
	
	// 연결 성공
	public void connect() throws NetWorkClientExceptionV2{
		if(connectError) {
			throw new NetWorkClientExceptionV2("connectError", address+" 서버 연결 실페");
		}
		System.out.println(address+" 서버 연결 성공");
	}
	
	// 전송 성공
	public void send(String data) throws NetWorkClientExceptionV2{
		
		if(sendError) {
			throw new NetWorkClientExceptionV2("sendError", address+" 서버에 데이터 전송 실패: "+data);
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
