package exception;

public class ExceptionMain2 {
	
	public static void main(String[] args) {
		System.out.println("main메소드 호출됨!");
		// main메소드까지 예외가 전달되면 main에는 
		// try ~ catch ~ 로 직접 처리해야 함
		try {
			a();
		} catch (ArithmeticException ae) {
			System.out.println("main메소드에서 예외를 처리함!");
		}
	} // main
	
	private static void a() throws ArithmeticException {
		System.out.println("a메소드 호출됨!");
		// 1. try ~ catch ~ 로 직접 처리
		// 2. throws ArithmeticException 구문으로 호출한 메소드쪽에 예외 처리 위임
		//try {
			b();
		//} catch (ArithmeticException ae) {
		//	System.out.println("a메소드에서 예외를 처리함!");
		//}
	}
	
	private static void b() throws ArithmeticException {
		System.out.println("b메소드 호출됨!");
		// 예외 발생 가능한 코드가 있으므로 두가지 중 한가지 처리를 해야만 함
		// 1. try ~ catch ~ 로 직접 처리
		// 2. throws ArithmeticException 구문으로 호출한 메소드쪽에 예외 처리 위임
		//try {
			int i = 10 / 0;
		//} catch (ArithmeticException ae) {
		//	System.out.println("b메소드에서 예외를 처리함!");
		//}
	}

} // class































