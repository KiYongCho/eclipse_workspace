/*
	정수 2개 중 더 큰 수를 출력하는 메서드를 생성하고 호출하여 결과를 출력
	* 기능 최대한 분리 > 기능 명세(prototype 또는 signature) 작성 > 기능을 메서드로 코딩
	  - 정수 2개 중 더 큰 수를 찾는 기능 : int getBiggerNum(int i1, int i2)
	  - 수를 출력하는 기능 : void printNum(int i)
*/

package basic.ex;

public class ExMethod1 {
	
	public static void main(String[] args) {
		
		printNum(getBiggerNum(5, 3));
		
	} // main
	
	static int getBiggerNum(int i1, int i2) {
		return i1>i2 ? i1 : i2;
	}
	
	static void printNum(int i) {
		System.out.println(i);
	}

}







