package collection.ex;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PersonInfo1 {
	
	public static void main(String[] args) {
		
		System.out.println("이름과 나이 3개를 입력해 주세요! (형식:이름,나이)");
		
		Scanner scanner = new Scanner(System.in);

		Map<String, String> personMap = new HashMap<String, String>();
		
		for (int i=0; i<3; i++) {
			String input = scanner.next();
			personMap.put(
				input.substring(0, input.indexOf(',')), // 이름
				input.substring(input.indexOf(',') + 1) // 나이
			);
		}
		
		Set<Map.Entry<String, String>> entrySet = personMap.entrySet();
		
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> entry = it.next();
			System.out.printf("%s는 %s살 입니다!\n", entry.getKey(), entry.getValue());
		}
		
		scanner.close();
		
	}

}













