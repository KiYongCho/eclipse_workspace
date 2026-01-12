package oop.modeling.livingthing;

public class Deer extends Animal 
	implements Herbivore {
	
	public Deer(String name, int age) {
		super(name, age);
	}	
	
	@Override
	public void herbivore() {
		System.out.println(getName() + " 풀을 먹는다!");
	}	

}
