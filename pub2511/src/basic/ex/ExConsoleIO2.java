package basic.ex;

import java.util.Scanner;

public class ExConsoleIO2 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("문자열 3개를 입력하세요!");
		
		String str1 = scanner.next();
		String str2 = scanner.next();
		String str3 = scanner.next();
		
		int cnt = 0;
		if (str1.equals("true") || str1.equals("false")) cnt++; 
		if (str2.equals("true") || str2.equals("false")) cnt++; 
		if (str3.equals("true") || str3.equals("false")) cnt++;
		
		System.out.println("true 또는 false인 문자열의 수 : " + cnt);
		
		scanner.close();
		
	}

}








