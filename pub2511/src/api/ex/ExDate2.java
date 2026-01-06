package api.ex;

import java.util.Calendar;
import java.util.Scanner;

// Hint
// 1. 입력받은 월의 1일은 무슨 요일인가?
// 2. 입력받은 월의 마지막날은 몇일인가?

public class ExDate2 {
	
	public static void main(String[] args) {
		
		System.out.println("달력을 표시할 년월 6자리를 입력해 주세요! 예) 202601");
		
		Scanner scanner = new Scanner(System.in);
		
		String yearMonth = scanner.nextLine();
		
		// 입력받은 년월의 1일로 설정
		Calendar cal = Calendar.getInstance();
		cal.set(
			Integer.parseInt(yearMonth.substring(0, 4)),		// 입력받은 년도 4자리 숫자
			Integer.parseInt(yearMonth.substring(4, 6)) - 1,  // 입력받은 월 2자리 숫자
			1 // 1일
		);
		
		// 1일의 요일 (1:일, 2:월, 3:화 ...)
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		
		// 월의 마지막 날자
		int lastDayOfMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		// 출력
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		// 요일값-1만큼 탭 만들기
		for (int i=1; i<dayOfWeek; i++) System.out.print("\t");
		
		// 날짜
		for (int i=1; i<=lastDayOfMonth; i++) {
			System.out.print(i + "\t");
			if ((dayOfWeek+(i-1))%7 == 0) System.out.println(); // 7개마다 줄바꿈
		}
		
		scanner.close();
		
	}

}





































