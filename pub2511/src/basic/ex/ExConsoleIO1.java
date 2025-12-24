package basic.ex;

import java.util.Scanner;

public class ExConsoleIO1 {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		System.out.println("두 수를 입력하세요!");
		int result = scanner.nextInt() * scanner.nextInt();
		// System.out.println("두 수의 곱은 " + result + "입니다!");
		System.out.printf("두 수의 곱은 %d 입니다!", result);
		
		System.out.println();
		
		// formatting print (형식화 출력)
		// %s:문자열, %d:정수, %f:실수, %2.2f:소수점앞두자리 소수점뒤두자리 실수
		System.out.printf("%s님의 나이는 %d이고, 키는 %.2f 입니다!"
				, "홍길동", 20, 175.5f); // 홍길동님의 나이는 20이고, 키는 175.50 입니다!		
		
		scanner.close();
		
	}

}








