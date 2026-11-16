/**
* File: Lab11_Problem1.java
* Class: CSCI 1302
* Author: Patricia Velasquez
* Created on: Nov 11, 2026
* Last Modified: Nov 11, 2026
* Description: This program will read an input file and then print out data
*  into a newly created output file. 
*/
import java.io.*;

public class Lab11Prob01 {
	public static void main(String[] args) {
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
		     DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"))) {
			while (true) {
				int age = input.readInt();
				String name = input.readUTF();
				String addr = input.readUTF();
				int zipCode = input.readInt();
				double salary = input.readDouble();

				System.out.println(String.format("%d %s %s %d %.2f",
						age, name, addr, zipCode, salary));

				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(addr);
				output.writeInt(zipCode);
				output.writeDouble(salary);
			}
		} catch (EOFException e) {
			System.out.flush(); // normal end of file
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}