//Kana Kihara
//Student.java

import java.util.*;
import java.io.*;

public class Student{
	private int id;
	private String fName;
	private String lName;
	private String school;

	/* Constructor that initializes the three instance variables */
	public Student(int id, String fName, String lName, String school){
		this.id = id; //assign id to instance variable id
		this.fName = fName;
		this.lName = lName;
		this.school = school;
	}

	public int getId() {
		return id;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getSchool(){
		return school;
	}

	public String toString(){
		return String.format("%d\t%s %s\n", getId(), getfName(), getlName());
	}

}






















