package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                        $(\"#error\").hide(1000);\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t$(\"input\").blur(function(){\n");
      out.write("\t\t\t\t$(this).css(\"background-color\", \"#ffffff\");\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\t});\n");
      out.write("\t\t\n");
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
      out.write("\t\t\t\t<li><a href=\"signup.jsp\">Sign Up</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- side navigation -->\n");
      out.write("\t\t\t<div id=\"menu_show\">\n");
      out.write("\t\t\t<p id=\"text\">Menu</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div id=\"side_navigation\">\n");
      out.write("\t\t\t\t<ul>Content<hr>\n");
      out.write("\t\t\t\t\t<li><a href=\"index.jsp\">Home</a></li><hr>\n");
      out.write("\t\t\t\t\t<li>Please Login</li><hr>\n");
      out.write("\t\t\t\t\t<li>Please Login</li><hr>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- main space -->\n");
      out.write("\t\t<div id=\"mainContainer\">\n");
      out.write("                    <p id=\"error\"><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></p>\n");
      out.write("                    <form action=\"UserLogin\" method=\"POST\">\n");
      out.write("                        \n");
      out.write("                        <table>\n");
      out.write("                                <tr><td>UserName: </td><td><input type=\"text\" class=\"textbox\" name=\"username\" placeholder=\"please Enter your username\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td>Password: </td><td><input type=\"password\" class=\"textbox\" name=\"password\" placeholder=\"please Enter your password\" required></td></tr>\n");
      out.write("\t\t\t\t<tr><td></td><td><b>Don't have an Account    </b><a href=\"signup.jsp\">Register?</a></td></tr>\n");
      out.write("\t\t\t\t<tr><td></td><td><input type=\"submit\" value=\"Login\" class=\"textbox\"></td></tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("                        \n");
      out.write("                    </form>\n");
      out.write("                    \n");
      out.write("\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\t\n");
      out.write("\t\t<!-- footer -->\n");
      out.write("\t\t\t<div id=\"footer\">\n");
      out.write("\t\t\t<p>Copyright Kripa</p>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t<!-- end -->\n");
      out.write("\t\n");
      out.write("\t</body>\n");
      out.write("</html>\n");
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
