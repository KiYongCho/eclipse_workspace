package api;

import java.lang.reflect.Method;

public class ObjectTest {

	public static void main(String[] args) {
		
		Object obj = new Object();
		System.out.println(obj); // java.lang.Object@5ca881b5
		// = System.out.println(obj.toString());
		
		Object obj2 = new Object();
		System.out.println(obj2); // java.lang.Object@24d46ca6
		
		// obj와 obj2는 참조값이 다름 = 메모리 주소가 다름 = 다른 객체
		
		// equals는 두 객체의 참조값을 비교
		System.out.println(obj.equals(obj2)); // false
		
		// getClass는 객체를 통해 클래스의 정보를 획득 (Reflection)
		Class objClass = obj.getClass();
		System.out.println(objClass.getPackageName()); // java.lang
		System.out.println(objClass.getCanonicalName()); // java.lang.Object
		System.out.println(objClass.getName()); // java.lang.Object
		System.out.println(objClass.getSimpleName()); // Object
		System.out.println(objClass.getTypeName()); // java.lang.Object
		
		// 실습 : objClass의 메소드명들을 출력
		Method[] methods = objClass.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
		
		// hashCode : 참조값을 10진수 int 반환
		System.out.println(obj.hashCode()); // 1554547125
		System.out.println(obj2.hashCode()); // 617901222
		System.out.println(obj.hashCode()==obj2.hashCode()); // false
		
		// clone : 동일한 비트패턴을 가진(내용이 같은) 다른 객체를 생성
		// clone의 조건
		// 1. clone할 객체의 클래스는 Cloneable 인터페이스를 구현해야 함
		// 2. clone할 객체의 클래스는 Object의 clone메소드를 오버라이딩해야 함
		// 3. clone메소드를 호출할때는 CloneNotSupportedException을 처리해야 함
		// clone의 역할(목적)
		// 1. 객체가 가진 내용이 복제된 객체를 만듬
		// 2. new연산자로 생성해서 객체의 데이터를 설정하는 것보다 속도가 빠름
		
		Person orgPerson = new Person("홍길동", 20);
		try {
			Person clonePerson = (Person)orgPerson.clone();
			System.out.println(clonePerson.getName());
			System.out.println(clonePerson.getAge());
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		
	} // main
	
} // class



































