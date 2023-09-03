<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%    HttpSession s=request.getSession(false);
      s.invalidate();
      response.sendRedirect("index.html");

%>