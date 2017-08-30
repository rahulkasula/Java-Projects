<%-- 
    Document   : index
    Created on : Apr 12, 2015, 12:24:50 AM
    Author     : sourabh
--%>

<%@page import="edu.uncc.weadvise.usermanagement.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="images/favicon.ico">
        <title>WeAdvise Home</title>
        <link href="css/style.css" rel="stylesheet">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

        <script>
            $(document).ready(function () {
                $("#menu_show").click(function () {
                    $("#side_navigation").toggle(1000);
                    $("#text").toggleClass("color");
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
                <li><a href="login.jsp">Sign Out</a></li>
            </ul>
        </div>
        <!-- end -->

        <!-- side navigation -->
        <div id="menu_show">
            <p id="text" class="blue">Menu</p>
        </div>
        <div id="side_navigation">
            <ul>Content<hr>
                <li><a href="#">Home</a></li><hr>
                <li><a href="profile_evaluation_form.jsp">Profile Evaluation</a></li><hr>
                <li><a href="training_home.jsp">Training Program</a></li><hr>
                <li><a href="#">Career Opportunity</a></li><hr>
                <li><a href="DiscussionController?action=view_discussions">Discussion Forum</a></li><hr>
            </ul>
        </div>
        <!-- end -->
        <%

            if (session.getAttribute("user") == null) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
            User currentUser = (User) session.getAttribute("user");

        %>
        <!-- main space -->
        <div id="mainContainer">

            <h2>Main WeAdvise:</h2>
            <p><b>Content Goes Here</b></p>

        </div>
        <!-- end -->

        <!-- footer -->
        <div id="footer">
            <p>Copyright Kripa</p>
        </div>
        <!-- end -->

    </body>
</html>