/*
	Aggregation(집합)과 Composition(합성)
	  - 집합은 독립적인 구성 요소들이 하나로 합쳐짐, 전체가 소멸되도 부분은 남는 관계
	    예) PC는 모니터,키보드,마우스,본체의 집합 (느슨한 관계, has-a 관계)
	  - 합성은 전체를 이루는 전체의 일부들의 집합, 전체가 소멸되면 부분도 소멸되는 관계
	    예) 사람과 심장의 관계 (강한 관계, part-of 관계)
*/

package oop.ex;

public class PC {

	// PC는 제품명과 가격 데이터가 있음
	private String name; // 제품명
	private int price; // 가격
	// PC는 모니터, 본체, 키보드로 구성 (Aggregation)
	// """ 클래스와 멤버변수의 관계는 has a 관계 """
	// PC has a Monitor, PC has a Desktop, PC has a Keyboard
	// PC는 Monitor, Desktop, Keyboard가 생성되면 생성될 수 있음
	private Monitor monitor; // 모니터
	private Desktop desktop; // 본체
	private Keyboard keyboard; // 키보드

	public PC() {
	}

	public PC(String name, int price, Monitor monitor, Desktop desktop, Keyboard keyboard) {
		super();
		this.name = name;
		this.price = price;
		this.monitor = monitor;
		this.desktop = desktop;
		this.keyboard = keyboard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	public Desktop getDesktop() {
		return desktop;
	}

	public void setDesktop(Desktop desktop) {
		this.desktop = desktop;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

}
