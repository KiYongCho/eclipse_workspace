package oop;

public class CarMain {
	
	public static void main(String[] args) {
		
		// Car타입 객체 생성
		// 1. Car타입 객체가 메모리에 생성됨
		// 2. 생성된 객체의 메모리 주소(address)를 해시알고리즘을 사용해 참조(reference)로 변환
		// 3. 변환된 참조값을 bmw라는 객체참조변수에 저장
		Car bmw = new Car();
		
		// 타입 + 구분자 @ + 16진수 8자리 참조값
		System.out.println(bmw); // oop.Car@24d46ca6
		
		// hashCode() : Object에서 상속받은 메소드로 10진수 참조값 반환
		System.out.println(bmw.hashCode()); // 617901222
		
		// Car타입 두번째 객체 생성
		Car bentz = new Car();
		
		System.out.println(bentz); // oop.Car@4517d9a3
		
		System.out.println(bentz.hashCode()); // 1159190947
		
		// 위에서 bmw와 bentz는 참조값이 다름
		// = 메모리 상에 다른 곳에 있음
		// = 두 객체는 다른 객체
		// * 자바에서 동일한 객체란 메모리상에 같은 곳에 위치한 객체를 말함
		//    = 참조값이 같으면 같은 객체
		
		// equals() : Object에서 상속받은 메소드, 두 객체의 참조값을 비교
		System.out.println(bmw.equals(bentz)); // false
		
		// 객체의 멤버변수에 값 할당
		
		// static
		bmw.carCount = 1;
		// non-static
		bmw.company = "BMW KOREA";
		bmw.model = "520D";
		bmw.name = "BMW";
		bmw.price = 1000;
		
		// static
		bentz.carCount = 2;
		// non-static
		bentz.company = "BENTZ KOREA";
		bentz.model = "AMG";
		bentz.name = "BENTZ";
		bentz.price = 2000;
		
		// static
		Car.carCount = 3;
		
		// static멤버변수는 메모리에 하나만 생성되고 모든 객체가 공유
		System.out.println(bmw.carCount); // 3
		System.out.println(bentz.carCount); // 3
		System.out.println(Car.carCount); // 3
		
		// non-static멤버변수는 객체마다 별도로 가짐
		bmw.price = 1500;
		bentz.price = 2500;
		System.out.println(bmw.price); // 1500
		System.out.println(bentz.price); // 2500
		
		// static메소드는 클래스와 객체에서 접근 가능
		System.out.println(Car.getCarCount()); // 3
		System.out.println(bmw.getCarCount()); // 3
		System.out.println(bentz.getCarCount()); // 3
		
		// non-static메소드는 객체로만 접근 가능
		// System.out.println(Car.getPrice());
		System.out.println(bmw.getPrice()); // 1500
		System.out.println(bentz.getPrice()); // 2500
		
	}

}










