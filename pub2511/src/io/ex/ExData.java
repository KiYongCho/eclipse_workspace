package io.ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExData {
	
	public static void main(String[] args) {
		
		DataOutputStream dos = null;
		DataInputStream dis = null;
		
		try {
			
			File file = new File("D:/pub2511/files/datastream.dat");
			
			dos = new DataOutputStream(new FileOutputStream(file));
			dos.writeUTF("홍길동");
			dos.writeInt(20);
			dos.writeUTF("010");
			dos.writeChar('-');
			dos.writeUTF("1234");
			dos.writeChar('-');
			dos.writeUTF("5678");
			dos.flush();
			
			dis = new DataInputStream(new FileInputStream(file));
			System.out.println(dis.readUTF());
			System.out.println(dis.readInt());
			System.out.println(dis.readUTF());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			
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











