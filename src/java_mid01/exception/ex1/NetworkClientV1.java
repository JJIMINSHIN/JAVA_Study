package java_mid01.exception.ex1;

public class NetworkClientV1 {
	
	private final String address;
	public boolean connectError; // 기본값 false
	public boolean sendError;

	public NetworkClientV1(String address) {
		this.address = address;
	}
	
	// 연결 성공
	public String connect() {
		if(connectError) {
			System.out.println(address+" 서버 연결 실페");
			return "connectError";
		}
		System.out.println(address+" 서버 연결 성공");
		return "success";
	}
	
	// 전송 성공
	public String send(String data) {
		
		if(sendError) {
			System.out.println(address+" 서버에 데이터 전송 실패: "+data);
			return "sendError";
		}
		
		System.out.println(address+" 서버에 데이터 전송: "+data);
		return "success";
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
