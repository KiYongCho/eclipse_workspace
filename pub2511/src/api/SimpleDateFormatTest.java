package api;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTest {
	
	public static void main(String[] args) {
		
		// 날짜/시간 표시 형식 생성
		SimpleDateFormat sdf 
			= new SimpleDateFormat("yyyy년 MM월 dd일 a HH시 mm분 ss초");
		
		// 현재 날짜/시간을 형식화한 문자열 생성
		String dateStr = sdf.format(new Date());
		
		System.out.println(dateStr);
		
	}

}


























