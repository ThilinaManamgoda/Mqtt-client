package com.maanadev.mqttclient.examples;

public class Person {

	private String name;
	private int age;
	private int height;
	public Person() {
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
	public int getHeigth() {
		return height;
	}
	public void setHeigth(int heigth) {
		this.height = heigth;
	}
	@Override
	public String toString() {
		String string= "Person's name is "+name+" and "+age+" old and"+height+" feet tall";
		return string;
	}
	
}
