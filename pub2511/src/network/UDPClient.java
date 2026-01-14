package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
	
	public static void main(String[] args) {
		
		// 클라이언트 DatagramSocket
		DatagramSocket socket = null;
		
		try {
			
			// 수신 포트
			int receivePort = 9876;
			
			// DatagramSocket 객체 생성
			socket = new DatagramSocket(receivePort);
			
			// 서버에서 보낸 문자열 저장할 배열
			byte[] byteArr = new byte[1024];
			
			while(true) {
				
				// 수신용 DatagramPacket
				DatagramPacket packet
					= new DatagramPacket(byteArr, byteArr.length);
				
				System.out.println("UDP클라이언트 수신 " + receivePort + "번 포트에서 수신 대기중!");
				
				// DatagramPacket 수신
				socket.receive(packet);
				
				// 받은 문자열 : 서버에서 보낸 바이트 배열을 문자열로 변환
				String receiveStr = new String(packet.getData(), 0, packet.getLength());
				
				System.out.println(packet.getAddress() + "서버로부터...");
				System.out.println("받은 문자열 : " + receiveStr + "\n");
				
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		
	}

}






























