// 다차원 배열

package basic;

public class MultiDemensionArray {
	
	public static void main(String[] args) {
		
		// 2차원 배열 : 배열을 요소로 갖는 배열, 행/열 구조
		// 2차원 배열 intArr의 length : 3 (인덱스 0~2)
		// 1차월 배열 intArr[0]의 length : 3 (인덱스 0~2)
		int[][] intArr = new int[3][3]; // 3행 3열
		
		// 2차원 배열에 값 할당
		intArr[0][0] = 1;
		intArr[0][1] = 2;
		intArr[0][2] = 3;
		intArr[1][0] = 4;
		intArr[1][1] = 5;
		intArr[1][2] = 6;
		intArr[2][0] = 7;
		intArr[2][1] = 8;
		intArr[2][2] = 9;
		
		// 2차원 배열의 모든 요소의 값 출력
		int intArrLeng = intArr.length;
		int intArr0Leng = intArr[0].length;
		for (int i=0; i<intArrLeng; i++) {
			for (int j=0; j<intArr0Leng; j++) {
				System.out.println(intArr[i][j]);
			}
		}
		
		// 2차원 배열 선언, 초기화, 할당 동시에
		int[][] intArr2 = {
			{1, 2, 3},
			{4, 5, 6},
			{7, 8, 9}
		};
		
		// for : 구문으로 2차원 배열의 각 요소 출력
		for (int[] iArr : intArr2) { // 2차원배열의 요소인 1차원배열 수만큼 반복
			for (int i : iArr) { // 1차원배열 요소 수만큼 반복
				System.out.println(i);
			}
		}
		
		// 참조타입 2차원 배열
		String[][] strArr = {
				{"홍길동", "강감찬", "이순신"},
				{"서울", "부산", "제주"},
				{"학생", "직장인", "가수"}
		};
		
		// 요소 출력
		for (String[] sArr : strArr) {
			for (String str : sArr) {
				System.out.println(str);
			}
		}
		
		// 문제 : strArr은 몇 바이트? sArr은 몇 바이트?
		//         => 참조타입은 바이트 수를 알 수 없음
		
		// 2차원 배열 출력
		System.out.println(strArr); // [[Ljava.lang.String;@5ca881b5
		// 1차원 배열 출력
		System.out.println(strArr[0]); // [Ljava.lang.String;@24d46ca6
		
	} // main

} // class

































