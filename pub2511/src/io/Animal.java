package io;

import java.io.Serializable;

public class Animal implements Serializable {
	
	private static final long serialVersionUID = 32948723948394L;
	
	private String name;
	private int legCount;
	
	public Animal() {
	}

	public Animal(String name, int legCount) {
		super();
		this.name = name;
		this.legCount = legCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLegCount() {
		return legCount;
	}

	public void setLegCount(int legCount) {
		this.legCount = legCount;
	}

	@Override
	public String toString() {
		return "Animal [name=" + name + ", legCount=" + legCount + "]";
	}
	
}


























