package com.Sudent.Servlets;

import java.io.IOException;

import com.student.dto.Student;
import com.student.dao.StudentSDAO;
import com.student.dao.StudentDAOImp;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/update")
public class Update extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    //Creating session object
    HttpSession session=req.getSession(false);
    Student s=(Student)session.getAttribute("Student");
    
    //Collect the data from users
    String name=req.getParameter("name");
    String phonenumber = req.getParameter("phoneno");
    String mailid = req.getParameter("mailid");
    String branch=req.getParameter("branch");
    String location=req.getParameter("location");
    
    long phone = Long.parseLong(phonenumber);

  
    StudentSDAO sd=new StudentDAOImp();
    
    if(s!=null) {
      s.setName(name);
      s.setPhoneno(phone);
      s.setMailid(mailid);
      s.setBranch(branch);
      s.setLocation(location);
    
      boolean result=sd.UpdateData(s);
      
      if(result) {
            
        req.setAttribute("success", "Updated Successful");
        RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
        rd.forward(req, resp);
      } else {
        req.setAttribute("failure", "Update Failed");
        RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
        rd.forward(req, resp);
      }
    }else {
      req.setAttribute("failure", "give proper data");
      RequestDispatcher rd=req.getRequestDispatcher("Update.jsp");
      rd.forward(req, resp);
    }

  }

}
