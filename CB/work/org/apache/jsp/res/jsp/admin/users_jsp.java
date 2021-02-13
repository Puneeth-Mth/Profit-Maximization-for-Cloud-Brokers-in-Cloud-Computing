package org.apache.jsp.res.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Utility;
import java.sql.ResultSet;
import com.dao.AdminDAO;

public final class users_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<script type=\"text/javascript\" src=\"");
      out.print(request.getContextPath() );
      out.write("/Resources/JS/pagination.js\"></script>\r\n");
      out.write("\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/style_table.css\">\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\tfunction check()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f1.dept.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Department1.\");\r\n");
      out.write("\t\t\tdocument.f1.dept.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.designation.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Designation1.\");\r\n");
      out.write("\t\t\tdocument.f1.designation.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t/* if(document.f1.dept1.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Department2.\");\r\n");
      out.write("\t\t\tdocument.f1.dept1.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.designation1.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Designation2.\");\r\n");
      out.write("\t\t\tdocument.f1.designation1.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t} */\r\n");
      out.write("\t\tif(document.f1.dept.value==document.f1.dept1.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Both The Departments Are Same,Select Different One.\");\r\n");
      out.write("\t\t\tdocument.f1.dept.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f1.designation.value==document.f1.designation1.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Both The Designations Are Same,Select Different One.\");\r\n");
      out.write("\t\t\tdocument.f1.designation.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\tfunction check1()\r\n");
      out.write("\t{\r\n");
      out.write("\t\tif(document.f.dept.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Department1.\");\r\n");
      out.write("\t\t\tdocument.f.dept.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f.designation.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Designation1.\");\r\n");
      out.write("\t\t\tdocument.f.designation.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f.dept1.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Department2.\");\r\n");
      out.write("\t\t\tdocument.f.dept1.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f.designation1.value==0)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Please,Select Your Designation2.\");\r\n");
      out.write("\t\t\tdocument.f.designation1.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f.dept.value==document.f.dept1.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Both The Departments Are Same,Select Different One.\");\r\n");
      out.write("\t\t\tdocument.f.dept.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(document.f.designation.value==document.f.designation1.value)\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\talert(\"Both The Designations Are Same,Select Different One.\");\r\n");
      out.write("\t\t\tdocument.f.designation.focus();\r\n");
      out.write("\t\t\treturn false\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
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
      out.write("<body onload=\"startTimer()\">\r\n");

    AdminDAO adminDAO = null;
   
    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    ResultSet rs1 = null;
    ResultSet rs2 = null;
    int id=0,deptId1=0,designId1=0;
	String username="",password="",name="",city="",mobile="",phone="",address="",email="";
	if(no==1)
	{

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/ListUser\">\r\n");
      out.write("<div align=\"right\" style=\"position:absolute;top:20px;left:150px\">\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Add\" class=\"button button5\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Edit\" class=\"button button5\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Delete\" class=\"button button5\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"LightWeight_Key\" class=\"button button5\"/>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"a3\" align=\"right\" style=\"position:absolute;top:60px;left:2px;width: 650px;height: 350px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("<p>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" border=\"1\" cellpadding=\"5px\" cellspacing=\"4px\" width=\"650px\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"6\" align=\"center\">\r\n");
      out.write("\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">User Details</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Select</th>\r\n");
      out.write("\t\t\t<th>Username</th>\r\n");
      out.write("\t\t\t<th>Name</th>\r\n");
      out.write("\t\t\t<th>Department</th>\r\n");
      out.write("\t\t\t<th>Designation</th>\r\n");
      out.write("\t\t\t<th>Contact</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
 
	
    if(rs != null)
    {
	    while(rs.next())
		{
	    	id=rs.getInt(1);
			username=rs.getString(2);
			name=rs.getString(4);
			deptId1=rs.getInt(5);
			designId1=rs.getInt(6);
			city=rs.getString(8);
			mobile=rs.getString(9);
			email = rs.getString(12);
		    

      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(id);
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(username);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(name);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(adminDAO.getDepartmentName(deptId1));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(adminDAO.getDesignationName(designId1));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(mobile);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");

		}
    }


      out.write("\r\n");
      out.write("  \t </table>\r\n");
      out.write("  \t </p>\r\n");
      out.write("   </div>\r\n");
      out.write(" </form>\r\n");
      out.write("   \r\n");
      out.write("\r\n");
      out.write("<div id=\"pageNavPosition\" style=\"position:absolute;top:420px;left:550px\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results',5); \r\n");
      out.write("        pager.init(); \r\n");
      out.write("        pager.showPageNav('pager', 'pageNavPosition'); \r\n");
      out.write("        pager.showPage(1);\r\n");
      out.write("    //--></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	if(Utility.parse(request.getParameter("no1"))==1)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>User Details Added successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>User Details Updated successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no1"))==3)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Select atleast one checkbox !</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no1"))==4)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Opps,Select only one checkbox to edit!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no1"))==5)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>User Details Deleted successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	
}
	if(no == 2)
	{

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"a3\" align=\"right\" style=\"position:absolute;top:11px;left:11px\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t <p>\r\n");
      out.write("\t\t\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<form name=\"f1\" action=\"");
      out.print(request.getContextPath());
      out.write("/ListUser\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Add\"></input>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"add1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Add User Details</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\"><hr></hr></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"175px\">Username</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"75px\">:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"200px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"username\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td >:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"password\" name=\"password\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"name\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Email</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"email\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Department1</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"dept\" class=\"field1\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"0\">--Select--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    		rs1 = adminDAO.getDepartmentDetails();
								    	      
								    		  while(rs1.next())
								    	      {
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"");
      out.print(rs1.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs1.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      }
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Designation1</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"designation\" class=\"field1\" >\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"0\">--Select--</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t    \r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      rs2 = adminDAO.getDesignationDetails();
								    	      while(rs2.next())
								    	      {
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"");
      out.print(rs2.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs2.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      }
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        <td>Address</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"address\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        <td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t\t<td>City</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"city\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Phone</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"phone\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Mobile</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"mobile\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"button button5\" type=\"submit\" onclick=\"return check();\" value=\"Register\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("</div>\r\n");

		if(Utility.parse(request.getParameter("no1"))==1)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry,This user is already exists  !</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry, Somthing went wrong try again!</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}
		if(Utility.parse(request.getParameter("no1"))==3)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Please,Select Your Department1.</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}


}

if(no == 3)
{
	/* Adding The User Details */
	
	String hostName="";
	
	
	 if(rs != null)
    {
	    while(rs.next())
		{
	    	id=rs.getInt(1);
			username=rs.getString(2);
			password=rs.getString(3);
			name=rs.getString(4);
			deptId1=rs.getInt(5);
			//deptId2=rs.getInt(6);
			designId1=rs.getInt(6);
			//designId2=rs.getInt(8);
			address=rs.getString(7);
			city=rs.getString(8);
			phone=rs.getString(9);
			mobile=rs.getString(10);
			email = rs.getString(11);
			
		}
    }   
	

      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div id=\"a2\" align=\"right\"  style=\"position:absolute;top:11px;left:11px\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t <p>\r\n");
      out.write("\t\t\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t<form name=\"f\" action=\"");
      out.print(request.getContextPath());
      out.write("/ListUser\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Edit\"></input>\r\n");
      out.write("\t\t\t    <input type=\"hidden\" name=\"edit1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Edit User Details</font>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\"><hr></hr></td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"175px\">Username</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"75px\">:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"200px\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"username\" value=\"");
      out.print(username );
      out.write("\" readonly=\"readonly\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Password</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td >:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"password\" name=\"password\" value=\"");
      out.print(password);
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Name</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"name\" value=\"");
      out.print(name );
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Email</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"email\" value=\"");
      out.print(email);
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Department1</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"dept\" class=\"field1\" required=\"yes\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"");
      out.print(deptId1);
      out.write("\" selected=\"selected\">");
      out.print(adminDAO.getDepartmentName(deptId1) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    		rs1 = adminDAO.getDepartmentDetails();
								    	      
								    		  while(rs1.next())
								    	      {
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"");
      out.print(rs1.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs1.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      }
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Designation1</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select name=\"designation\" class=\"field1\" required=\"yes\">\r\n");
      out.write("\t\t\t\t\t\t\t\t    <option value=\"");
      out.print(designId1);
      out.write("\" selected=\"selected\">");
      out.print(adminDAO.getDesignationName(designId1) );
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      rs2 = adminDAO.getDesignationDetails();
								    	      while(rs2.next())
								    	      {
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t \r\n");
      out.write("\t\t\t\t\t\t\t\t    \t<option value=\"");
      out.print(rs2.getInt(1));
      out.write('"');
      out.write('>');
      out.print(rs2.getString(2));
      out.write("</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t");

								    	      }
								    	
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        <td>Address</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"address\" value=\"");
      out.print(address );
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t        <td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t        \r\n");
      out.write("\t\t\t\t\t\t\t<td>City</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"city\" value=\"");
      out.print(city );
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>Phone</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"phone\" value=\"");
      out.print(phone);
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td width=\"50px\"></td>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t<td>Mobile</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"field\" type=\"text\" name=\"mobile\" value=\"");
      out.print(mobile);
      out.write("\" required=\"yes\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"7\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"button button5\" type=\"submit\" onclick=\"return check1();\" value=\"Update\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("</div>\r\n");

		if(Utility.parse(request.getParameter("no1"))==1)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:200px;left:200px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry, Somthing went wrong try again!</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}
		
		if(Utility.parse(request.getParameter("no1"))==2)
		{
			
      out.write("\r\n");
      out.write("\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t<p>Sorry, Somthing went wrong try again!</p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t");

		}


}

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
