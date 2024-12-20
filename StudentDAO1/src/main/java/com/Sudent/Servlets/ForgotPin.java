package com.Sudent.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.student.dao.StudentSDAO;
import com.student.dao.StudentDAOImp;
import com.student.dto.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ForgotPin")
public class ForgotPin extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Collect the data from users
		
		String phonenumber = req.getParameter("phone");
		String mailid = req.getParameter("mail");
		String Pass = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm");
		
		//conversion of datatypes
		long phone = Long.parseLong(phonenumber);
		PrintWriter out=resp.getWriter();
		
		//JDBC Implemetation
		StudentSDAO sd=new StudentDAOImp();
		Student s=sd.getStudent(phone,mailid);
		if(s!=null&&Pass.equals(confirmPassword)) {
			s.setPhoneno(phone);
			s.setMailid(mailid);
			s.setPassword(confirmPassword);
			boolean result=sd.updateStudent(s);
			if(result) {
				req.setAttribute("success", "ForgotPin successful");
				RequestDispatcher rd = req.getRequestDispatcher("ForgotPin.jsp");
				rd.forward(req, resp);
				//s=sd.getStudent(mailid, confirmPassword);
				//out.println("<h1>Password updated successfully</h1>");
			
		}
	else {
		req.setAttribute("failure", "Failure to Login");
		RequestDispatcher rd = req.getRequestDispatcher("ForgotPin.jsp");
		rd.forward(req, resp);
			
			//out.println("<h1> Failed to update the password</h1>");
		}
		}
	}
}