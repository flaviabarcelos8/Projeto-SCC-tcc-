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
import dao.PropostaDAO;
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
import model.Candidato;
import model.Cargo;
import model.Localizacao;
import model.Partido;
import model.Proposta;

/**
 *
 * @author flavi
 */
@WebServlet(name = "CandidatoWS", urlPatterns = {"/admin/candidato/CandidatoWS", "/public/CandidatoWS"})
public class CandidatoWS extends HttpServlet {

    private Candidato obj;
    private String pagina;
    private String acao;
    List<Proposta> lista;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Candidato> lista = null;
        acao = request.getParameter("acao");
        String id;
        CandidatoDAO dao;
        switch (String.valueOf(acao)) {

            case "add":
                request.setAttribute("partido", this.listaPartido());
                request.setAttribute("cargo", this.listaCargo());
                request.setAttribute("localizacao", this.listaLocalizacao());

                pagina = "add.jsp";
                break;
            case "del":
                id = request.getParameter("id");
                dao = new CandidatoDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if (deucerto) {
                    request.setAttribute("lista", this.listaCandidatos());
                    request.setAttribute("msg", "Excluído com sucesso");
                } else {
                    request.setAttribute("msg", "Erro ao excluir");
                }
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new CandidatoDAO();
                Candidato obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);

                request.setAttribute("partido", this.listaPartido());
                request.setAttribute("localizacao", this.listaLocalizacao());
                request.setAttribute("cargo", this.listaCargo());
                pagina = "edita.jsp";
                break;
            case "candidato":
                dao = new CandidatoDAO();
                Candidato candidato = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("id")));
                request.setAttribute("obj", candidato);
                request.setAttribute("partido", this.listaPartido());
                request.setAttribute("cargo", this.listaCargo());
                request.setAttribute("localizacao", this.listaLocalizacao());
                request.setAttribute("cargos", this.listarCargos());
                request.setAttribute("partidos", this.listaPartidos());

                pagina = "candidato.jsp";
                break;

            case "listCandidatos":
                request.setAttribute("partido", this.listaPartido());
                request.setAttribute("cargo", this.listaCargo());
                request.setAttribute("localizacao", this.listaLocalizacao());

                try {
                    if (request.getParameter("cargo") != null) {
                        Cargo cargo;
                        CargoDAO cdao = new CargoDAO();
                        cargo = cdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("cargo")));
                        lista = cargo.getCandidatos();
                    } else if (request.getParameter("localizacao") != null) {
                        Localizacao localizacao;
                        LocalizacaoDAO ldao = new LocalizacaoDAO();
                        localizacao = ldao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("localizacao")));
                        lista = localizacao.getCandidatos();
                    } else if (request.getParameter("partido") != null) {
                        Partido partido;
                        PartidoDAO pdao = new PartidoDAO();
                        partido = pdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("partido")));
                        lista = partido.getCandidatos();
                    } else {
                        lista = this.listaCandidatos();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(CandidatoWS.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista", lista);
                pagina = "index.jsp";
                break;
            case "filter":
                pagina = "index.jsp";
                //pega a informação digitada pelo livro
                String filtro = request.getParameter("txtFiltro");
                List<Candidato> lista2 = this.listar(filtro);
                request.setAttribute("lista", lista2);
                break;
            default:
                dao = new CandidatoDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(CandidatoWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = this.listaCandidatos();
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
        CargoDAO cdao = new CargoDAO();
        PartidoDAO pdao = new PartidoDAO();
        LocalizacaoDAO ldao = new LocalizacaoDAO();
        CandidatoDAO dao;
        request.setCharacterEncoding("UTF-8");
        Long id_cargo = Long.parseLong(request.getParameter("txtCargo"));
        Long id_localizacao = Long.parseLong(request.getParameter("txtLocalizacao"));
        Long id_partido = Long.parseLong(request.getParameter("txtPartido"));

        String nome = request.getParameter("txtNome");
        int idade = Integer.parseInt(request.getParameter("txtIdade"));
        int numcandidato = Integer.parseInt(request.getParameter("txtNum"));
        String biocandidato = request.getParameter("txtBio");
        String fotocandidato = request.getParameter("txtFoto");
        String planospdf = request.getParameter("txtPDF");
        String twitter = request.getParameter("txtTwitter");
        String facebook = request.getParameter("txtFacebook");
        Cargo cargo;
        Partido partido;
        Localizacao localizacao;
        request.setCharacterEncoding("UTF-8");
        String msg;

        //verificar campos obrigatórios
        if (request.getParameter("txtNome") == null || request.getParameter("txtCargo") == null || request.getParameter("txtLocalizacao") == null) {
            msg = "Campos obrigatórios não informados";
        } else {
            dao = new CandidatoDAO();
            obj = new Candidato();
            cargo = cdao.buscarPorChavePrimaria(id_cargo);
            partido = pdao.buscarPorChavePrimaria(id_partido);
            localizacao = ldao.buscarPorChavePrimaria(id_localizacao);

            //preencho o objeto com o que vem do post
            Boolean deucerto;

            //se veio com a chave primaria então tem q alterar
            if (request.getParameter("txtId") != null) {
                obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                obj.setNome(nome);
                obj.setTwitter(twitter);
                obj.setFacebook(facebook);
                obj.setIdade(idade);
                obj.setNumcandidato(numcandidato);
                obj.setBiocandidato(biocandidato);
                obj.setFotocandidato(fotocandidato);
                obj.setPlanospdf(planospdf);
                obj.setCargo(cargo);
                obj.setLocalizacao(localizacao);
                obj.setPartido(partido);
                deucerto = dao.alterar(obj);
                pagina = "edita.jsp";
            } else {
                obj.setNome(nome);
                obj.setTwitter(twitter);
                obj.setFacebook(facebook);
                obj.setIdade(idade);
                obj.setNumcandidato(numcandidato);
                obj.setBiocandidato(biocandidato);
                obj.setFotocandidato(fotocandidato);
                obj.setPlanospdf(planospdf);
                obj.setCargo(cargo);
                obj.setLocalizacao(localizacao);
                obj.setPartido(partido);
                deucerto = dao.incluir(obj);
                pagina = "add.jsp";
            }
            if (deucerto) {
                msg = "Operação realizada com sucesso";
            } else {
                msg = "Erro ao realizar a operação";
            }
        }

        request.setAttribute("msg", msg);
        RequestDispatcher destino = request.getRequestDispatcher(pagina);
        destino.forward(request, response);
    }

    private List<Candidato> listaCandidatos() {
        CandidatoDAO dao = new CandidatoDAO();
        List<Candidato> candidatos = dao.listar();
        dao.fecharConexao();
        return candidatos;
    }

    private List<Partido> listaPartido() {
        PartidoDAO dao = new PartidoDAO();
        List<Partido> partidos = dao.listar();
        dao.fecharConexao();
        return partidos;
    }

    private List<Partido> listaPartidos() {
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

    public List<Candidato> listar(String filtro) {
        List<Candidato> lista;
        CandidatoDAO dao = new CandidatoDAO();
        lista = dao.listar(filtro);
        dao.fecharConexao();
        return lista;
    }

    private Candidato buscaPorPK(Long id) {
        CandidatoDAO dao = new CandidatoDAO();
        Candidato candidato = dao.buscarPorChavePrimaria(id);
        dao.fecharConexao();
        return candidato;

    }

}
