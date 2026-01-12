package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTest {
	
	public static void main(String[] args) {
		
		File file = new File("D:/pub2511/files/data.dat");
		
		// 기본타입 데이터와 문자열을 바이트단위로 쓰는 스트림
		DataOutputStream dos = null;
		
		// 기본타입 데이터와 문자열을 바이트단위로 읽는 스트림
		DataInputStream dis = null;
		
		try {
			
			// FileOutputStream에 연결된 DataOutputStream 객체 생성
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeInt(20); // 4 byte
			dos.writeBoolean(false); // 1 byte
			dos.writeFloat(3.14f); // 4 byte
			dos.writeUTF("홍길동"); // String
			dos.flush();
			
			// FileInputStream에 연결된 DataInputStream 객체 생성
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readInt());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readFloat());
			System.out.println(dis.readUTF());
			
			// DataOutputStream으로 출력한 데이터는 DataInputStream으로 입력
			// 출력한 순서/타입에 맞춰서 입력을 해야 데이터가 손실되지 않음
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				dis.close();
				dos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

}































