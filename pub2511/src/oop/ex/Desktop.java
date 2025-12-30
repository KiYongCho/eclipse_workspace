package oop.ex;

// 본체를 추상화한 클래스
public class Desktop {

	private String name; // 제품명
	private int price; // 가격
	private String cpu; // CPU 종류
	private int memory; // 메모리 크기 (GByte)

	public Desktop() {
	}

	public Desktop(String name, int price, String cpu, int memory) {
		super();
		this.name = name;
		this.price = price;
		this.cpu = cpu;
		this.memory = memory;
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

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

}
