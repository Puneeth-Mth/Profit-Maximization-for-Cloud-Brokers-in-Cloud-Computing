package org.apache.jsp.res.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.util.Utility;
import java.sql.ResultSet;
import com.dao.*;

public final class Config_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" <link rel=\"stylesheet\" href=\"css/style_table.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body onload=\"startTimer()\">\r\n");

    int no=Utility.parse(request.getParameter("no"));
    ResultSet rs=(ResultSet)request.getAttribute("rs");
    int id=0;
	String status="";
	int quality=0,url=0,size=0,cost=0;
	if(no==1)
	{

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<form action=\"");
      out.print(request.getContextPath());
      out.write("/SPconfigList\">\r\n");
      out.write("<div align=\"right\" style=\"position:absolute;top:30px;left:450px\">\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"submit\" name=\"submit\" value=\"Edit\" class=\"button button5\"/>\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"a3\" align=\"right\" style=\"position:absolute;top:75px;left:11px;width: 650px;height: 300px;\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("<p>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"results\" class=\"tab\" border=\"1\" cellpadding=\"5px\" cellspacing=\"4px\" width=\"550px\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<td colspan=\"8\" align=\"center\">\r\n");
      out.write("\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Cloud Service Provider Configuration Details</font>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>Select</th>\r\n");
      out.write("\t\t\t<th>Service Provider</th>\r\n");
      out.write("\t\t\t<th>Cloud Size</th>\r\n");
      out.write("\t\t\t<th>Cloud Cost</th>\r\n");
      out.write("\t\t\t<th>Cloud Quality</th>\r\n");
      out.write("\t\t\t<th>Cloud Status</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
 
	
    if(rs != null)
    {
	    while(rs.next())
		{
			id=rs.getInt(1);
			url=rs.getInt(2);
			size=rs.getInt(3);
			cost=rs.getInt(4);
			quality=rs.getInt(5);
			status=rs.getString(6);
		    

      out.write("\r\n");
      out.write("\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t<td><input name=\"chk\" type=\"checkbox\" value=\"");
      out.print(id);
      out.write("\"></td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(AdminDAO.geturl(url));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(size);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");
      out.print(cost);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t\t<td>");

				int qty=quality;
				String qty1="";
				if(qty==0)
					qty1="Low";
				if(qty==1)
					qty1="Good";
				if(qty==2)
					qty1="Very Good";
				if(qty==3)
					qty1="Excellent";
			
      out.print(qty1 );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print(status);
      out.write("</td>\t\r\n");
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
      out.write("<div id=\"pageNavPosition\" style=\"position:absolute;top:380px;left:575px\"></div>\r\n");
      out.write("<script type=\"text/javascript\"><!--\r\n");
      out.write("        var pager = new Pager('results',6); \r\n");
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
      out.write("\t\t\t\t<p>Server Details Added successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
	if(Utility.parse(request.getParameter("no1"))==2)
	{
		
      out.write("\r\n");
      out.write("\t\t\t<div class=\"success\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t<p>Server Details Updated successfully ..!</p>\r\n");
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
      out.write("\t\t\t\t<p>Server Details Deleted successfully ..!</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t");

	}
}
	if(no == 3)
	{
		/* Adding The Server Details */
		
		int s_code=0,s_id=0,s_size=0,s_cost=0,s_qty=0;
		String s_status="";
		
		 if(rs != null)
	    {
		    while(rs.next())
			{
		    	s_code=rs.getInt(1);
				s_id=rs.getInt(2);
				s_size=rs.getInt(3);
				s_cost=rs.getInt(4);
				s_qty=rs.getInt(5);
				s_status=rs.getString(6);
				
				
			}
	    }   
	
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"a2\" align=\"right\" style=\"position:absolute;top:50px;left:25px\">\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t <p>\r\n");
      out.write("\t\t\t\t<table id=\"login\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<form action=\"");
      out.print(request.getContextPath());
      out.write("/SPconfigList\">\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"submit\" value=\"Edit\"></input>\r\n");
      out.write("\t\t\t\t    <input type=\"hidden\" name=\"edit1\" value=\"YES\"></input>\r\n");
      out.write("\t\t\t\t    <input type=\"hidden\" name=\"id\" value=\"");
      out.print(id );
      out.write("\"></input>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<font color=\"#000000\" style=\"font-style: bold\" size=\"5\">Edit Cloud Service Provider Configuration Details</font>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\"><hr></hr></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"175px\">Service Provider Name</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"75px\">:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td width=\"200px\"><input class=\"field\" type=\"text\" name=\"host\" value=\"");
      out.print(AdminDAO.geturl(s_id));
      out.write("\" readonly></input>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"s_code\" value=\"");
      out.print(s_code );
      out.write("\"></input></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Cloud Size</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td >:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<select class=\"field\" style=\"color:black\" name=\"s_size\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"10\">10 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"20\">20 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"50\">50 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"100\">100 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"200\">200 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"300\">300 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"500\">500 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1000\">1000 MB</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Storage Cost (Per KB) </td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<select class=\"field\" style=\"color:black\" name=\"s_cost\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"5\">5 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"10\">10 RS</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"15\">15 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"20\">20 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"25\">25 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"30\">30 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"35\">35 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"40\">40 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"50\">50 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"75\">75 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<option value=\"100\">100 Rs</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Storage Quality</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t <select class=\"field1\" name=\"s_qty\" required=\"yes\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t \t\t<option value=\"0\">Poor</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"1\">Good</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"2\">Very Good</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"3\">Excellent</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t </select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>Status</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>:</td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t <select class=\"field1\" name=\"status\" required=\"yes\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t \t\t<option value=\"Active\">Active</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<option value=\"Deactive\">Deactive</option>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t </select>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td>&nbsp;</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<td colspan=\"3\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<input class=\"button button5\" type=\"submit\"  value=\"Update Server\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t</p>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t");

			if(Utility.parse(request.getParameter("no1"))==1)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t\t<p>Sorry, Somthing went wrong try again!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

			}
			
			if(Utility.parse(request.getParameter("no1"))==2)
			{
				
      out.write("\r\n");
      out.write("\t\t\t\t\t<div class=\"error\" id=\"message\" style=\"position:absolute;top:5px;left:50px\">\t\r\n");
      out.write("\t\t\t\t\t\t<p>Sorry, Somthing went wrong try again!</p>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

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
