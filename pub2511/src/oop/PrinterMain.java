package oop;

public class PrinterMain {
	
	public static void main(String[] args) {
		
		// 인터페이스 타입으로 InkjetPrinter 객체 생성
		IPrinter inkjet = new InkjetPrinter("잉크젯", "삼송", "잉크안막혀", 1000);
		
		// 인터페이스 타입으로 RazorPrinter 객체 생성
		IPrinter razor = new RazorPrinter("레이져", "앱송", "종이안잘려", 2000);
		
		// InkjetPrinter 작동
		inkjet.turnOn();
		inkjet.print();
		inkjet.turnOff();
		
		// RazorPrinter 작동
		razor.turnOn();
		razor.print();
		razor.turnOff();
		
		// 실습 : DotPrinter를 생성해서 작동
		//         분류:도트, 회사명:HPP, 이름:잘찍혀, 가격:500
		IPrinter dot = new DotPrinter("도트", "HPP", "잘찍혀", 500);
		dot.turnOn();
		dot.print();
		dot.turnOff();
		
		// 실습 : 프린터 5000개를 생성, 잉크젯과 레이져와 도트 비율 4:4:2
		//         만들어진 모든 프린터를 켜고 출력하고 끄기
		int count = 5000;
		IPrinter[] prtArr = new IPrinter[count];
		for (int i=0; i<count; i++) {
			if (i%10<4) prtArr[i] = new InkjetPrinter("잉크젯", "삼송", "잉크안막혀"+(i+1), 1000);
			else if (i%10<8) prtArr[i] = new RazorPrinter("레이져", "엡송", "종이안잘려"+(i+1), 2000);
			else prtArr[i] = new DotPrinter("도트", "HPP", "잘찍혀"+(i+1), 500);
		}
		for (IPrinter iprinter : prtArr) {
			iprinter.turnOn();
			iprinter.print();
			iprinter.turnOff();
		}
		
	} // main

}


















































