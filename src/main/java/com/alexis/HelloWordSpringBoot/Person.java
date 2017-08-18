package com.alexis.HelloWordSpringBoot;

import java.util.Date;

public class Person {
	
	private long id;
	private String name;
	private String lastName;
	private String sex;
	
	public Person() {}
	
	public Person(String name,String lastname,String sex) {
		this.id = (new Date()).getTime();
		this.name = name;
		this.lastName = lastname;
		this.sex = sex;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		String person ="Student{" + "id=" + id + ", name='" + name + '\'' 
				+ ", lastName='" + lastName + '\'' + ", sex='" + sex + '\'' +'}';
		
		return person;
	}
	
	
}
