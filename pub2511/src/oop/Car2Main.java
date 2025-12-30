package oop;

public class Car2Main {
	
	public static void main(String[] args) {
		
		// Car2 타입 객체 생성
		Car2 audi = new Car2();
		
		// 멤버변수가 private 접근지정이므로 직접 접근 불가
		// System.out.println(audi.company);
		// audi.company = "AUDI KOREA";
		
		// setter메소드를 통해 객체 멤버변수값 변경
		audi.setCompany("AUDI KOREA");
		audi.setModel("A8");
		audi.setName("AUDI");
		// Car2에서 setter를 제공안하면 price값 변경 불가
		// audi.setPrice(2000);
		
		// getter메소드를 통해 객체 멤버변수값 획득
		System.out.println(audi.getCompany());
		System.out.println(audi.getModel());
		System.out.println(audi.getName());
		// Car2에서 제공한 getter를 사용해 price값 획득 가능
		// 하지만, 원래의 price가 얼마인지는 알지 못함
		System.out.println(audi.getPrice());
		
	}

}








