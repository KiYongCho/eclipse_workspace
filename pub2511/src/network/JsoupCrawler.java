package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URLConnection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
	[Jsoup 라이브러리 : 정적인 웹페이지 크롤링]
	- mvnrepository.com에서 jsoup.jar 다운로드 > 라이브러리에 추가
	- Java기반의 HTML파싱 및 웹크롤링 라이브러리
	- 웹페이지를 크롤링하고 DOM을 탐색 및 조작하는데 사용됨
	- Python BeautifulSoup 웹크롤링 라이브러리의 Java버젼
	- 주요 기능 : HTML파싱, DOM탐색/조작, 데이터 추출, GET/POST요청
*/

public class JsoupCrawler {
	
	public static void main(String[] args) {
		
		// HTML문자열
		String html = "<html><body><h1>제목</h1><p>내용</p></body></html>";
		
		// HTML문자열을 파싱해서 Document객체 생성
		Document doc = Jsoup.parse(html);
		
		Element h1 = doc.selectFirst("h1"); // 첫번째 h1 요소
		System.out.println("제목 : " + h1.text());
		
		Element p = doc.selectFirst("p"); // 첫번째 p 요소
		System.out.println("내용 : " + p.text());
		
		// 웹페이지 크롤링
		String url = "https://news.naver.com/breakingnews/section/103/237";
		
		try {
			
			// 크롤링 딜레이 간격
			int interval = (int)(Math.random()*1001) + 1500; // 0 ~ 2500
			
			Document docNews =
					// url 연결
					Jsoup.connect(url)
					// 웹브라우져에서 요청한 것처럼 속임 (요청헤더 설정)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
					// 요청간 딜레이 간격
					.timeout(interval)
					// GET 요청
					.get();
			
			// 선택자에 해당하는 요소들
			Elements titles = docNews.select("strong.sa_text_strong");
			for (Element title : titles) {
				System.out.println("제목 : " + title.text());
			}
			
			// 학원 웹사이트내의 이미지 가져오기
			String koreaUrl = "http://koreaitacademy.kr/curriculum/app/app.asp";
			
			// 크롤링 딜레이 간격
			int interval2 = (int)(Math.random()*1001) + 1500; // 0 ~ 2500
			
			Document docKorea =
					// url 연결
					Jsoup.connect(koreaUrl)
					// 웹브라우져에서 요청한 것처럼 속임 (요청헤더 설정)
					.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
					// 요청간 딜레이 간격
					.timeout(interval2)
					// GET 요청
					.get();
			
			Elements images = docKorea.select("img");
			for (Element image : images) {
				System.out.println("이미지경로명 : " + image.absUrl("src"));
			}
			
			// 이미지들을 D:/pub2511/files/koreaitimage 폴더에 저장
			
			new File("D:/pub2511/files/koreaitimage").mkdirs(); // 폴더 생성
			
			for (Element image : images) {
				saveImage(image.absUrl("src")); // 절대경로로 만들어서 saveImage 호출
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	} // main
	
	// 이미지파일 저장 메소드
	private static void saveImage(String imagePath) throws Exception {
		
		// http://koreaitacademy.kr/2023/img/mou-img005.jpg
		String imageFileName 
			= imagePath.substring(imagePath.lastIndexOf('/') + 1); // mou-img005.jpg
		
		if (imageFileName.endsWith("jpg") || imageFileName.endsWith("png")) {
			
			// 커넥션 획득
			URLConnection conn = new URI(imagePath).toURL().openConnection();
			if (conn!=null) {
				
				// 웹브라우져 인척~
				conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
				
				// 이미지의 byte들을 버퍼링해서 읽는 스트림
				BufferedInputStream bis
					= new BufferedInputStream(conn.getInputStream());
				
				// 파일에 byte들을 버퍼링해서 쓰는 스트림
				BufferedOutputStream bos
					= new BufferedOutputStream(
							new FileOutputStream(
								new File("D:/pub2511/files/koreaitimage/" + imageFileName)
							)
						);
				
				// byte 버퍼
				byte[] buffer = new byte[1024];
				
				// 읽은 바이트 수
				int readByteCount = 0 ;
				
				// 읽은 바이트가 있는 동안 읽고 쓰기
				while ((readByteCount=bis.read(buffer)) > -1) {
					bos.write(buffer, 0, readByteCount);
				}
				bos.flush();
				
				System.out.println(imageFileName + " 파일 생성됨!");
				
				bos.close();
				bis.close();
				
			}
		}
		
	} // saveImage

}









