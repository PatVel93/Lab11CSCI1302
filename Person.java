/**
* File: Person.java
* Class: CSCI 1302
* Author: Patricia Velasquez
* Created on: Nov 11, 2026
* Last Modified: Nov 11, 2026
* Description: This program will take the data info from the input file and store them into 
* person object which will then be used in Lab11_Prob02
*/
import java.text.NumberFormat;
import java.util.Locale;

public class Person implements Comparable<Person> {
	//private to avoid changes made to values
	private int age;
	private String name;
	private String address;
	private int zipCode;
	private double salary;

	public Person() {
		//this(0, "", "", 0, 0.0); this isnt necessary..
	}

	public Person(int age, String name, String address, int zipCode, double salary) {
		this.age = age;
		this.name = name;
		this.address = address;
		this.zipCode = zipCode;
		this.salary = salary;
	}
//getters and setters 
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public int compareTo(Person other) {
		return Double.compare(other.salary, this.salary);
	}

	@Override
	public String toString() {//use currency shortcut 
		NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
		return age + " " + name + " " + address + " " + zipCode + " " + money.format(salary);
	}
}
