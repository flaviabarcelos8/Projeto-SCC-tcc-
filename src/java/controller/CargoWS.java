/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CargoDAO;
import dao.LocalizacaoDAO;
import dao.PartidoDAO;
import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author flavi
 */
@WebServlet(name = "CargoWS", urlPatterns = {"/admin/cargo/CargoWS"})
public class CargoWS extends HttpServlet {

    private CargoDAO dao;
    private Cargo obj;
    private String pagina;
    private String acao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acao = request.getParameter("acao");
        List<Cargo> lista = null;
        String id;
        switch (String.valueOf(acao)) {
            case "list":
                dao = new CargoDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(PartidoWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = dao.listar();
                }
                //pra onde deve ser redirecionada a página
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;
            case "del":
                id = request.getParameter("id");
                dao = new CargoDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if (deucerto) {
                    lista = dao.listar();
                    request.setAttribute("lista", lista);
                    request.setAttribute("msg", "Excluído com sucesso");
                } else {
                    request.setAttribute("msg", "Erro ao excluir");
                }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new CargoDAO();
                Cargo obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                pagina = "edita.jsp";
                break;

            case "filter":
                pagina = "index.jsp";
                //pega a informação digitada pelo livro
                String filtro = request.getParameter("txtFiltro");
                List<Cargo> lista2 = this.listar(filtro);
                request.setAttribute("lista", lista2);
                break;
            default:
                dao = new CargoDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(CargoWS.class.getName()).log(Level.SEVERE, null, ex);
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
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    public List<Cargo> listar(String filtro) {
        List<Cargo> lista;
        CargoDAO dao = new CargoDAO();
        lista = dao.listar(filtro);
        dao.fecharConexao();
        return lista;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String msg;
        //verificar campos obrigatórios
        if (request.getParameter("txtCargo") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new CargoDAO();
            obj = new Cargo();
            //preencho o objeto com o que vem do post

            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                request.setCharacterEncoding("UTF-8");
                obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                obj.setCargo(request.getParameter("txtCargo"));
                deucerto = dao.alterar(obj);
                pagina = "edita.jsp";
            } else {
                request.setCharacterEncoding("UTF-8");
                obj.setCargo(request.getParameter("txtCargo"));
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
