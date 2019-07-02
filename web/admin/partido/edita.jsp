<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
        <div class="row">
          <div class="col-md-8">
            <div class="card card-user">
              <div class="card-header">
                <h5 class="card-title">Edita Partido</h5>
              </div>
              <div class="card-body">
                <form action="PartidoWS" method="POST">
                  <div class="row">
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Id</label>
                        <input type="text" name="txtId" required class="form-control" placeholder="Id" value="${obj.id}" readonly="true" >
                      </div>
                    </div>
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Nome do Partido</label>
                        <input type="text" name="txtPartido" required class="form-control" placeholder="Partido" value="${obj.partido}" >
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Salvar</button>
                      <a class="btn btn-primary btn-round text-center" href="PartidoWS?acao=list">
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