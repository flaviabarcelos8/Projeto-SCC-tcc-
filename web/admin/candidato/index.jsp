<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
    <form action="CandidatoWS" method="get" class="form-horizontal">
              <div class="input-group no-border">
                <input name="txtFiltro" type="text" class="form-control" placeholder="Pesquise...">
                 <input type="hidden" name="acao" value="filter"/>
                <div class="input-group-append">
                  <div class="input-group-text">
                    <i class="nc-icon nc-zoom-split"></i>
                  </div>
                </div>
              </div>
            </form>
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
                        N� Candidato
                      </th>
                      <th>
                       Partido
                      </th>
                      <th>
                        Cargo
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
                        <td>${obj.numcandidato}</td>
                        <td>${obj.partido.partido}</td>
                        <td>${obj.cargo.cargo}</td>
                        <td><img src="../../arquivos/${obj.fotocandidato}" height="42" width="42"></td>
                        <td>
                            
                          <a class="btn btn-primary" href="CandidatoWS?acao=edit&id=${obj.id}" role="button">Editar
                                       
                             </a>
                        </td>
                        <td><a class="btn btn-primary" href="CandidatoWS?acao=del&id=${obj.id}" role="button">Excluir
                                       
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