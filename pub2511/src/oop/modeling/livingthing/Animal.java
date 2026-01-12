package oop.modeling.livingthing;

// 동물
public abstract class Animal extends LivingThing 
	implements Sleep, Eat {
	
	public Animal(String name, int age) {
		super(name, age);
	}
	
	@Override
	public void sleep() {
		System.out.println(getName() + " 잠을 잔다!");
	}
	
	@Override
	public void eat() {
		System.out.println(getName() + " 먹는다!");
	}

}
