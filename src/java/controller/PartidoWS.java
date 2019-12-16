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
@WebServlet(name = "PartidoWS", urlPatterns = {"/admin/partido/PartidoWS", "/public/PartidoWS"})
public class PartidoWS extends HttpServlet {

    private PartidoDAO dao;
    private Partido objp;
    private String pagina;
    private String acao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acao = request.getParameter("acao");
        List<Partido> lista = null;
        String id;
        switch (String.valueOf(acao)) {

            case "list":
                dao = new PartidoDAO();
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
                request.setAttribute("localizacao", this.listaLocalizacao());
                request.setAttribute("cargos", this.listarCargos());
                request.setAttribute("partidos", this.listaPartidos());
                pagina = "index.jsp";
                //passar a listagem para a página
                request.setAttribute("lista", lista);
                break;
            case "del":
                id = request.getParameter("id");
                dao = new PartidoDAO();
                pagina = "index.jsp";
                objp = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(objp);
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
                dao = new PartidoDAO();
                Partido objp = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("objp", objp);
                pagina = "edita.jsp";
                break;
            case "partido":
                dao = new PartidoDAO();
                Partido partido = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));
                request.setAttribute("objp", partido);
                request.setAttribute("localizacao", this.listaLocalizacao());
                request.setAttribute("cargos", this.listarCargos());
                request.setAttribute("partidos", this.listaPartidos());
                pagina = "partido.jsp";
                break;
            case "filter":
                pagina = "index.jsp";
                //pega a informação digitada pelo livro
                String filtro = request.getParameter("txtFiltro");
                List<Partido> lista2 = this.listar(filtro);
                request.setAttribute("lista", lista2);
                break;
            default:
                dao = new PartidoDAO();
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

        }
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg;

        //verificar campos obrigatórios
        if (request.getParameter("txtPartido") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new PartidoDAO();
            objp = new Partido();
            //preencho o objeto com o que vem do post

            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                request.setCharacterEncoding("UTF-8");
                objp = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                objp.setPartido(request.getParameter("txtPartido"));
                objp.setBio(request.getParameter("txtBio"));
                objp.setFavoravel(request.getParameter("txtFavoravel"));
                objp.setInfoadicional(request.getParameter("txtInfoadicional"));
                objp.setFotopartido(request.getParameter("txtFotoPartido"));
                objp.setNumpartido(request.getParameter("txtNumPartido"));
                deucerto = dao.alterar(objp);
                pagina = "edita.jsp";
            } else {
                request.setCharacterEncoding("UTF-8");
                objp.setPartido(request.getParameter("txtPartido"));
                objp.setFavoravel(request.getParameter("txtFavoravel"));
                objp.setInfoadicional(request.getParameter("txtInfoadicional"));
                objp.setBio(request.getParameter("txtBio"));
                objp.setFotopartido(request.getParameter("txtFotoPartido"));
                objp.setNumpartido(request.getParameter("txtNumPartido"));
                deucerto = dao.incluir(objp);
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

    private List<Partido> listaPartidos() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partidos = dao.listar();
        dao.fecharConexao();
        return partidos;
    }
    
    public List<Partido> listar(String filtro) {
        List<Partido> lista;
        PartidoDAO dao = new PartidoDAO();
        lista = dao.listar(filtro);
        dao.fecharConexao();
        return lista;
    }


    private Partido buscaPorPK(Long id) {
        PartidoDAO dao = new PartidoDAO();
        Partido partido = dao.buscarPorChavePrimaria(id);
        dao.fecharConexao();
        return partido;

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

    public List<Cargo> listarCargos() {
        CargoDAO dao = new CargoDAO();
        List<Cargo> lista = dao.listar();
        dao.fecharConexao();
        return lista;

    }
}
