/*
	콘솔 입출력
	  - Console : 표준입력장치(키보드) + 표준출력장치(모니터)
	  - 키보드로 입력받는 것을 표준입력
	  - 모니터로 출력하는 것을 표준출력
*/

package basic;

// java.lang 패키지 외의 모든 패키지의 클래스/인터페이스는 import해야 사용 가능
import java.util.Scanner;

public class ConsoleIO {
	
	public static void main(String[] args) {
		
		// 스캐너 객체 생성
		// System.in : 표준 입력스트림
		// System.out : 표준 출력스트림
		// Sytem.err : 표준 에러스트림
		Scanner scanner = new Scanner(System.in);
		
//		System.out.println("문자열을 입력하세요!");
//		while (scanner.hasNext()) { // 입력받는 문자열이 있는 동안 반복
//			// scanner.next() : 문자열 입력하고 엔터칠때까지 대기했다가 입력한 문자열을 리턴 (블로킹 메소드)
//			String nextStr = scanner.next(); // 입력받은 문자열을 변수에 저장
//			System.out.println("입력하신 문자열 : " + nextStr);
//		}
		
		// 실습 : 두 수를 키보드로 입력받아서 합계를 출력
		// code here
		System.out.println("두 수를 입력하세요!");
		int sum = scanner.nextInt() + scanner.nextInt();
		System.out.println("두 수의 합은 " + sum + "입니다!");
		
		scanner.close();
		
	}

}








