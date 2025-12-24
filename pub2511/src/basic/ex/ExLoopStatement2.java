package basic.ex;

public class ExLoopStatement2 {
	
	public static void main(String[] args) {
		
		// (6) - 1
		// i=0, j=0  i=1, j=0,1 ...
		for (int i=0; i<5; i++) { // 줄의 수
			for (int j=0; j<i+1; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// (6) - 2
		// i=0, j=0,1,2,3,4  i=1, j=0,1,2,3 ...
		for (int i=0; i<5; i++) { // 줄의 수
			for (int j=0; j<5-i; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}		
		
		System.out.println();
		
		// (6) - 3
		// i=0, j=0,1,2,3,4  i=1, j=0,1,2,3 ...
		// k=0                   k=1                ...
		for (int i=0; i<5; i++) { // 줄의 수
			for (int k=0; k<i; k++) { // 공백의 수
				System.out.print("o");
			}
			for (int j=0; j<5-i; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}		
		
		System.out.println();
		
		// (6) - 4
		// i=0, j=0      i=1, j=0,1,2 ...
		// k=4,3,2,1    k=3,2,1       ...
		for (int i=0; i<5; i++) { // 줄의 수
			for (int k=4-i; k>0; k--) { // 공백의 수
				System.out.print("o");
			}
			for (int j=0; j<2*i+1; j++) { // 별의 수
				System.out.print("*");
			}
			System.out.println();
		}			
		
		System.out.println();
		
		// (6) - 5
		for (int i=0; i<5; i++) { // 줄의 수
			for (int j=0; j<5; j++) { // 별의 수
				if (i%4==0 || j%4==0) {
					System.out.print("*");
				} else {
					System.out.print("o");
				}
				
			}
			System.out.println();
		}		
		
		System.out.println();
		
		// (6) - 6
		for (int i=0; i<5; i++) { // 줄의 수
			for (int j=0; j<5; j++) { // 별의 수
				if (i==j || 4-i==j) {
					System.out.print("*");
				} else {
					System.out.print("o");
				}
				
			}
			System.out.println();
		}		
		
		System.out.println();
		
		// (6) - 7
		for (int i=0; i<5; i++) { // 줄의 수
			for (int j=0; j<5; j++) { // 별의 수
				if (i%4==0 || j%4==0 || i==j || 4-i==j) {
					System.out.print("*");
				} else {
					System.out.print("o");
				}
				
			}
			System.out.println();
		}
		
		// 보너스 실습 1)
		// oo*oo
		// o***o
		// *****
		// o***o		
		// oo*oo
		
		// i(줄)    : 0 1 2 3 4
		// j(별)    : 1 3 5 3 1
		// k(공백) : 2 1 0 1 2
		
		// i의 중간값을 middle이라 하면... i=2
		// 전체 줄의 수를 total이라 하면... total=5 => total=middle*2+1
		// 1) k = (5-j)/2
		// 2) k = Math.abs(2-i)
		// 그러므로 
		// (total-i)/middle = middle-i 또는
		// (total-i)/middle = i-middle
		// 2가지 경우가 생김
		
		int lineNums = 5; // 전체 줄의 수
		int middleLineNum = lineNums / 2; // 가운데 줄의 번호
		int kEnd = 0; // k반복의 끝 값 = 공백의 수
		int jEnd = 0; // j반복의 끝 값 = 별의 수
		
		for (int i=0; i<lineNums; i++) { // 줄 반복
			if (i<=middleLineNum) {
				kEnd = middleLineNum - i;
				jEnd = 2*i + 1;
			} else {
				kEnd = i - middleLineNum;
				jEnd = (lineNums*2-1) - 2*i;
			}
			for (int k=0; k<kEnd; k++) System.out.print("o"); // 공백 출력
			for (int j=0; j<jEnd; j++) System.out.print("*"); // 별 출력
			for (int k=0; k<kEnd; k++) System.out.print("o"); // 공백 출력
			System.out.println();
		}
		
		System.out.println();
		
		// 보너스 실습 2)
		// 3이상의 홀수를 입력하면 최대 별의 개수가
		// 입력한 별의 개수가 되는 다이아몬드 별찍기
		// 3입력하면...
		// o*o
		// ***
		// o*o
		// 5입력하면...
		// oo*oo
		// o***o
		// *****
		// o***o		
		// oo*oo		
		
//		System.out.println("별의 최대길이를 3이상 홀수로 입력해 주세요!");
//		int lineNums = new Scanner(System.in).nextInt(); // 줄의 수
//		int middleLineNum = lineNums/2; // 가운데 줄 번호
//		int kEnd = 0; // k 반복의 끝 값 = 공백의 수
//		int jEnd = 0; // j 반복의 끝 값 = 별의 수
//		
//		for (int i=0; i<lineNums; i++) {
//			if (i<=middleLineNum) {
//				kEnd = middleLineNum - i;
//				jEnd = 2*i + 1;
//			} else {
//				kEnd = i - middleLineNum;
//				jEnd = (lineNums*2-1) - 2*i;
//			}
//			for (int k=0; k<kEnd; k++) System.out.print("o");
//			for (int j=0; j<jEnd; j++) System.out.print("*");
//			System.out.println();
//		}		
		
	} // main

} // class





















