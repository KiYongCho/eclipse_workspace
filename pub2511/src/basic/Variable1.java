package basic;

public class Variable1 {
	
	public static void main(String[] args) {
		
		// 자바의 기본타입 8가지
		byte b = 1; // 1바이트 부호화 정수, 표현범위 : -2^7 ~ 2^7-1
		short s = 2; // 2바이트 부호화 정수, 표현범위 : -2^15 ~ 2^15-1
		int i = 3; // 4바이트 부호화 정수, 표현범위 : -2^31 ~ 2^31-1
		long l = 4; // 8바이트 부호화 정수, 표현범위 : -2^63 ~ 2^63-1
		// 3.14는 double 타입이므로 float 타입의 3.14임을 알리기 위해 3.14f로 써야함
		float f = 3.14f; // 4바이트 부호화 실수(부동소수), 부호비트1, 지수비트8, 가수비트23
		double d = 2.1; // 8바이트 부호화 실수(부동소수), 부호비트1, 지수비트11, 가수비트52
		char c = 'a'; // 2바이트 유니코드
		boolean bool = true; // 1바이트, true 또는 false의 값만 가짐
		
		// 표현범위의 크기
		// double > float > long > int > short > byte
		
		// 정수 타입의 기본타입 : int
		// 325라는 정수는 int
		
		// 실수 타입의 기본타입 : double
		// 32.5라는 실수는 double
		
	}

}













