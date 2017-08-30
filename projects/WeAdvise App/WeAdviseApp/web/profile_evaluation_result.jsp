<%-- 
    Document   : profile_evaluation_result
    Created on : Apr 15, 2015, 8:43:41 PM
    Author     : Kapil
--%>

<%@page import="edu.uncc.weadvise.trainings.beans.Training"%>
<%@page import="edu.uncc.weadvise.careers.beans.Job"%>
<%@page import="edu.uncc.weadvise.careers.beans.University"%>
<%@page import="edu.uncc.weadvise.profileevaluation.beans.Result"%>
<%@page import="edu.uncc.weadvise.usermanagement.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="images/favicon.ico">
        <title>WeAdvise Home</title>
        <link href="css/style.css" rel="stylesheet">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
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
                <li><a href="#">Profile Evaluation</a></li><hr>
                <li><a href="#">Training Program</a></li><hr>
                <li><a href="#">Career Opportunity</a></li><hr>
                <li><a href="#">Discussion Forum</a></li><hr>
            </ul>
        </div>
        <!-- end -->
        <%

            if (session.getAttribute("user") == null) {
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
            User currentUser = (User) session.getAttribute("user");

            Result result = (Result)request.getAttribute("result");

        %>
        <!-- main space -->
        <div id="mainContainer_profile_evaluation_form" class="container">

            <h2><p class="text-center">Profile Evaluation Results</p>
                <p><small style="color: white">Here are all the matches we found suitable for your profile</small></p>
            </h2>
            <form>
                <div class="list-group">
                    <a href="#" class="list-group-item active">
                        Matching Universities
                    </a>

                    <% 
                        for (University university : result.getUniversityList()) {
                    %>
                    <a href="<%= university.getHomeUrl()%>" target="_blank" class="list-group-item"><%= university.getName()%></a>
                    <%
                        }
                    %>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item active">
                        Matching Jobs
                    </a>
                    <%
                        for (Job job : result.getJobList()) {
                    %>
                    <a href="#" class="list-group-item"><%= job.getTitle()%></a>
                    <%
                        }
                    %>
                </div>
                <div class="list-group">
                    <a href="#" class="list-group-item active">
                        Training Suggestions
                    </a>
                    <%
                        for (Training training : result.getTrainingList()) {
                    %>
                    <a href="TrainingController?id=<%= training.getId()%>&action=get_training"  class="list-group-item"><%= training.getName()%></a>
                    <%
                        }
                    %>
                </div>

            </form>

        </div>
        <!-- end -->

        <!-- footer -->
        <div id="footer">
            <p>Copyright WeAdvise</p>
        </div>
        <!-- end -->

    </body>
</html>