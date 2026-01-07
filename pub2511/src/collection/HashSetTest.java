package collection;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
	
	public static void main(String[] args) {
		
		// String을 저장하는 HashSet 객체 생성
		Set<String> nameSet = new HashSet<String>();
		
		// 요소 추가
		nameSet.add("홍길동");
		nameSet.add("이순신");
		nameSet.add("강감찬");
		System.out.println(nameSet);
		
		Set<String> subSet = new HashSet<String>();
		subSet.add("장보고");
		subSet.add("권율");
		
		// Set에 Set 추가
		nameSet.addAll(subSet);
		System.out.println(nameSet);
		
		// 요소 포함 여부
		System.out.println(nameSet.contains("장보고"));
		System.out.println(nameSet.contains("을지문덕"));
		
		// 요소가 없는지 확인
		System.out.println(nameSet.isEmpty());
		
		// 요소 제거
		nameSet.remove("권율");
		System.out.println(nameSet);
		
		// Set을 Object배열로 변환
		Object[] objArr = nameSet.toArray();
		for (Object obj : objArr) {
			System.out.println(obj);
		}
		
		// Set은 중복 저장 불허
		nameSet.add("홍길동");
		nameSet.add("홍길동");
		System.out.println(nameSet);
		
	}

}
































