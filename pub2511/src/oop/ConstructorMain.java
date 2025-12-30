package oop;

public class ConstructorMain {
	
	public static void main(String[] args) {
		
		// 기본생성자로 만든 Person 객체
		Person person1 = new Person();
		printInfo(person1);
		
		Person person2 = new Person("홍길동");
		printInfo(person2);
		
		Person person3 = new Person("홍길동", "산적");
		printInfo(person3);
		
		Person person4 = new Person("홍길동", "산적", 20);
		printInfo(person4);
		
		Person person5 = new Person("홍길동", "산적", 20, 160.5f);
		printInfo(person5);
		
	}
	
	// 객체의 멤버변수 값들을 출력하는 메소드
	private static void printInfo(Person person) {
		System.out.println(person.getName()); // null, 참조타입 기본값
		System.out.println(person.getJob()); // null, 참조타입 기본값
		System.out.println(person.getAge()); // 0, int 기본값
		System.out.println(person.getHeight()); // 0.0, float 기본값
	}

}











