package oop;

public class OuterMain {
	
	public static void main(String[] args) {
		
		// Outer 객체 생성
		Outer outerObj = new Outer();
		outerObj.print();
		
		System.out.println();
		
		// Outer의 static inner class 객체 생성
		Outer.SIClass outerSIClassObj = new Outer.SIClass();
		outerSIClassObj.print();
		
		System.out.println();
		
		// Outer의 non-static inner class 객체 생성
		Outer.NSIClass outerNSIObj = outerObj.new NSIClass();
		outerNSIObj.print();
		
	}

}








