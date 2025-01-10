package java_adv02.network.tcp.v1;

import static java_adv02.util.MyLogger.log;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 서버 먼저 실행 후 클라이언트 실행시키기
 * 클라이언트-서버 통신 결과
15:10:05.513 [     main] 서버 시작 
15:10:05.557 [     main] 서버 소켓 시작 - 리스닝 포트: 12345 
15:10:23.189 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=56568,localport=12345] 
15:10:23.196 [     main] client -> server: Hello 
15:10:23.198 [     main] client <- server:  World! 
15:10:23.199 [     main] 연결 종료: Socket[addr=/127.0.0.1,port=56568,localport=12345] 
 * 
 */
public class Server1 {

	private static final int PORT = 12345;

	public static void main(String args[]) throws IOException {
		log("서버 시작");
		ServerSocket serverSocket = new ServerSocket(PORT);
		log("서버 소켓 시작 - 리스닝 포트: "+PORT);
		
		Socket socket = serverSocket.accept();
		log("소켓 연결: " + socket);
		DataInputStream input = new DataInputStream(socket.getInputStream());
		DataOutputStream output = new DataOutputStream(socket.getOutputStream());

		// 서버로부터 문자 받기
		String received = input.readUTF();
		log("client -> server: " + received);

		// 클라이언트로에게 문자 보내기
		String toSend = " World!";
		output.writeUTF(toSend);
		log("client <- server: " + toSend);

		// 자원 정리
		log("연결 종료: " + socket);
		input.close();
		output.close();
		socket.close();
		serverSocket.close();

	}

}
