<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
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
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://cdn.tailwindcss.com"></script>
    <style>

        @media only screen and (max-width : 640px) {

            .navbar ul {
                margin-bottom: 25px;
            }
            
            .nav {
                flex-direction: column;
            }
            .h-nav-res{
                height: 72px;
            }

            .v-nav-res{
                opacity: 0;
            }
        }
    </style>

</head>
<body class="bg-yellow-50">
    <section class="w-[100%] bg-slate-400 h-[100px] flex sm:justify-between justify-evenly items-center nav">

        <div class="logo">
            <img src="logo_2.png" class="sm:w-[200px] w-[140px]" alt="logo">
        </div>
        <form action="Logout.jsp" method="link">
        <div>
            <nav class="navbar">
                <ul class="flex items-center justify-between sm:space-x-5 space-x-3 sm:m-10 m-2 text-white font-bold md:text-xl sm:text-lg">
                    <li class="hover:text-yellow-100"><a href="#">Home</a></li>
                    <li class="hover:text-yellow-100"><a href="#About">About</a></li>
                    <li class="hover:text-yellow-100"><a href="#Contact">Contact Us</a></li>
                    <button type="logout" class="hover:bg-yellow-700 bg-red-700 rounded-[6px] px-2">Log  Out</button>
                </ul>
            </nav>

        </div>
        </form>

        <div class="burger hidden cursor-pointer top-4 right-[5%]">
            <div class="w-[33px] bg-white h-[4px] mx-[5px] my-[3px]"></div>
            <div class="w-[33px] bg-white h-[4px] mx-[5px] my-[3px]"></div>
            <div class="w-[33px] bg-white h-[4px] mx-[5px] my-[3px]"></div>
        </div>

    </section>
    
    <section class=" w-[100%] sm:h-[90vh] h-[80vh] flex flex-col sm:flex-row sm:flex-wrap sm:justify-evenly items-center px-2 text-center top-[250px] mt-[5%]">

        <a href="#"><div class="sm:h-[200px] h-[100px] w-[300px] mt-6 bg-slate-400 flex justify-center md:text-[20px] items-center font-bold rounded-[50px]">Semester 3</div> </a>

        <a href="#"><div class="sm:h-[200px] h-[100px] w-[300px] mt-6 bg-slate-400 flex justify-center md:text-[20px] items-center font-bold rounded-[50px]">Semester 4</div></a>
        
        <a href="sem5.jsp"><div class="sm:h-[200px] h-[100px] w-[300px] mt-6 bg-slate-400 flex justify-center md:text-[20px] items-center font-bold rounded-[50px]">Semester 5</div></a>
        
        <a href="sem6.jsp"><div class="sm:h-[200px] h-[100px] w-[300px] mt-6 bg-slate-400 flex justify-center md:text-[20px] items-center font-bold rounded-[50px]">Semester 6</div></a>
        
        <a href="#"><div class="sm:h-[200px] h-[100px] w-[300px] mt-6 bg-slate-400 flex justify-center md:text-[20px] items-center font-bold rounded-[50px]">Semester 7</div></a>

    </section>

    <section class="bg-yellow-100 h-[50%] w-[100%] flex flex-col" id="Contact">

        <h2 class="text-center p-4 font-bold text-[40px]">
            Contact Us
        </h2>

        <div class="max-w-[400px] mx-auto">
        <form action="feedback" method="get">
            
            <input class="w-[90%] text-[18px] rounded-[6px] px-[5px] py-2 my-4 mx-[8px] border-4 border-gray-300" type="text"  required name="name" id="name" placeholder="Enter your name">
            
            <input class="w-[90%] text-[18px] rounded-[6px] px-[5px] py-2 my-4 mx-[8px] border-4 border-gray-300"" type="number" required name="phoneNumber" id="phoneNumber" placeholder="Enter your Mo. number" >
            
            <input class="w-[90%] text-[18px] rounded-[6px] px-[5px] py-2 my-4 mx-[8px] border-4 border-gray-300" type="email" required name="email" id="email" placeholder="Enter your Email">
            
            <textarea class="w-[90%] text-[18px] rounded-[6px] px-[5px] py-2 my-4 mx-[8px] border-4 border-gray-300"" type="text" cols="30" rows="7"name="message" required  id="text" placeholder="Ellaborate your concern"></textarea>
            
            <button type="feedback"  class="bg-yellow-500 px-4 w-[90%] h-[55px] font-bold hover:bg-yellow-700 rounded-[6px] border-4 mb-4 mx-[8px] border-slate-200 cursor-pointer text-black">
                Submit
             </button>
             </form>
        
        </div>
    </section>

    <section>

        <h2 class="text-center p-4 font-bold text-[40px]" id="About">
            About Us
        </h2>

        <div class="w-auto h-10vh mx-4 mb-4 sm:text-[25px] text-[15px]">
            Learners to Build is an enthusiastic and collaborative team of software developers driven by a shared passion for learning and creating innovative solutions.

            Our mission is to collectively enhance our skills, exchange knowledge, and work together to develop high-quality software applications.


        </div>
    </section>


    <footer class="bg-slate-100 w-[100%] h-[50px] text-center pt-4">
        <p >
            Copyright &copy; <strong>Learners to Build</strong>
        </p>
    </footer>
</body>
</html>






