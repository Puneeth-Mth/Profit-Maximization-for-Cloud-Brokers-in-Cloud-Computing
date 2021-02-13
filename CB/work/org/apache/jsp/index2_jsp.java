package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <meta charset=\"utf-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("        <title>Bootstrap Login Form Template</title>\r\n");
      out.write("\r\n");
      out.write("        <!-- CSS -->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"http://fonts.googleapis.com/css?family=Roboto:400,100,300,500\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/font-awesome/css/font-awesome.min.css\">\r\n");
      out.write("\t\t<link rel=\"stylesheet\" href=\"assets/css/form-elements.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\r\n");
      out.write("\r\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\r\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\r\n");
      out.write("        <!--[if lt IE 9]>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js\"></script>\r\n");
      out.write("            <script src=\"https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("        <!-- Favicon and touch icons -->\r\n");
      out.write("        <link rel=\"shortcut icon\" href=\"assets/ico/favicon.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"144x144\" href=\"assets/ico/apple-touch-icon-144-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"114x114\" href=\"assets/ico/apple-touch-icon-114-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" sizes=\"72x72\" href=\"assets/ico/apple-touch-icon-72-precomposed.png\">\r\n");
      out.write("        <link rel=\"apple-touch-icon-precomposed\" href=\"assets/ico/apple-touch-icon-57-precomposed.png\">\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("\r\n");


String k=null;
k=request.getParameter("no");
 int no=0;
 if(k!=null)
 {
	 no=Integer.parseInt(k); 
 }




      out.write("\r\n");
      out.write(" \r\n");
      out.write(" ");

if(no==1)
{

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">alert(\"Invalid User ID/Password.....!\");</script>\r\n");
      out.write("\t\r\n");
}else if(no==2)
{

      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("alert(\"SignedUP Successfully.....!\");\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
} else
{
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
} 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Top content -->\r\n");
      out.write("        <div class=\"top-content\">\r\n");
      out.write("        \t\r\n");
      out.write("            <div class=\"inner-bg\">\r\n");
      out.write("                <div class=\"container\">\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-8 col-sm-offset-2 text\">\r\n");
      out.write("                             <h1><strong></strong></h1>\r\n");
      out.write("\r\n");
      out.write("                           \r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-6 col-sm-offset-3 form-box\">\r\n");
      out.write("                        \t<div class=\"form-top\">\r\n");
      out.write("                        \t\t<div class=\"form-top-left\">\r\n");
      out.write("                        \t\t\t<h3>User Login Form</h3>\r\n");
      out.write("                            \t\t<p>Enter your username and password to logon:</p>\r\n");
      out.write("                        \t\t</div>\r\n");
      out.write("                        \t\t<div class=\"form-top-right\">\r\n");
      out.write("                        \t\t\t<i class=\"fa fa-lock\"></i>\r\n");
      out.write("                        \t\t</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <div class=\"form-bottom\">\r\n");
      out.write("\t\t\t                    <form role=\"form\" action=\"");
      out.print(request.getContextPath());
      out.write("/UserLogin\" method=\"post\" class=\"login-form\">\r\n");
      out.write("\t\t\t                    \t<div class=\"form-group\">\r\n");
      out.write("\t\t\t                    \t\t<label class=\"sr-only\" for=\"form-username\">Username</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"text\" name=\"username\" placeholder=\"Username...\" class=\"form-username form-control\" id=\"form-username\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <div class=\"form-group\">\r\n");
      out.write("\t\t\t                        \t<label class=\"sr-only\" for=\"form-password\">Password</label>\r\n");
      out.write("\t\t\t                        \t<input type=\"password\" name=\"password\" placeholder=\"Password...\" class=\"form-password form-control\" id=\"form-password\">\r\n");
      out.write("\t\t\t                        </div>\r\n");
      out.write("\t\t\t                        <button type=\"submit\" class=\"btn\">Sign in!</button>\r\n");
      out.write("\t\t\t                    </form>\r\n");
      out.write("\t\t                    </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"row\">\r\n");
      out.write("                        <div class=\"col-sm-6 col-sm-offset-3 social-login\">\r\n");
      out.write("                        \t<h3>...or login with:</h3>\r\n");
      out.write("                        \t<div class=\"social-login-buttons\">\r\n");
      out.write("\t                        \t<a class=\"btn btn-link-2\" href=\"");
      out.print(request.getContextPath());
      out.write("/index.jsp\">\r\n");
      out.write("\t                        \t\t<i class=\"fa fa-twitter\"></i> Admin\r\n");
      out.write("\t                        \t</a>\r\n");
      out.write("\t                        \t<a class=\"btn btn-link-2\" href=\"");
      out.print(request.getContextPath());
      out.write("/index1.jsp\">\r\n");
      out.write("\t                        \t\t<i class=\"fa fa-twitter\"></i> DataOwner\r\n");
      out.write("\t                        \t</a>\r\n");
      out.write("\t                        \t<a class=\"btn btn-link-2\" href=\"");
      out.print(request.getContextPath());
      out.write("/index2.jsp\">\r\n");
      out.write("\t                        \t\t<i class=\"fa fa-twitter\"></i> User\r\n");
      out.write("\t                        \t</a>\r\n");
      out.write("\t                        \t");
      out.write("\r\n");
      out.write("                        \t</div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <!-- Javascript -->\r\n");
      out.write("        <script src=\"assets/js/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/jquery.backstretch.min.js\"></script>\r\n");
      out.write("        <script src=\"assets/js/scripts.js\"></script>\r\n");
      out.write("        \r\n");
      out.write("        <!--[if lt IE 10]>\r\n");
      out.write("            <script src=\"assets/js/placeholder.js\"></script>\r\n");
      out.write("        <![endif]-->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
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
