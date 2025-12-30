package oop;

// 탈것을 추상화한 클래스
public class Vehicle {
	
	// 탈것이 가지는 공통의 데이터 / 변수
	private String name; // 이름
	private boolean hasEngine; // 엔진보유 여부
	
	public Vehicle() {
	}
	
	public Vehicle(String name) {
		this.name = name;
	}

	public Vehicle(String name, boolean hasEngine) {
		super();
		this.name = name;
		this.hasEngine = hasEngine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isHasEngine() {
		return hasEngine;
	}

	public void setHasEngine(boolean hasEngine) {
		this.hasEngine = hasEngine;
	}
	
	// @Override : 오버라이딩한 메소드인지 컴파일타임에 검증하는 어노테이션(annotation)
	@Override
	public String toString() {
		return "탈것";
	}

}












