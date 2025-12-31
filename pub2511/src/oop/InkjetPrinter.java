package oop;

// AbstractPrinter를 상속받은 구체클래스 InkljetPrinter
public class InkjetPrinter extends AbstractPrinter {
	
	public InkjetPrinter() {
	}

	public InkjetPrinter(String sort, String company, String name, int price) {
		super(sort, company, name, price);
	}
	
	// 추상클래스에서 구현하지 못한 추상메소드를 오버라이딩해서 구현
	@Override
	public void print() {
		System.out.println(
			"[잉크젯프린터] " +
			sort + "타입의 " +
			company + "사에서 만든 " +
			name + "프린터의 가격은 " +
			price + "원 입니다!"
		);
	}
	

}








