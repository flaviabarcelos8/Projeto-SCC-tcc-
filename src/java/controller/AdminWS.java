/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
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
import model.Admin;
import util.Criptografia;

/**
 *
 * @author flavi
 */
@WebServlet(name = "AdminWS", urlPatterns = {"/admin/admin/AdminWS"})
public class AdminWS extends HttpServlet {

    private AdminDAO dao;
    private Admin obj;
    private String pagina;
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        List<Admin> lista = null;
        String id;
        switch (String.valueOf(acao)) {
            case "del":
                id = request.getParameter("id");
                dao = new AdminDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Admin adm_sessao = (Admin) request.getSession().getAttribute("admin");
                if (adm_sessao.getId() == Long.parseLong(id)) {
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("msg", "Você não pode excluir o Admin que esta logado.");
                } else {
                    Boolean deucerto = dao.excluir(obj);
                    if (deucerto) {
                        lista = dao.listar();
                        request.setAttribute("lista", lista);
                        request.setAttribute("msg", "Excluído com sucesso");
                    } else {
                        request.setAttribute("msg", "Erro ao excluir");
                    }
                }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new AdminDAO();
                Admin obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;
            case "sair":

                request.getSession().invalidate();
                request.setAttribute("msg", "Você se deslogou com sucesso!");

                ((HttpServletResponse) response).sendRedirect("../login/login.jsp");

                break;
            default:
                dao = new AdminDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = dao.listar();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;

        }
        if (acao !=null && !acao.equals("sair")) {
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg;
        request.setCharacterEncoding("UTF-8");
        //verificar campos obrigatórios
        if (request.getParameter("txtAdmin") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new AdminDAO();
            obj = new Admin();
            //preencho o objeto com o que vem do post

            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                obj.setAdmin(request.getParameter("txtAdmin"));
                obj.setEmail(request.getParameter("txtEmail"));
                try {
                    obj.setSenha(Criptografia.convertPasswordToMD5(request.getParameter("txtSenha")));
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
                }
                deucerto = dao.alterar(obj);
                pagina = "edita.jsp";
            } else {
                obj.setAdmin(request.getParameter("txtAdmin"));
                obj.setEmail(request.getParameter("txtEmail"));
                try {
                    String criptografia = Criptografia.convertPasswordToMD5(request.getParameter("txtSenha"));
                    obj.setSenha(criptografia);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AdminWS.class.getName()).log(Level.SEVERE, null, ex);
                }

                deucerto = dao.incluir(obj);
                pagina = "add.jsp";
            }
            if (deucerto) {
                msg = "Operação realizada com sucesso";
            } else {
                msg = "Erro ao realizar a operação";
            }
        }
        dao.fecharConexao();
        request.setAttribute("msg", msg);
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
