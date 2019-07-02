<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h4 class="card-title">Localizacao</h4>
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
                        Cidade/Estado
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
                        <td>${obj.localizacao}</td>
                        <td>
                          <a class="btn btn-info btn-fab btn-icon btn-round" href="LocalizacaoWS?acao=edit&id=${obj.id}">
                                        <i class="nc-icon tim-icons icon-pencil"></i>
                             </a>
                        </td>
                        <td><a class="btn btn-info btn-fab btn-icon btn-round" href="LocalizacaoWS?acao=del&id=${obj.id}">
                                        <i class=" nc-icon tim-icons icon-remove"></i>
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