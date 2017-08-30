<%-- 
    Document   : discussion_view
    Created on : Apr 23, 2015, 1:03:53 AM
    Author     : Kapil
--%>

<%@page import="edu.uncc.weadvise.discussion.beans.DiscussionComment"%>
<%@page import="edu.uncc.weadvise.discussion.beans.DiscussionTopic"%>
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
        <div id="mainContainer_training_view" class="container" style="color: white">

            <h2><p class="text-center">Discussion Details</p>
                <p><small style="color: white">View the training details or choose following options to change the existing training program</small></p>
            </h2>

            <%
                DiscussionTopic currentDiscussion = (DiscussionTopic) request.getAttribute("discussion");
                boolean isRegistered = (Boolean) request.getAttribute("registered");
                if (session.getAttribute("user") == null) {
                    getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
                }
                User currentUser = (User) session.getAttribute("user");

                if (currentUser.getId() == currentDiscussion.getCreatedBy().getId()) {
            %>

            <a href="DiscussionController?id=<%= currentDiscussion.getId()%>&action=edit_discussion"><button type="button" class="btn btn-primary" style="margin: 10px">Edit</button></a>
            <% 
                }
                if(currentUser.isAdmin() || currentUser.getId() == currentDiscussion.getCreatedBy().getId()) {
            %>
            
            <a href="DiscussionController?id=<%= currentDiscussion.getId()%>&action=delete_discussion"><button type="button" class="btn btn-primary" style="margin: 10px">Delete</button></a>
            <%
                }
            %> 
            <h2><%= currentDiscussion.getContent()%></h2>
            <form role="form" action="DiscussionController" method="POST">
                <input type="hidden" name="action" value="post_discussion_comment">
                <input type="hidden" name="training_id" value=<%= currentDiscussion.getId()%>>
                <div class="form-group">
                    <input type="textarea" class="form-control" name="comment" placeholder="Write comment">
                </div>
                <button type="submit" class="btn btn-default">Post</button>
            </form>
            <table class="table">
                <thead>
                    <tr>
                        <th><h3>Comment</h3></th>
                <th><h3>User</h3></th>
                <th></th>
                </tr>
                </thead>
                <tbody>

                    <%
                        for (DiscussionComment comment : currentDiscussion.getComments()) {
                    %>
                    <tr class="success" style="color: #000000">
                        <td ><h5><%= comment.getComment()%></h5></td>
                        <td ><h5><%= comment.getComentedUser().getFirstName()%></h5></td>

                        <td align="left">
                            <%
                                if (comment.getComentedUser().getId() == currentUser.getId()) {
                            %>
                            <a href="DiscussionController?id=<%= comment.getId()%>&action=delete_discussion_comment&discussion_id=<%= comment.getDiscussionId()%>">
                                <img alt="Comments" title="Delete Comment" src="./images/delete.png"  height="24" width="24">
                            </a>
                            <%
                                }
                            %>
                        </td>

                    </tr>
                    <%
                        }
                    %>
            </table>

        </div>
        <!-- end -->

        <!-- footer -->
        <div id="footer">
            <p>Copyright WeAdvise</p>
        </div>
        <!-- end -->

    </body>
</html>