<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">Edição</h5>
              </div>
              <div class="card-body">
                <form action="CandidatoWS" method="POST">
                  <div class="row">
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Id</label>
                        <input type="text" name="txtId" required class="form-control" placeholder="Id" value="${obj.id}" readonly="true" >
                      </div>
                    </div>
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Nome</label>
                        <input type="text" name="txtNome" required class="form-control" placeholder="Nome" value="${obj.nome}" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>N° do Candidato</label>
                        <input type="number" name="txtNumero" required class="form-control" placeholder="numcandidato" value="${obj.numcandidato}" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Idade</label>
                        <input type="number" name="txtIdade" required class="form-control" placeholder="Idade" value="${obj.idade}" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Biografia</label>
                        <input type="text" name="txtBio" required class="form-control" placeholder="Biografia" value="${obj.biocandidato}" >
                      </div>
                    </div>
                      <div class="form-group-file">
                        <label for="file">Foto</label>
                        <input type="file" name="txtFoto" required class="form-control form-control-file">
                    </div>
                      <div class="form-group-file">
                        <label for="file">Proposta PDF</label>
                        <input type="file" name="txtPDF" required class="form-control form-control-file">
                    </div>
                       
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                      <label>Cargo</label>
                        <select class="form-control" name="txtCargo">
                             <c:forEach items="${cargo}" var="objCargo">
                                <option value="${objCargo.id}" ${obj.cargo.equals(objCargo)?'selected':''}> ${objCargo.cargo}</option>
                            </c:forEach>
                        </select> 
                  </div>
                      </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                      <label>Partido</label>
                        <select class="form-control" name="txtPartido">
                             <c:forEach items="${partido}" var="objPartido">
                                <option value="${objPartido.id}" ${obj.partido.equals(objPartido)?'selected':''}> ${objPartido.partido}</option>
                            </c:forEach>
                        </select> 
                  </div>
                      </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                      <label>Localização</label>
                        <select class="form-control" name="txtLocalizacao">
                             <c:forEach items="${localizacao}" var="objLocalizacao">
                                <option value="${objLocalizacao.id}" ${obj.localizacao.equals(objLocalizacao)?'selected':''}> ${objLocalizacao.localizacao}</option>
                            </c:forEach>
                        </select> 
                  </div>
                      </div>
                  
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Salvar</button>
                      <a class="btn btn-primary btn-round text-center" href="CandidatoWS?acao=list">
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