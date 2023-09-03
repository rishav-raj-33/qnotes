import java.time.LocalDateTime;


public class Query {
	
	public static String signUpQuery(String name,String email,String password) {
		String getDateTime=LocalDateTime.now().toString();
		String singup="INSERT INTO usertable (Email,Password,Date_Time,Name) Values("+"'"+email+"','"+password+"','"+getDateTime+"','"+name+"');";
		return singup;
	}
	
	public static String getDataQuery(String tableName) {
		String fetch="Select* from "+tableName;
		return fetch;
	}
	

public static String insertIntoFeedback(String email,String mobileno,String message,String name) {
	String feedback="INSERT INTO feedback VALUES("+"'"+name+"','"+email+"','"+mobileno+"','"+message+"');";
	return feedback;
}



	
	

}
