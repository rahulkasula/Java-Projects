package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class training_005fhome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <link rel=\"icon\" type=\"image/ico\" href=\"images/favicon.ico\">\n");
      out.write("        <title>WeAdvise Home</title>\n");
      out.write("        <link href=\"css/style.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Latest compiled and minified CSS -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Optional theme -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Latest compiled and minified JavaScript -->\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js\"></script>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $(\"#menu_show\").click(function () {\n");
      out.write("                    $(\"#side_navigation\").toggle(1000);\n");
      out.write("                    $(\"#text\").toggleClass(\"color\");\n");
      out.write("                });\n");
      out.write("            });\n");
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
      out.write("        <!-- main space -->\n");
      out.write("        <div id=\"mainContainer_profile_evaluation_form\" class=\"container\">\n");
      out.write("\n");
      out.write("            <h2><p class=\"text-center\">Training Program</p>\n");
      out.write("                <p><small style=\"color: white\">Select following options to know more about training programs</small></p>\n");
      out.write("            </h2>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-lg\">View All Trainings</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-lg\">Create Trainings</button>\n");
      out.write("            <button type=\"button\" class=\"btn btn-primary btn-lg\">View Registered Trainings</button>\n");
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
