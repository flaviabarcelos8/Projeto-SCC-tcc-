/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import dao.CargoDAO;
import dao.LocalizacaoDAO;
import dao.PartidoDAO;
import dao.UsuarioDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Candidato;
import model.Cargo;
import model.Localizacao;
import model.Partido;
import model.Usuario;
import util.Criptografia;
import util.FormataData;

/**
 *
 * @author flavi
 */
@WebServlet(name = "UsuarioWS", urlPatterns = {"/public/UsuarioWS"})
public class UsuarioWS extends HttpServlet {

    private UsuarioDAO dao;
    private Usuario obj;
    private String pagina;
    private String acao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        acao = request.getParameter("acao");
        List<Usuario> lista = null;
        String id;
        
        
        switch (String.valueOf(acao)) {
            case "del":
                Usuario adm_sessao = (Usuario) request.getSession().getAttribute("usuario");
                dao = new UsuarioDAO();
                obj = dao.buscarPorChavePrimaria(adm_sessao.getId());
                Boolean deucerto = dao.excluir(obj);
                    if (deucerto) {
                        request.getSession().invalidate();
                        request.setAttribute("msg", "Excluído com sucesso");
                        pagina = "index.jsp";
                    } else {                       
                        request.setAttribute("msg", "Erro ao excluir");
                         pagina = "perfil-user.jsp";
                    }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new UsuarioDAO();
                Usuario obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "perfil-user.jsp";
                break;
            case "sair":
                request.getSession().invalidate();
                request.setAttribute("msg", "Você se deslogou com sucesso!");
                pagina = "login.jsp";
                break;
            default:
                dao = new UsuarioDAO();

                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;

        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg;
        request.setCharacterEncoding("UTF-8");
        //verificar campos obrigatórios
        if (request.getParameter("txtEmail") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new UsuarioDAO();
            obj = new Usuario();
            //preencho o objeto com o que vem do post

            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                obj.setNome(request.getParameter("txtNome"));
                obj.setEmail(request.getParameter("txtEmail"));
                obj.setSobrenome(request.getParameter("txtSobrenome"));
                obj.setEndFoto(request.getParameter("txtFoto"));
               
                try {
                    obj.setSenha(Criptografia.convertPasswordToMD5(request.getParameter("txtSenha")));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(UsuarioWS.class.getName()).log(Level.SEVERE, null, ex);
                }
                deucerto = dao.alterar(obj);
                  RequestDispatcher destino = request.getRequestDispatcher(pagina);
                destino.forward(request, response);
                pagina = "login.jsp";
            } else {
                obj.setNome(request.getParameter("txtNome"));
                obj.setEmail(request.getParameter("txtEmail"));
                obj.setSobrenome(request.getParameter("txtSobrenome"));
                obj.setEndFoto(request.getParameter("txtFoto"));

                try {
                    String criptografia = Criptografia.convertPasswordToMD5(request.getParameter("txtSenha"));
                    obj.setSenha(criptografia);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(UsuarioWS.class.getName()).log(Level.SEVERE, null, ex);
                }

                deucerto = dao.incluir(obj);
                request.getSession().setAttribute("usuario", obj);
                
              response.sendRedirect("./SiteWS");
            }
            if (deucerto) {

                msg = "Operação realizada com sucesso";
            } else {
                msg = "Erro ao realizar a operação";

            }
        }

        dao.fecharConexao();
        request.setAttribute("msg", msg);
       
    }
 
}
