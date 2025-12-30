package oop;

public class VehicleMain {
	
	public static void main(String[] args) {
		
		// 하위클래스에서 상위클래스의 메소드를 오버라이딩한 경우
		// 객체참조변수가 가지고 있는 참조에 따라 하위클래스의 메소드가 호출됨
		// * 객체참조변수가 무슨 타입이냐보다 무슨 타입 참조를 가지고 있느냐가 중요!
		
		// 아래 v1, v2, v3 변수는 모두 Vehicle 타입이나 가지고 있는 참조는 모두 다름
		// => 다형성 : 동일한 형태인데 다른 성질을 가짐
		
		// 오버라이딩의 목적
		// 상위타입 객체참조변수에 하위타입 객체참조값을 저장하면
		// 하위타입들을 하나의 상위타입으로 "타입 일원화" 할 수 있음!!!
		
		// v1변수는 Vehicle타입, 가지고 있는 참조는 Vehicle참조
		Vehicle v1 = new Vehicle("탈것", false);
		System.out.println(v1); // Vehicle의 toString호출
		
		// v2변수는 Vehicle타입, 가지고 있는 참조는 Bus참조
		Vehicle v2 = new Bus("버스", true, 25);
		System.out.println(v2); // Bus의 toString호출
		
		// v3변수는 Vehicle타입, 가지고 있는 참조는 Bicycle참조
		Vehicle v3 = new Bicycle("자전거", true, false);
		System.out.println(v3); // Bicycle의 toString호출
		
		// 실습 : Airplane 클래스를 생성하고 Vehicle을 상속받아 toString을 오버라이딩한
		//         후 객체를 생성해서 출력
		Vehicle v4 = new Airplane("비행기", true, 2);
		System.out.println(v4);
		
		// 실습
		// name이 Bus1 ~ Bus1000인 1000개의 Bus객체를 생성
		// name이 Bicycle1 ~ Bicycle1000인 1000개의 Bicycle객체를 생성
		// name이 Airplane1 ~ Airplane1000인 1000개의 Airplane객체를 생성
		// 생성된 3000개 객체의 name을 출력
		
		// poor code
		// Bus, Bicycle, Airplane 별도의 배열을 생성? 탈것이 100개라면???
		int count = 1000;
		Bus[] busArr = new Bus[count];
		Bicycle[] bicycleArr = new Bicycle[count];
		Airplane[] airplaneArr = new Airplane[count];
		for (int i=0; i<count; i++) {
			busArr[i] = new Bus("Bus" + (i+1), true, 25);
			bicycleArr[i] = new Bicycle("Bicycle" + (i+1), true, false);
			airplaneArr[i] = new Airplane("Airplane" + (i+1), true, 2);
			System.out.println(busArr[i].getName());
			System.out.println(bicycleArr[i].getName());
			System.out.println(airplaneArr[i].getName());
		}
		
		// better code
		// Bus, Bicycle, Airplane 모두 Vehicle 타입이다! 상위타입으로 일원화!
		int cnt = 3000;
		Vehicle[] vArr = new Vehicle[cnt];
		for (int i=0; i<cnt; i=i+3) {
			vArr[i] = new Bus("Bus" + (i/3+1), true, 25);
			vArr[i+1] = new Bicycle("Bicycle" + (i/3+1), true, false);
			vArr[i+2] = new Airplane("Airplane" + (i/3+1), true, 2);
		}
		for (Vehicle v : vArr) {
			System.out.println(v.getName());
		}
		
		// 실습
		// Vehicle의 기본 요금은 1000원
		// Bus 요금은 Vehicle 기본 요금의 1.5배
		// Bicycle 요금은 Vehicle 기본 요금의 0.5배
		// Airplane 요금은 Vehicle 기본 요금의 30배
		// 3명이 Bus를 타고 5명이 Bicycle을 타고 2명이 Airplane을
		// 탄다고 했을 때 총 요금을 연산
		
		Vehicle vv = new Vehicle();		
		vv.setPrice(1000);
		Vehicle bu = new Bus();				
		bu.setPrice((int)(vv.getPrice() * 1.5));
		Vehicle bi = new Bicycle();			
		bi.setPrice((int)(vv.getPrice() * 0.5));
		Vehicle ai = new Airplane();		
		ai.setPrice(vv.getPrice() * 30);
		
		Vehicle[] vvArr = {bu, bu, bu, bi, bi, bi, bi, bi, ai, ai, ai};
		
		int priceSum = 0;
		for (Vehicle v : vvArr) {
			priceSum += v.getPrice();
		}
		
		System.out.printf("요금 총합 : %d", priceSum);
		
	} // main

} // class
























































