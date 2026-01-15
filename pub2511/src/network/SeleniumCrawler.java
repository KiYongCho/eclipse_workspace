/*
	[Selenium 라이브러리 : 동적 웹페이지 크롤링 라이브러리]
	  1. zip파일 다운로드 > 압축 해체 > jar들을 추출
	     (https://www.selenium.dev/downloads/)
	  2. build path에 jar들을 추가
	  3. Chrome Driver 다운로드 및 복사
	      (https://storage.googleapis.com/chrome-for-testing-public/143.0.7499.192/win64/chromedriver-win64.zip)
	      > 압축 해제 > D:/pub2511/driver/chromedriver.exe 복사
*/

package network;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumCrawler {
	
	public static void main(String[] args) {
		
		// 크롬드라이버 경로 설정
		System.setProperty("webdriver.chrome.driver", "D:/pub2511/driver/chromedriver.exe");
		
		// 크롬드라이버 객체 생성
		WebDriver driver = new ChromeDriver();
		
		try {
			
			// GET 요청
			driver.get("https://pixabay.com/photos/");
			
			// 접속하는 시간동안 잠시 대기
			Thread.sleep(2000); // 2초
			
			// img 요소들
			List<WebElement> imageElements
				= driver.findElements(By.cssSelector("img"));
			
			System.out.println("이미지 개수 : " + imageElements.size());
			
			// img 요소의 src 속성값 출력
			for (WebElement image : imageElements) {
				String src = image.getAttribute("src");
				if (src!=null && !src.isEmpty()) {
					System.out.println("이미지 경로명 : " + src);
				}
			}
			
			// 실습
			// 가져온 이미지파일 경로들을 이용해서
			// D://pub2511/files/pixbayimages 폴더에 이미지파일들을 저장
			
			new File("D:/pub2511/files/pixabayimages/").mkdirs();
			
			// img파일을 로컬 저장
			for (WebElement image : imageElements) {
				String src = image.getAttribute("src");
				if (src!=null && !src.isEmpty()) {
					saveImage(src);
					Thread.sleep((int)(Math.random()*1001) + 500); // 0.5초 ~ 1.5초
				}
			}			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit(); // 드라이버 종료
		}
		
	} // main
	
	// 이미지파일 저장 메소드
	private static void saveImage(String imagePath) throws Exception {
		
		String imageFileName 
			= imagePath.substring(imagePath.lastIndexOf('/') + 1);
		
		if (imageFileName.endsWith("jpg") 
				|| imageFileName.endsWith("jpeg")
				|| imageFileName.endsWith("png")
				|| imageFileName.endsWith("gif")
				|| imageFileName.endsWith("svg")) {
			
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
								new File("D:/pub2511/files/pixabayimages/" + imageFileName)
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

} // class































