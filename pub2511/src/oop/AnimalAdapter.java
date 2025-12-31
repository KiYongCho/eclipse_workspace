package oop;

// 디자인패턴 중에서 Adapter패턴
// 인터페이스의 모든 추상메소드를 기본구현하는 추상클래스를
// 인터페이스와 구체클래스 중간에 두는 패턴
// => 구체클래스는 인터페이스를 직접 구현하지 않고
//       인터페이스를 기본구현한 추상클래스를 상속 받아서
//       원하는 메소드만 오버라이딩 할 수 있음

// IAnimal인터페이스를 구현하고 모든 추상메소드를 기본 구현하는
// AnimalAdater 추상클래스
public abstract class AnimalAdapter implements IAnimal {
	
	@Override
	public void breath() {}
	
	@Override
	public void eat() {}
	
	@Override
	public void move() {}
	
	@Override
	public void poo() {}
	
	@Override
	public void sleep() {}
	
	@Override
	public void sound() {}

}








