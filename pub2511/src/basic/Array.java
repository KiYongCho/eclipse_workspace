/*
	Java 배열의 특성 (정적 배열)
	  - 반드시 크기를 정하고 사용해야 함 (초기화해야 사용가능)
	  - 기본타입, 참조타입 모두 저장 가능하나 한 타입만 저장 가능
	  - 크기를 정하면 변경할 수 없음
	  - 메모리에 연속적으로 값들이 저장
*/

package basic;

public class Array {
	
	public static void main(String[] args) {
		
		// 배열 선언 : 배열의 타입과 변수명을 지정
		int[] intArr;
		// int intArr[] : 선언시 []를 변수명 뒤에 사용 가능하나 권장하지 않음
		
		// 배열 초기화 : 배열의 메모리를 확보하고 각 요소의 기본타입값으로 요소값을 초기화
		//                  int 5개를 저장할 수 있는 배열이 메모리에 생성됨
		//                  각 요소는 int타입의 기본값인 int 0으로 초기화됨
		//                  요소의 개수(length) : 5, 인덱스의 범위 : 0~4 (0~length-1)
		intArr = new int[5];
		
		System.out.println(intArr); // [I@5ca881b5, 배열의 참조값
		
		// 배열 값 할당
		intArr[0] = 1;
		intArr[1] = 2;
		intArr[2] = 3;
		intArr[3] = 4;
		intArr[4] = 5;
		
		// 배열의 인덱스 범위만큼 반복 
		int intArrLength = intArr.length;
		for (int i=0; i<intArrLength; i++) {
			System.out.printf("인덱스 %d : 값 %d\n", i, intArr[i]);
		}
		
		// 컴파일에러 없음
		// 실행예외 발생 :  java.lang.ArrayIndexOutOfBoundsException
		// intArr[5] = 6;
		
		// 배열 선언, 초기화, 할당을 동시에
		int[] intArr2 = {1, 2, 3, 4, 5};
		
		// for : 구문 (향상된 for문 : enhanced for)
		// 배열의 요소수만큼 반복하는 for문
		// 인덱스는 사용하지 않고 요소들만 추출해서 반복할때 사용
		for (int i : intArr2) {
			System.out.println(i);
		}
		
	}

}






























