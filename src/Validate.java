import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validate {
	public static boolean emailValidate(String email) {
		boolean check=false;
		String pattern="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
		Pattern emailPattern=Pattern.compile(pattern);
		Matcher emailMatcher=emailPattern.matcher(email);
		if(emailMatcher.matches()) {
			return true;
		}
		return check;
	}
	
	public static boolean passwordValidate(String Password) {
		boolean check=false;
		String pattern="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
		Pattern passwordPattern=Pattern.compile(pattern);
		Matcher passwordMatcher=passwordPattern.matcher(Password);
		if(passwordMatcher.matches()) {
			return true;
		}
		
		
		return check;
	}
	
	public static boolean mobileValidate(String mobileno) {
		boolean check=false;
		String pattern="^[789]\\d{9}$";
		Pattern mobilePattern=Pattern.compile(pattern);
		Matcher mobileMatcher=mobilePattern.matcher(mobileno);
		if(mobileMatcher.matches()) {
			return true;
		}
		return check;
	}
	
	

}
