package org.apache.jsp.res.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
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
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("     \r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write(" <title>Project</title>\r\n");
      out.write("<script src=\"assets/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"../favicon.ico\"> \r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/demo.css\" />\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/style1.css\" />\r\n");
      out.write("        <link href=\"");
      out.print(request.getContextPath() );
      out.write("/css/fontstyle.css\" rel='stylesheet' type='text/css' />\r\n");
      out.write("      <link rel=\"stylesheet\" type=\"text/css\" href=\"");
      out.print(request.getContextPath() );
      out.write("/css/menu.css\" />\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("window.history.forward();\r\n");
      out.write("function noBack() { window.history.forward(); }\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("       \r\n");
      out.write("           <img alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/Files/Images/Title copy.png\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<div class=\"header\">\r\n");
      out.write("               \r\n");
      out.write("                <span class=\"right\">\r\n");
      out.write("                    <a href=\"#\" target=\"_blank\">Welcome....!</a>\r\n");
      out.write("                    <a href=\"#\"><strong>Admin</strong></a>\r\n");
      out.write("                </span>\r\n");
      out.write("                <div class=\"clr\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("   <nav>\r\n");
      out.write("    <div class='nav-container'>\r\n");
      out.write("      <div>\r\n");
      out.write("        <input id='slider1' name='slider1' type='checkbox'>\r\n");
      out.write("        <label class='slide has-child' for='slider1'>\r\n");
      out.write("          <span class='element'>Profile</span>\r\n");
      out.write("          <span class='name'>User Profile</span>\r\n");
      out.write("        </label>\r\n");
      out.write("        <div class='child-menu'>\r\n");
      out.write("           <a href=\"");
      out.print(request.getContextPath());
      out.write("/Profile\" target=\"f\">View Profile</a>         \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("       <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/ServerList?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>Service Providers</span>\r\n");
      out.write("          <span class='name'>Service Providers</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("       <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/RechargeList?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>Recharge Details</span>\r\n");
      out.write("          <span class='name'>Recharge Details</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/SPconfigList?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>SP Configuration</span>\r\n");
      out.write("          <span class='name'>SP Configuration</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/newDataOwners?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>New Data Owner Details</span>\r\n");
      out.write("          <span class='name'>Data Owner Details</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/ListDataOwners?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>Data Owner Details</span>\r\n");
      out.write("          <span class='name'>Data Owner Details</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/res/jsp/admin/generate_key.jsp\" target=\"f\">\r\n");
      out.write("          <span class='element'>Key Generation</span>\r\n");
      out.write("          <span class='name'>Key Generation</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("       <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/DepartmentList?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>Department</span>\r\n");
      out.write("          <span class='name'>Department</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>   \r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/DesignationList?submit=get\" target=\"f\">\r\n");
      out.write("          <span class='element'>Designation</span>\r\n");
      out.write("          <span class='name'>Designation</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div>\r\n");
      out.write("        <a class='slide' href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp?no=6\">\r\n");
      out.write("          <span class='element'>Logout</span>\r\n");
      out.write("          <span class='name'>Logout</span>\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("  </div>\r\n");
      out.write("  <div class='social-container'>\r\n");
      out.write("    <span>\r\n");
      out.write("      <a class='social-roll github' href='#'></a>\r\n");
      out.write("    </span>\r\n");
      out.write("    <span>\r\n");
      out.write("      <a class='social-roll twitter' href='#'></a>\r\n");
      out.write("    </span>\r\n");
      out.write("    <span>\r\n");
      out.write("      <a class='social-roll linkedin' href='#'></a>\r\n");
      out.write("    </span>\r\n");
      out.write("    <span>\r\n");
      out.write("      <a class='social-roll rss' href='#'></a>\r\n");
      out.write("    </span>\r\n");
      out.write("  </div>\r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("            \r\n");
      out.write("                     \r\n");
      out.write("            \r\n");
      out.write("           <div style=\"position: absolute;top: 160px;left: 300px;\"><iframe  width=\"950px;\" height=\"520px;\" name=\"f\"  frameborder=\"0\" scrolling=\"auto\"></iframe></div>\r\n");
      out.write("            \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("    </body>\r\n");
      out.write("    \r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else log(t.getMessage(), t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
