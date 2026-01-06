package exception.ex;

public class ExceptionTest1 {
	
	// Kilo(1024), Mega(1024^2), Giga(1024^3), Tera(1024^4), Peta(1024^5)
	// 1024 * 1024 * 1024 * 4(int) = 4Gbytes
	int[] intArr = new int[1024 * 1024 * 1024];
	
	public static void main(String[] args) {
		
		// java.lang.OutOfMemoryError: Java heap space
		// ExceptionTest1 et1 = new ExceptionTest1();

		// java.lang.StackOverflowError : 메소드 순환 호출 a() > b() > a() > b() ...
		// a(); 
		
	}
	
	private static void a() {
		b();
	}
	
	private static void b() {
		a();
	}

}
