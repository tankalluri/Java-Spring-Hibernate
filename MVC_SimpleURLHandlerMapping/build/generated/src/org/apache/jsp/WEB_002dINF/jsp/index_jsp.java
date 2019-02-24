package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(" \r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\r\n");
      out.write("    \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Movie Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <h1>Please make your selection below</h1>\r\n");
      out.write("        <div class=\"dropdown\">\r\n");
      out.write("            <div class=\"dropdown-content\">\r\n");
      out.write("                <select name=\"movie\" id=\"movieId\">\r\n");
      out.write("                    <option value='Browse Movies'>Browse Movies</option>\r\n");
      out.write("                    <option value='Add New Movie to database'>Add New Movie to database</option>\r\n");
      out.write("                </select>\r\n");
      out.write("                \r\n");
      out.write("            <button onclick=\"myFunction()\">Send</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div><br />\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            function myFunction() {\r\n");
      out.write("              \r\n");
      out.write("              var index = document.getElementById(\"movieId\").selectedIndex;\r\n");
      out.write("              if(index == 0){\r\n");
      out.write("                  location.replace(\"http://localhost:8080/WEB-INF/jsp/HW_4_Part5/SearchMovie.jsp\");\r\n");
      out.write("              }else{\r\n");
      out.write("                  location.replace(\"http://localhost:8080/WEB-INF/jsp/HW_4_Part5/AddNewMovie.jsp\");\r\n");
      out.write("              }\r\n");
      out.write("            }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
