package org.apache.jsp.admin.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <!-- Required meta tags-->\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("    <meta name=\"description\" content=\"au theme template\">\n");
      out.write("    <meta name=\"author\" content=\"Hau Nguyen\">\n");
      out.write("    <meta name=\"keywords\" content=\"au theme template\">\n");
      out.write("\n");
      out.write("    <!-- Title Page-->\n");
      out.write("    <title>Login</title>\n");
      out.write("\n");
      out.write("    <!-- Fontfaces CSS-->\n");
      out.write("    <link href=\"css/font-face.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/font-awesome-4.7/css/font-awesome.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/font-awesome-5/css/fontawesome-all.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/mdi-font/css/material-design-iconic-font.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("    <!-- Bootstrap CSS-->\n");
      out.write("    <link href=\"vendor/bootstrap-4.1/bootstrap.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("    <!-- Vendor CSS-->\n");
      out.write("    <link href=\"vendor/animsition/animsition.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/wow/animate.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/css-hamburgers/hamburgers.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/slick/slick.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/select2/select2.min.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("    <link href=\"vendor/perfect-scrollbar/perfect-scrollbar.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("    <!-- Main CSS-->\n");
      out.write("    <link href=\"css/theme.css\" rel=\"stylesheet\" media=\"all\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"animsition\">\n");
      out.write("    <div class=\"page-wrapper\">\n");
      out.write("        <div class=\"page-content--bge5\">\n");
      out.write("            <div class=\"container\">\n");
      out.write("                <div class=\"login-wrap\">\n");
      out.write("                    <div class=\"login-content\">\n");
      out.write("                        <div class=\"login-logo\">\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"login-form\">\n");
      out.write("                            <form action=\"../login/LoginWS\" method=\"post\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Email</label>\n");
      out.write("                                    <input class=\"au-input au-input--full\" type=\"email\" name=\"txtEmail\" placeholder=\"Email\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label>Password</label>\n");
      out.write("                                    <input class=\"au-input au-input--full\" type=\"password\" name=\"txtSenha\" placeholder=\"Senha\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"login-checkbox\">\n");
      out.write("                                    <label>\n");
      out.write("                                        <input type=\"checkbox\" name=\"remember\">Me lembre\n");
      out.write("                                    </label>\n");
      out.write("                                    <label>\n");
      out.write("                                        <a href=\"#\">Recupera a senha</a>\n");
      out.write("                                    </label>\n");
      out.write("                                </div>\n");
      out.write("                                <button class=\"au-btn au-btn--block au-btn--blue m-b-20\" type=\"submit\">Entrar</button>\n");
      out.write("                            </form>\n");
      out.write("                            ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                            \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Jquery JS-->\n");
      out.write("    <script src=\"vendor/jquery-3.2.1.min.js\"></script>\n");
      out.write("    <!-- Bootstrap JS-->\n");
      out.write("    <script src=\"vendor/bootstrap-4.1/popper.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap-4.1/bootstrap.min.js\"></script>\n");
      out.write("    <!-- Vendor JS       -->\n");
      out.write("    <script src=\"vendor/slick/slick.min.js\">\n");
      out.write("    </script>\n");
      out.write("    <script src=\"vendor/wow/wow.min.js\"></script>\n");
      out.write("    <script src=\"vendor/animsition/animsition.min.js\"></script>\n");
      out.write("    <script src=\"vendor/bootstrap-progressbar/bootstrap-progressbar.min.js\">\n");
      out.write("    </script>\n");
      out.write("    <script src=\"vendor/counter-up/jquery.waypoints.min.js\"></script>\n");
      out.write("    <script src=\"vendor/counter-up/jquery.counterup.min.js\">\n");
      out.write("    </script>\n");
      out.write("    <script src=\"vendor/circle-progress/circle-progress.min.js\"></script>\n");
      out.write("    <script src=\"vendor/perfect-scrollbar/perfect-scrollbar.js\"></script>\n");
      out.write("    <script src=\"vendor/chartjs/Chart.bundle.min.js\"></script>\n");
      out.write("    <script src=\"vendor/select2/select2.min.js\">\n");
      out.write("    </script>\n");
      out.write("\n");
      out.write("    <!-- Main JS-->\n");
      out.write("    <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${not empty msg}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                    <div class=\"alert alert-primary alert-dismissible fade show\" role=\"alert\">\n");
        out.write("                        <strong>ERRO:</strong> ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\n");
        out.write("                        <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\n");
        out.write("                            <i class=\"tim-icons icon-simple-remove\"></i>\n");
        out.write("                        </button>\n");
        out.write("                    </div>\n");
        out.write("                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }
}
