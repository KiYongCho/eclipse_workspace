package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class TCPClient {
	
	public static void main(String[] args) {
		
		// 클라이언트소켓
		Socket clientSocket = null;
		
		// 서버에 문자를 송신할 문자출력스트림
		PrintWriter pw = null;
		
		// 서버에선 보낸 문자열을 수신할 문자입력스트림
		BufferedReader br = null;
		
		try {
			
			// 클라이언트소켓 생성
			clientSocket = new Socket("192.168.8.254", 5555); // 서버IP, 포트번호
			
			// 클라이어트소켓에서 서버로 바이너리를 전송할 스트림을 얻어서 문자스트림으로 변경
			pw = new PrintWriter(
				new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8")
			);
			
			// 서버로 문자열 전송
			pw.println("클라이언트가 보낸 메세지 : 서버 안녕~!");
			pw.flush();
			
			// 서버에서 보낸 바이너리 데이터를 문자 데이터로 변경해서 버퍼링하는 스트림
			br = new BufferedReader(
				new InputStreamReader(clientSocket.getInputStream(), "UTF-8")
			);
			
			// 서버에서 보낸 문자열을 화면에 출력
			System.out.println("서버가 보낸 메세지 : " + br.readLine());			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				pw.close();
				clientSocket.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

}





















