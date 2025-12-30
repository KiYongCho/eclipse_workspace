package oop;

public class Person {

	private String name; // 이름
	private String job; // 직업
	private int age; // 나이
	private float height; // 키

	// 클래스내에 생성자를 명시하지 않으면 파라미터가 없는
	// 기본생성자를 자동으로 만들어 줌
	// 단, 파라미터 있는 생성자를 하나라도 만들면 기본생성자를 만들어 주지 않음

	// 기본 생성자 : 모든 멤버변수를 멤버변수의 타입의 기본값으로 초기화
	public Person() {
		// 모든 생성자의 첫번째 라인은 상위클래스의 생성자 호출 구문임
		// 하위클래스의 객체는 상위클래스의 객체가 생성된 이후에 생성 가능
		// Person타입의 객체가 만들어지려면 Object의 객체가 만들어 져야함
		super(); // 상위(부모)클래스인 Object의 기본생성자 호출, 생략 가능 
	}

	// name 멤버변수만 초기화 하는 생성자
	public Person(String name) {
		this.name = name; // 앞의 name변수는 객체의 멤버변수, 뒤의 name은 파라미터
	}

	// name, job 멤버변수를 초기화 하는 생성자
	public Person(String name, String job) {
		this(name); // 생성자 내에서 다른 생성자 호출 시 this() 사용
		this.job = job;
	}

	// name, job, age 멤버변수를 초기화 하는 생성자
	public Person(String name, String job, int age) {
		this(name, job);
		this.age = age;
	}

	// name, job, age, height 멤버변수를 초기화 하는 생성자
	public Person(String name, String job, int age, float height) {
		this(name, job, age);
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

}
