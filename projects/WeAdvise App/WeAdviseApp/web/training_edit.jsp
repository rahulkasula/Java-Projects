<%-- 
    Document   : training_edit
    Created on : Apr 22, 2015, 4:10:12 AM
    Author     : Kapil
--%>

<%@page import="edu.uncc.weadvise.trainings.beans.Training"%>
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
            Training currentTraining = (Training) request.getAttribute("training");
        %>
        <!-- main space -->
        <div id="mainContainer_profile_evaluation_form" class="container">

            <h2><p class="text-center">Edit Training</p>
                <p><small style="color: white">Please edit following data to update the training</small></p>
            </h2>
            <form action="TrainingController" method="POST">
                <input type="hidden" name="action" value="update_training">
                <input type="hidden" name="trainingId" value=<%= currentTraining.getId() %>>
                <div class="form-group">
                    <label for="trainingName">Training Name</label>
                    <input type="text" class="form-control" id="trainingName" name="trainingName" placeholder="Enter Training Name" value=<%= currentTraining.getName() %>>
                </div>
                <div class="form-group">
                    <label for="trainingDescription">Training Description</label>
                    <input type="text" class="form-control" id="trainingDescription" name="trainingDescription" placeholder="Enter Training Description" value=<%= currentTraining.getDescription() %>>
                </div>
                <div class="form-group">
                    <label for="trainerName">Trainer Name</label>
                    <input type="text" class="form-control" id="trainerName" name="trainerName" placeholder="Enter Trainer Name" value=<%= currentTraining.getTrainer_name() %>>
                </div>
                <button type="submit" class="btn btn-default">Submit</button>
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