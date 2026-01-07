package collection.ex;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Fruits2 {
	
	public static void main(String[] args) {
		
		System.out.println("과일명 5개를 입력해 주세요!");
		
		Scanner scanner = new Scanner(System.in);
		
		Set<String> fruitSet = new HashSet<String>();
		
		for (int i=0; i<5; i++) {
			fruitSet.add(scanner.next());
		}
		
		Iterator<String> it = fruitSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		scanner.close();
		
	}

}
























