package org.apache.jsp.admin.candidato;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class add_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/admin/candidato/../cabecalho.jsp");
    _jspx_dependants.add("/admin/candidato/../rodape.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
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

      out.write('\n');
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\" />\n");
      out.write("  <link rel=\"apple-touch-icon\" sizes=\"76x76\" href=\"../assets/img/apple-icon.png\">\n");
      out.write("  <link rel=\"icon\" type=\"image/png\" href=\"../assets/img/favicon.png\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge,chrome=1\" />\n");
      out.write("  <title>\n");
      out.write("    SCC - Sistema para Cadastro de Candidatos\n");
      out.write("  </title>\n");
      out.write("  <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />\n");
      out.write("  <!--     Fonts and icons     -->\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700,200\" rel=\"stylesheet\" />\n");
      out.write("  <link href=\"https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("  <!-- CSS Files -->\n");
      out.write("  <link href=\"../assets/css/bootstrap.min.css\" rel=\"stylesheet\" />\n");
      out.write("  <link href=\"../assets/css/paper-dashboard.css?v=2.0.0\" rel=\"stylesheet\" />\n");
      out.write("  <!-- CSS Just for demo purpose, don't include it in your project -->\n");
      out.write("  <link href=\"../assets/demo/demo.css\" rel=\"stylesheet\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body class=\"\">\n");
      out.write("  <div class=\"wrapper \">\n");
      out.write("    <div class=\"sidebar\" data-color=\"white\" data-active-color=\"DeepSkyBlue\">\n");
      out.write("      <!--\n");
      out.write("        Tip 1: You can change the color of the sidebar using: data-color=\"blue | green | orange | red | yellow\"\n");
      out.write("    -->\n");
      out.write("      <div class=\"logo\">\n");
      out.write("        <a href=\"http://www.creative-tim.com\" class=\"simple-text logo-mini\">\n");
      out.write("           <i class=\"nc-icon nc-circle-10\"></i>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"http://www.creative-tim.com\" class=\"simple-text logo-normal\">\n");
      out.write("          Admin\n");
      out.write("          <!-- <div class=\"logo-image-big\">\n");
      out.write("            <img src=\"../assets/img/logo-big.png\">\n");
      out.write("          </div> -->\n");
      out.write("        </a>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"sidebar-wrapper\">\n");
      out.write("        <ul class=\"nav\">\n");
      out.write("          <li class=\"active \">\n");
      out.write("            <a href=\"../admin/AdminWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-single-02\"></i>\n");
      out.write("              <p>Admin</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../partido/PartidoWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-briefcase-24\"></i>\n");
      out.write("              <p>Partido</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../cargo/CargoWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-badge\"></i>\n");
      out.write("              <p>Cargo</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../localizacao/LocalizacaoWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-pin-3\"></i>\n");
      out.write("              <p>Localização</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../topico/TopicoWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-bullet-list-67\"></i>\n");
      out.write("              <p>Topico</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../candidato/CandidatoWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-single-02\"></i>\n");
      out.write("              <p>Candidato</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li>\n");
      out.write("            <a href=\"../proposta/PropostaWS?acao=list\">\n");
      out.write("              <i class=\"nc-icon nc-paper\"></i>\n");
      out.write("              <p>Proposta</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("          <li class=\"active-pro\">\n");
      out.write("            <a href=\"./upgrade.html\">\n");
      out.write("              <i class=\"nc-icon nc-spaceship\"></i>\n");
      out.write("              <p>Upgrade to PRO</p>\n");
      out.write("            </a>\n");
      out.write("          </li>\n");
      out.write("        </ul>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"main-panel\">\n");
      out.write("      <!-- Navbar -->\n");
      out.write("      <nav class=\"navbar navbar-expand-lg navbar-absolute fixed-top navbar-transparent\">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <div class=\"navbar-wrapper\">\n");
      out.write("            <div class=\"navbar-toggle\">\n");
      out.write("              <button type=\"button\" class=\"navbar-toggler\">\n");
      out.write("                <span class=\"navbar-toggler-bar bar1\"></span>\n");
      out.write("                <span class=\"navbar-toggler-bar bar2\"></span>\n");
      out.write("                <span class=\"navbar-toggler-bar bar3\"></span>\n");
      out.write("              </button>\n");
      out.write("            </div>\n");
      out.write("            <a class=\"navbar-brand\" href=\"#pablo\">Sistema para Cadastro de Candidatos</a>\n");
      out.write("          </div>\n");
      out.write("          <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navigation\" aria-controls=\"navigation-index\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("            <span class=\"navbar-toggler-bar navbar-kebab\"></span>\n");
      out.write("            <span class=\"navbar-toggler-bar navbar-kebab\"></span>\n");
      out.write("            <span class=\"navbar-toggler-bar navbar-kebab\"></span>\n");
      out.write("          </button>\n");
      out.write("          <div class=\"collapse navbar-collapse justify-content-end\" id=\"navigation\">\n");
      out.write("            <form>\n");
      out.write("              <div class=\"input-group no-border\">\n");
      out.write("                <input type=\"text\" value=\"\" class=\"form-control\" placeholder=\"Pesquise...\">\n");
      out.write("                <div class=\"input-group-append\">\n");
      out.write("                  <div class=\"input-group-text\">\n");
      out.write("                    <i class=\"nc-icon nc-zoom-split\"></i>\n");
      out.write("                  </div>\n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("            </form>\n");
      out.write("            <ul class=\"navbar-nav\">\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link btn-magnify\" href=\"#pablo\">\n");
      out.write("                  <i class=\"nc-icon nc-layout-11\"></i>\n");
      out.write("                  <p>\n");
      out.write("                    <span class=\"d-lg-none d-md-block\">Stats</span>\n");
      out.write("                  </p>\n");
      out.write("                </a>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item btn-rotate dropdown\">\n");
      out.write("                <a class=\"nav-link dropdown-toggle\" href=\"http://example.com\" id=\"navbarDropdownMenuLink\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                  <i class=\"nc-icon nc-bell-55\"></i>\n");
      out.write("                  <p>\n");
      out.write("                    <span class=\"d-lg-none d-md-block\">Some Actions</span>\n");
      out.write("                  </p>\n");
      out.write("                </a>\n");
      out.write("                <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"navbarDropdownMenuLink\">\n");
      out.write("                  <a class=\"dropdown-item\" href=\"#\">Action</a>\n");
      out.write("                  <a class=\"dropdown-item\" href=\"#\">Another action</a>\n");
      out.write("                  <a class=\"dropdown-item\" href=\"#\">Something else here</a>\n");
      out.write("                </div>\n");
      out.write("              </li>\n");
      out.write("              <li class=\"nav-item\">\n");
      out.write("                <a class=\"nav-link btn-rotate\" href=\"#pablo\">\n");
      out.write("                  <i class=\"nc-icon nc-settings-gear-65\"></i>\n");
      out.write("                  <p>\n");
      out.write("                    <span class=\"d-lg-none d-md-block\">Account</span>\n");
      out.write("                  </p>\n");
      out.write("                </a>\n");
      out.write("              </li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </nav>\n");
      out.write("      <!-- End Navbar -->");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"content\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-md-8\">\n");
      out.write("            <div class=\"card card-user\">\n");
      out.write("              <div class=\"card-header\">\n");
      out.write("                <h5 class=\"card-title\">Cadastro</h5>\n");
      out.write("              </div>\n");
      out.write("              <div class=\"card-body\">\n");
      out.write("                <form action=\"UploadWS\" method=\"POST\" enctype=\"multipart/form-data\">\n");
      out.write("            <input type=\"hidden\" name=\"urldestino\" value=\"CandidatoWS\">\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Nome e Sobrenome:</label>\n");
      out.write("                        <input type=\"text\" name=\"txtNome\" required class=\"form-control\" placeholder=\"\" >\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Idade:</label>\n");
      out.write("                        <input type=\"number\" name=\"txtIdade\" required class=\"form-control\" placeholder=\"\" >\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>N° candidato:</label>\n");
      out.write("                        <input type=\"number\" name=\"txtNum\" required class=\"form-control\" placeholder=\"\" >\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Biografia:</label>\n");
      out.write("                        <input type=\"text\" name=\"txtBio\" required class=\"form-control\" placeholder=\"\" >\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                       <label for=\"file\">Foto</label>\n");
      out.write("                        <input type=\"file\" name=\"txtFoto\" required class=\"form-control form-control-file\" placeholder=\"\">\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                       <div class=\"form-group\">\n");
      out.write("                       <label for=\"file\">Planos PDF</label>\n");
      out.write("                        <input type=\"file\" name=\"txtPDF\" required class=\"form-control form-control-file\"placeholder=\"\">\n");
      out.write("                      </div>\n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Cargo</label>\n");
      out.write("                        <select class=\"form-control\" name=\"txtCargo\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select> \n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Partido</label>\n");
      out.write("                        <select class=\"form-control\" name=\"txtPartido\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_1(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select> \n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                      <div class=\"col-md-5 pr-1\">\n");
      out.write("                      <div class=\"form-group\">\n");
      out.write("                        <label>Localizacao</label>\n");
      out.write("                        <select class=\"form-control\" name=\"txtLocalizacao\">\n");
      out.write("                            ");
      if (_jspx_meth_c_forEach_2(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                        </select> \n");
      out.write("                      </div>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                  <div class=\"row\">\n");
      out.write("                    <div class=\"update ml-auto mr-auto\">\n");
      out.write("                      <button type=\"submit\" class=\"btn btn-primary btn-round\">Salvar</button>\n");
      out.write("                      <a class=\"btn btn-primary btn-round text-center\" href=\"CandidatoWS?acao=list\">\n");
      out.write("                <i class=\"tim-icons icon-bullet-list-67\"></i> Listar\n");
      out.write("            </a>\n");
      out.write("                    </div>\n");
      out.write("                  </div>\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write(" <footer class=\"footer footer-black  footer-white \">\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("          <div class=\"row\">\n");
      out.write("            <nav class=\"footer-nav\">\n");
      out.write("              <ul>\n");
      out.write("                <li>\n");
      out.write("                  <a href=\"https://www.creative-tim.com\" target=\"_blank\">Creative Tim</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                  <a href=\"http://blog.creative-tim.com/\" target=\"_blank\">Blog</a>\n");
      out.write("                </li>\n");
      out.write("                <li>\n");
      out.write("                  <a href=\"https://www.creative-tim.com/license\" target=\"_blank\">Licenses</a>\n");
      out.write("                </li>\n");
      out.write("              </ul>\n");
      out.write("            </nav>\n");
      out.write("            <div class=\"credits ml-auto\">\n");
      out.write("              <span class=\"copyright\">\n");
      out.write("                ©\n");
      out.write("                <script>\n");
      out.write("                  document.write(new Date().getFullYear())\n");
      out.write("                </script>, made with <i class=\"fa fa-heart heart\"></i> by Creative Tim\n");
      out.write("              </span>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </footer>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  <!--   Core JS Files   -->\n");
      out.write("  <script src=\"../assets/js/core/jquery.min.js\"></script>\n");
      out.write("  <script src=\"../assets/js/core/popper.min.js\"></script>\n");
      out.write("  <script src=\"../assets/js/core/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"../assets/js/plugins/perfect-scrollbar.jquery.min.js\"></script>\n");
      out.write("  <!--  Google Maps Plugin    -->\n");
      out.write("  <script src=\"https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE\"></script>\n");
      out.write("  <!-- Chart JS -->\n");
      out.write("  <script src=\"../assets/js/plugins/chartjs.min.js\"></script>\n");
      out.write("  <!--  Notifications Plugin    -->\n");
      out.write("  <script src=\"../assets/js/plugins/bootstrap-notify.js\"></script>\n");
      out.write("  <!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->\n");
      out.write("  <script src=\"../assets/js/paper-dashboard.min.js?v=2.0.0\" type=\"text/javascript\"></script>\n");
      out.write("  <!-- Paper Dashboard DEMO methods, don't include it in your project! -->\n");
      out.write("  <script src=\"../assets/demo/demo.js\"></script>\n");
      out.write("  <script>\n");
      out.write("    $(document).ready(function() {\n");
      out.write("      // Javascript method's body can be found in assets/assets-for-demo/js/demo.js\n");
      out.write("      demo.initChartsPages();\n");
      out.write("    });\n");
      out.write("  </script>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cargo}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_0.setVar("obj");
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.cargo}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_1.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_1.setParent(null);
    _jspx_th_c_forEach_1.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${partido}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_1.setVar("obj");
    int[] _jspx_push_body_count_c_forEach_1 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_1 = _jspx_th_c_forEach_1.doStartTag();
      if (_jspx_eval_c_forEach_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.partido}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_1.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_1);
    }
    return false;
  }

  private boolean _jspx_meth_c_forEach_2(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_2 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_2.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_2.setParent(null);
    _jspx_th_c_forEach_2.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${localizacao}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    _jspx_th_c_forEach_2.setVar("obj");
    int[] _jspx_push_body_count_c_forEach_2 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_2 = _jspx_th_c_forEach_2.doStartTag();
      if (_jspx_eval_c_forEach_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.id}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${obj.localizacao}", java.lang.String.class, (PageContext)_jspx_page_context, null));
          out.write("</option>\n");
          out.write("                            ");
          int evalDoAfterBody = _jspx_th_c_forEach_2.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_2[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_2.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_2.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_2);
    }
    return false;
  }
}
