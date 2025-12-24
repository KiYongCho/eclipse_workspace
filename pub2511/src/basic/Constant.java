/*
	상수 (Constant)
	  - 값을 초기화하면 변경할 수 없는 변수
	  - 상수명은 대문자로 만드는 관례가 있고, 여러 단어를 조합할때는 _로 연결
	  - 상수는 반드시 초기화해야 사용할 수 있음
	  - 변수 선언시 앞에 final 키워드를 사용하면 상수
*/

package basic;

public class Constant {
	
	// 상수느 일반적으로 public static final로 생성
	public static final double PI = 3.141592;
	
	public static void main(String[] args) {
		
		final int F1;
		// System.out.println(F1); // 상수는 초기화 후에 사용 가능
		F1 = 1; // 상수를 초기화 함
		System.out.println(F1);
		
		// F1 = 2; // 상수는 초기화 후에 값 변경 불가
		
	}

}














