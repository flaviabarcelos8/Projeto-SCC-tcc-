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
                <form action="AdminWS" method="POST">
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
                        <input type="text" name="txtAdmin" required class="form-control" placeholder="Admin" value="${obj.admin}" >
                      </div>
                    </div>
                       <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Email</label>
                        <input type="text" name="txtEmail" required class="form-control" placeholder="Email" value="${obj.email}" >
                      </div>
                    </div>
                       <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Senha</label>
                        <input type="text" name="txtSenha" required class="form-control" placeholder="Senha" value="${obj.senha}" >
                      </div>
                    </div>
                      
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Salvar</button>
                      <a class="btn btn-primary btn-round text-center" href="AdminWS?acao=list">
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