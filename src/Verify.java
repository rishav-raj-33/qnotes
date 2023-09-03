import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;





public class Verify {
	
	public static boolean verify(String email,String password) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qnotes";
            String usernameString="root";
            String passwordString="Root@123";	
           Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
           Statement statement=connection.createStatement();
           String fetchQuery=Query.getDataQuery("usertable");
           ResultSet loginData=statement.executeQuery(fetchQuery); 
          while(loginData.next()) {
        	  
        	  if(loginData.getString(1).equals(email) &&  loginData.getString(2).equals(password)) {
        		  
        		  return true;
        	  }
          }
           
		}catch (Exception e) {
		}
		return false;
	}
public static boolean verify(String email) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/qnotes";
            String usernameString="root";
            String passwordString="Root@123";	
           Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
           Statement statement=connection.createStatement();
           String fetchQuery=Query.getDataQuery("usertable");
           ResultSet loginData=statement.executeQuery(fetchQuery); 
          while(loginData.next()) {
        	  
        	  if(loginData.getString(1).equals(email)) {
        		 
        		  return true;
        	  }
          }
           
		}catch (Exception e) {
		}
		return false;
	}

	
	

}
