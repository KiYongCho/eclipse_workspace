package api;

public class StringTest {
	
	public static void main(String[] args) {
		
		String str1 = "abcdefgh"; // length:8, index:0~7(문자열은 내부적으로 문자의 배열)
		
		System.out.println(str1.charAt(3)); // d
		System.out.println(str1.concat("ij")); // abcdefghij, str1이 변경되는건 아님
		System.out.println(str1+"ij"); // abcdefghij, str1이 변경되는건 아님
		System.out.println(str1.contains("cba")); // false
		System.out.println(str1.startsWith("cd")); // false
		System.out.println(str1.endsWith("gh")); // true
		System.out.println(str1.equals("abcde")); // false, Object의 equals를 오버라이딩 함
		System.out.println(str1.equalsIgnoreCase("ABCDEFGH")); // true
		
		byte[] byteArr = str1.getBytes();
		for (byte b : byteArr) {
			System.out.println(b); // 문자의 ASCII코드값
			System.out.println((char)b); // 문자
		}
		
		System.out.println(str1.indexOf('c')); // 2
		
		String str2 = "                 ";
		System.out.println(str2.isBlank()); // true
		System.out.println(str2.isEmpty()); // false
		
		String str3 = "abcdabcdabcd";
		System.out.println(str3.lastIndexOf('a')); // 8
		System.out.println(str3.length()); // 12
		System.out.println(str3.repeat(2)); // abcdabcdabcdabcdabcdabcd 
		System.out.println(str3.replace("bc", "ef")); // aefdaefdaefd
		System.out.println(str3.replaceAll("a+", "ef")); // efbcdefbcdefbcd
		
		String str4 = "010-1234-5678";
		
		// - 문자열을 기준으로 전체 문자열을 분리(Tokenizing)해서 문자열 배열로 반환
		String[] strArr = str4.split("-"); // delimeter(구분문자열)를 안쓰면 공백문자가 기본
		for (String str : strArr) {
			System.out.println(str);
		}
		
		String str5 = "안녕하세요! 자바 재밌나요?";
		
		System.out.println(str5.startsWith("안녕")); // true
		System.out.println(str5.substring(7)); // 자바 재밌나요?
		System.out.println(str5.substring(7, 9)); // 자바
		
		char[] charArr = str5.toCharArray();
		for (char ch : charArr) {
			System.out.println(ch);
		}
		
		String str6 = "   Abc   dEf   ";
		
		System.out.println(str6.toLowerCase()); //   abc   def   
		System.out.println(str6.toUpperCase()); //   ABC   DEF  
		System.out.println(str6.trim()); // Abc   dEf
		
		System.out.println(String.valueOf(123)); // "123" 문자열
		System.out.println(String.valueOf(false)); // "false" 문자열
		System.out.println(""+false); // false 문자열
		
		
	} // main

} // class



















































