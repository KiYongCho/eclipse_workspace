package api.ex;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class ExDate1 {

	public static void main(String[] args) {

		printDate("한국 서울", TimeZone.getTimeZone("Asia/Seoul"));
		printDate("영국 런던", TimeZone.getTimeZone("Europe/London"));
		printDate("미국 LA", TimeZone.getTimeZone("America/Los_Angeles"));
		printDate("호주 시드니", TimeZone.getTimeZone("Australia/Sydney"));

	}

	public static void printDate(String name, TimeZone timeZone) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(
				" yyyy년 MM월 dd일 HH시 a mm분 ss초 입니다!"
		);
		sdf.setTimeZone(timeZone);
		System.out.println(name + sdf.format(cal.getTime()));
	}

}
