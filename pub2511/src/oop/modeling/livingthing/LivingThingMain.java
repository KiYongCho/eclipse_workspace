package oop.modeling.livingthing;

public class LivingThingMain {
	
	public static void main(String[] args) {
		
		LivingThing tiger = new Tiger("호돌이", 10);
		LivingThing lion = new Lion("심바", 2);
		LivingThing cow = new Cow("원앙소", 5);
		LivingThing deer = new Deer("꽃사슴", 7);
		LivingThing human = new Human("홍길동", 20);
		print(tiger);
		print(lion);
		print(cow);
		print(deer);
		print(human);		
		
	} // main
	
	private static void print(LivingThing lt) {
		lt.breathe();
		if (lt instanceof Animal) {
			((Animal)lt).sleep();
			((Animal)lt).eat();
		}
	}

} // class











































