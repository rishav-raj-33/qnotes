import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/feedback")
public class FeedBackServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		boolean check=Validate.emailValidate(email);
		int logic=0;   // if mobile or email is wrong.
		if(check==false) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Invalid_Email.html");
			requestDispatcher.forward(req, resp);
			logic=1;
		}
		String mobileno=req.getParameter("phoneNumber");
		boolean mobileCheck=Validate.mobileValidate(mobileno);   
		if(mobileCheck==false) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("Invalid_Mobile_No.html");
			requestDispatcher.forward(req, resp);
			logic=1;
			
		}
		String message=req.getParameter("message");
		if(logic==0) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qnotes";
            String usernameString="root";
            String passwordString="Root@123";	
           Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
           Statement statement=connection.createStatement();
           String getQuery=Query.insertIntoFeedback(email, mobileno, message, name);
           statement.execute(getQuery);
			resp.sendRedirect("Home.jsp");
		}catch (Exception e) {
			resp.sendRedirect("connection.html");
		}
		}
		
		
		
	}
		
	
}
