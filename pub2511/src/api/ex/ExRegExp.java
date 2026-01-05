package api.ex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExRegExp {
	
	public static void main(String[] args) {
		
		// 정규표현식 실습 1
		// 아래 문자열에서 숫자만 남겨서 출력
		String rstr1 = "전화: 010-1234-5678";
		System.out.println(rstr1.replaceAll("[^\\d]", ""));
		
		// 정규표현식 실습 2
		// 아래 문자열을 공백 기준으로 단어들을 분리해서 출력
		String rstr2 = "Java is powerful and simple";
		
		// 정규표현식 실습 3 (Pattern 사용)
		// 아래 문자열이 Java라는 단어를 포함하고 있는지 출력
		String rstr3 = "I love Java Programming";
		Pattern pattern3 = Pattern.compile("Java");
		Matcher matcher3 = pattern3.matcher(rstr3);
		System.out.println(matcher3.find() ? "포함" : "미포함");
		
		// 정규표현식 실습 4
		// 아래 문자열에서 소문자만 제거 후 출력
		String rstr4 = "Java123abcDEF";
		
		// 정규표현식 실습 5
		// 아래 문자열이 휴대폰 번호 형식이 맞는지 확인 후 출력
		String rstr5 = "010-1234-5678";
		
		// 정규표현식 실습 6
		// 아래 문자열에서 HTML 태그를 제거 후 출력
		String rstr6 = "<p>Hello<br><b>World</b>";
		
		// 정규표현식 실습 7
		// 아래 문자열에서 여러개의 공백을 하나로 변경 후 출력
		String rstr7 = "Java      is      easy";
		
		// 정규표현식 실습 8
		// 아래 배열의 문자열들에 모두 매칭되는 전화번호 정규표현식 패턴만들기
		// 전화번호 : 숫자2개나3개-숫자3개나4개-숫자4개
		String[] telArr = {
				"02-123-4567",
				"031-123-4567",
				"02-1234-5678",
				"031-1234-5678"
		};
		
		// 정규표현식 실습 9
		// 아래 배열의 문자열들에 모두 매칭되는 주민등록번호 정규표현식 패턴만들기
		// 주민등록번호 : 년도2자리월2자리일2자리-남녀구분1자리숫자6자리
		// 년도:00~99, 월:01~12, 일:01~31, 남녀구분:1~4중하나
		String[] ssnArr = {
				"100101-3234567",
				"001231-4234567",
				"900101-1234567",
				"800101-2234567",
				"701301-1234567",
				"601201-5234567"
		};
		
		// 정규표현식 실습 10
		// 아래 문자열의 다양한 날짜 형식들을 "YYYY-MM-DD" 형식으로 출력
		String rstr10 = "오늘은 2025-06-13이고, 작년엔 2024.06.12에 회의를 했고, 다음 회의는 2025/06/15입니다.";
		
	} // main

} // class






















