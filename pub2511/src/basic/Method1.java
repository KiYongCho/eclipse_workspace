package basic;

public class Method1 {

	// Java의 main메소드 : 프로그램의 진입점(entry point)
	//                             JVM이 프로그램 실행시 가장 먼저 호출하는 메소드
	// 어디서든 접근 가능해야 하므로 public
	// 객체 생성없이 호출할 수 있어야 하므로 static
	// 메소드 실행 후 반환하는 값이 없으므로 void
	// 메소드명은 main으로 정해져 있음
	// 호출시에 String배열을 인자로 받을 수 있음 (Command Line Arguments)
	public static void main(String[] args) {
		
		// 메소드 호출시에는 메소드명과 파라미터리스트에 맞는 인자를 구성해서 호출
		print("Hello Jeva Method!");
		print("Java Programming!");
		
		// 메소드 호출 후 반환값을 변수에 저장
		int sum = add(1, 2);
		System.out.println(sum);
		
		// static 메소드는 클래스로 접근 가능
		Method1.print("안녕하세욤!");
		System.out.println(Method1.add(3, 4));		
		
		// non-static메소드는 객체를 생성해야 접근 가능
		// sub(5, 3);
		// Method1.sub(5,3);
		Method1 method1 = new Method1();
		System.out.println(method1.sub(5,  3));
		
	} // main
	
	// default, static, non-final, void, print, String
	static void print(String str) {
		System.out.println(str);
		// return; 생략된 것
	}
	
	// private, static, non-final, int add, int int
	private static int add(int a, int b) {
		return a + b; //반환값이 있으면 return 구문 생략 불가
	}
	
	// default, non-static, non-final, int, sub, int int
	int sub(int a, int b) {
		return a - b;
	}
		
}









































