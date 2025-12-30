package basic.ex;

import java.util.Scanner;

public class ExMethod3 {
	
	public static void main(String[] args) {
		
		String lineStr = inputData();
		String[] strArr = lineStr.split(" ");
		int i1 = Integer.parseInt(strArr[0]);
		int i2 = Integer.parseInt(strArr[1]);
		
		switch (strArr[2]) {
			case "+":	System.out.println(add(i1, i2));	break;
			case "-":	System.out.println(sub(i1, i2));	break;
			case "*":	System.out.println(mul(i1, i2));	break;
			case "/":	System.out.println(dev(i1, i2));	break;
			default: System.out.println("정확한 연산자를 입력해 주세요!");
		}
		
	} // main
	
	// 2개의 정수와 연산자를 입력받는 메소드
	static String inputData() {
		Scanner scanner = new Scanner(System.in);
		String lineStr = scanner.nextLine();
		scanner.close();
		return lineStr;
	}
	
	static int add(int i1, int i2) {
		return i1 + i2;
	}
	
	static int sub(int i1, int i2) {
		return i1 - i2;
	}
	
	static int mul(int i1, int i2) {
		return i1 * i2;
	}
	
	static float dev(int i1, int i2) {
		return i1 / i2;
	}
	
}







