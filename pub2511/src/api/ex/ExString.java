package api.ex;

import java.util.StringTokenizer;

public class ExString {
	
	public static void main(String[] args) {
		
		// 실습 1
		// 문자열내 한글 개수 출력
		String str1 = "안녕하세요! Java 재밌나요?";
		int str1Leng = str1.length(); // 전체 문자 수
		int nkLeng = str1.replaceAll("[가-힣]", "").length(); // 한글이 아닌 문자 수
		System.out.println("한글 개수 : " + (str1Leng - nkLeng));
		
		// 실습 2
		// 홀수번째 인덱스에 있는 소문자들을 출력
		String str2 = "Hello! Java Programming!";
		int str2Leng = str2.length();
		for (int i=0; i<str2Leng; i++) {
			byte b = (byte)str2.charAt(i); // 각 문자의 byte
			if (i%2==1 && b>=97 && b<=122) { // 홀수, 아스키코드가 97에서 122
				System.out.println((char)b);
			}
		}
		
		// 실습 3
		// 문자열을 , 기준으로 분리하고 분리된 각 문자열과 문자열의 길이를 출력
		String str3 = "Apple,Banana,Orange,Grape";
		String[] str3Arr = str3.split(","); // ,를 기준으로 분리한 문자열 배열
		int str3ArrLeng = str3Arr.length;
		for (int i=0; i<str3ArrLeng; i++) {
			System.out.println(str3Arr[i] + ", " + str3Arr[i].length());
		}
		
		// 실습 4
		// 문자열내 단어의 수를 출력
		String str4 = "    Java is a powerful programming language   ";
		StringTokenizer st1 = new StringTokenizer(str4.trim());
		System.out.println(st1.countTokens());
		
		// 실습 5
		// 문자열내 중복문자는 한번만 출력
		String str5 = "This is Java Programming";
		StringBuilder sb5 = new StringBuilder();
		int str5Leng = str5.length();
		for (int i=0; i<str5Leng; i++) {
			char ch = str5.charAt(i); // 각 문자
			// StringBuilder가 각 문자를 포함하지 않으면
			if (!sb5.toString().contains(String.valueOf(ch))) {
				sb5.append(ch); // StringBuilder에 문자열을 추가
			}
		}
		System.out.println(sb5);
		
		// 실습 6
		// 주민등록번호 문자열에서 생년월일을 아래 형식으로 출력
		// 생년월일 : 1999년 1월 16일
		String str6 = "990116-1234567";
		String shortYear = str6.substring(0, 2); // 연도 2 자리
		String month = str6.substring(2, 4); // 월 2 자리
		String date = str6.substring(4, 6); // 일 2 자리
		System.out.printf(
			"생년월일 : 19%s년 %s월 %s일",
			shortYear, month.startsWith("0") ? month.charAt(1) : month, date					
		);
		
		// 실습 7
		// 문자열내 숫자들의 합을 출력
		String str7 = "Today is 12th event in 2025";
		int str7Leng = str7.length();
		int sum = 0 ;
		for (int i=0; i<str7Leng; i++) {
			byte b = (byte)str7.charAt(i); // 각 문자를 byte로
			if (b>=48 && b<=57) { // 아스키코드 숫자
				// 숫자인 문자를 정수로 변환해서 누적
				sum += Integer.parseInt(String.valueOf(str7.charAt(i)));
			}
		}
		System.out.println("\n합계 : " + sum);
		
		// 실습 8
		// 문자열내 a문자의 인덱스들을 출력
		String str8 = "Banana is a very delicious and amazing";
		int aIdx = 0;
		// a문자의 인덱스를 찾으면 그 다음 문자부터 다시 a문자의 인덱스를 찾음
		while ((aIdx=str8.indexOf('a', aIdx+1)) > -1) {
			System.out.println(aIdx);
		}
		
		// 실습 9
		// 문자열내 두번째 Java 문자열의 인덱스를 출력
		String str9 = "I love Java. I hate Java";
		int firstIdx = str9.indexOf("Java"); // 첫번째 Java 문자열 인덱스
		// 첫번째 Java가 나온 곳의 인덱스 다음부터 Java 인덱스 탐색
		System.out.println(str9.indexOf("Java", firstIdx+1));
		
		// 실습 10
		// 문자열에서 확장자를 추출하여 출력
		String str10 = "document.final.version.pdf";		
		int lastDotIdx = str10.lastIndexOf("."); // 마지막 . 문자열 인덱스
		System.out.println(str10.substring(lastDotIdx+1));
		
	}

}







