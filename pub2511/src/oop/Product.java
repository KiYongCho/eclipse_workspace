/*
	상위형변환(up type casting) = 자동(auto) = 묵시적(implicit)
	  - 하위 타입 > 상위 타입
	  - 하위 타입의 참조범위는 상위 타입보다 넓음
	하위형변환(down type casting) = 강제(force) = 명시적(explicit)
	  - 상위 타입 > 하위 타입
	  - 상위 타입의 참조범위는 하위 타입보다 좁음
	  - 한번은 상위형변환 되었던 것만 하위형변환 가능
*/

package oop;

// 제품을 추상화한 클래스
public class Product {
	
	private String company; // 제조사명
	private String name; // 제품명
	private int price; // 가격
	
	public Product() {
	}

	public Product(String company, String name, int price) {
		super();
		this.company = company;
		this.name = name;
		this.price = price;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
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
	
	// Product 객체 출력시 사용할 문자열을 만들기 위해서
	// Object의 toString()을 오버라이딩
	@Override
	public String toString() {
		return "[제조회사명:" + company + ", 제품명:"+name+", 가격:"+price+"]";
	}

}















