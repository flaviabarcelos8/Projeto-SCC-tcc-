<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">Cadastro</h5>
              </div>
              <div class="card-body">
                <form action="PropostaWS" method="POST">
                  <div class="row">
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Candidato</label>
                        <select class="form-control" name="txtNome">
                            <c:forEach items="${candidato}" var="obj">
                                <option value="${obj.id}">${obj.nome}</option>
                            </c:forEach>
                        </select> 
                      </div>
                    </div>
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Topico</label>
                        <select class="form-control" name="txtTopico">
                            <c:forEach items="${topico}" var="obj">
                                <option value="${obj.id}">${obj.topico}</option>
                            </c:forEach>
                        </select> 
                      </div>
                    </div>
                        <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Solução</label>
                        <input type="text" name="txtSolucao" required class="form-control" placeholder="Solucao" value="${obj.solucao}" >
                      </div>
                    </div>
                       <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Fonte</label>
                        <input type="text" name="txtFonte" required class="form-control" placeholder="Fonte" value="${obj.fonte}" >
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Salvar</button>
                      <a class="btn btn-primary btn-round text-center" href="PropostaWS?acao=list">
                <i class="tim-icons icon-bullet-list-67"></i> Listar
            </a>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
<%@include file="../rodape.jsp" %>
