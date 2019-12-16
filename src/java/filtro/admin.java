package filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

@WebFilter(filterName = "admin", urlPatterns = {"/admin/*"})
public class admin implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
            
        HttpSession session = ((HttpServletRequest)request).getSession();
        Admin admin = (Admin)session.getAttribute("admin");
        if(admin == null){
            admin = new Admin();
        }
        String path = ((HttpServletRequest)request).getRequestURI();
        
       if((path.startsWith("/SistemaEleicoes/admin/login")
              ||path.startsWith("/SistemaEleicoes/admin/assets/"))||(admin.getId()!=null)){
              chain.doFilter(request, response);
        }else{
            chain.doFilter(request, response);
           // request.setAttribute("msg","Você não está logado no sistema!");
           //a linha abaixo deve ser comentada caso queira fazer o cadastro do 
           //admin e o filtro deixar passar
         ((HttpServletResponse)response).sendRedirect("../login/login.jsp");
        }
        
    }
    @Override
    public void destroy(){
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
      
    }
}
