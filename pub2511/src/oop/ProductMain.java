package oop;

public class ProductMain {
	
	public static void main(String[] args) {
		
		// 상위형변환
		// 상속관계에서 하위타입 객체는 상위타입으로 생성! => 타입 일원화의 장점
		Product tv1 = new TV("알지전자", "완전커1", 1000, true);
		Product radio1 = new Radio("십만전자", "잘들려1", 500, true);
		System.out.println(tv1); // TV가 오버라이딩한 toString 호출
		System.out.println(radio1); // Radio가 오버라이딩한 toString 호출
		// Product에는 getCompany(), getName(), getPrice() 메소드가 존재함
		System.out.println(tv1.getCompany());
		System.out.println(tv1.getName());
		System.out.println(tv1.getPrice());
		
		// 하위형변환
		// 하위형변환은 한번은 상위형변환이 되었어야 가능
		// => 가지고 있는 참조가 하위타입참조여야 함
		TV tv2 = (TV)tv1;
		Radio radio2 = (Radio)radio1;
		
		// Object로 상위형변환
		Object tv3 = new TV("알지전자", "완전커2", 2000, true);
		Object radio3 = new Radio("십만전자", "잘들려2", 1500, true);
		System.out.println(tv3);
		System.out.println(radio3);
		// Object에는 getCompany(), getName(), getPrice() 메소드가 없음		
		// System.out.println(tv3.getCompany());
		// System.out.println(tv3.getName());
		// System.out.println(tv3.getPrice());
		
		// 상위형변환의 효용 (가치)
		// 상속관계에서 하위타입들을 상위타입으로 타입 일원화를 하면 (상위형변환 하면)
		// 하위타입들을 각각 취급하지 않고 상위타입으로 일괄적인 취급이 가능
		// 예를 들어 TV객체 100개, Radio객체 100개를 만들어
		// 배열에 저장한다면 각각을 배열로 만들지 않고 Product배열 200개짜리를 만듬
		
	}

}

































