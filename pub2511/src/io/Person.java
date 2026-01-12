/*
	[직렬화할 객체의 클래스]
	1. java.io.Serializable 인터페이스를 구현해야 함
	2. private static final long serialVersionUID 상수 생성
	3. 타입의 기본값으로 직렬화할 변수 앞에는 transient 키워드를 붙임
	4. 멤버변수는 모두 직렬화 가능한 타입이어야 함 (기본타입이거나 Serializable을 구현한 타입) 
*/

package io;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serealVersionUID = 223984789324289323L;
	
	private String name; // String은 Serializable을 구현하고 있으므로 직렬화 가능
	private int age; // 모든 기본타입들은 직렬화 가능
	private transient String ssn; // ssn이 어떤 값을 가지던지 String타입의 기본값인 null로 직렬화 됨
	
	public Person() {
	}

	public Person(String name, int age, String ssn) {
		super();
		this.name = name;
		this.age = age;
		this.ssn = ssn;
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

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ssn=" + ssn + "]";
	}

}














