// java.util.Arrays : 배열 사용시 유용한 메소드들을 가지고 있는 유틸리티 클래스

package collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ArraysTest {
	
	public static void main(String[] args) {
		
		Integer[] intArr1 = {10, 5, 9, 3, 1};
		
		// 배열을 리스트로 변환
		List<Integer> intList = Arrays.asList(intArr1);
		
		Integer[] intArr2 = {1, 20, 5, 9, 3, 2, 7, 4, 15, 9, 6};
		
		// 배열 정렬
		Arrays.sort(intArr2, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// return o1 - o2; // 오름차순 정렬
				return o2 - o1; // 내림차순 정렬
			}
		});
		
		// 배열을 스트림으로 만들어서 각 요소를 출력
		Arrays.stream(intArr2).forEach(System.out::println);
		
		Integer[] intArr3 = {10, 5, 9, 3, 1};
		Integer[] intArr4 = {1, 20, 5, 9, 3, 2, 7, 4, 15, 9, 6};
		
		// 배열 비교 : 맨 앞의 요소부터 차례대로 비교
		// 앞의 배열이 크면 양수, 같으면 0, 뒤의 배열이 크면 음수를 반환
		System.out.println(Arrays.compare(intArr3, intArr4)); // 양수 1
		
		// 배열 카피 (요수 수 만큼 카피)
		Integer[] intArr5 = Arrays.copyOf(intArr4, 3); // 복사대상배열, 요수 수
		Arrays.stream(intArr5).forEach(System.out::println);
		
		// 배열 카피 (인덱스 범위 카피)
		// 복사대상배열, 시작인덱스, 끝인덱스+1
		Integer[] intArr6 = Arrays.copyOfRange(intArr4, 1, 4);
		Arrays.stream(intArr6).forEach(System.out::println);
		
		// 배열 채우기
		Integer[] intArr7 = new Integer[5];
		Arrays.fill(intArr7, 3);
		Arrays.stream(intArr7).forEach(System.out::println);
		
	}

}

















