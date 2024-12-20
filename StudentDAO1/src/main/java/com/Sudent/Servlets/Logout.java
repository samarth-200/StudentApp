package com.Sudent.Servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String logs=req.getParameter("val");
    HttpSession session=req.getSession(false);
    while(logs.equals("Logout")) {
      session.invalidate();
      req.setAttribute("success", "Logout Successful");
      RequestDispatcher rd=req.getRequestDispatcher("Login.jsp");
      rd.forward(req, resp);
    }
  }
}