package com.student.dao;

import java.util.List;

import com.student.dto.Student;

public interface StudentSDAO {
	public boolean insertStudent(Student s);
	public boolean updateStudent(Student s);
	public boolean deleteStudent(Student s);
	public Student getStudent(String mail,String pass);
	public Student getStudent(Long phone,String mail);
	public List<Student> getStudent();
	public boolean UpdateData (Student s);

}
