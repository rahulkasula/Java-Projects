<%-- 
    Document   : profile_evaluation_form
    Created on : Apr 15, 2015, 3:37:37 PM
    Author     : Kapil
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
        <!-- Latest compiled and minified CSS -->
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
            var acadInfoCount = 1;
            function addAcademicInfo() {
                acadInfoCount++;
                var acadHtml = "<div> <div class='form-group'> <label for='degreeName'>Degree Name</label> <input type='text' class='form-control' id='degreeName' placeholder='Enter Degree Name' name='degreeName" + acadInfoCount + "'> </div> <div class='form-group'> <label for='universityName'>University/College/Institute</label> <input type='text' class='form-control' id='universityName' placeholder='Enter University Name' name='universityName" + acadInfoCount + "'> </div> <div class='form-group'> <label for='gpa'>GPA</label> <input type='number' class='form-control' id='gpa' placeholder='Enter GPA' name='gpa" + acadInfoCount + "'> </div> </div>"
                $('#academicInfo').append(acadHtml);
                $('#academicInfoInput').val(acadInfoCount);
            }

            var workInfoCount = 1;
            function addWorkInfo() {
                workInfoCount++;
                var workHtml = "<div> <div class='form-group'> <label for='employer'>Employer</label> <input type='text' class='form-control' id='employer' placeholder='Enter Employer Name' name='employer"+workInfoCount+"'> </div> <div class='form-group'> <label for='tenure'>Tenure</label> <input type='text' class='form-control' id='tenure' placeholder='Enter Tenure' name='tenure"+workInfoCount+"'> </div> <div class='form-group'> <label for='designation'>Designation</label> <input type='text' class='form-control' id='gpa' placeholder='Enter Designation' name='designation"+workInfoCount+"'> </div> </div>"
                $('#workInfo').append(workHtml);
                $('#workInfoInput').val(workInfoCount);
            }
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
//                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
            User currentUser = (User) session.getAttribute("user");

        %>

        <!-- main space -->
        <div id="mainContainer_profile_evaluation_form" class="container">

            <h2><p class="text-center">Profile Evaluation</p>
                <p><small style="color: white">Please fill following data to get your profile evaluated</small></p>
            </h2>
            <form action="ProfileController" method="POST">
                <div id="academicInfo">
                    <input type="hidden" name="academicInfoInput" id="academicInfoInput" value="1">
                    <h3><span class="label label-default">Academic Information</span></h3>
                    <div>
                        <div class="form-group">
                            <label for="degreeName">Degree Name</label>
                            <input type="text" class="form-control" id="degreeName" placeholder="Enter Degree Name" name="degreeName1">
                        </div>
                        <div class="form-group">
                            <label for="universityName">University/College/Institute</label>
                            <input type="text" class="form-control" id="universityName" placeholder="Enter University Name" name="universityName1">
                        </div>
                        <div class="form-group">
                            <label for="gpa">GPA</label>
                            <input type="number" class="form-control" id="gpa" placeholder="Enter GPA" name="gpa1">
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="addAcademicInfo()">Add More</button>

                <!--work experience-->
                <div id="workInfo">
                    <input type="hidden" name="workInfoInput" id="workInfoInput" value="1">
                    <h3><span class="label label-default">Work Experience</span></h3>
                    <div>
                        <div class="form-group">
                            <label for="employer">Employer</label>
                            <input type="text" class="form-control" id="employer" placeholder="Enter Employer Name" name="employer1">
                        </div>
                        <div class="form-group">
                            <label for="tenure">Tenure</label>
                            <input type="text" class="form-control" id="tenure" placeholder="Enter Tenure" name="tenure1">
                        </div>
                        <div class="form-group">
                            <label for="designation">Designation</label>
                            <input type="text" class="form-control" id="gpa" placeholder="Enter Designation" name="designation1">
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-primary" onclick="addWorkInfo()">Add More</button>
                <!--GRE-->

                <h3><span class="label label-default">GRE</span></h3>

                <div class="form-group">
                    <label for="verbal">Verbal Score</label>
                    <input type="text" class="form-control" id="verbal" placeholder="Enter Verbal Score" name="greVerbal">
                </div>
                <div class="form-group">
                    <label for="quantitative">Quantitative Score</label>
                    <input type="text" class="form-control" id="quantitative" placeholder="Enter Quantitative Score" name="greQuant"> 
                </div>
                <div class="form-group">
                    <label for="analytical">Analytical Score</label>
                    <input type="text" class="form-control" id="analytical" placeholder="Enter Analytical Score" name="greAwa">
                </div>
                <!--TOEFL-->                
                <h3><span class="label label-default">TOEFL/IELTS</span></h3>

                <div class="form-group">
                    <label for="toefl">TOEFL/IELTS Score</label>
                    <input type="text" class="form-control" id="toefl" placeholder="Enter TOEFL/IELTS Score" name="toefl">
                </div>
                <!--technology worked-->
                <h3><span class="label label-default">Technology Worked</span></h3>

                <div class="form-group">
                    <label for="technology">Technology</label>
                    <input type="text" class="form-control" id="technology" placeholder="Enter Technologies worked on in comma separated form e.g: Java, Android" name="technology">
                </div>
<!--                <div class="form-group">
                    <label for="experience">Experience</label>
                    <input type="text" class="form-control" id="experience" placeholder="Enter Experience in Months">
                </div>
                <div class="form-group">
                    <label for="level">Level</label>
                    <select class="form-control" id="level">
                        <option>Beginner</option>
                        <option>Intermediate</option>
                        <option>Expert</option>
                    </select>
                </div>
                <button type="button" class="btn btn-primary">Add More</button>-->
                <button type="submit" class="btn btn-default">Evaluate Profile</button>
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