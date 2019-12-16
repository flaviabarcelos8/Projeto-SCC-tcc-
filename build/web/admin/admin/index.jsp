<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-12">
            <div class="card">
              <div class="card-header">
                <h4 class="card-title">Admin</h4>
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
                        Admin
                      </th>
                      <th>
                        Email
                      </th>
                      <th>
                        Senha
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
                        <td>${obj.admin}</td>
                        <td>${obj.email}</td>
                        <td>${obj.senha}</td>
                        <td>
                          <a class="btn btn-primary" href="AdminWS?acao=edit&id=${obj.id}" role="button">Editar
                                       
                             </a>
                        </td>
                        <td><a class="btn btn-primary" href="AdminWS?acao=del&id=${obj.id}" role="button">Excluir
                                       
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