<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h4 class="card-title">Candidato</h4>
              </div>
              <div class="card-body">
                  <a class="btn btn-primary btn-round text-center" href="CandidatoWS?acao=add">
                        <i class="tim-icons icon-simple-add"></i> Cadastro
                    </a>
                <div class="table-responsive">
                       <table class="table tablesorter " id="">
                    <thead class=" text-primary">
                      <th>
                        Id
                      </th>
                      <th>
                        Candidato
                      </th>
                      <th>
                        Idade
                      </th>
                      <th>
                        N° Candidato
                      </th>
                      <th>
                       Partido
                      </th>
                      <th>
                        Cargo
                      </th>
                      <th>
                        Localização
                      </th>
                      <th>
                        Foto
                      </th>
                      <th>
                        Edita
                      </th>
                      <th>
                        Deleta
                      </th>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="obj">
                      <tr>
                        <td>${obj.id}</td>
                        <td>${obj.nome}</td>
                        <td>${obj.idade}</td> 
                        <td>${obj.numcandidato}</td>
                        <td>${obj.partido.partido}</td>
                        <<td>${obj.cargo.cargo}</td>
                        <td>${obj.localizacao.localizacao}</td>
                        <td><img src="../../arquivos/${obj.fotocandidato}" height="42" width="42"></td>
                        <td>
                          <a class="btn btn-info btn-fab btn-icon btn-round" href="CandidatoWS?acao=edit&id=${obj.id}">
                                        <i class="nc-icon tim-icons icon-pencil"></i>
                             </a>
                        </td>
                        <td><a class="btn btn-info btn-fab btn-icon btn-round" href="CandidatoWS?acao=del&id=${obj.id}">
                                        <i class=" nc-icon tim-icons icon-remove"></i>
                             </a>
                        </td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
                <div class="card-footer">
        <c:if test = "${not empty msg}">
            <div class="alert alert-primary alert-dismissible fade show" role="alert">
                ${msg}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <i class="tim-icons icon-simple-remove"></i>
                </button>
            </div>
        </c:if>
    </div>
            </div>
          </div>
        </div>
      </div>

<%@include file="../rodape.jsp" %>