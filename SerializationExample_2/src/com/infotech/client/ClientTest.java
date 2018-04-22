package com.infotech.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.infotech.model.Employee;

public class ClientTest {

	public static void main(String[] args) {

		String fileName = "employee.ser";
		serializeObject(fileName);
		deserializeObject(fileName);
		
	}

	private static void deserializeObject(String fileName) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File(fileName)))) {
			System.out.println("Object is deserialized..");
			Object object = ois.readObject();
			Employee employee=(Employee)object;
			System.out.println("ID:"+employee.getId());
			System.out.println("Name:"+employee.getName());
			System.out.println("Age:"+employee.getAge());
			System.out.println("Email:"+employee.getEmail());
			System.out.println("Password:"+employee.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void serializeObject(String fileName) {
		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("KK");
		employee.setAge(30);
		
		employee.setEmail("kishan.javatrainer@gmail.com");
		employee.setPassword("pass@123");

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fileName)))) {
			oos.writeObject(employee);
			System.out.println("Object is serialized..");
			System.out.println("-------------------------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
