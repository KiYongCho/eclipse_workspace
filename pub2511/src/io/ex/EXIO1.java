package io.ex;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EXIO1 {
	
	public static void main(String[] args) {
		
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(new File("D:/pub2511/files/gimi.txt"));
			
			int i = 0;
			while ((i=fr.read()) > -1) {
				System.out.print((char)i);
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				fr.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	}

}













