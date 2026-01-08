package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ComparatorTest {
	
	public static void main(String[] args) {
		
		// Comparator타입 객체 생성
		// Integer들을 오름차순 정렬하는 Comparator
		Comparator<Integer> intComp = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		};
		
		List<Integer> intList = new ArrayList<Integer>();
		Collections.addAll(intList, 3, 10, 2, 9, 5, 7, 15, 6, 4);
		
		// Comparator를 활용해 리스트를 정렬
		Collections.sort(intList, intComp);
		System.out.println(intList);
		
		// 문자열 길이에 따라 오름차순 정렬하는 Comparator
		Comparator<String> strComp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		List<String> strList = new ArrayList<String>();
		Collections.addAll(strList, "hi", "hello", "java", "progrmming", "a");
		
		Collections.sort(strList, strComp);
		System.out.println(strList);
		
		// 객체 정렬
		class Person {
			private String name;
			private int age;
			public Person() {
			}
			public Person(String name, int age) {
				super();
				this.name = name;
				this.age = age;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public int getAge() {
				return age;
			}
			public void setAge(int age) {
				this.age = age;
			}
			@Override
			public String toString() {
				return name + ":" + age;
			}
		} // Person
		
		List<Person> personList = new ArrayList<Person>();
		Collections.addAll(personList,
			new Person("홍길동", 90),
			new Person("강감찬", 10),
			new Person("이순신", 30),
			new Person("최영", 100),
			new Person("권율", 40)
		);
		
		// 나이에 대해서 오름차순 정렬하는 Comparator
		Comparator<Person> ascCom = new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge() - o2.getAge();
			};
		};
		
		Collections.sort(personList, ascCom);
		System.out.println(personList);
		
		// Comparator API 활용

		// Comparator.naturalOrder() : 오름차순 정렬
		// Comparator.reverseOrder() : 내림차순 정렬		
        String[] names = {"Hong", "kim", "Lee", "park"};
        Arrays.sort(names, Comparator.naturalOrder());
        System.out.println("오름차순: " + Arrays.toString(names));
        Arrays.sort(names, Comparator.reverseOrder());
        System.out.println("내림차순: " + Arrays.toString(names));
        
        // 짝수 우선 정렬
        Integer[] nums = {7, 2, 9, 4, 3, 8, 1, 6, 5};
        Comparator<Integer> evenFirst = (a, b) -> {
            int pa = (a % 2 == 0) ? 0 : 1; // a가 짝수면 pa는 0
            int pb = (b % 2 == 0) ? 0 : 1; // b가 짝수면 pa는 0
            if (pa != pb) return pa - pb;
            return a - b;
        };
        Arrays.sort(nums, evenFirst);
        System.out.println("결과: " + Arrays.toString(nums));
        
        class Student {
            private String name;
            private int score;
            private int age;
            public Student() {
			}
            public Student(String name, int score, int age) {
                this.name = name;
                this.score = score;
                this.age = age;
            }
            public String getName() { return name; }
            public int getScore() { return score; }
            public int getAge() { return age; }
            public void setName(String name) { this.name = name; }
            public void setScore(int score) { this.score = score; }
            public void setAge(int age) { this.age = age; }
            @Override
            public String toString() {
                return String.format("이름:'%s', 성적:%d, 나이:%d\n", name, score, age);
            }
        }        
        
        // 점수 내림차순 정렬 후 이름 오름차순 정렬
        // thenComparing() : 후속 정렬 (2차, 3차 ...)
        Student[] arr = {
                new Student("홍길동", 90, 20),
                new Student("강감찬", 95, 22),
                new Student("이순신", 95, 21),
                new Student("장보고", 90, 19),
        };
        Comparator<Student> byScoreDescThenNameAsc =
                Comparator.comparing(Student::getScore).reversed()
                          .thenComparing(Student::getName);
        Arrays.sort(arr, byScoreDescThenNameAsc);
        System.out.println(Arrays.toString(arr));
        
        // sort(String.CASE_INSENSITIVE_ORDER) : 대소문자 무시 정렬
        List<String> list = new ArrayList<>(List.of("Hong", "kim", "Lee", "park", "Kang"));
        list.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(list);
        
        // Comparator.nullsLast() : null을 맨 뒤로
        List<String> list2 = new ArrayList<>(
        	Arrays.asList("banana", null, "kiwi", "apple", null, "pear", "plum")
        );
        Comparator<String> rule =
                Comparator.nullsLast(
                        Comparator.comparingInt(String::length)
                                  .thenComparing(Comparator.naturalOrder())
                );

        list2.sort(rule);
        System.out.println(list2);
        
        // 점수 내림차순, 나이 오름차순, 이름 오름차순 정렬 후 상위 N명 출력
        List<Student> students = new ArrayList<>(List.of(
                new Student("홍길동", 90, 20),
                new Student("강감찬", 95, 22),
                new Student("이순신", 95, 21),
                new Student("장보고", 90, 19),
                new Student("권율", 95, 21),
                new Student("최영", 88, 23)
        ));
        Comparator<Student> rule2 =
                Comparator.comparing(Student::getScore).reversed()
                          .thenComparing(Student::getAge)
                          .thenComparing(Student::getName);

        students.sort(rule2);
        students.forEach(System.out::println);
        List<Student> top = students.stream()
        	.limit(3)
        	.collect(Collectors.toList());
        System.out.println(top);        
		
	}

}















































