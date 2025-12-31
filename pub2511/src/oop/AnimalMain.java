package oop;

public class AnimalMain {
	
	public static void main(String[] args) {
		
		// 실습 : 강아지를 한마리 만들어서 소리를 내봅니다.
		Animal dog = new Dog();
		dog.sound();
		
		// 실습 : 고양이를 한마리 만들어서 소리를 내봅니다.
		Animal cat = new Cat();
		cat.sound();
		
		// 실습 : 파리를 한마리 만들어서 윙윙 소리를 내봅니다.
		//         파리는 혐오동물이므로 한마리만 만듭니다.
		//         그래서 별도의 클래스로 만들지 않습니다.
		
		// Animal 추상클래스를 상속받아서 sound메소드를
		// 오버라이딩하는 익명이너클래스의 객체를 생성
		Animal fly = new Animal() {
			@Override
			public void sound() {
				System.out.println("파리는 윙윙 소리를 냅니다!");
			}
		};
		fly.sound();
		
		// 실습 : 상어를 만들어서 소리를 내봅니다.
		Animal shark = new Animal() {
			@Override
			public void sound() {
				System.out.println("상어는 뚜루뚜뚜루 소리를 냅니다!");
			}
		};
		shark.sound();
		
	}

}


































