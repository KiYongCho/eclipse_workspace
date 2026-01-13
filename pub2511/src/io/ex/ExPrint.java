package io.ex;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;

public class ExPrint {
	
	public static void main(String[] args) {
		
		// System.out은 PrintStream
		PrintStream ps = new PrintStream(System.out);
		ps.println((byte)1);
		ps.flush();
		
		// PrintStream을 PrintWriter로 변환
		PrintWriter pw = new PrintWriter(System.out);
		pw.println('A');
		pw.flush();
		pw.close();
		
	}

}











