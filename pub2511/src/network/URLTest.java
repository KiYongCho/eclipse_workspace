package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
	
	public static void main(String[] args) {
		
		URI uri = null; // 전체 주소
		URL url = null; // 전체 주소 중 경로(path)까지
		URLConnection conn = null; // 연결
		InputStream is = null; // 바이너리 데이터를 읽어들이는 스트림
		InputStreamReader isr = null; // 바이너리 데이터를 문자 데이터로 변경하는 스트림
		BufferedReader br = null; // 문자 데이터를 버퍼링하는 입력스트림
		BufferedWriter bw = null; // 문자 데이터를 버퍼링하는 출력스트림
		
		try {
			
			// 1. URI 객체 생성
			uri = new URI("https://www.naver.com");
			
			// 2. URL 객체 생성
			url = uri.toURL();
			
			// 3. URLConnection 객체 생성
			conn = url.openConnection();
			
			if (conn != null) { // 연결 되었다면
				is = conn.getInputStream(); // 연결을 통해 바이너리 데이터를 읽는 스트림
				isr = new InputStreamReader(is); // 바이너리 데이터를 문자 데이터로 변환하는 스트림
				br = new BufferedReader(isr); // 문자 데이터를 버퍼링하는 스트림
				String html = ""; // 읽어들인 문자열 전체를 저장할 변수
				String lineStr = ""; // 읽어들인 한 줄의 문자열을 저장할 변수
				while ((lineStr=br.readLine()) != null) { // 읽어들인 한 줄의 문자열이 있는동안 반복
					html += lineStr;
				}
				
				// 화면에 출력
				System.out.println(html);
				
				// 파일에 저장
				File file = new File("D:/pub2511/files/naversrc.html");
				// 파일에 문자들을 버퍼링해서 출력하는 스트림
				bw = new BufferedWriter(new FileWriter(file));
				bw.write(html);
				bw.flush();
				
			}
			
		} catch (URISyntaxException urise) { // URI 문법 예외
			urise.printStackTrace();
		} catch (MalformedURLException murle) { // URL 형식 예외
			murle.printStackTrace();
		} catch (IOException ioe) { // IO 예외
			ioe.printStackTrace();
		} finally {
			try {
				bw.close();
				br.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		
	} // main

} // class




















































