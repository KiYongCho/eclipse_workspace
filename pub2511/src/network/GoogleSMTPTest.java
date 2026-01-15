/*
	Google에서 제공하는 무료SMTP(Simple Mail Transfer Protocol)서버를
	이용해서 이메일 보내기
	1. jakarta.mail(메일발송), jakarta.activation(메일계정인증),
	   angus-mail(메일구현체) 라이브러리 필요
	   (mvnrepository.com에서 다운로드해서 빌드패스에 추가)
    2. Google SMTP 사용 설정
      1) 2단계 인증 설정
        Google 로그인 > 계정아이콘 클릭 > Google 계정 관리 > 보안 및 로그인 > 2단계 인증
      2) 앱비밀번호 생성
        앱 비밀번호 생성 후 저장
*/

package network;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class GoogleSMTPTest {
	
	public static void main(String[] args) {
		
		String username = "realchoky@gmail.com"; // 구글 계정 이메일
		String password = "wler afcl vmmg dqnf"; // 앱 비밀번호
		
		// SMTP 서버 설정
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true"); // SMTP서버 인증 여부
		props.put("mail.smtp.starttls.enable", "true"); // TLS서비스 사용 여부
		props.put("mail.smtp.host", "smtp.gmail.com"); // SMTP 서버 호스트명
		props.put("mail.smtp.port", "587"); // SMTP 서버 포트번호
		
		// 메일세션(연결)
		Session session = Session.getInstance(props, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			
			// 이메일 메세지
			Message message = new MimeMessage(session);
			
			// 발신자 이메일 주소
			message.setFrom(new InternetAddress("realchoky@gmail.com"));
			
			// 수신자 이메일 주소
			message.setRecipient(
				Message.RecipientType.TO,
				InternetAddress.parse("realchoky@naver.com")[0]
			);
			
			// 이메일 제목
			message.setSubject("Google SMTP 테스트 메일");
			
			// 이메일 내용
			message.setText("안녕하세요~ Google SMTP서버에서 보내는 테스트 메일입니다!");
			
			// 이메일 발송
			Transport.send(message);
			
			System.out.println("이메일 발송 완료!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
		
	} // main

} // class



























