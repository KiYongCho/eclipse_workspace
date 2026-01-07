package collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
	
	public static void main(String[] args) {
		
		// 키가 Integer, 값이 String인 HashMap 객체 생성
		Map<Integer, String> stdMap = new HashMap<Integer, String>();
		
		// 엔트리 추가
		stdMap.put(1, "홍길동");
		stdMap.put(2, "장보고");
		stdMap.put(3, "이순신");
		stdMap.put(2, "강감찬"); // 기존 2를 키로 하는 값이 변경됨
		System.out.println(stdMap);
		
		// 키 포함 여부
		System.out.println(stdMap.containsKey(1));
		
		// 값 포함 여부
		System.out.println(stdMap.containsValue("유관순"));
		
		// 키에 해당하는 값 반환
		System.out.println(stdMap.get(3)); // 3키에 매핑된 값
		
		// 엔트리가 없는지 여부
		System.out.println(stdMap.isEmpty());
		
		// 맵에 맵을 추가
		Map<Integer, String> subMap
			= new HashMap<Integer, String>();
		subMap.put(4, "유관순");
		subMap.put(5, "권율");
		stdMap.putAll(subMap);
		System.out.println(stdMap);
		
		// 엔트리 제거
		stdMap.remove(1);
		System.out.println(stdMap);
		
		// 엔트리 수
		System.out.println(stdMap.size());
		
		// 모든 엔트리 제거
		subMap.clear();
		System.out.println(subMap); // empty map
		
		// 엔트리 셋
		Set<Map.Entry<Integer, String>> entrySet = stdMap.entrySet();
		
		// 엔트리 셋 반복자
		Iterator<Map.Entry<Integer, String>> it = entrySet.iterator();
		while (it.hasNext()) { // 반복할 요소가 있는 동안 반복
			Map.Entry<Integer, String> entry = it.next(); // 엔트리 추출
			System.out.println(entry.getKey()); // 엔트리에서 키 추출
			System.out.println(entry.getValue()); // 엔트리에서 값 추출
		}
		
		// 실습 : stdMap에서 키들을 추출해서 출력 (keySet메소드 사용)
		Set<Integer> keySet = stdMap.keySet(); // 키들의 Set
		Iterator<Integer> it2 = keySet.iterator(); // Set의 반복자
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		// 실습 : stdMap에서 값들을 추출해서 출력 (values메소드 사용)
		Collection<String> valueColl = stdMap.values();
		Iterator<String> it3 = valueColl.iterator();
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
	} // main

}






































