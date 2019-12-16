/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CargoDAO;
import dao.LocalizacaoDAO;
import dao.PartidoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cargo;
import model.Localizacao;
import model.Partido;
import model.Usuario;
import util.Criptografia;

/**
 *
 * @author flavi
 */
@WebServlet(name = "LogarUsuarioWS", urlPatterns = {"/public/LogarUsuarioWS"})
public class LogarUsuarioWS extends HttpServlet {
   String acao;
      
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String email = request.getParameter("txtEmailLogar");
        String senha;
        String pagina;
        
        try {
            senha = Criptografia.convertPasswordToMD5(request.getParameter("txtSenha"));
            UsuarioDAO dao = new UsuarioDAO();
            Usuario usuario = dao.fazerLogin(email, senha);
            if(usuario.getId()!=null){
                request.getSession().setAttribute("usuario",usuario);
                response.sendRedirect("./SiteWS");
             //   pagina = "../public/index.jsp";
            }else{
                request.setAttribute("msg", "Senha e/ou Login incorretos!");
                pagina = "login.jsp";
                RequestDispatcher destino = request.getRequestDispatcher(pagina);
                destino.forward(request, response);
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LogarUsuarioWS.class.getName()).log(Level.SEVERE, null, ex);
        }
}
 private List<Partido> listaPartido() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partidos = dao.listar();
        dao.fecharConexao();
        return partidos;
    }

    private List<Cargo> listaCargo() {
        CargoDAO dao = new CargoDAO();
        List<Cargo> cargos = dao.listar();
        dao.fecharConexao();
        return cargos;
    }

    private List<Localizacao> listaLocalizacao() {
        LocalizacaoDAO dao = new LocalizacaoDAO();
        List<Localizacao> localizacao = dao.listar();
        dao.fecharConexao();
        return localizacao;
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
