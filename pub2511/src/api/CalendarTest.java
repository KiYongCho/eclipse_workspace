package api;

import java.util.Calendar;

public class CalendarTest {
	
	public static void main(String[] args) {
		
		// Calendar 객체 생성
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		/*
			java.util.GregorianCalendar
			[time=1767663467815,
			areFieldsSet=true,
			areAllFieldsSet=true,
			lenient=true,
			zone=sun.util.calendar.ZoneInfo[
				id="Asia/Seoul",offset=32400000,dstSavings=0,
				useDaylight=false,transitions=30,lastRule=null],
			firstDayOfWeek=1,
			minimalDaysInFirstWeek=1,
			ERA=1,
			YEAR=2026,
			MONTH=0,
			WEEK_OF_YEAR=2,
			WEEK_OF_MONTH=2,
			DAY_OF_MONTH=6,
			DAY_OF_YEAR=6,
			DAY_OF_WEEK=3,
			DAY_OF_WEEK_IN_MONTH=1,
			AM_PM=0,
			HOUR=10,
			HOUR_OF_DAY=10,
			MINUTE=37,
			SECOND=47,
			MILLISECOND=815,
			ZONE_OFFSET=32400000,
			DST_OFFSET=0]		
		*/
		
		// unix time = epoch time
		System.out.println(cal.getTimeInMillis()); // Calendar 클래스
		System.out.println(System.currentTimeMillis()); // System 클래스
		
		// TimeZone (시간대)
		System.out.println(cal.getTimeZone());
		
		// 현재 날짜/시간 정보
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // 월을 0부터 표시
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 한달에서 몇일
		System.out.println(cal.get(Calendar.HOUR_OF_DAY)); // 하루에서 몇시간
		System.out.println(cal.get(Calendar.MINUTE)); // 분
		System.out.println(cal.get(Calendar.SECOND)); // 초
		System.out.println(cal.get(Calendar.MILLISECOND)); // 밀리초
		
		// 특정 날짜/시간 설정
		cal.set(2026, Calendar.FEBRUARY, 10); // 2026년 2월 10일
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // 월을 0부터 표시
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 한달에서 몇일	
		
		// 날짜 양수 더하기 (이후 시간)
		cal.add(Calendar.YEAR, 3); // 3년 후
		cal.add(Calendar.MONTH, 3); // 3개월 후
		cal.add(Calendar.DAY_OF_MONTH, 7); // 7일 후
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // 월을 0부터 표시
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 한달에서 몇일
		
		// 날짜 음수 더하기 (이전 시간)
		cal.add(Calendar.YEAR, -3); // 3년 전
		cal.add(Calendar.MONTH, -3); // 3개월 전
		cal.add(Calendar.DAY_OF_MONTH, -7); // 7일 전
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1); // 월을 0부터 표시
		System.out.println(cal.get(Calendar.DAY_OF_MONTH)); // 한달에서 몇일		
		
	} // main

} // class





























