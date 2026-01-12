package io;

import java.io.Serializable;

public class Dog extends Animal {

	private static final long serialVersionUID = 3298483943294398L;

	private String sound;

	public Dog() {
	}

	public Dog(String name, int legCount, String sound) {
		super(name, legCount);
		this.sound = sound;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	@Override
	public String toString() {
		return super.toString() + " Dog [sound=" + sound + "]";
	}

}










