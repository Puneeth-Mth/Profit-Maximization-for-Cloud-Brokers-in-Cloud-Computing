package org.apache.jsp.res.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Utility;
import java.sql.ResultSet;
import com.dao.AdminDAO;
import com.dao.UserDAO;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public final class select_005ffile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {


	int fileId = 0;
	int ownerid=0;

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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/style_table.css\">\r\n");
      out.write("<style>\r\n");
      out.write(".button {\r\n");
      out.write("    background-color: #FFFFFF; \r\n");
      out.write("    border: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("    padding: 15px 32px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    margin: 4px 2px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".button5 {background-color: #ffba4d;} \r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.file.value.length==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please Select a File\");\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\telse\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\treturn true;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	fileId = Integer.parseInt(request.getParameter("fileId").toString());
    System.out.println(" Download File Id : " + fileId);
    
    ownerid=Integer.parseInt(request.getParameter("ownerid").toString());

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div id=\"a2\" style=\"position:absolute;top:50px;left:50px\" class=\"c\">\r\n");
      out.write("\t<form name=\"f1\" action=\"");
      out.print(request.getContextPath());
      out.write("/ReadFile?fileId=");
      out.print(fileId);
      out.write("&ownerid=");
      out.print(ownerid);
      out.write("\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t    \r\n");
      out.write("\t    <h1 align=\"center\"><font color=\"#000\" style=\"font-style: bold\" size=\"5\">Select Your File Having Key Information</font></h1>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t    \r\n");
      out.write("\t\t<tr id=\"label\" align=\"center\">\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t\t<td align=\"left\">Select Private key:\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" class=\"field2\" name=\"file\" required=\"required\" width=\"150px\"></input>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td align=\"left\">Select pseudo key:\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t<input type=\"file\" class=\"field2\" name=\"file2\" required=\"required\" width=\"150px\"></input>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t<button class=\"button button5\" type=\"submit\" name=\"submit\" value=\"Download File\">Download File</button>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t    </tr>\r\n");
      out.write("\t\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("</body>\r\n");
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
