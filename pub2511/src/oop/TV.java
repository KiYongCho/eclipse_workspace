package oop;

// TV is a Product
public class TV extends Product {
	
	private boolean hasDisplay; // 화면 보유 여부
	
	public TV() {
	}

	public TV(String company, String name, int price, boolean hasDisplay) {
		super(company, name, price);
		this.hasDisplay = hasDisplay;
	}

	public boolean isHasDisplay() {
		return hasDisplay;
	}

	public void setHasDisplay(boolean hasDisplay) {
		this.hasDisplay = hasDisplay;
	}

	// Product의 toString()을 오버라이딩
	@Override
	public String toString() {
		return "[TV, 디스플레이:" + (hasDisplay?"있음":"없음") + "]";
	}

}















