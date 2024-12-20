package com.student.main;


import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.student.dao.StudentSDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

public class Test {
public static void main(String[] args) {
	Student s = new Student();
	StudentDAOImp DO  = new StudentDAOImp();
	Scanner sc = new Scanner(System.in);
	List<Student>students=DO.getStudent();
	Iterator<Student> it=students.iterator();
	while(it.hasNext()) {
		s=it.next();
		System.out.println(s);
	}
	
	
	//inserting the data
	System.out.println("Enter the name");
	s.setName(sc.next());
	System.out.println("Enter the phone number");
	s.setPhoneno(sc.nextLong());
	System.out.println("Enter the mail id");
	s.setMailid(sc.next());
	System.out.println("Enter the Branch");
	s.setBranch(sc.next());
	System.out.println("Enter the Location");
	s.setLocation(sc.next());
	System.out.println("Enter the password");
	String pass = sc.next();
	s.setPassword(pass);
	System.out.println("Enter the conform password");
	String conformpass = sc.next();
	
	
	if(pass.equals(conformpass)) {
		
		
	 boolean res = DO.insertStudent(s);
		if(res) {
			System.out.println("working is Successfully");
		}else {
			System.out.println("Your make mistake check again");
		}
	}
	System.out.println("Enter the phone no to be updated");
	s.setPhoneno(sc.nextLong());
	boolean res=DO.updateStudent(s);
	if(res) {
		System.out.println("phone no updated to "+s.getPhoneno()+"sucessfully");
	}
	else {
		System.out.println("failed to update");
	}
	
}
}