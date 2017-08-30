<%-- 
    Document   : login
    Created on : Apr 12, 2015, 12:45:38 AM
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
                        $("#error").hide(1000);
			});
			$("input").blur(function(){
				$(this).css("background-color", "#ffffff");
			});
			});
		
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
				<li><a href="signup.jsp">Sign Up</a></li>
			</ul>
			</div>
		<!-- end -->
		
		<!-- side navigation -->
			<div id="menu_show">
			<p id="text">Menu</p>
			</div>
			<div id="side_navigation">
				<ul>Content<hr>
					<li><a href="index.jsp">Home</a></li><hr>
					<li>Please Login</li><hr>
					<li>Please Login</li><hr>
				</ul>
			</div>
		<!-- end -->
		
		<!-- main space -->
		<div id="mainContainer">
                    <p id="error"><b>${message}</b></p>
                    <form action="UserLogin" method="POST">
                        
                        <table>
                                <tr><td>UserName: </td><td><input type="text" class="textbox" name="username" placeholder="please Enter your username" required></td></tr>
				<tr><td>Password: </td><td><input type="password" class="textbox" name="password" placeholder="please Enter your password" required></td></tr>
				<tr><td></td><td><b>Don't have an Account    </b><a href="signup.jsp">Register?</a></td></tr>
				<tr><td></td><td><input type="submit" value="Login" class="textbox"></td></tr>
			</table>
                        
                    </form>
                    
		</div>
		<!-- end -->
		
		<!-- footer -->
			<div id="footer">
			<p>Copyright Kripa</p>
			</div>
		<!-- end -->
	
	</body>
</html>
