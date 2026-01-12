package oop.modeling.livingthing;

public class Human extends Animal 
	implements Carnivore, Herbivore {
	
	public Human(String name, int age) {
		super(name, age);
	}	
	
	@Override
	public void carnivore() {
		System.out.println(getName() + " 고기를 먹는다!");
	}
	
	@Override
	public void herbivore() {
		System.out.println(getName() + " 풀을 먹는다!");
	}

}
