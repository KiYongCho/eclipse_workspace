// Variable3와 다른 패키지에 있는 Variable3OP 클래스

package basic2;

// basic패키지내의 Variable3클래스를 가져옴
import basic.Variable3;

public class Variable3OP {
	
	public static void main(String[] args) {
		
		Variable3 variable3 = new Variable3();
		System.out.println(variable3.pubi); // 1
		// System.out.println(variable3.proi);
		// System.out.println(variable3.di);
		// System.out.println(variable3.prii);
		
	}

}







