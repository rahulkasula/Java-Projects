package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class signup_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("            <link rel=\"icon\" type=\"image/ico\" href=\"images/favicon.ico\">\n");
      out.write("\t\t<title>WeAdvise Login</title>\n");
      out.write("\t\t<link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("\t<script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\t\n");
      out.write("\t\t<script>\n");
      out.write("\t\t$(document).ready(function(){\n");
      out.write("\t\t\t$(\"#menu_show\").click(function(){\n");
      out.write("\t\t\t\t$(\"#side_navigation\").toggle(1000);\n");
      out.write("\t\t\t\t$(\"#text\").toggleClass(\"color\");\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t$(\"input\").focus(function(){\n");
      out.write("\t\t\t$(this).css(\"background-color\", \"#cccccc\");\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t$(\"input\").blur(function(){\n");
      out.write("\t\t\t\t$(this).css(\"background-color\", \"#ffffff\");\n");
      out.write("\t\t\t});\n");
      out.write("\t\t});\n");
      out.write("\t\t</script>\n");
      out.write("\t\t<script>\n");
      out.write("//\t\t\tfunction showDiv(radioID)\n");
      out.write("//\t\t\t{\n");
      out.write("//\t\t\t\tvar radio = radioID;\n");
      out.write("//\t\t\t\tif(radio == 'student')\n");
      out.write("//\t\t\t\t{\n");
      out.write("//\t\t\t\t\t\tdocument.getElementById(\"student\").style.display=\"block\";\n");
      out.write("//\t\t\t\t\t\tdocument.getElementById(\"user\").style.display=\"none\";\n");
      out.write("//\t\t\t\t\t\tdocument.getElementById(\"employer\").style.display=\"none\";\n");
      out.write("//\t\t\t\t}\n");
      out.write("//\t\t\t\telse if(radio == 'user')\n");
      out.write("//\t\t\t\t{\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"user\").style.display=\"block\";\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"student\").style.display=\"none\";\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"employer\").style.display=\"none\";\n");
      out.write("//\t\t\t\t}\n");
      out.write("//\t\t\t\telse if(radio == 'employer')\n");
      out.write("//\t\t\t\t{\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"employer\").style.display=\"block\";\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"student\").style.display=\"none\";\n");
      out.write("//\t\t\t\t\tdocument.getElementById(\"user\").style.display=\"none\";\n");
      out.write("//\t\t\t\t}\n");
      out.write("//\t\t\t}\n");
      out.write("\t\t</script>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\n");
      out.write("\t\t<!-- header with navigation -->\n");
      out.write("\t\t\t<div id=\"header\">\n");
      out.write("\t\t\t<h1 id=\"logo\">We Advise</h1>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- top navigation -->\n");
      out.write("\t\t\t<div id=\"header_nav\">\n");
      out.write("\t\t\t<ul >\n");
      out.write("\t\t\t\t<li><a href=\"login.jsp\">Login In</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- side navigation -->\n");
      out.write("\t\t\t<div id=\"menu_show\">\n");
      out.write("\t\t\t<p id=\"text\" class=\"blue\">Menu</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"side_navigation\">\n");
      out.write("\t\t\t\t<ul>Content<hr>\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\">Home</a></li><hr>\n");
      out.write("                                        <li><a href=\"login.jsp\">Login</a></li><hr>\n");
      out.write("\t\t\t\t\t<li>Please Login</li><hr>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- main space -->\n");
      out.write("\t\t<div id=\"mainContainer_signup\">\n");
      out.write("<!--\t\t\t<ul id=\"radio_list\">\n");
      out.write("\t\t\t\t<li><input type=\"radio\" name=\"act\" onClick=\"javascript:showDiv('student');\"><b>Student</b></li>\n");
      out.write("\t\t\t\t<li><input type=\"radio\" name=\"act\" onClick=\"javascript:showDiv('user');\"><b>User</b></li>\n");
      out.write("\t\t\t\t<li><input type=\"radio\" name=\"act\" onClick=\"javascript:showDiv('employer');\"><b>Employer</b></li>\n");
      out.write("\t\t\t</ul>-->\n");
      out.write("                    <!-- Form for student -->\n");
      out.write("<!--                    <form action=\"studentRegister\" method=\"POST\">\n");
      out.write("\t\t\t<table id=\"student\">\n");
      out.write("\t\t\t\t<tr><td>First Name: </td><td><input type=\"text\" class=\"textbox\" name=\"firstname\" placeholder=\"please Enter your FirstName\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Last Name: </td><td><input type=\"text\" class=\"textbox\" name=\"lastname\" placeholder=\"please Enter your LastName\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Phone Number: </td><td><input type=\"number\" class=\"textbox\" name=\"phonenumber\" placeholder=\"Enter your contact Info\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Address: </td><td><input type=\"text\" class=\"textbox\" name=\"address\" placeholder=\"Residential Address\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>UserName: </td><td><input type=\"text\" class=\"textbox\" name=\"username\" placeholder=\"please Select your username\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Password: </td><td><input type=\"password\" class=\"textbox\" name=\"password\" placeholder=\"please Select your password\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Email: </td><td><input type=\"email\" class=\"textbox\" name=\"email\" placeholder=\"Personal Email\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>University: </td><td><input type=\"text\" class=\"textbox\" name=\"university\" placeholder=\"Ex: UNCC\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td></td><td><input type=\"submit\" value=\"Sign Up\" class=\"textbox\"></td></tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("                        </form>-->\n");
      out.write("                     <!-- Form for user -->\n");
      out.write("                     <form action=\"UserRegister\" method=\"POST\">\n");
      out.write("\t\t\t<table id=\"user\" >\n");
      out.write("\t\t\t\t<tr><td>First Name: </td><td><input type=\"text\" class=\"textbox\" name=\"firstname\" placeholder=\"please Enter your FirstName\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Last Name: </td><td><input type=\"text\" class=\"textbox\" name=\"lastname\" placeholder=\"please Enter your LastName\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Phone Number: </td><td><input type=\"number\" class=\"textbox\" name=\"phonenumber\" placeholder=\"Enter your contact Info\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Address: </td><td><input type=\"text\" class=\"textbox\" name=\"address\" placeholder=\"Residential Address\" required></td></tr>\n");
      out.write("                                <tr><td>UserName: </td><td><input type=\"text\" class=\"textbox\" name=\"username\" placeholder=\"please Select your username\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Password: </td><td><input type=\"password\" class=\"textbox\" name=\"password\" placeholder=\"please Select your password\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Email: </td><td><input type=\"email\" class=\"textbox\" name=\"email\" placeholder=\"Personal Email\" required></td></tr>\n");
      out.write("\t\t\t\t<!--<tr><td></td><td><input type=\"hidden\" class=\"textbox\" name=\"hidden\" value=\"NULL\"></td></tr> -->\n");
      out.write("\t\t\t\t<tr><td></td><td><input type=\"submit\" value=\"Sign Up\" class=\"textbox\"></td></tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("                     </form>\n");
      out.write("                      <!-- Form for employer -->\n");
      out.write("<!--                      <form action=\"employerRegister\" method=\"POST\">\n");
      out.write("\t\t\t<table id=\"employer\">\n");
      out.write("\t\t\t\t<tr><td>Company Name: </td><td><input type=\"text\" name=\"companyname\" class=\"textbox\" placeholder=\"please Enter your CompanyName\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Employer Name: </td><td><input type=\"text\" name=\"employername\" class=\"textbox\" placeholder=\"please Enter your Name\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Phone Number: </td><td><input type=\"number\" name=\"phonenumber\" class=\"textbox\" placeholder=\"Enter company contact Info\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Company Address: </td><td><input type=\"text\" name=\"companyaddress\" class=\"textbox\" placeholder=\"office Address\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>UserName: </td><td><input type=\"text\" name=\"username\" class=\"textbox\" placeholder=\"please select your username\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Password: </td><td><input type=\"password\" name=\"password\" class=\"textbox\" placeholder=\"please select your password\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Email: </td><td><input type=\"email\" class=\"textbox\" name=\"email\" placeholder=\"company Email\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td></td><td><input type=\"submit\" value=\"Sign Up\" class=\"textbox\"></td></tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("                      </form>-->\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div id=\"user_div\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- footer -->\n");
      out.write("\t\t\t<div id=\"footer\">\n");
      out.write("\t\t\t<p>Copyright WeAdvise</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\n");
      out.write("\t</body>\n");
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
