package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;

public class PrintTest {
	
	public static void main(String[] args) {
		
		File file = new File("D:/pub2511/files/print.dat");
		
		// OutputStream에 기능을 추가한 스트림
		PrintStream ps = null;
		
		try {
			
			// FileOutputStream에 PrintStream을 연결, true => auto flush 여부
			ps = new PrintStream(new FileOutputStream(file), true);
			ps.print("홍길동");
			ps.println("강감찬");
			ps.printf("%s은 %d살 입니다!", "이순신", 30);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			ps.close();
		}
		
		PrintWriter pw = null;
		
		File file2 = new File("D:/pub2511/files/print.txt");
		
		try {
			
			pw = new PrintWriter(new FileWriter(file2), true);
			pw.print("안녕하세요!");
			pw.println("하이");
			pw.printf("%s은 %d살 입니다!", "이순신", 30);
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			pw.close();
		}
		
	}

}


















