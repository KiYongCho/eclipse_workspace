// 네이버 뉴스여행/레저 뉴스 제목 크롤링
// https://news.naver.com/breakingnews/section/103/237

package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URLConnection;

public class CrawlingTest1 {
	
	public static void main(String[] args) {
		
		URLConnection conn = null;
		BufferedReader br = null;
		
		try {
			
			conn = new URI("https://news.naver.com/breakingnews/section/103/237")
					.toURL().openConnection();
			
			if (conn != null) {
				
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				/*
					<strong class="sa_text_strong">미 정부 “외국인은 입장료 100달러 더 내”…올해부터 추가 요금 부과 미국 국립공원 11곳 어디?(리스트)</strong>
					startIdx에 있는 글자 => 미
					endIdx에 있는 글자 => <
				*/
				
				String lineStr = "";
				String startStr = "<strong class=\"sa_text_strong\">";
				String endStr = "</strong>";
				
				while ((lineStr=br.readLine()) != null) {
					String subject = ""; // 제목 저장할 변수
					if (lineStr.trim().startsWith(startStr)) { // startStr로 시작한다면
						// 제목의 첫번째 인덱스
						int startIdx = lineStr.indexOf(startStr) + startStr.length();
						// 제목의 마지막 인덱스 + 1
						int endIdx = lineStr.indexOf(endStr, startIdx);
						subject = lineStr.substring(startIdx, endIdx);
						System.out.println(subject);
					}
				}
				
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class







































