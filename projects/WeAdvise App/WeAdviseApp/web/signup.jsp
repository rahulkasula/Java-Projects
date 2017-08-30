<%-- 
    Document   : signup
    Created on : Apr 12, 2015, 12:46:33 AM
    Author     : sourabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
            <link rel="icon" type="image/ico" href="images/favicon.ico">
		<title>WeAdvise Login</title>
		<link href="css/style.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	
		<script>
		$(document).ready(function(){
			$("#menu_show").click(function(){
				$("#side_navigation").toggle(1000);
				$("#text").toggleClass("color");
			});
			$("input").focus(function(){
			$(this).css("background-color", "#cccccc");
			});
			$("input").blur(function(){
				$(this).css("background-color", "#ffffff");
			});
		});
		</script>
		<script>
//			function showDiv(radioID)
//			{
//				var radio = radioID;
//				if(radio == 'student')
//				{
//						document.getElementById("student").style.display="block";
//						document.getElementById("user").style.display="none";
//						document.getElementById("employer").style.display="none";
//				}
//				else if(radio == 'user')
//				{
//					document.getElementById("user").style.display="block";
//					document.getElementById("student").style.display="none";
//					document.getElementById("employer").style.display="none";
//				}
//				else if(radio == 'employer')
//				{
//					document.getElementById("employer").style.display="block";
//					document.getElementById("student").style.display="none";
//					document.getElementById("user").style.display="none";
//				}
//			}
		</script>
	</head>
	<body>
	
		<!-- header with navigation -->
			<div id="header">
			<h1 id="logo">We Advise</h1>
			</div>
		<!-- end -->
		
		<!-- top navigation -->
			<div id="header_nav">
			<ul >
				<li><a href="login.jsp">Login In</a></li>
			</ul>
			</div>
		<!-- end -->
		
		<!-- side navigation -->
			<div id="menu_show">
			<p id="text" class="blue">Menu</p>
			</div>
			<div id="side_navigation">
				<ul>Content<hr>
					<li><a href="index.jsp">Home</a></li><hr>
                                        <li><a href="login.jsp">Login</a></li><hr>
					<li>Please Login</li><hr>
				</ul>
			</div>
		<!-- end -->
		
		<!-- main space -->
		<div id="mainContainer_signup">
<!--			<ul id="radio_list">
				<li><input type="radio" name="act" onClick="javascript:showDiv('student');"><b>Student</b></li>
				<li><input type="radio" name="act" onClick="javascript:showDiv('user');"><b>User</b></li>
				<li><input type="radio" name="act" onClick="javascript:showDiv('employer');"><b>Employer</b></li>
			</ul>-->
                    <!-- Form for student -->
<!--                    <form action="studentRegister" method="POST">
			<table id="student">
				<tr><td>First Name: </td><td><input type="text" class="textbox" name="firstname" placeholder="please Enter your FirstName" required></td></tr>
				<tr><td>Last Name: </td><td><input type="text" class="textbox" name="lastname" placeholder="please Enter your LastName" required></td></tr>
				<tr><td>Phone Number: </td><td><input type="number" class="textbox" name="phonenumber" placeholder="Enter your contact Info" required></td></tr>
				<tr><td>Address: </td><td><input type="text" class="textbox" name="address" placeholder="Residential Address" required></td></tr>
				<tr><td>UserName: </td><td><input type="text" class="textbox" name="username" placeholder="please Select your username" required></td></tr>
				<tr><td>Password: </td><td><input type="password" class="textbox" name="password" placeholder="please Select your password" required></td></tr>
				<tr><td>Email: </td><td><input type="email" class="textbox" name="email" placeholder="Personal Email" required></td></tr>
				<tr><td>University: </td><td><input type="text" class="textbox" name="university" placeholder="Ex: UNCC" required></td></tr>
				<tr><td></td><td><input type="submit" value="Sign Up" class="textbox"></td></tr>
			</table>
                        </form>-->
                     <!-- Form for user -->
                     <form action="UserRegister" method="POST">
			<table id="user" >
				<tr><td>First Name: </td><td><input type="text" class="textbox" name="firstname" placeholder="please Enter your FirstName" required></td></tr>
				<tr><td>Last Name: </td><td><input type="text" class="textbox" name="lastname" placeholder="please Enter your LastName" required></td></tr>
				<tr><td>Phone Number: </td><td><input type="number" class="textbox" name="phonenumber" placeholder="Enter your contact Info" required></td></tr>
				<tr><td>Address: </td><td><input type="text" class="textbox" name="address" placeholder="Residential Address" required></td></tr>
                                <tr><td>UserName: </td><td><input type="text" class="textbox" name="username" placeholder="please Select your username" required></td></tr>
				<tr><td>Password: </td><td><input type="password" class="textbox" name="password" placeholder="please Select your password" required></td></tr>
				<tr><td>Email: </td><td><input type="email" class="textbox" name="email" placeholder="Personal Email" required></td></tr>
				<!--<tr><td></td><td><input type="hidden" class="textbox" name="hidden" value="NULL"></td></tr> -->
				<tr><td></td><td><input type="submit" value="Sign Up" class="textbox"></td></tr>
			</table>
                     </form>
                      <!-- Form for employer -->
<!--                      <form action="employerRegister" method="POST">
			<table id="employer">
				<tr><td>Company Name: </td><td><input type="text" name="companyname" class="textbox" placeholder="please Enter your CompanyName" required></td></tr>
				<tr><td>Employer Name: </td><td><input type="text" name="employername" class="textbox" placeholder="please Enter your Name" required></td></tr>
				<tr><td>Phone Number: </td><td><input type="number" name="phonenumber" class="textbox" placeholder="Enter company contact Info" required></td></tr>
				<tr><td>Company Address: </td><td><input type="text" name="companyaddress" class="textbox" placeholder="office Address" required></td></tr>
				<tr><td>UserName: </td><td><input type="text" name="username" class="textbox" placeholder="please select your username" required></td></tr>
				<tr><td>Password: </td><td><input type="password" name="password" class="textbox" placeholder="please select your password" required></td></tr>
				<tr><td>Email: </td><td><input type="email" class="textbox" name="email" placeholder="company Email" required></td></tr>
				<tr><td></td><td><input type="submit" value="Sign Up" class="textbox"></td></tr>
			</table>
                      </form>-->
			
		</div>
		<div id="user_div">
			
		</div>
		<!-- end -->
		
		<!-- footer -->
			<div id="footer">
			<p>Copyright WeAdvise</p>
			</div>
		<!-- end -->
	
	</body>
</html>