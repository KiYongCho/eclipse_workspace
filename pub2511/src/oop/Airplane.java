package oop;

public class Airplane extends Vehicle {
	
	private boolean hasWing; // 날개 보유 여부
	private int jetEngineCnt; // 제트 엔진 수
	
	public Airplane() {
	}

	public Airplane(String name, boolean hasWing, int jetEngineCnt) {
		super(name);
		this.hasWing = hasWing;
		this.jetEngineCnt = jetEngineCnt;
	}

	public boolean isHasWing() {
		return hasWing;
	}

	public void setHasWing(boolean hasWing) {
		this.hasWing = hasWing;
	}

	public int getJetEngineCnt() {
		return jetEngineCnt;
	}

	public void setJetEngineCnt(int jetEngineCnt) {
		this.jetEngineCnt = jetEngineCnt;
	}
	
	@Override
	public String toString() {
		return "비행기";
	}

}
