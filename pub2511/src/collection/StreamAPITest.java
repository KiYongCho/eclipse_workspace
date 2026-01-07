package collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPITest {
	
	public static void main(String[] args) {
		
		// 리스트를 스트림으로
		// Arrays.asList : 배열을 리스트로, 인자는 가변인자(varargs:인자의 개수가 가변적)
		List<String> strList = Arrays.asList("Java", "Python", "C++");
		Stream<String> strStream = strList.stream(); // 단일 스트림
		Stream<String> parallelStream = strList.parallelStream(); // 병렬 스트림
		
		// 배열을 스트림으로
		String[] sArr = {"Java", "Hello", "Hi", "Thanks", "Sorry"};
		Stream<String> sArrStream = Arrays.stream(sArr);
		
		// 수집결과를 List, Set, Map으로 만들기
		List<String> sList = sArrStream.collect(Collectors.toList());
		System.out.println(sList);
		
		Set<String> sSet 
			= Arrays.stream(sArr).collect(Collectors.toSet());
		System.out.println(sSet);
		
		Map<String, Integer> sMap
			= sList.stream().collect(Collectors.toMap(str->str, str->str.length()));
		System.out.println(sMap);
		
		// 그룹핑 / 집계
		List<String> gList = Arrays.asList(
			"apple", "banana", "kiwi", "pear", "grape", "melon", "peach"
		);
		// 문자열의 길이로 그룹핑한 맵 : 키는 문자열의 길이, 값은 그룹핑된 문자열들의 리스트
		Map<Integer, List<String>> groupedByLength
			= gList.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(groupedByLength);
		
		long count = gList.stream().collect(Collectors.counting());
		System.out.println(count);
		
		// 병렬 스트림 처리 : 데이터가 아주 많을때
		gList.parallelStream()
			.filter(s->s.length()>=5)
			.forEachOrdered(System.out::println);
		
		// 메소드 체이닝 : 스트림 연속 처리
		List<String> nameList
			= Arrays.asList("홍길동", "강감찬", "홍길동", "이순신", "최영", "권율");
		List<String> resultList
			= nameList.stream() // 리스트를 스트림으로
					.filter(name->name.length()>=3) // 문자열 길이가 3이상인 것들만 필터링
					.distinct() // 중복 제거
					.sorted() // 오름차순 정렬
					.map(name->name+"님") // 각 문자열 뒤에 님 붙임
					.collect(Collectors.toList()); // 스트림 연산 결과를 리스트로 반환
		System.out.println(nameList);
		System.out.println(resultList);
		
		class Student {
			private String name;
			private int score;
			public Student() {
			}
			public Student(String name, int score) {
				this.name = name;
				this.score = score;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getScore() {
				return score;
			}
			public void setScore(int score) {
				this.score = score;
			}
		}
		
		List<Student> studentList = Arrays.asList(
			new Student("홍길동", 90),
			new Student("강감찬", 100),
			new Student("이순신", 60),
			new Student("최영", 70)
		);		
		
		// 실습 : 학생리스트에서 점수가 70점 이상인 학생들의 리스트를 출력
		// code here
		List<String> resultList2 = 
			studentList.stream()
				.filter(student->student.getScore()>=70)
				.map(Student::getName)
				.collect(Collectors.toList());
		resultList2.stream().forEach(System.out::println);
		
	}

}








































