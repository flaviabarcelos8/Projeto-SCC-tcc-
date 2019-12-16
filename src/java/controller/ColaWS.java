/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import dao.CargoDAO;
import dao.ColaDAO;
import dao.LocalizacaoDAO;
import dao.PartidoDAO;
import dao.UsuarioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Candidato;
import model.Cargo;
import model.Cola;
import model.Localizacao;
import model.Partido;

import model.Usuario;

/**
 *
 * @author flavi
 */
@WebServlet(name = "ColaWS", urlPatterns = {"/public/ColaWS"})
public class ColaWS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao;
        // List<Candidato> lista;
        Cola cola;
        String pagina;
        acao = request.getParameter("acao");
        HttpSession session = request.getSession(true);
        String id;
        request.setAttribute("cargos", this.listaCargo());
        request.setAttribute("candidatos", this.listaCandidatos());
        request.setAttribute("partido", this.listaPartido());
        request.setAttribute("partidos", this.listarPartidos());
        request.setAttribute("localizacao", this.listaLocalizacao());
        switch (String.valueOf(acao)) {
            case "list":
                Usuario usuario = (Usuario) session.getAttribute("usuario");
                UsuarioDAO dao2 = new UsuarioDAO();
                usuario = dao2.buscarPorChavePrimaria(usuario.getId());

                Cola obj = usuario.getCola();
                //List<Candidato> candidatos = obj.getCandidatos();
                //obj.setCandidatos(candidatos);
                pagina = "cola.jsp";
                request.setAttribute("cola", obj);

                break;
            case "del":
                CandidatoDAO cdao = new CandidatoDAO();
                id = request.getParameter("id");
                Candidato candidato = cdao.buscarPorChavePrimaria(Long.parseLong(id));

                ColaDAO dao = new ColaDAO();

                Usuario usuario1 = (Usuario) session.getAttribute("usuario");
                UsuarioDAO udao = new UsuarioDAO();
                usuario1 = udao.buscarPorChavePrimaria(usuario1.getId());
                cola = usuario1.getCola();
                List<Candidato> candidatos = cola.getCandidatos();

                candidatos.remove(candidato);

                cola.setCandidatos(candidatos);
                Boolean deucerto = dao.alterar(cola);
                dao.fecharConexao();

                pagina = "cola.jsp";
                if (deucerto) {

                    request.setAttribute("cola", cola);
                    request.setAttribute("msg", "Excluído com sucesso");
                } else {
                    request.setAttribute("msg", "Erro ao excluir");
                }
                break;

        }
        pagina = "cola.jsp";
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pagina;
        CandidatoDAO dao = new CandidatoDAO();
        Candidato candidato = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
        //  Cola cola = (Cola) request.getSession().getAttribute("cola");
        //  Favorito obj = new Favorito();
        HttpSession session = request.getSession(true);

        Usuario usuario = (Usuario) session.getAttribute("usuario");

        if (usuario == null) {
            request.setAttribute("msg", "Opss! Você precisa se logar antes.");
            //response.sendRedirect("./LogarUsuarioWS");
            request.setAttribute("obj", candidato);
            request.setAttribute("partido", this.listaPartido());
            request.setAttribute("cargo", this.listaCargo());
            request.setAttribute("localizacao", this.listaLocalizacao());
            pagina = "candidato.jsp";

        } else {
            UsuarioDAO usuariodao = new UsuarioDAO();
            usuario = usuariodao.buscarPorChavePrimaria(usuario.getId());
            Cola obj = usuario.getCola();
            List<Candidato> candidatos;

            if (obj == null) {
                obj = new Cola();
                candidatos = new ArrayList<>();
            } else {
                candidatos = obj.getCandidatos();
            }
            if (candidatos.indexOf(candidato) < 0) {
                candidatos.add(candidato);
                obj.setCandidatos(candidatos);
                obj.setUsuario(usuario);
                ColaDAO dao1 = new ColaDAO();
                dao1.alterar(obj);
                request.setAttribute("msg", "Candidato adicionado a cola");
            } else {
                request.setAttribute("msg", " Esse candidato já existe na cola");
            }

            request.setAttribute("obj", candidato);
            request.setAttribute("partido", this.listaPartido());
            request.setAttribute("cargo", this.listaCargo());
            request.setAttribute("localizacao", this.listaLocalizacao());
            request.setAttribute("cargos", this.listaCargo());
            request.setAttribute("candidatos", this.listaCandidatos());
            request.setAttribute("partido", this.listaPartido());
            request.setAttribute("partidos", this.listarPartidos());
            request.setAttribute("localizacao", this.listaLocalizacao());
            
            pagina = "candidato.jsp";
        }

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

    public List<Partido> listarPartidos() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partidos = dao.listar();
        dao.fecharConexao();
        return partidos;

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

    private List<Candidato> listaCandidatos() {
        CandidatoDAO dao = new CandidatoDAO();
        List<Candidato> candidatos = dao.listar();
        dao.fecharConexao();
        return candidatos;
    }

    private Candidato buscaPorPK(Long id) {
        CandidatoDAO dao = new CandidatoDAO();
        Candidato candidato = dao.buscarPorChavePrimaria(id);
        dao.fecharConexao();
        return candidato;

    }
}
