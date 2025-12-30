package oop;

public class Bicycle extends Vehicle {
	
	private boolean hasChain; // 체인 보유 여부
	private boolean isElectric; // 전기자전거 여부
	
	public Bicycle() {
	}

	public Bicycle(String name, boolean hasChain, boolean isElectric) {
		super(name);
		this.hasChain = hasChain;
		this.isElectric = isElectric;
	}

	public boolean isHasChain() {
		return hasChain;
	}

	public void setHasChain(boolean hasChain) {
		this.hasChain = hasChain;
	}

	public boolean isElectric() {
		return isElectric;
	}

	public void setElectric(boolean isElectric) {
		this.isElectric = isElectric;
	}
	
	@Override
	public String toString() {
		return "자전거";
	}

}











