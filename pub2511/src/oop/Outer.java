package oop;

public class Outer {
	
	// static member variable
	static int si = 1;
	
	// non-static member variable
	int nsi = 2;
	
	// static inner class
	static class SIClass {
		void print() {
			// static에서는 static멤버변수에 접근가능
			System.out.println("SIClass print si => " + si);
		}
	}
	
	// non-static inner class
	class NSIClass {
		void print() {
			// non-static에서는 static멤버변수와 non-static멤버변수에 접근가능
			System.out.println("NSIClass print si => " + si);
			System.out.println("NSIClass print nsi => " + nsi);
		}
	}
	
	// Outer클래스의 print메소드
	void print() {
		
		// print메소드의 local variable
		int li = 3;
		
		System.out.println("Outer print");
		
		// local inner class
		class LIClass {
			void print() {
				// local에서는 static, non-static, local변수 모두 접근 가능
				System.out.println("LIClass print si => " + si);
				System.out.println("LIClass print nsi => " + nsi);
				System.out.println("LIClass print li => " + li);
			}
		}
		
		LIClass liClassObj = new LIClass();
		liClassObj.print();
		
	} // print

} // class































