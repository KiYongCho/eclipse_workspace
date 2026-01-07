package collection.ex;

import java.util.Arrays;
import java.util.List;

public class ExStreamAPI {
	
	public static void main(String[] args) {
		
		List<Student2> students = Arrays.asList(
			new Student2("Alice", 85),
			new Student2("Bob", 67),
			new Student2("Charlie", 90),
			new Student2("David", 75),
			new Student2("Eve", 90),
			new Student2("Frank", 45),
			new Student2("Bob", 67),
			new Student2("Grace", 70)
		);
		
		List<String> resultStudents = students.stream()
				
				// 1. 70점 이상인 학생들 필터링
				
				// 2. 이름을 대문자로 변경
				
				// 3. 중복 제거
				
				// 4. 이름에 대해 내림차순 정렬
				
				// 5. 처음 한명 건너뛰기
				
				// 6. 3명만 추출
				
				// 7. 결과를 리스트로
		
		resultStudents.stream().forEach(System.out::println);
		
		// 8. 학생 수 출력
		
		// 9. 평균 점수 출력
		
		// 10. 점수 최대값 출력
		
		// 11. 점수 최소값 출력
		
		// 12. 100점인 학생이 있는지? 모두 30점 이상인지? 음수인 점수가 없는지? 출력
		
		// 13. 점수가 70점에서 80점 사이인 학생 중 첫번째 학생의 이름 출력
		
		// 14. 점수의 총합 출력
		
		// 15. 중복을 제거 후 점수별로 그룹핑된 학생 이름을 출력
		
	} // main
	
} // class