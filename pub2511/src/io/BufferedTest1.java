package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedTest1 {
	
	public static void main(String[] args) {
		
		File file = new File("D:/pub2511/files/buffered.dat");
		
		// 내부 버퍼를 사용해서 속도를 향상시키는 바이트단위 출력스트림
		BufferedOutputStream bos = null; 
		// 내부 버퍼를 사용해서 속도를 향상시키는 바이트단위 입력스트림
		BufferedInputStream bis = null;
		
		try {
			
			// 파일에서 바이트들을 버퍼링해서 출력하는 스트림
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			long startTime = System.currentTimeMillis();
			byte[] byteArr = new byte[1024 * 1024 * 1024]; // 1G bytes
			int byteArrLeng = byteArr.length;
			for (int i=0; i<byteArrLeng; i++) {
				byteArr[i] = (byte)i;
			}
			bos.write(byteArr);
			long endTime = System.currentTimeMillis();
			System.out.println("소요 시간 : " + (endTime - startTime) + "ms");
			
			// 파일에서 바이트들을 버퍼링해서 입력하는 스트림
			bis = new BufferedInputStream(new FileInputStream(file));
			byte[] readArr = new byte[1024 * 1024 * 1024];
			bis.read(readArr);
			int readArrLeng = readArr.length;
			for (int i=0; i<readArrLeng; i++ ) {
				System.out.println(readArr[i]);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
		
		
	} // main

} // class




























