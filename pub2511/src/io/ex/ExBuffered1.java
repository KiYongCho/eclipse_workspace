package io.ex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ExBuffered1 {
	
	public static void main(String[] args) {
		
		File file = new File("D:/pub2511/files/gimi.txt");
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			pw = new PrintWriter(System.out);
			
			String line = null;
			while ((line=br.readLine()) != null) {
				pw.write(line);
			}
			pw.flush();
			 
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				pw.close();
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

}





























