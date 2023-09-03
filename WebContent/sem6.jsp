<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  import="java.sql.*" %>
    
    
    
    
 <% HttpSession s=request.getSession(); 
    String match=(String)s.getAttribute("ID");
    String id=s.getId();
    try{
    if(match.equals(id)==false){
    	response.sendRedirect("index.html");
    }
    }catch(Exception e){
    	response.sendRedirect("index.html");
    }%>   
<!DOCTYPE html>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>6th Semester</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-yellow-50 text-center mx-auto">

    <h1 class="font-bold sm:text-[50px] text-[35px] my-4">Semester 6 Notes</h1>
    <div class="bg-yellow-100 max-w-[500px] sm:mx-auto  sm:mt-12 mx-4 sm:h-[80vh] h-[60vh] overflow-y-auto"  >
     <%  try {
		Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/qnotes";
        String usernameString="root";
        String passwordString="Root@123";	
       Connection  connection= DriverManager.getConnection(url,usernameString,passwordString);
       Statement statement=connection.createStatement();
       String query="SELECT* FROM filelist WHERE Sem=6;";
       ResultSet resultSet=statement.executeQuery(query);
       
       while(resultSet.next())
       {
    	   
    	   %>

        <form action="download" method="get" class="flex items-center justify-evenly">
            <input type="hidden" name="uniquefile" value="<%out.print(resultSet.getString(3)); %>">

            <input type="hidden" name="semester" value="6">

            <span class="font-bold   sm:text-[20px] pl-[15px] text-[20px] border-[#ccc] rounded-[8px"> <% out.print(resultSet.getString(3)); %> </span>

            <span class="font-bold   sm:text-[20px] pl-[15px] text-[20px] border-[#ccc] rounded-[8px"> <%  out.print(resultSet.getString(2));  %></span>
                                                                                                 
                                                                                                 
                                                                                              

            <button type="download"class="bg-yellow-500 px-4 sm:h-[55px] h-[40px] font-bold hover:bg-yellow-700 rounded-[6px] border-4 mb-4 mx-[8px] border-slate-200 cursor-pointer text-black">
                 Download   
              </a>
             </button>

        </form>
         <%
         }
       
       connection.close();
     }catch(Exception e){
	 response.sendRedirect("connection.html");
 }   %>  

        
        
    </div>
    
</body>
</html>