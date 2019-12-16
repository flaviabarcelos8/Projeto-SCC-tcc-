/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CandidatoDAO;
import dao.PropostaDAO;
import dao.TopicoDAO;
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
import model.Proposta;
import model.Topico;

/**
 *
 * @author flavi
 */
@WebServlet(name = "Proposta", urlPatterns = {"/admin/proposta/PropostaWS"})
public class PropostaWS extends HttpServlet {
    
    private PropostaDAO dao;
    private Proposta obj;
    private String pagina;
    private String acao;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        acao = request.getParameter("acao");
        String id;
        PropostaDAO dao;
         List<Proposta> lista = null;
        switch(String.valueOf(acao)){
            case "add":
                request.setAttribute("topico", this.listaTopicos());
                request.setAttribute("candidato", this.listaCandidatos());
                pagina = "add.jsp";
                break;
            case "del":
                id = request.getParameter("id");
                dao = new PropostaDAO();
                pagina = "index.jsp";
                obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                Boolean deucerto = dao.excluir(obj);
                if(deucerto){   
                    request.setAttribute("lista", this.listaPropostas());
                 
                    
                    request.setAttribute("msg", "Excluído com sucesso");
                }
                else{
                    request.setAttribute("msg", "Erro ao excluir");
                }
                
                break;
            case "edit":
                id = request.getParameter("id");
                dao = new PropostaDAO();
                Proposta obj = dao.buscarPorChavePrimaria(Long.parseLong(id));
                request.setAttribute("obj", obj);
                
                request.setAttribute("candidato", this.listaCandidatos());
                request.setAttribute("topico", this.listaTopicos());
                
                pagina = "edita.jsp";
                break;
            case "listPropostas":
                request.setAttribute("topico", this.listaTopicos());
                 request.setAttribute("candidato", this.listaCandidatos());
                
                
                try {
                    if(request.getParameter("topico")!=null){
                        Topico topico;
                        TopicoDAO tdao = new TopicoDAO();
                        topico = tdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("topico")));
                        lista = topico.getPropostas();
                    }else if(request.getParameter("candidato")!=null){
                        Candidato candidato;
                        CandidatoDAO cdao = new CandidatoDAO();
                        candidato = cdao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("candidato")));
                        lista = candidato.getPropostas();
                    }
                    else{
                        lista = this.listaPropostas();
                    }
                } catch (Exception ex) {
                    Logger.getLogger(PropostaWS.class.getName()).log(Level.SEVERE, null, ex);
                }
                request.setAttribute("lista", lista);
                pagina = "index.jsp";
                break;
            default:
                dao = new PropostaDAO();
                if (request.getParameter("filtro") != null) {
                    try {
                        lista = dao.listar(request.getParameter("filtro"));
                    } catch (Exception ex) {
                        Logger.getLogger(PropostaWS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    lista = this.listaPropostas();
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
             TopicoDAO tdao = new TopicoDAO();
            CandidatoDAO cdao = new CandidatoDAO();
              request.setCharacterEncoding("UTF-8");
            PropostaDAO dao;
            Topico topico;
            Candidato nome;
            
            
            request.setCharacterEncoding("UTF-8");
            String solucao = request.getParameter("txtSolucao");
            String fonte = request.getParameter("txtFonte");
            Long id_topico = Long.parseLong(request.getParameter("txtTopico"));
            Long id_candidato = Long.parseLong(request.getParameter("txtNome"));
            
           
            //verificar campos obrigatórios
            if(request.getParameter("txtSolucao") == null || request.getParameter("txtFonte") == null || request.getParameter("txtTopico") == null){
                msg = "Campos obrigatórios não informados";
            }
            else{
                dao = new PropostaDAO();
                obj = new Proposta();
                topico = tdao.buscarPorChavePrimaria(id_topico);
                nome = cdao.buscarPorChavePrimaria(id_candidato);
                
                
                //preencho o objeto com o que vem do post
                
                Boolean deucerto;
                
                //se veio com a chave primaria então tem q alterar
                if(request.getParameter("txtId")!= null){
                   
                    obj = dao.buscarPorChavePrimaria(Long.parseLong(request.getParameter("txtId")));
                    obj.setSolucao(solucao);
                    obj.setFonte(fonte);
                    obj.setTopico(topico);
                    obj.setCandidato(nome);
                   
                    deucerto = dao.alterar(obj);
                    pagina="edita.jsp";
                }
                else{
                   
                    obj.setSolucao(solucao);
                    obj.setFonte(fonte);
                    obj.setTopico(topico);
                    obj.setCandidato(nome);
                    deucerto = dao.incluir(obj);
                    pagina="add.jsp";   
                }
                if(deucerto){
                    msg = "Operação realizada com sucesso";    
                }
                else{
                    msg = "Erro ao realizar a operação";
                }
            }
            
            request.setAttribute("msg", msg);
            RequestDispatcher destino = request.getRequestDispatcher(pagina);
            destino.forward(request, response);
    }
    
    
    
  private List<Topico> listaTopicos() {
        TopicoDAO dao = new TopicoDAO();
        List<Topico> topicos = dao.listar();
        dao.fecharConexao();
        return topicos;
    }
   private List<Proposta> listaPropostas() {
        PropostaDAO dao = new PropostaDAO();
        List<Proposta> propostas= dao.listar();
        dao.fecharConexao();
        return propostas;
    }
   
    private List<Candidato> listaCandidatos() {
        CandidatoDAO dao = new CandidatoDAO();
        List<Candidato> candidato = dao.listar();
        dao.fecharConexao();
        return candidato;
    }
   
   private Proposta buscaPorPK(Long id){
        PropostaDAO dao = new PropostaDAO();
        Proposta proposta = dao.buscarPorChavePrimaria(id);
         dao.fecharConexao();
         return proposta;
       
        
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
