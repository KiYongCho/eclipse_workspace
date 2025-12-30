package oop;

// 자동차를 추상화한 Car 클래스 정의
// Car라는 이름의 참조타입
public class Car { // extends Object가 생략된 것
	
	// static member variable
	// 1. 객체 생성없이 클래스를 통해서 사용 가능
	// 2. 객체들이 변수를 공유
	// 3. static / non-static 접근 모두 가능
	// 4. 메모리에 하나만 생성됨
	static int carCount = 0; // 생성된 객체의 수를 저장할 변수
	
	// non-static member variable
	// 1. 생성된 객체를 통해서 사용 가능
	// 2. 객체마다 각각 변수를 가짐
	// 3. non-static 접근만 가능
	// 4. 메모리에 객체의 수만큼 생성됨
	String company; // 제조사명
	String model; // 모델명
	String name; // 이름
	int price; // 가격
	
	// 기본(default) 생성자
	// 역할 : non-static 멤버변수의 값을 초기화
	Car() {
	}
	
	// static member method
	// 객체 생성없이 클래스를 통해 사용 가능
	public static int getCarCount() {
		return carCount; // Car.carCount에서 Car.이 생략된 것
	}
	
	// non-static member method
	// 객체 생성 후에 사용 가능
	public int getPrice() {
		return price; // this.price에서 this.이 생략된 것
	}

}










