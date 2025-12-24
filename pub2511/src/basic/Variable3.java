/*
	Access Modifier (접근지정자=접근제한자=접근한정자)
	  - 클래스, 생성자, 멤버변수, 메소드에 대한 접근 범위를 지정
	  - public : 모든 패키지의 모든 클래스에서 접근 가능
	  - protected : 동일 패키지내의 클래스나 다른 패키지더라도 상속관계의 클래스에서 접근 가능
	  - (default) : 동일 패키지내의 클래스에서 접근 가능
	  - private : 클래스 내에서만 접근 가능
	  - 접근 범위 : public > protected > (default) > private 
*/

package basic;

public class Variable3 {

	public int pubi = 1;
	protected int proi = 2;
	int di = 3;
	private int prii = 4;

} // class
































