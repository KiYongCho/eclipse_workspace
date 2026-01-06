package exception;

public class ExceptionMain3 {
	
	public static void main(String[] args) {
		
		// 10~29 임의의 정수
		int age = (int)(Math.random()*20) + 10;
		System.out.println("나이 : " + age);
		
		// 사용자 정의 예외클래스를 상황에 맞게 잘 만들어 두고
		// 상황이 되면 예외를 발생시켜서 처리하는 예외처리 프로그래밍 기법은
		// 코드 가독성과 논리적인 코드 구성에 유용한 도구!
		
		try {
			// 임의의 정수가 15보다 작으면 Under15Exception을 발생시킴
			if (age < 15) throw new Under15Exception();
			// 임의의 정수가 19보다 작으면 Under19Exception을 발생시킴
			else if (age < 19) throw new Under19Exception();
			else System.out.println("20세 이상이므로 통과!");
		} catch (Under15Exception u15e) {
			System.out.println(u15e);
		} catch (Under19Exception u19e) {
			System.out.println(u19e);
		}
		
		System.out.println("즐거운 관람되세요!");
		
	}

}





























