package com.Sudent.Servlets;



import java.io.IOException;

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

@WebServlet("/delete")
public class Delete extends HttpServlet{
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    String sid=req.getParameter("id");
    String email=req.getParameter("mail");
    int id=Integer.parseInt(sid);
    Student s=new Student();
    StudentSDAO sd=new StudentDAOImp();
    HttpSession session=req.getSession(false);
    if(email!=null) {
      s.setId(id);
      s.setMailid(email);
      boolean result=sd.deleteStudent(s);
      if(id!=1) {      
        req.setAttribute("delete", "admin can not be deleted");
        RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
        rd.forward(req, resp);
      } else {
        if(result) {
          req.setAttribute("keyall",sd.getStudent());
          req.setAttribute("delete", "delete successfull");
          RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
          rd.forward(req, resp);
        }else {
          req.setAttribute("delete", "delete unsuccessful");
          RequestDispatcher rd=req.getRequestDispatcher("viewUsers.jsp");
          rd.forward(req, resp);
        }
      }
    }
  }
}