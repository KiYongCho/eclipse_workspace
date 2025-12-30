package oop;

public class Bus extends Vehicle {
	
	private boolean hasCardTag; // 카드태그 보유 여부
	private int psgCount; // 탑승 정원 수
	
	public Bus() {
	}

	public Bus(String name, boolean hasCardTag, int psgCount) {
		super(name);
		this.hasCardTag = hasCardTag;
		this.psgCount = psgCount;
	}

	public boolean isHasCardTag() {
		return hasCardTag;
	}

	public void setHasCardTag(boolean hasCardTag) {
		this.hasCardTag = hasCardTag;
	}

	public int getPsgCount() {
		return psgCount;
	}

	public void setPsgCount(int psgCount) {
		this.psgCount = psgCount;
	}
	
	@Override
	public String toString() {
		return "버스";
	}

}












