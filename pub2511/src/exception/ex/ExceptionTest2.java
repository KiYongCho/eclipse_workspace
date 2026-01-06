package exception.ex;

import java.util.Scanner;

public class ExceptionTest2 {

	public static void main(String[] args) {
		
		System.out.println("두 수를 입력해 주세요!");

		Scanner scanner = new Scanner(System.in);

		try {
			System.out.println(scanner.nextInt() / scanner.nextInt());
		} catch (ArithmeticException ae) {
			System.out.println("0으로 나눌 수 없습니다!");
		} finally {
			scanner.close();
		}

	}

}
