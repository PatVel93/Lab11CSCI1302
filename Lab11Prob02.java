/**
* File: Lab11_Problem1.java
* Class: CSCI 1302
* Author: Patricia Velasquez
* Created on: Nov 11, 2026
* Last Modified: Nov 11, 2026
* Description: This will create an array using the info for the input file 
* this data will then be stored in a person object using the person class which will 
* be store in the array found in this class. 
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob02 {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();
		
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"))) {
			while (true) {//allows for looping through each line of the file 
				int age = input.readInt();
				String name = input.readUTF();
				String addr = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				people.add(new Person(age, name, addr, zipCode, salary));
			}//this will call the person call using the inputs found in the file 
		} catch (EOFException e) {
			System.out.flush(); // normal end of file
		} catch (IOException e) {
			e.printStackTrace();
		}
		//shortcut to sort through the list 
		Collections.sort(people);

		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {
			for (Person p : people) {//print out all of the person objects created
				output.writeUTF(p.toString());
				System.out.println(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}