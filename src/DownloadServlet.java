import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Statement;
import java.time.LocalDateTime;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uniqueName=request.getParameter("uniquefile");  
		String sem=request.getParameter("semester");      
		HttpSession s=request.getSession();
		String email=s.getAttribute("email").toString();
		String fileName=" ";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        String url="jdbc:mysql://localhost:3306/qnotes";
	        String usernameString="root";
	        String passwordString="Root@123";	
	       Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
	       Statement statement=connection.createStatement();
	       ResultSet getFileData=statement.executeQuery("Select* from filelist");
	       while(getFileData.next()) {
	    	   if(getFileData.getString(3).equals(uniqueName)) {
	    		   fileName=getFileData.getNString(1);
	    		   String date_time=LocalDateTime.now().toString();
	        	   String insertDownloadList="INSERT INTO downloadedlist (Email,Date,FileName,Sem) Values("+"'"+email+"','"+date_time+"','"+fileName+"','"+sem+"');";
	        	   statement.execute(insertDownloadList);
	        	   break;
	    	   }
	       }
	    	    try{
	    		       String filepath="D:\\Application (Java)\\IDE\\com.QNotes\\WebContent\\Notes\\"+fileName;
	    		       FileInputStream downloadFile=new FileInputStream(filepath);
	    		       response.setContentType("application/docx");
	    		       response.setHeader("Content-Disposition", "attachment: filename ="+fileName);
	    		       response.setContentLength(downloadFile.available());
	    		       int c;
	    		       while((c=downloadFile.read())!=-1) {
	    		    	   response.getOutputStream().write(c);
	    		       }
	    		       response.getOutputStream().flush();
	    		       response.getOutputStream().close();
	    		       downloadFile.close();
	    		       }catch(Exception e1){
	    		    	   response.getWriter().println("Bad request");
	    		       }
	    		
	    	   
	       
		}catch (Exception e) {
			response.sendRedirect("connection.html");
			
			
		}
	       
	   
	


}
}
