/**
* File: Lab11_Prob3.java
* Class: CSCI 1302
* Author: Patricia Velasquez
* Created on: Nov 11, 2026
* Last Modified: Nov 11, 2026
* Description: This will use the code from problem 2 and will be modified to change the objects 
* instances to a binary file instead of string data 
* LINK TO GITHUB: https://github.com/PatVel93/Lab11CSCI1302.git
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Lab11Prob03 {
	public static void main(String[] args) {
		ArrayList<Person> people = new ArrayList<>();

		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"))) {
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String addr = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				people.add(new Person(age, name, addr, zipCode, salary));
			}
		} catch (EOFException e) {
			System.out.flush(); // normal end of file
		} catch (IOException e) {
			e.printStackTrace();
		}

		Collections.sort(people);

		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-sorted.dat"))) {
			for (Person p : people) {
				output.writeUTF(p.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// UPDATED CODE: this will make the objects print out on a binary output file 
		try (ObjectOutputStream objOut = new ObjectOutputStream(
				new FileOutputStream("src/people-salary-sorted-objects.dat"))) {//file to print to 
			for (Person p : people) {//print onto output file 
				objOut.writeObject(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
