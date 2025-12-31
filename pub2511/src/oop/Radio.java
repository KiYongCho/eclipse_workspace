package oop;

// Radio is a Product
public class Radio extends Product {
	
	private boolean hasAntena; // 안테나 보유 여부
	
	public Radio() {
	}

	public Radio(String company, String name, int price, boolean hasAntena) {
		super(company, name, price);
		this.hasAntena = hasAntena;
	}

	public boolean isHasAntena() {
		return hasAntena;
	}

	public void setHasAntena(boolean hasAntena) {
		this.hasAntena = hasAntena;
	}
	
	// Product toString메소드 오버라이딩
	@Override
	public String toString() {
		return "[Radio, 안테나:" + (hasAntena?"있음":"없음") + "]";
	}	

}
















