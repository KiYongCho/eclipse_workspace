package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	
	public static void main(String[] args) {
		
		// 서버소켓
		// 클라이언트 소켓의 연결요청을 받으면 클라이언트 소켓과 데이터를 송수신할 수 있는
		// 서버측소켓을 생성하는 역할
		ServerSocket ss = null;
		
		// 클라이언트와 송수신하는데 사용되는 서버측소켓
		Socket dataSocket = null;
		
		// 클라이언트가 보낸 문자열을 버퍼링해서 입력받을 스트림
		BufferedReader br = null;
		
		// 클라이언트에게 문자열을 보낼때 사용할 스트림
		PrintWriter pw = null;
		
		try {
			
			// 서버소켓 객체 생성
			ss = new ServerSocket(5555); // 서버소켓 포트번호
			if (ss != null) { // 서버소켓이 생성 되었다면
				System.out.println("ServerSocket 생성됨!");				
			}
			
			// 클라이언트 접속을 무한 대기
			while (true) {
				
				// 클라이언트 접속을 기다렸다가 접속하면 클라이언트 소켓과 교신할 서버측 소켓을 생성
				// accept() : blocking method, 접속할때까지 계속 대기했다가 접속이 되면
				//                클라이언트 소켓과 교신할 서버측 소켓을 반환
				dataSocket = ss.accept();
				System.out.println("클라이언트 접속함!");
				
				if (dataSocket != null) { // 클라이언트 소켓과 교신할 서버측 소켓이 있다면
					// 서버측소켓에서 바이너리 입력스트림을 얻어서 문자입력스트림으로 변경하고 버퍼링
					br = new BufferedReader(
						new InputStreamReader(dataSocket.getInputStream())
					);
					System.out.println("클라이언트 IP : " + dataSocket.getInetAddress());
					System.out.println("클라이언트가 보낸 문자열 : " + br.readLine());
				}
				
				// 서버측소켓에서 바이너리 출력스트림을 얻어서 문자출력스트림으로 변경한 후 PrintWriter 생성
				pw = new PrintWriter(
					new OutputStreamWriter(dataSocket.getOutputStream())
				);
				// 서버측에서 문자열을 송신
				pw.println(dataSocket.getInetAddress() + "님 안녕하세요!");
				pw.flush();
				
			} // while
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
				dataSocket.close();
				ss.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

}









