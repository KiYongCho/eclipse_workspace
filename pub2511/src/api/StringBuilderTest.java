/*
	String은 불변(immutable) : 한번 메모리에 생성되면 변경 불가!
	문자열 접합 연산을 많이 하면 메모리에 불필요한 중간단계의 문자열들이 생김
	이를 방지하기 위해서 자바에는 StringBuffer와 StringBuilder가 있음
	1) StringBuffer는 스레드에 안전(thread safe)한 반면 속도가 느림
	2) StringBuilder는 스레드에 안전하지 않음(thread un-safe)한 반면 속도가 빠름
	그러므로 스레드에 안전하려면 StringBuffer를 사용, 속도가 더 중요하면 StringBuilder를 사용
	스레드 안전 : 동시에 두개 이상의 스레드가 문자열 작업을 하는데 있어 한 순간에 하나의 스레드만 작업하도록 
*/

package api;

public class StringBuilderTest {
	
	public static void main(String[] args) {
		
		StringBuilder sb1 = new StringBuilder();
		
		System.out.println(sb1.capacity()); // 기본 16개 버퍼 생성
		
		sb1.append("H");
		sb1.append("e");
		sb1.append("l");
		sb1.append("l");
		sb1.append("o");
		sb1.append(" ");
		sb1.append("J");
		sb1.append("a");
		sb1.append("v");
		sb1.append("a");
		
		System.out.println(sb1.capacity()); // 버퍼 16개
		System.out.println(sb1.length()); // 문자 10개
		
		// 담겨있는 문자의 개수에 버퍼의 개수를 맞춤 
		sb1.trimToSize();
		
		System.out.println(sb1.capacity()); // 버퍼 10개
		System.out.println(sb1.length()); // 문자 10개
		
		// 버퍼를 문자열로 변환
		String str1 = sb1.toString();
		System.out.println(str1);
		
		// 실험 : 문자열 접합연산과 StringBuilder append연산 속도 차
		
		long stStartTime = System.currentTimeMillis();
		String st = "";
		for (int i=0; i<100000; i++) {
			st += "A";
		}
		long stEndTime = System.currentTimeMillis();
		System.out.println("문자열 접합연산 : " + (stEndTime - stStartTime) + "ms");
		
		long sbStartTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<100000; i++) {
			sb.append("a");
		}
		String strSb = sb.toString();
		long sbEndTime = System.currentTimeMillis();
		System.out.println("StringBuilder append연산 : " + (sbEndTime - sbStartTime) + "ms");
		
		StringBuilder sb2 = new StringBuilder("안녕하세요 자바!");
		
		System.out.println(sb2.charAt(2)); // 하
		
		sb2.delete(2, 5);
		System.out.println(sb2); // 안녕 자바!
		
		// 버퍼용량을 최소 50이상으로 증설
		sb2.ensureCapacity(50);
		System.out.println(sb2.capacity()); // 52
		
		System.out.println(sb2.indexOf("자바")); // 3
		
		StringBuilder sb3 = new StringBuilder("Java Java Java");
		
		// 인덱스 5에서부터 Java문자열이 나오는 첫번째 인덱스
		System.out.println(sb3.indexOf("Java", 5)); // 5
		System.out.println(sb3.insert(5,  "Hi")); // Java HiJava Java
		System.out.println(sb3.lastIndexOf("Java")); // 12
		System.out.println(sb3.length()); // 16
		System.out.println(sb3.replace(5 , 7, "Hello")); // Java HelloJava Java
		System.out.println(sb3.reverse()); // avaJ avaJolleH avaJ
		
		sb3.setCharAt(0, 'J'); 
		System.out.println(sb3); // JvaJ avaJolleH avaJ
		
		System.out.println(sb3.substring(5)); // avaJolleH avaJ
		System.out.println(sb3.substring(5, 9)); // avaJ
		
	} // main

} // class


























