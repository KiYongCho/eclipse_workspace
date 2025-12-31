package oop;

// Tiger클래스가 IAnimal인터페이스를 구현하려면
// 6개의 추상메소드를 모두 오버라이딩해서 구현해야 함
// 그런데 Tiger가 eat기능만 사용한다면? => Adapter 추상클래스가 필요함
//public class Tiger implements IAnimal {

// 어뎁터 추상클래스를 상속받아서 원하는 메소드만 오버라이딩함
public class Tiger extends AnimalAdapter {
	
	@Override
	public void eat() {
		System.out.println("호랑이가 먹는다!");
	}

}













