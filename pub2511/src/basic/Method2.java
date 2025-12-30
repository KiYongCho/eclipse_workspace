package basic;

public class Method2 {
	
	public static void main(String[] args) {
		
		System.out.println(add(10, 5));
		System.out.println(sub(10, 5));
		System.out.println(mul(10, 5));
		System.out.println(dev(10, 5));
		
	} // main
	
	public static int add(int a, int b) {
		return a + b;
	}
	
	protected static int sub(int a, int b) {
		return a - b;
	}
	
	static int mul(int a, int b) {
		return a * b;
	}
	
	private static int dev(int a, int b) {
		return a / b;
	}

}
















