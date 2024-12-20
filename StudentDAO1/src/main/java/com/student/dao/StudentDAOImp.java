package com.student.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.student.connectors.ConnectionFactory;
import com.student.dto.Student;

public class StudentDAOImp implements StudentSDAO{

	private Connection con;
	
	public StudentDAOImp() {
		this.con=ConnectionFactory.Connectionrequest();
	}
	
	
	@Override
	public boolean insertStudent(Student s) {
		// inserting method implementation
		String query ="INSERT INTO STUDENT VALUE(0,?,?,?,?,?,?,SYSDATE())";
		PreparedStatement ps = null;
		int res = 0;
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, s.getName());
			ps.setLong(2, s.getPhoneno());
			ps.setString(3, s.getMailid());
			ps.setString(4, s.getBranch());
			ps.setString(5, s.getLocation());
			ps.setString(6, s.getPassword());
			res = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(res > 0) {
		return true;
	}else {
		return false;
	}
	}

	@Override
	public boolean updateStudent(Student s) {
		String query="UPDATE STUDENT SET PASSWORD=? WHERE PHONENO=? AND MAILID=? ";
		int res=0; 
		PreparedStatement ps=null;
		try {
            ps=con.prepareStatement(query);
            ps.setString(1, s.getPassword());
            ps.setLong(2,s.getPhoneno());
            ps.setString(3,s.getMailid());
            
            res=ps.executeUpdate();
            
		}catch(SQLException e) {
			e.printStackTrace(); 
		}
		if(res>0) 
		  { 
		   return true; 
		  } 
		  else {
			  return false;
		  }
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean deleteStudent(Student s) {
		String query="DELETE FROM STUDENT WHERE ID=?"; 
		  int res=0; 
		  PreparedStatement ps=null; 
		  try {
			ps=con.prepareStatement(query);
			ps.setInt(1,s.getId());
			res=ps.executeUpdate();
			
		  }
		  catch(SQLException e) {
			  e.printStackTrace();
			  
		  }
		  if(res>0) {
			  return true;
			  
		  }
		  else {
			  return false;
		  }
		  
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudent(String mail, String pass) {
		String query="SELECT * FROM STUDENT WHERE MAILID=? AND PASSWORD=?";
		Student s=null;
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			ps=con.prepareStatement(query);
			ps.setString(1,mail);
			ps.setString(2,pass);
			rs=ps.executeQuery();
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhoneno(rs.getLong("Phoneno"));
				s.setMailid(rs.getString("Mailid"));
				s.setBranch(rs.getString("Branch"));
				s.setLocation(rs.getString("Location"));
				s.setPassword(rs.getString("Password"));
				s.setDate(rs.getString("Date"));
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return s;
	}
	@Override
	public List<Student> getStudent() {
		ArrayList<Student>students=new ArrayList<Student>();
		Student s=null;
		String query="Select * from Student";
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("Name"));
				s.setPhoneno(rs.getLong("Phoneno"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("Location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
			    students.add(s);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return students;
	}


	@Override
	public Student getStudent(Long phone, String mail) {
		Student s=null;
		PreparedStatement ps =null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement("SELECT * FROM STUDENT WHERE PHONENO=? AND MAILID=?");
			ps.setLong(1, phone);
			ps.setString(2, mail);
			rs=ps.executeQuery();
			while(rs.next()) {
				s=new Student();
				
				//String name=rs.getString("name");
				//s.setName(name);
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setPhoneno(rs.getLong("phoneno"));
				s.setMailid(rs.getString("mailid"));
				s.setBranch(rs.getString("branch"));
				s.setLocation(rs.getString("location"));
				s.setPassword(rs.getString("password"));
				s.setDate(rs.getString("date"));
				
			}
		}catch( SQLException e) {
			e.printStackTrace();
		}
		return s;
	}


	@Override
	public boolean UpdateData(Student s) {
		PreparedStatement ps=null;
	    int res=0;
	    try {
	      ps=con.prepareStatement("UPDATE STUDENT SET NAME=?, PHONENO=?, MAILID=?, BRANCH=?, LOCATION=? WHERE Id=?");
	      ps.setString(1, s.getName());
	      ps.setLong(2, s.getPhoneno());
	      ps.setString(3, s.getMailid());
	      ps.setString(4, s.getBranch());
	      ps.setString(5, s.getLocation());
	      ps.setInt(6, s.getId());
	      
	      res=ps.executeUpdate();
	    }catch( SQLException e) {
	      e.printStackTrace();
	    }
	    if(res>0) {
	      return true;
	    }
	    
		// TODO Auto-generated method stub
		return false;
	}

}
