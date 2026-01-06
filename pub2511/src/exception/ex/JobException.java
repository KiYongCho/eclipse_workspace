package exception.ex;

public class JobException extends RuntimeException {
	
	@Override
	public String toString() {
		return "좋은 직업을 선택하세요!";
	}

}
