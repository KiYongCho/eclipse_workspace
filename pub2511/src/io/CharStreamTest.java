package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CharStreamTest {
	
	public static void main(String[] args) {
		
		// 문자 단위 출력스트림
		Writer writer = null;
		
		// 문자 단위 입력스트림
		Reader reader = null;
		
		try {
			
			// 파일 객체 생성
			File file = new File("D:/pub2511/files/file2.txt");
			
			writer = new FileWriter(file);
			
			// 스트림에 쓰기
			writer.write(65); // ASCII코드 65 => A
			
			// 스트림의 데이터를 파일로 밀어내기
			writer.flush();
			
			reader = new FileReader(file);
			
			// 파일의 문자를 하나 읽어서 출력
			System.out.println((char)reader.read());
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				reader.close();
				writer.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class



























