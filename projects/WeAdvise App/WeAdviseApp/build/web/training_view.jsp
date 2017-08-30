<%-- 
    Document   : training_view
    Created on : Apr 21, 2015, 8:09:25 PM
    Author     : Kapil
--%>

<%@page import="edu.uncc.weadvise.trainings.beans.Training"%>
<%@page import="edu.uncc.weadvise.usermanagement.beans.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" type="image/ico" href="images/favicon.ico">
        <title>WeAdvise Home</title>
        <link href="css/style.css" rel="stylesheet">
        <!-- Latest compiled and minified CSS -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

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

        <!-- main space -->
        <div id="mainContainer_training_view" class="container">

            <h2><p class="text-center">Training Details</p>
                <p><small style="color: white">View the training details or choose following options to change the existing training program</small></p>
            </h2>

            <%
                Training currentTraining = (Training) request.getAttribute("training");
                boolean isRegistered = (Boolean) request.getAttribute("registered");
                if(session.getAttribute("user") == null) {
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }
                User currentUser = (User) session.getAttribute("user");
                

                if (currentUser.getId() == currentTraining.getCreated_by().getId()) {
            %>

            <a href="TrainingController?id=<%= currentTraining.getId() %>&action=edit_training"><button type="button" class="btn btn-primary" style="margin: 10px">Edit</button></a>
            <% 
                }
                if(currentUser.isAdmin() || currentUser.getId() == currentTraining.getCreated_by().getId()) {
            %>
            <a href="TrainingController?id=<%= currentTraining.getId() %>&action=delete_training"><button type="button" class="btn btn-primary" style="margin: 10px">Delete</button></a>
            <%
                }
                if (currentUser.isAdmin() && !currentTraining.isApproved()) {
            %> 
            <a href="TrainingController?id=<%= currentTraining.getId() %>&action=approve_training"><button type="button" class="btn btn-primary" style="margin: 10px">Approve</button></a>
            <% }
                if (!isRegistered) {
            %>
            <a href="TrainingController?id=<%= currentTraining.getId() %>&action=apply_training"><button type="button" class="btn btn-primary" style="margin: 10px">Apply</button></a>
            <% }
            %>
            <div class="panel panel-default">
                <div class="panel-heading">Name</div>
                <div class="panel-body">
                    <c:out value="${training.name}" />
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Description</div>
                <div class="panel-body">
                    <c:out value="${training.description}" />
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Trainer Name</div>
                <div class="panel-body">
                    <c:out value="${training.trainer_name}" />
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Creation Date</div>
                <div class="panel-body">
                    <c:out value="${training.created}" />
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">Approved Status</div>
                <div class="panel-body">
                    <c:out value="${training.approved}" />
                </div>
            </div>


        </div>
        <!-- end -->

        <!-- footer -->
        <div id="footer">
            <p>Copyright WeAdvise</p>
        </div>
        <!-- end -->

    </body>
</html>