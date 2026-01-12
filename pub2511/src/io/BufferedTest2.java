package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedTest2 {
	
	public static void main(String[] args) {
		
		File file = new File("D:/pub2511/files/buffered.txt");
		
		// 버퍼링한 문자출력스트림
		BufferedWriter bw = null;
		// 버퍼링한 문자입력스트림
		BufferedReader br = null;
		
		try {
			
			bw = new BufferedWriter(new FileWriter(file));
			
			long startTime = System.currentTimeMillis();
			for (int i=0; i<10000000; i++) {
				bw.write("Hello Java!");
				bw.newLine(); // 줄바꿈 문자 (윈도우:\r\n, 유닉스/리눅스:\n)
			}
			long endTime = System.currentTimeMillis();
			System.out.println("소요 시간 : " + (endTime - startTime) + "ms");
			
			br = new BufferedReader(new FileReader(file));
			
			String lineStr = "";
			while ((lineStr = br.readLine()) != null) { // 읽은 한 줄의 문자열이 있는 동안 반복
				System.out.println(lineStr);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				br.close();
				bw.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class






























