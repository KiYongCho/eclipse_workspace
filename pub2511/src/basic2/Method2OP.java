package basic2;

import basic.Method2;

public class Method2OP {
	
	public static void main(String[] args) {
		
		// 다른 패키지에서 접근하므로 public만 접근 가능
		System.out.println(Method2.add(10, 5));
		// System.out.println(Method2.sub(10, 5));
		// System.out.println(Method2.mul(10, 5));
		// System.out.println(Method2.dev(10, 5));
		
	}

}
