import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getname=req.getParameter("signupname");      
		String getEmail=req.getParameter("signupemail");     
		String getpassword=req.getParameter("signuppassword");      
		boolean checkEmail=Validate.emailValidate(getEmail);
		boolean checkPassword=Validate.passwordValidate(getpassword);
		  int flag=0;
		if(checkEmail==false) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("Invalid_Email.html");
			dispatcher.forward(req, resp);
			flag=1;
			
		}
		if(checkPassword==false) {
			RequestDispatcher dispatcher=req.getRequestDispatcher("Invalid_password.html");
			dispatcher.forward(req, resp);
			flag=1;
		}
		if(flag==0) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qnotes";
            String usernameString="root";
            String passwordString="Root@123";	
           Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
           Statement statement=connection.createStatement();
           String signupQuery=Query.signUpQuery(getname, getEmail, getpassword);
			statement.execute(signupQuery);
			resp.sendRedirect("index.html");
		}catch (Exception e) {

			resp.sendRedirect("DuplicateEntry.html");
		}
		
		}
		
		
		
		
		
		
		
		
	}
	
	
	

}
