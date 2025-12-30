/*
	메소드 오버로딩 (Method Overloading)
	  - 유사한 기능을 하는 메소드의 이름을 일원화 하기 위해
	  - 동일한 반환타입, 동일한 메소드명, 다른 파라미터 구성(개수, 타입, 순서)을 갖는 메소드를
	    클래스내에 2개 이상 생성
	  - 접근지정자와 파라미터 변수명은 오버로딩의 조건이 아님
*/

package basic;

public class MethodOverloading {
	
	public static void main(String[] args) {
		
		// 동일한 기능을 하는 메소드의 이름을 일원화
		// => 형태는 같은데 성질은 다름 => 다형성 (Polymophism)
		
		// 문자열 하나를 출력하려면
		printStr("Hello");
		
		System.out.println();
		
		// 문자열 다섯번 출력하려면
		printStr("Hello", 5);
		
		System.out.println();		
		
		// 문자열 두개를 다섯번 출력하려면
		printStr("Hello", "Java", 5);
		
	} // main
	
	// 문자열 하나를 출력
	static void printStr(String str) {
		System.out.println(str);
	}
	
	// 문자열 개수만큼 출력
	static void printStr(String str, int loopCount) {
		for (int i=0; i<loopCount; i++) {
			System.out.println(str);
		}
	}
	
	// 문자열 두개를 개수만큼 출력
	static void printStr(String str1, String str2, int loopCount) {
		for (int i=0; i<loopCount; i++) {
			System.out.println(str1 + ", " + str2);
		}
	}

} // class

































