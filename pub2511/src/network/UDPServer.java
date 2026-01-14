package network;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {

	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		try {
			
			// DatagramSocket 객체 생성
			socket = new DatagramSocket();
			
			// 브로드캐스트 설정
			// 유니캐스트:1대1통신, 브로드캐스트:1대다통신
			socket.setBroadcast(true);
			
			// 보낼 문자열
			String message = "헬로우 에브리원~!";
			
			// 전송을 위해 문자열을 바이트배열로 변환
			byte[] byteArr = message.getBytes();
			
			// 브로드캐스트 IP
			InetAddress broadcastIP = InetAddress.getByName("192.168.8.255");
			
			// 브로드캐스트 포트
			int broadcastPort = 9876;
			
			// DatagramPacket 객체 생성 
			// DatagramPacket : UDP를 통해서 전송되는 데이터
			DatagramPacket packet = new DatagramPacket(
				byteArr, // 전송할 바이트 배열
				byteArr.length, // 전송할 바이스 수
				broadcastIP, // 브로드캐스트 IP
				broadcastPort // 브로드캐스트 포트
			);
			
			// 데이터를 브로드캐스트
			socket.send(packet);
			
			System.out.println("브로드캐스트 완료!");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
	} // main
	
} // class
































