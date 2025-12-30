package oop;

// 상속 해주는 클래스 = 상위(super) = 부모(parent) = 기본(base)
// class 앞에 final이 붙으면 상속 불가
public class Parent /* extends Object 생략됨 */ {
	
	private static int psi; // private 상속 불가
	private int pnsi; // private 상속 불가
	static int si; // 상속 가능
	int nsi; // 상속 가능

	// 생성자는 상속 불가
	public Parent() {
	}
	
	// private 상속 불가
	private static void psm() {
		System.out.println("psm()");
	}

	// private 상속 불가	
	private void pnsm() {
		System.out.println("pnsm()");
	}
	
	// 상속 가능	
	static void sm() {
		System.out.println("sm()");
	}
	
	// 상속 가능
	void nsm() {
		System.out.println("nsm()");
	}

}
















