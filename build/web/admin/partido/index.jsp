<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
    <form action="PartidoWS" method="get" class="form-horizontal">
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
                <h4 class="card-title">Partido</h4>
              </div>
              <div class="card-body">
                  <a class="btn btn-primary btn-round text-center" href="add.jsp">
                        <i class="tim-icons icon-simple-add"></i> Cadastro
                    </a>
                <div class="table-responsive">
                       <table class="table tablesorter " id="">
                    <thead class=" text-primary">
                      <th>
                        Id
                      </th>
                      <th>
                        Nome
                      </th>
                      <th>
                        N° do Partido
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
                        <c:forEach items="${lista}" var="objp">
                      <tr>
                        <td>${objp.id}</td>
                        <td>${objp.partido}</td>
                        <td>${objp.numpartido}</td>
                        <td><img src="../../arquivos/${objp.fotopartido}" height="42" width="42"></td>
                        <td>
                          <a class="btn btn-primary" href="PartidoWS?acao=edit&id=${objp.id}" role="button">Editar
                                        
                             </a>
                        </td>
                        <td><a class="btn btn-primary" href="PartidoWS?acao=del&id=${objp.id}" role="button">Excluir
                                       
                             </a>
                        </td>
                      </tr>
                      </c:forEach>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

<%@include file="../rodape.jsp" %>