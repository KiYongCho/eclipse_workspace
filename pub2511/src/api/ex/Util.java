package api.ex;

import java.util.Scanner;

public class Util {
	
	// 입력받을 줄의 수를 인자로 받아서 입력한 문자열들을 배열로 반환하는 메소드 
	public static String[] getLineText(int lineCount) {
		System.out.println("문자열을 " + lineCount + "줄 입력해 주세요!");
		Scanner scanner = new Scanner(System.in);
		String[] lineTextArr = new String[lineCount];
		for (int i=0; i<lineCount; i++) {
			lineTextArr[i] = scanner.nextLine();
		}
		scanner.close();
		return lineTextArr;
	}

}
