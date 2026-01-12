package oop.modeling.livingthing;

public class Lion extends Animal 
	implements Carnivore {
	
	public Lion(String name, int age) {
		super(name, age);
	}	
	
	@Override
	public void carnivore() {
		System.out.println(getName() + " 고기를 먹는다!");
	}	

}
