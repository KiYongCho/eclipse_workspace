package oop.modeling.livingthing;

// 생물
public abstract class LivingThing implements Breathe {

	private String name; // 이름
	private int age; // 나이

	public LivingThing() {
	}

	public LivingThing(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "생물 [이름: " + name + ", 나이: " + age + "]";
	}
	
	@Override
	public void breathe() {
		System.out.println(name + " 숨을 쉰다!");
	}

}











