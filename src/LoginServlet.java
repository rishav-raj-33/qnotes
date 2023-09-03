import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doPost(req, resp);
		}
   @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("signinemail");  
	String password=req.getParameter("signinpassword");  
	boolean find=Verify.verify(email, password);
	boolean checkEmail=Validate.emailValidate(email);
	if(checkEmail==false) {
		RequestDispatcher dispatcher=req.getRequestDispatcher("Invalid_Email.html");
		dispatcher.forward(req, resp);
		
	}
	boolean checkPassword=Validate.passwordValidate(password);
	
	if(checkPassword==false) {
		RequestDispatcher dispatcher=req.getRequestDispatcher("Invalid_password.html");
		dispatcher.forward(req, resp);
		
	}
	if(find==true) {
		HttpSession session=req.getSession();
		session.setAttribute("email", email);
		String s=session.getId();
		session.setAttribute("ID", s);
	   	resp.sendRedirect("Home.jsp");
	} else {

		resp.sendRedirect("Not_Found.html");
		
	}	   
	   

   }
	
	
}
