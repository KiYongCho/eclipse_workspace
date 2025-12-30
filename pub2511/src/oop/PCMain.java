package oop;

public class PCMain {
	
	public static void main(String[] args) {
		
		// 모니터 객체 생성 후 멤버변수 값 설정
		Monitor monitor = new Monitor();
		monitor.setName("삼송UHD슈퍼잘보임");
		monitor.setPrice(2000);
		monitor.setInch(30);
		
		// 본체 객체 생성 후 멤버변수 값 설정
		Desktop desktop = new Desktop();
		desktop.setName("삼송파워알파컴퓨터");
		desktop.setPrice(5000);
		desktop.setCpu("I9 10세대");
		desktop.setMemory(32);
		
		// 키보드 객체 생성 후 멤버변수 값 설정
		Keyboard keyboard = new Keyboard();
		keyboard.setName("잘눌러져키보드");
		keyboard.setPrice(1000);
		keyboard.setType("기계식");
		keyboard.setKeyCount(108);
		
		// PC 객체 생성 후 멤버변수 값 설정
		PC pc = new PC();
		pc.setName("파워컴퓨터");
		pc.setPrice(10000);
		pc.setMonitor(monitor);
		pc.setDesktop(desktop);
		pc.setKeyboard(keyboard);
		
		// PC의 모니터의 이름
		System.out.println(pc.getMonitor().getName());
		
		// PC의 본체의 가격
		System.out.println(pc.getDesktop().getPrice());
		
		// PC의 키보드의 타입
		System.out.println(pc.getKeyboard().getType());
		
		// PC의 본체의 가격을 변경 후 출력
		pc.getDesktop().setPrice(5500);
		System.out.println(pc.getDesktop().getPrice());
		
		// PC의 키보드의 타입을 변경 후 출력
		pc.getKeyboard().setType("전자식");
		System.out.println(pc.getKeyboard().getType());
		
		// 실습 : PC의 가격을 모니터와 본체와 키보드 가격 합의 2배로 함
		pc.setPrice(
			(pc.getMonitor().getPrice()
					+ pc.getDesktop().getPrice()
						+ pc.getKeyboard().getPrice())
			* 2
		);
		System.out.println(pc.getPrice());
		
	}

}








