package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

public class CollectionsTest {
	
	public static void main(String[] args) {
		
		// Collections의 상수
		System.out.println(Collections.EMPTY_LIST);
		System.out.println(Collections.EMPTY_SET);
		System.out.println(Collections.EMPTY_MAP);
		
		// empty List, Set, Map, Iterator 메소드
		System.out.println(Collections.emptyList());
		System.out.println(Collections.emptySet());
		System.out.println(Collections.emptyMap());
		System.out.println(Collections.emptyIterator());
		
		// Arrays.asList는 고정길이 리스트를 생성
		// 그러므로 가변길이 리스트를 생성하려면 ArrayList생성자 인자로 고정길이 리스트를 줘야 함
		List<String> nameList 
			= new ArrayList<String>(Arrays.asList("홍길동", "강감찬", "이순신"));
		
		// 컬렉션에 요소 추가
		Collections.addAll(nameList, "장보고");
		Collections.addAll(nameList, "권율", "최영", "이성계");
		System.out.println(nameList);
		
		// 컬렉션 복사
		// 컬렉션을 복사하려면 복사대상 컬렉션의 요소의 수만큼 공간을 확보해야 함
		
		// copyList는 nameList의 size만큼 공간을 확보하고 각 공간을 null로 초기화
		List<String> copyList
			= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		Collections.copy(copyList, nameList); // 복사본, 원본
		System.out.println(copyList);
		
		// 컬렉션 채우기
		List<String> copyList2
			= new ArrayList<String>(Collections.nCopies(nameList.size(), null));
		Collections.fill(copyList2, "김유신");
		System.out.println(copyList2);
		
		// 컬렉션 열거자
		// Enumeration : jdk1.0부터 있었고 Iterator의 하위 호환 버젼
		//                      hasMoreElements, nextElement 메소드 제공
		//                      이전 버젼 자바코드와 호환을 위해 아직까지 존재함
		Enumeration<String> en = Collections.enumeration(nameList);
		while (en.hasMoreElements()) {
			System.out.println(en.nextElement());
		}
		
		// 컬렉션 요소 대체
		Collections.replaceAll(copyList2, "김유신", "최영");
		System.out.println(copyList2);
		
		// 컬렉션 요소 순서 180도 뒤집기
		Collections.reverse(nameList);
		System.out.println(nameList);
		
		// 컬렉션 요소 순서 랜덤하게 섞기
		Collections.shuffle(nameList);
		System.out.println(nameList);
		
		// 컬렉션 요소 순서 정렬
		// Collections의 sort메소드를 사용 : 인자는 정렬대상 리스트와 정렬기준을 구현한 Comparator구현체
		// public static <T> void sort(List<T> list, Comparator<? super T>) comparator)
		// Comparator의 compare메소드를 오버라이딩해서 구현함
		// compare메소드는 앞 파라미터의 값이 크면 양수를 반환, 같으면 0을 반환, 뒤 파라미터의 값이 크면 음수를 반환
		
		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, 5, 10, 1, 6, 9, 4, 7, 8);
		
		Collections.sort(intList, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// return o1 - o2; // 오름차순 정렬 = Ascending sort
				return o2 - o1; // 내림차순 정렬 = Descending sort
			}
		});
		
		System.out.println(intList);
		
	}

}













