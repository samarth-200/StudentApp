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

@WebServlet("/Signup")

public class Signup extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//collect the data from user
		String name = req.getParameter("name");
		String phonenumber = req.getParameter("phone");
		String mailId = req.getParameter("mail");
		String branch = req.getParameter("branch");
		String loc = req.getParameter("loc");
		String password = req.getParameter("password");
		String confirmPassword = req.getParameter("confirm");
//converting the necessary datatypes
		long phone = Long.parseLong(phonenumber);
		PrintWriter out = resp.getWriter();
//JDBC Implementation
		Student s = new Student();
		StudentSDAO sdao = new StudentDAOImp();
		if (password.equals(confirmPassword)) {
			s.setName(name);
			s.setPhoneno(phone);
			s.setMailid(mailId);
			s.setBranch(branch);
			s.setLocation(loc);
			s.setPassword(password);
			boolean result = sdao.insertStudent(s);
			if (result) {
				//s = sdao.getStudent(mailId, confirmPassword);
				//out.println("<h1>Data added successfully. Your Student ID is " + s.getId() + "</h1>");
				req.setAttribute("success", "Signup successful");
				RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
			} else {
				req.setAttribute("failure", "Signup failed");
				RequestDispatcher rd = req.getRequestDispatcher("Signup.jsp");
				rd.forward(req, resp);
				//out.println("<h1>Failed to add the data</h1>");
			}
		}
	}
}