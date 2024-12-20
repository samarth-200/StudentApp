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
import jakarta.servlet.http.HttpSession; 
@WebServlet("/Login") 
public class Login extends HttpServlet{ 

 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
   
	 
  HttpSession session=req.getSession();
  //collect the data from the user  
  String mail=req.getParameter("mail"); 
  String password=req.getParameter("password"); 
//  PrintWriter out=resp.getWriter(); 
   
  //jdbc implementation 
  StudentSDAO sdao=new StudentDAOImp(); 
  Student s=sdao.getStudent(mail, password); 
  if(s!=null) 
  { 
	    session.setAttribute("Student", s);
		RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
		rd.forward(req, resp);
   //out.println("<h1>Login successful, Welcome "+s.getName()+"</h1>"  + "<br>"  + "<a href=\"login.html\">Back</a>"); 
  } 
  else 
  { 
	    req.setAttribute("failure", "Failure to Login");
		RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
		rd.forward(req, resp);
   //out.println("<h1>Invalid mail or password!</h1>" + "<br>" + "<a href=\"Login.html\">Back</a>"); 
}   
} 
}