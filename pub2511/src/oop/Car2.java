/*
	캡슐화(Encapsulation) = 정보 은닉(Information Hiding)
	  - 객체내 변수들의 값을 보호하고 변수값에 대한 획득/변경을 클래스 내부에서 통제
	  - 클래스 내부의 변수들을 private으로 선언 (클래스 외부 직접 접근을 차단)
	  - 변수의 값을 외부에 공개하기 위해서 public getter메소드를 선언
	    getter메소드 형식 : get + 대문자로 시작하는 변수명
	  - 변수의 값을 외부에서 변경하기 위해서 public setter메소드를 선언
	    setter메소드 형식 : set + 대문자로 시작하는 변수명 
*/

package oop;

public class Car2 {
	
	// private 멤버변수
	private String company;
	private String model;
	private String name;
	private int price;
	
	// public getter / setter	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price + 500;
	}
//	public void setPrice(int price) {
//		this.price = price;
//	}

}














