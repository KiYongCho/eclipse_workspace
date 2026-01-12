package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteStreamTest {
	
	public static void main(String[] args) {
		
		InputStream is = null;	// byte단위 입력스트림
		OutputStream os = null; // byte단위 출력스트림
		
		try {
			
			// 파일 객체
			File file = new File("D:/pub2511/files/file1.dat");
			
			// 파일에 바이트를 출력하는 스트림
			os = new FileOutputStream(file);
			
			// 스트림에 출력
			os.write(100);
			
			// 스트림내의 데이터를 파일로 밀어냄
			os.flush();
			
			// 파일에서 바이트를 읽는 스트림
			is = new FileInputStream(file);
			
			// 한 바이트를 읽어서 출력
			System.out.println("읽은 바이트 : " + is.read());
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				// 사용한 스트림의 역순으로 close
				is.close();
				os.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class



























