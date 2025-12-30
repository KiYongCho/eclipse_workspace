package oop;

public class Main {
	
	public static void main(String[] args) {
		
		// 상위타입 객체참조변수에 하위타입 객체참조값을 할당
		// => 하위타입들을 상위타입으로 "타입 일원화" 가능
		Parent child = new Child();
		
		// 모든 객체참조는 Object 객체참조변수에 저장이 가능
		// child2는 Parent의 변수,메소드가 없음
		Object child2 = new Child();
		
		// 상위타입인 Parent의 private이 아닌 멤버변수를 하위타입에서 상속 받음
		System.out.println(child.si);
		System.out.println(child.nsi);

		// 상위타입인 Parent의 private이 아닌 멤버메서드를 하위타입에서 상속 받음		
		child.sm();
		child.nsm();
		
	}

}










