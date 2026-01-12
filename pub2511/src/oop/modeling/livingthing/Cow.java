package oop.modeling.livingthing;

public class Cow extends Animal 
	implements Herbivore {
	
	public Cow(String name, int age) {
		super(name, age);
	}	
	
	@Override
	public void herbivore() {
		System.out.println(getName() + " 풀을 먹는다!");
	}

}
