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
                <form action="LocalizacaoWS" method="POST">
                  <div class="row">
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Cidade/Estado</label>
                        <input type="text" name="txtLocalizacao" required class="form-control" placeholder="Localizacao" >
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="update ml-auto mr-auto">
                      <button type="submit" class="btn btn-primary btn-round">Salvar</button>
                      <a class="btn btn-primary btn-round text-center" href="LocalizacaoWS?acao=list">
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