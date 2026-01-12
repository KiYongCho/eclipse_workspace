// 파일 복제

package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageCopyer {
	
	public static void main(String[] args) {
		
		InputStream is = null;
		OutputStream os = null;
		File orgFile = null;
		File copyFile = null;
		
		try {
			
			orgFile = new File("D:/pub2511/files/dog.jpg"); // 원본파일 객체
			copyFile = new File("D:/pub2511/files/dog_copy.jpg"); // 복사파일 객체
			
			// 원본파일에서 바이트를 읽는 스트림
			is = new FileInputStream(orgFile);
			
			// 복사파일에 바이트를 쓰는 스트림
			os = new FileOutputStream(copyFile);
			
			// 방법 1 : 한 바이트 읽어서 한 바이트 쓰기 (시간 오래 소요됨)
//			long startTime = System.currentTimeMillis();
//			int readByte = 0;
//			while ((readByte=is.read()) > -1) { // 원본파일에서 한 바이트 읽기
//				os.write(readByte); // 복사파일에 한 바이트 쓰기
//			}
//			os.flush(); // 파일에 바이트들 밀어내기
//			long endTime = System.currentTimeMillis();
//			System.out.println("방법 1 소요시간 : " + (endTime-startTime) + "ms");
			
			// 방법 2 : 바이트 묶어서 읽고 쓰기 (시간 적게 소요됨)
			long startTime = System.currentTimeMillis();
			// 버퍼의 크기는 파일의 크기, 시스템의 성능, 네트워크의 속도마다 다르므로
			// 숫자를 바꿔가며 최적의 크기를 찾아야 함!
			int byteCount = 1024; 
			byte[] byteArr = new byte[byteCount];
			int readByte = 0; // 읽어들인 byte의 수 저장
			while ((readByte=is.read(byteArr)) > -1) { // byteCount만큼 읽기
				os.write(byteArr, 0, readByte);
			}
			os.flush();
			long endTime = System.currentTimeMillis();
			System.out.println("방법 2 소요시간 : " + (endTime-startTime) + "ms");
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				os.close();
				is.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class




































