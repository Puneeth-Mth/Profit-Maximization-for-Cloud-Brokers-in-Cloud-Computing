package org.apache.jsp.res.jsp.owner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.dao.OwnerDAO;
import com.util.*;
import java.sql.*;

public final class creditdetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/style.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/message.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/button.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<link href=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/CSS/login.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/style.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write(".button {\r\n");
      out.write("    background-color: #ffba4d; \r\n");
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
      out.write("<body>\r\n");

	String u_user=request.getAttribute("u_user").toString();
	String credit=request.getAttribute("credit").toString();
	int no=Utility.parse(request.getParameter("no"));
	

      out.write("\r\n");
      out.write("\r\n");
      out.write("         \r\n");
      out.write("\t<form class=\"warning\" action=\"");
      out.print(request.getContextPath() );
      out.write("/Recharge\">\r\n");
      out.write("\t\t\t<p>\r\n");
      out.write("\t\t\t\t<center><pre>welcome user [");
      out.print(u_user );
      out.write("]</pre></center><br>\r\n");
      out.write("\t\t\t\tYour current balance is [");
      out.print(credit );
      out.write("]<br>\r\n");
      out.write("\t\t\t\tIf you want to recharge and get more balance<br>\r\n");
      out.write("\t\t\t\tthen enter 10 digit code of recharge voucher<br>\r\n");
      out.write("\t\t\t\tin the text field below........\r\n");
      out.write("\t\t\t</p> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"u_user\" value=\"");
      out.print(u_user );
      out.write("\"></input>\r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"credit\" value=\"");
      out.print(credit );
      out.write("\"></input>\r\n");
      out.write("\t\t\tVoucher Code :- <input class=\"ff\" type=\"text\" name=\"code\" required=\"yes\"><br><br></br>\r\n");
      out.write("\t\t\t<input type=\"submit\" class=\"button\" value=\"Recharge Account\"></input>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t            \r\n");
      out.write("\t\t\t<div class=\"info\">\r\n");
      out.write("\t\t\t\tPlease Note\r\n");
      out.write("\t\t\t\t<li>Do not enter wrong code ...... </li>\r\n");
      out.write("\t\t\t\t<li>If you do not have recharge voucher , get it from your nearest retailer...... </li>\r\n");
      out.write("\t\t\t</div>\r\n");

if(no==2)
	{
      out.write("<div class=\"error\" id=\"message\">OOP's Voucher code is incorrect.....</div>");
}
if(no==1)
	{
      out.write("<div class=\"error\" id=\"message\">OOP's This Voucher Has Been Expired.....</div>");
}
if(no==3)
	{
      out.write("<div class=\"success\" id=\"message\">You account has been credited successfully.....</div>");
}
if(no==4)
	{
      out.write("<div class=\"error\" id=\"message\">OOP's Something Went Wrong.....</div>");
}

      out.write("\r\n");
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
