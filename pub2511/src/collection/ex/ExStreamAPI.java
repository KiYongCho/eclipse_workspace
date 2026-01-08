package collection.ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
				.filter(s -> s.getScore()>=70)
				
				// 2. 이름을 대문자로 변경
				.map(s -> s.getName().toUpperCase())
				
				// 3. 중복 제거
				.distinct()
				
				// 4. 이름에 대해 내림차순 정렬
				.sorted(Comparator.reverseOrder())
				
				// 5. 처음 한명 건너뛰기
				.skip(1)
				
				// 6. 3명만 추출
				.limit(3)
				
				// 7. 결과를 리스트로
				.collect(Collectors.toList());
		
		resultStudents.stream().forEach(System.out::println);
		
		// 8. 학생 수 출력
		System.out.println(students.stream().count());
		
		// 9. 평균 점수 출력
		System.out.println(
			students.stream().collect(
				Collectors.averagingInt(Student2::getScore)
			)
		);
		
		// 10. 점수 최대값 출력
		System.out.println(
			students.stream().mapToInt(Student2::getScore).max().orElse(0)
		);
		
		// 11. 점수 최소값 출력
		System.out.println(
				students.stream().mapToInt(Student2::getScore).min().orElse(0)
			);		
		
		// 12. 100점인 학생이 있는지? 모두 30점 이상인지? 음수인 점수가 없는지? 출력
		System.out.println(
				students.stream().anyMatch(s -> s.getScore()==100)
				? "100점 있음" : "100점 없음"
		);
		System.out.println(
				students.stream().allMatch(s -> s.getScore()>=30)
				? "모두 30점 이상" : "모두 30점 이상은 아님"
		);		
		System.out.println(
				students.stream().noneMatch(s -> s.getScore()<0)
				? "음수인 점수 없음" : "음수인 점수 있음"
		);				
		
		// 13. 점수가 70점에서 80점 사이인 학생 중 첫번째 학생의 이름 출력
		// findFirst는 Optional<Student2>를 반환
		// => Student2가 null인 경우에 대체하는 타입
		// => get()메소드를 사용해서 Optional에서 Student2를 꺼냄
		System.out.println(
			students.stream()
				.filter(s->s.getScore()>=70 && s.getScore()<=80)
				.map(Student2::getName).findFirst().get()
		);
		
		// 14. 점수의 총합 출력
		System.out.println(
			students.stream()
				.map(Student2::getScore).reduce(0, Integer::sum)
		);
		
		// 15. 중복을 제거 후 점수별로 그룹핑된 학생 이름을 출력
		Map<Integer, List<String>> grouped
			= students.stream()
				.distinct()
				.collect(
					Collectors.groupingBy(
						Student2::getScore,
						Collectors.mapping(Student2::getName, Collectors.toList())
					)
				);
		grouped.forEach((score, names) -> {
			System.out.println("점수: " + score + ", 이름: " + names);
		});
		
	} // main
	
} // class













