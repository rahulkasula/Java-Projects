package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import edu.uncc.weadvise.usermanagement.beans.User;

public final class profile_005fevaluation_005fform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" type=\"image/ico\" href=\"images/favicon.ico\">\n");
      out.write("        <title>WeAdvise Home</title>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#menu_show\").click(function () {\n");
      out.write("                    $(\"#side_navigation\").toggle(1000);\n");
      out.write("                    $(\"#text\").toggleClass(\"color\");\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            var acadInfoCount = 1;\n");
      out.write("            function addAcademicInfo() {\n");
      out.write("                acadInfoCount++;\n");
      out.write("                var acadHtml = \"<div> <div class='form-group'> <label for='degreeName'>Degree Name</label> <input type='text' class='form-control' id='degreeName' placeholder='Enter Degree Name' name='degreeName\" + acadInfoCount + \"'> </div> <div class='form-group'> <label for='universityName'>University/College/Institute</label> <input type='text' class='form-control' id='universityName' placeholder='Enter University Name' name='universityName\" + acadInfoCount + \"'> </div> <div class='form-group'> <label for='gpa'>GPA</label> <input type='number' class='form-control' id='gpa' placeholder='Enter GPA' name='gpa\" + acadInfoCount + \"'> </div> </div>\"\n");
      out.write("                $('#academicInfo').append(acadHtml);\n");
      out.write("                $('#academicInfoInput').val(adacInfoCount);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var workInfoCount = 1;\n");
      out.write("            function addAcademicInfo() {\n");
      out.write("                workInfoCount++;\n");
      out.write("                var workHtml = \"<div> <div class='form-group'> <label for='employer'>Employer</label> <input type='text' class='form-control' id='employer' placeholder='Enter Employer Name' name='employer\"+workInfoCount+\"'> </div> <div class='form-group'> <label for='tenure'>Tenure</label> <input type='text' class='form-control' id='tenure' placeholder='Enter Tenure' name='tenure\"+workInfoCount+\"'> </div> <div class='form-group'> <label for='designation'>Designation</label> <input type='text' class='form-control' id='gpa' placeholder='Enter Designation' name='designation\"+workInfoCount+\"'> </div> </div>\"\n");
      out.write("                $('#workInfo').append(workHtml);\n");
      out.write("                $('#workInfoInput').val(workInfoCount);\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!-- header with navigation -->\n");
      out.write("        <div id=\"header\">\n");
      out.write("            <h1 id=\"logo\">We Advise</h1>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- end -->\n");
      out.write("\n");
      out.write("        <!-- top navigation -->\n");
      out.write("        <div id=\"header_nav\">\n");
      out.write("            <ul >\n");
      out.write("                <li><a href=\"login.jsp\">Sign Out</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- end -->\n");
      out.write("\n");
      out.write("        <!-- side navigation -->\n");
      out.write("        <div id=\"menu_show\">\n");
      out.write("            <p id=\"text\" class=\"blue\">Menu</p>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"side_navigation\">\n");
      out.write("            <ul>Content<hr>\n");
      out.write("                <li><a href=\"#\">Home</a></li><hr>\n");
      out.write("                <li><a href=\"#\">Profile Evaluation</a></li><hr>\n");
      out.write("                <li><a href=\"#\">Training Program</a></li><hr>\n");
      out.write("                <li><a href=\"#\">Career Opportunity</a></li><hr>\n");
      out.write("                <li><a href=\"#\">Discussion Forum</a></li><hr>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <!-- end -->\n");
      out.write("\n");
      out.write("        ");


            if (session.getAttribute("user") == null) {
//                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
            User currentUser = (User) session.getAttribute("user");

        
      out.write("\n");
      out.write("\n");
      out.write("        <!-- main space -->\n");
      out.write("        <div id=\"mainContainer_profile_evaluation_form\" class=\"container\">\n");
      out.write("\n");
      out.write("            <h2><p class=\"text-center\">Profile Evaluation</p>\n");
      out.write("                <p><small style=\"color: white\">Please fill following data to get your profile evaluated</small></p>\n");
      out.write("            </h2>\n");
      out.write("            <form action=\"ProfileController\" method=\"POST\">\n");
      out.write("                <div id=\"academicInfo\">\n");
      out.write("                    <input type=\"hidden\" name=\"academicInfoInput\" value=\"1\">\n");
      out.write("                    <h3><span class=\"label label-default\">Academic Information</span></h3>\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"degreeName\">Degree Name</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"degreeName\" placeholder=\"Enter Degree Name\" name=\"degreeName1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"universityName\">University/College/Institute</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"universityName\" placeholder=\"Enter University Name\" name=\"universityName1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"gpa\">GPA</label>\n");
      out.write("                            <input type=\"number\" class=\"form-control\" id=\"gpa\" placeholder=\"Enter GPA\" name=\"gpa1\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\" onclick=\"addAcademicInfo()\">Add More</button>\n");
      out.write("\n");
      out.write("                <!--work experience-->\n");
      out.write("                <div id=\"workInfo\">\n");
      out.write("                    <input type=\"hidden\" name=\"workInfoInput\" value=\"1\">\n");
      out.write("                    <h3><span class=\"label label-default\">Work Experience</span></h3>\n");
      out.write("                    <div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"employer\">Employer</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"employer\" placeholder=\"Enter Employer Name\" name=\"employer1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"tenure\">Tenure</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"tenure\" placeholder=\"Enter Tenure\" name=\"tenure1\">\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <label for=\"designation\">Designation</label>\n");
      out.write("                            <input type=\"text\" class=\"form-control\" id=\"gpa\" placeholder=\"Enter Designation\" name=\"designation1\">\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\">Add More</button>\n");
      out.write("                <!--GRE-->\n");
      out.write("\n");
      out.write("                <h3><span class=\"label label-default\">GRE</span></h3>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"verbal\">Verbal Score</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"verbal\" placeholder=\"Enter Verbal Score\" name=\"greVerbal\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"quantitative\">Quantitative Score</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"quantitative\" placeholder=\"Enter Quantitative Score\" name=\"greQuant\"> \n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"analytical\">Analytical Score</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"analytical\" placeholder=\"Enter Analytical Score\" name=\"greAwa\">\n");
      out.write("                </div>\n");
      out.write("                <!--TOEFL-->                \n");
      out.write("                <h3><span class=\"label label-default\">TOEFL/IELTS</span></h3>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"toefl\">TOEFL/IELTS Score</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"toefl\" placeholder=\"Enter TOEFL/IELTS Score\" name=\"toefl\">\n");
      out.write("                </div>\n");
      out.write("                <!--technology worked-->\n");
      out.write("                <h3><span class=\"label label-default\">Technology Worked</span></h3>\n");
      out.write("\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"technology\">Technology</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"technology\" placeholder=\"Enter Technologies worked on in comma separated form e.g: Java, Android\" name=\"technology\">\n");
      out.write("                </div>\n");
      out.write("<!--                <div class=\"form-group\">\n");
      out.write("                    <label for=\"experience\">Experience</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"experience\" placeholder=\"Enter Experience in Months\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label for=\"level\">Level</label>\n");
      out.write("                    <select class=\"form-control\" id=\"level\">\n");
      out.write("                        <option>Beginner</option>\n");
      out.write("                        <option>Intermediate</option>\n");
      out.write("                        <option>Expert</option>\n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                <button type=\"button\" class=\"btn btn-primary\">Add More</button>-->\n");
      out.write("                <button type=\"submit\" class=\"btn btn-default\">Evaluate Profile</button>\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!-- end -->\n");
      out.write("\n");
      out.write("        <!-- footer -->\n");
      out.write("        <div id=\"footer\">\n");
      out.write("            <p>Copyright WeAdvise</p>\n");
      out.write("        </div>\n");
      out.write("        <!-- end -->\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
