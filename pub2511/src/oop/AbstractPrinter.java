package oop;

// IPrinter 인터페이스를 구현하는 추상클래스
public abstract class AbstractPrinter implements IPrinter {
	
	String sort; // 분류
	String company; // 제조사명
	String name; // 제품명
	int price; // 가격
	
	public AbstractPrinter() {
	}

	public AbstractPrinter(String sort, String company, String name, int price) {
		super();
		this.sort = sort;
		this.company = company;
		this.name = name;
		this.price = price;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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
	
	// 추상프린터는 켜기 기능을 구현할 수 있다? => 있다 => 구현
	@Override
	public void turnOn() {
		System.out.println(name + " 프린터의 전원을 켜다!");	
	}
	
	// 추상프린터는 출력 기능을 구현할 수 있다? => 없다 => 추상
	@Override
	public abstract void print();
	
	// 추상프린터는 끄기 기능을 구현할 수 있다? => 있다 => 구현
	@Override
	public void turnOff() {
		System.out.println(name + " 프린터의 전원을 끄다!");
	}
	
}












