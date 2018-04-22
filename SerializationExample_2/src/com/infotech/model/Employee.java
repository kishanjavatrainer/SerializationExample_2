package com.infotech.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee extends Person implements Serializable {

	private static final long serialVersionUID = -4724957588046435474L;
	
	private String email;
	private String password;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private void writeObject(ObjectOutputStream oos) throws IOException {
		// calling default functionality for Employee fields
		oos.defaultWriteObject();
		
		// Explicitly writing Person fields
		oos.writeInt(getId());
		oos.writeObject(getName());
		oos.writeInt(getAge());
	}
	
	private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
		 // calling default functionality for Employee fields
		ois.defaultReadObject();
		
		// Explicitly reading Person fields and setting them
		setId(ois.readInt());
		setName((String)ois.readObject());
		setAge(ois.readInt());
	}
	@Override
	public String toString() {
		return "Employee [email=" + email + ", password=" + password + "]";
	}
}
