/*
	StringTokenizer : 문자열을 구분문자열(delimeter)로 분리할때 사용
	                          예를들어 "010-1234-5678" 문자열을 - 기준으로 3개로 분리
*/

package api;

import java.util.StringTokenizer;

public class StringTokenizerTest {
	
	public static void main(String[] args) {
		
		String str1 = "안녕 하세요! 자바 재밌나요?";
		String str2 = "010-1234-5678";
		
		StringTokenizer st1 = new StringTokenizer(str1); // 공백문자 기준 토크나이져
		System.out.println(st1.countTokens()); // 4
		
		while (st1.hasMoreTokens()) { // 토큰이 있는동안 반복
			System.out.println(st1.nextToken()); // 각 토큰
		}
		
		StringTokenizer st2 = new StringTokenizer(str2, "-"); // -문자 기준 토크나이져
		System.out.println(st2.countTokens()); // 3
		
		while (st2.hasMoreTokens()) { // 토큰이 있는동안 반복
			System.out.println(st2.nextToken()); // 각 토큰
		}
		
		String str3 = "a,b,c\n,d,e,f\n1,2,3";
		
		// \n 문자열과 , 문자열을 기준으로 분리하는 토크나이져
		StringTokenizer st3 = new StringTokenizer(str3, "\n,");
		System.out.println(st3.countTokens()); // 9
		
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
		// 실습
		// str4 문자열을 토크나이징해서 아래 형식으로 출력
		// 번호:1, 이름:홍길동, 이메일:hong@hong.com, 전화번호:(010)0000-0000
		// 번호:2, 이름:강감찬, 이메일:kang@kang.com, 전화번호:(010)1111-2222
		// 번호:3, 이름:이순신, 이메일:lee@lee.com, 전화번호:(010)2222-2222
		
		String str4 = "[";
		str4 += "{\"name\": \"홍길동\", \"email\": \"hong@hong.com\", \"tel\": \"010-0000-0000\"},";
		str4 += "{\"name\": \"강감찬\", \"email\": \"kang@kang.com\", \"tel\": \"010-1111-1111\"},";
		str4 += "{\"name\": \"이순신\", \"email\": \"lee@lee.com\", \"tel\": \"010-2222-2222\"}";
		str4 += "]";
		
		// [
		//{"name": "홍길동", "email": "hong@hong.com", "tel": "010-0000-0000"},
		//{"name": "강감찬", "email": "kang@kang.com", "tel": "010-1111-1111"},
		//{"name": "이순신", "email": "lee@lee.com", "tel": "010-2222-2222"}
		//]
		//System.out.println(str4);
		
		// 불필요한 문자들 제거하고 문자열 배열 생성
		StringTokenizer st4 = new StringTokenizer(str4, "[{}\": , ]");
		String[] strTokens = new String[st4.countTokens()];
		int idx = 0;
		while (st4.hasMoreTokens()) {
			strTokens[idx] = st4.nextToken();
			System.out.println(strTokens[idx]);
			idx++;
		}
		
		// 배열 요소들 추출해서 필요한 형식으로 출력
		for (int i=0; i<3; i++) {
			// 전화번호 분리용 토크나이져
			StringTokenizer st5 = new StringTokenizer(strTokens[i*6+5], "-");
			String newTelnum = "(" + st5.nextToken() + ")"
				+ st5.nextToken() + "-" + st5.nextToken();
			System.out.printf(
				"번호:%d, 이름:%s, 이메일:%s, 전화번호:%s\n",
				(i+1), strTokens[i*6+1], strTokens[i*6+3], newTelnum 
			);
		}
		
		
		
	} // main

} // class
























