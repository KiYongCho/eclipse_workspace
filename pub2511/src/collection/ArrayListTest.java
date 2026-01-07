package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListTest {
	
	public static void main(String[] args) {
		
		// String을 저장하는 ArrayList 생성
		List<String> fruitList = new ArrayList<String>();
		
		// List에 요소 추가
		fruitList.add("사과");
		fruitList.add("딸기");
		fruitList.add("포도");
		
		System.out.println(fruitList);
		
		List<String> subList = new ArrayList<String>();
		
		subList.add("복숭아");
		subList.add("참외");
		
		// List에 List 추가
		fruitList.addAll(subList);
		System.out.println(fruitList);
		
		// List의 모든 요소 제거
		subList.clear();
		System.out.println(subList); // [], empty list
		
		// List가 요소를 포함하고 있는지 여부
		System.out.println(fruitList.contains("포도"));
		
		// List에서 인덱스에 해당하는 요소 획득
		System.out.println(fruitList.get(0));
		
		// 요소 인덱스 반환
		System.out.println(fruitList.indexOf("딸기"));
		System.out.println(fruitList.indexOf("자두")); // 요소가 없으면 -1
		
		// 요소가 없는지 확인
		System.out.println(fruitList.isEmpty());
		System.out.println(subList.isEmpty());
		
		fruitList.add("포도");
		System.out.println(fruitList);
		
		// 요소가 마지막으로 나온 인덱스
		System.out.println(fruitList.lastIndexOf("포도"));
		
		// 요소를 리스트에서 제거
		fruitList.remove("딸기");
		System.out.println(fruitList);
		fruitList.remove("포도"); // 처음 나온 요소만 제거
		System.out.println(fruitList);
		
		// 요소를 리스트에서 모두 제거
		subList.add("복숭아");
		subList.add("참외");
		fruitList.removeAll(subList);
		System.out.println(fruitList);
		
		// 요소 변경
		fruitList.set(1, "복숭아");
		System.out.println(fruitList);
		
		// List를 Object[]로 변경
		Object[] objArr = fruitList.toArray();
		for (Object obj : objArr) {
			System.out.println(obj);
		}
		
		// Object[]을 List로 변경
		List<Object> objList = Arrays.asList(objArr);
		for (Object obj : objList) {
			System.out.println(obj);
		}
		
	}

}
































