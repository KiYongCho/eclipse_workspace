package exception;

// RuntimeException을 상속받은 사용자 정의 예외클래스
public class Under15Exception extends RuntimeException {
	
	@Override
	public String toString() {
		return "15세 이하 관람불가!";
	}
	
	@Override
	public String getMessage() {
		return "15세 이하 관람불가!";
	}

}

























