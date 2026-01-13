package thread;

// 계좌 클래스
public class Account {
	
	private String name; // 계좌 주인 이름
	private int money; // 계좌 잔액
	
	public Account() {
	}

	public Account(String name, int money) {
		super();
		this.name = name;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [name=" + name + ", money=" + money + "]";
	}
	
}
