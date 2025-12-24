/*
	Wrapper 클래스
	  - Wrapper : 기본타입의 값을 가진 참조타입
	  - Wrapping(boxing) : 기본타입의 값을 가진 참조타입을 생성
	  - Unwrapping(Unboxing) : 참조타입이 가진 기본타입의 값을 꺼냄
	  - Auto Wrapping : 참조타입이 필요한 자리에 자동으로 기본타입의 값을 가진 참조타입을 생성
	  - Auto Unwrapping : 기본타입이 필요한 자리에 자동으로 참조타입이 가진 기본타입의 값을 꺼냄
*/

package basic;

public class Wrapper {
	
	public static void main(String[] args) {
		
		// 자바의 기본타입 8가지
		byte b = 1;
		short s = 2;
		int i = 3;
		long l = 4;
		float f = 3.14f;
		double d = 2.1;
		char c = '김';
		boolean bool = true;
		
		// Wrapping
		Byte wb = new Byte(b);
		Short ws = new Short(s);
		Integer wi = new Integer(i);
		Long wl = new Long(l);
		Float wf = new Float(f);
		Double wd = new Double(d);
		Character wc = new Character(c);
		Boolean wbool = new Boolean(bool);
		
		// Unwrapping
		System.out.println(wb.byteValue());
		System.out.println(ws.shortValue());
		System.out.println(wi.intValue());
		System.out.println(wl.longValue());
		System.out.println(wf.floatValue());
		System.out.println(wd.doubleValue());
		System.out.println(wc.charValue());
		System.out.println(wbool.booleanValue());
		
		// 참조타입 wi와 기본타입 2를 더하기 위해 wi가 가진 기본타입값을 자동으로 꺼냄
		// Auto Unwrapping
		int sum = wi + 2; // 5, int sum = wi.intValue() + 2;
		System.out.println(sum);
		
		// 기본타입 7을 자동으로 참조타입으로 만들어서 할당
		// Auto Wrapping
		Integer wi2 = 7; // Integer wi2 = new Integer(7);
		
	}

}














