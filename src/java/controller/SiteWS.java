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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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

/**
 *
 * @author flavi
 */
@WebServlet(name = "SiteWS", urlPatterns = {"/public/SiteWS"})
public class SiteWS extends HttpServlet {

    private Candidato obj;

    CandidatoDAO dao;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina = null;
        String pg = request.getParameter("pg");
        request.setAttribute("cargos", this.listarCargos());
        request.setAttribute("candidatos", this.listarCandidatos());
        request.setAttribute("partido", this.listarPartido());
        request.setAttribute("partidos", this.listarPartidos());
        request.setAttribute("localizacao", this.listarLocalizacao());

        if (request.getParameter("pg") == null) {
            pg = "";
        }
        switch (pg) {

            case "index":
                pagina = "index.jsp";

                break;
            case "candidatos":
                request.setAttribute("candidatos", this.listarCandidatos());
                pagina = "candidatos.jsp";

                break;
            case "candidato":
                dao = new CandidatoDAO();
                Candidato candidato = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));
                request.setAttribute("obj", candidato);
                request.setAttribute("cargo", this.listarCargos());
                request.setAttribute("partido", this.listarPartido());
                request.setAttribute("localizacao", this.listarLocalizacao());
                pagina = "candidato.jsp";

                break;
            case "partido":
                PartidoDAO pdao = new PartidoDAO();
                Partido partido = pdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));
                request.setAttribute("objp", partido);
                pagina = "partido.jsp";
                break;

            case "partidos":
                request.setAttribute("partido", this.listarPartidos());
                pagina = "partidos.jsp";
                break;

            case "cargos":

                String id = request.getParameter("id");
                CargoDAO dao = new CargoDAO();
                Cargo c = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("candidatos", c.getCandidatos());
                request.setAttribute("c", c);
                dao.fecharConexao();
                pagina = "cargos.jsp";

                break;

            case "localizacaos":
                pagina = "cidade.jsp";
                String id_l = request.getParameter("id");
                LocalizacaoDAO ldao = new LocalizacaoDAO();
                Localizacao l = ldao.buscarPorChavePrimaria(Long.parseLong(id_l));
                request.setAttribute("candidatos", l.getCandidatos());
                request.setAttribute("l", l);
                ldao.fecharConexao();

                break;
         
            default:
                pagina = "index.jsp";

                break;

        }

        RequestDispatcher destino;
        destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    public List<Cargo> listarCargos() {
        CargoDAO dao = new CargoDAO();
        List<Cargo> lista = dao.listar();
        dao.fecharConexao();
        return lista;

    }

    public List<Partido> listarPartido() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partido = dao.listar();
        dao.fecharConexao();
        return partido;

    }

    public List<Partido> listarPartidos() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partidos = dao.listar();
        dao.fecharConexao();
        return partidos;

    }

    public List<Localizacao> listarLocalizacao() {
        LocalizacaoDAO dao = new LocalizacaoDAO();
        List<Localizacao> localizacao = dao.listar();
        dao.fecharConexao();
        return localizacao;

    }

    public List<Candidato> listarCandidatos() {
        CandidatoDAO dao = new CandidatoDAO();
        List<Candidato> candidatos = dao.listar();
        dao.fecharConexao();
        return candidatos;

    }

    public List<Candidato> listar(String filtro) {
        List<Candidato> lista;
        CandidatoDAO dao = new CandidatoDAO();
        lista = dao.listar(filtro);
        dao.fecharConexao();
        return lista;
    }

    public List<Candidato> listar(Long partido, Long localizacao, Long cargo) {
        List<Candidato> lista;
        CandidatoDAO dao = new CandidatoDAO();
        lista = dao.listar(partido, localizacao, cargo);
        dao.fecharConexao();
        return lista;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Long partido = Long.parseLong(request.getParameter("txtPartido"));
        Long localizacao = Long.parseLong(request.getParameter("txtLocalizacao"));
        Long cargo = Long.parseLong(request.getParameter("txtCargo"));

        request.setAttribute("lista", this.listar(partido, localizacao, cargo));
        String pagina = "filtros-lista.jsp";

        RequestDispatcher destino;
        destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
