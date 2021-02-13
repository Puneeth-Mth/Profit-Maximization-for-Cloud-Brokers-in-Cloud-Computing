package org.apache.jsp.res.jsp.owner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import com.util.*;

public final class files_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\r\n");

	ResultSet rs=(ResultSet)Utility.parse2(request.getAttribute("rs"));
	String name=Utility.parse1(request.getParameter("name")); 
	
	System.out.print("name in jsp page"+name);
	int count=1;
	
	

      out.write("\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/pagination.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\" src=\"http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function Validate()\r\n");
      out.write("{\r\n");
      out.write("     var image =document.getElementById(\"image\").value;\r\n");
      out.write("     if(image!='')\r\n");
      out.write("     {\r\n");
      out.write("           var checkimg = image.toLowerCase();\r\n");
      out.write("          if (!checkimg.match(/(\\.jpg|\\.png|\\.JPG|\\.PNG|\\.jpeg|\\.JPEG|\\.xls|\\.xlsx|\\.docx|\\.doc|\\.txt)$/)){ // validation of file extension using regular expression before file upload\r\n");
      out.write("              document.getElementById(\"image\").focus();\r\n");
      out.write("              document.getElementById(\"errorName5\").innerHTML=\"File Format support oly(.jpg|.png|.JPG|.PNG|.jpeg|.JPEG|.xls|.xlsx|.docx|.doc|.txt)\"; \r\n");
      out.write("              return false;\r\n");
      out.write("           }\r\n");
      out.write("            var img = document.getElementById(\"image\"); \r\n");
      out.write("            alert(img.files[0].size);\r\n");
      out.write("            if(img.files[0].size >  1048576)  // validation according to file size\r\n");
      out.write("            {\r\n");
      out.write("            document.getElementById(\"errorName5\").innerHTML=\"Image size too large\";\r\n");
      out.write("            return false;\r\n");
      out.write("             }\r\n");
      out.write("             return true;\r\n");
      out.write("      }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath() );
      out.write("/UploadFile\">\r\n");
      out.write("<button class=\"button button5\" type=\"submit\" name=\"submit\"   value=\"Upload\" id=\"a1\">Upload</button>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("<input type=\"hidden\" name=\"name\" value=\"");
      out.print(name );
      out.write("\"/>\r\n");
      out.write("<button class=\"button button5\" type=\"submit\"   name=\"submit\"  value=\"Delete\"  id=\"a1\">Delete</button>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\"  style=\"top: 1000 ; right:100; width: 800 ; color: black\";>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">Select</font></th>\r\n");
      out.write("\t\t<th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">FileId</font></th>\r\n");
      out.write("\t\t<!-- <th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">UserId</font></th> -->\r\n");
      out.write("\t\t<th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">File_Name</font></th>\r\n");
      out.write("\t\t<th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">Date</font></th>\r\n");
      out.write("\t\t<th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">Time</font></th>\r\n");
      out.write("\t\t<!-- <th><font color=\"#000\" style=\"font-style: bold\" size=\"4\">Day</font></th> -->\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t");

	if(rs!=null)
		while(rs.next())
		{
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(count++ );
      out.write("&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t<input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(rs.getInt(1) );
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t<td><font color=\"#000\" style=\"font-style: bold\" size=\"4\">");
      out.print(rs.getInt(1) );
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<td><font color=\"#000\" style=\"font-style: bold\" size=\"4\">");
      out.print(rs.getString(2) );
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td><font color=\"#000\" style=\"font-style: bold\" size=\"4\">");
      out.print(rs.getString(9) );
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t<td><font color=\"#000\" style=\"font-style: bold\" size=\"4\">");
      out.print(rs.getString(10) );
      out.write("</font></td>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t");
}
	
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"cursor:hand;color: white\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results', 5); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");





	if(Utility.parse(request.getParameter("no"))==2)
    {
    
		
		
    
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("     \r\n");
      out.write("      \t\t\t\r\n");
      out.write("    \t\t\talert('File Uploaded Successfully.....!'+x);\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==1)
	{
	
		
	
	
      out.write("\r\n");
      out.write("\t\t<div class=\"tab1\" style=\"position:absolute;top:250px;left:350px\">\t\r\n");
      out.write("\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<form action=\"");
      out.print(request.getContextPath() );
      out.write("/UploadToCloud?name=");
      out.print(name );
      out.write("\" method=\"post\"  enctype=\"multipart/form-data\" onSubmit=\"return Validate()\";>\r\n");
      out.write("<input type=\"file\" name=\"file\" id=\"image\"/>\r\n");
      out.write("<span id=\"errorName5\" style=\"color: red;\"></span>\r\n");
      out.write("<input type=\"submit\" value=\"Upload\" name=\"Upload File\"/>\r\n");
      out.write("</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\t\t\t\r\n");
      out.write("\t");
}
	if(Utility.parse(request.getParameter("no"))==3)
    {
      out.write("\r\n");
      out.write("    \r\n");
      out.write("       <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Opps select atleast one to delete.....!');\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==4)
    {
      out.write("\r\n");
      out.write("    \r\n");
      out.write("          <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('File Deleted Successfully.....!');\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    \r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==5)
    {
      out.write("\r\n");
      out.write("    \r\n");
      out.write("          <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Network problem.....!');\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    ");
}
	
	if(Utility.parse(request.getParameter("no"))==6)
    {
      out.write("\r\n");
      out.write("    \r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Downloaded Successfully');\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    ");
}
	if(Utility.parse(request.getParameter("no"))==7)
    {
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("    \t\t\talert('Some blocks of file are already exists in the cloud');\r\n");
      out.write("    \t\t\t</script>\t\r\n");
      out.write("    \t\t\r\n");
      out.write("    ");
}
	

      out.write("\t\t\r\n");
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
