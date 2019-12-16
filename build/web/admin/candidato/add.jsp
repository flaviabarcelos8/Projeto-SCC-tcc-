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
                <form action="UploadWS" method="POST" enctype="multipart/form-data">
            <input type="hidden" name="urldestino" value="CandidatoWS">
                  <div class="row">
                     <div class="col-md-5 pr-1">
                      <div class="form-group">
                          <label for="file">Foto</label>
                       <div class="custom-file">
                            
                            <input type="file" name="txtFoto" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                            <label class="custom-file-label" for="inputGroupFile01">Escolher foto</label>
                        </div>
                      </div>
                    </div>
                    <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Nome e Sobrenome:</label>
                        <input type="text" name="txtNome" required class="form-control" placeholder="" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Idade:</label>
                        <input type="number" name="txtIdade" required class="form-control" placeholder="" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>N° candidato:</label>
                        <input type="number" name="txtNum" required class="form-control" placeholder="" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Biografia:</label>
                        <textarea type="text" name="txtBio" required class="form-control" id="exampleFormControlTextarea1" rows="3" placeholder=""> </textarea>
                      </div>
                    </div>
                      
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                       <div class="form-group">
                       <label for="file">Planos PDF</label>
                       <div class="custom-file">
                            <input type="file" name="txtPDF" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                            <label class="custom-file-label" for="inputGroupFile01">Escolher arquivo</label>
                        </div>
                      </div>
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Cargo</label>
                        <select class="form-control" name="txtCargo">
                            <c:forEach items="${cargo}" var="obj">
                                <option value="${obj.id}">${obj.cargo}</option>
                            </c:forEach>
                        </select> 
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Partido</label>
                        <select class="form-control" name="txtPartido">
                            <c:forEach items="${partido}" var="obj">
                                <option value="${obj.id}">${obj.partido}</option>
                            </c:forEach>
                        </select> 
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Localizacao</label>
                        <select class="form-control" name="txtLocalizacao">
                            <c:forEach items="${localizacao}" var="obj">
                                <option value="${obj.id}">${obj.localizacao}</option>
                            </c:forEach>
                        </select> 
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Link do Twitter:</label>
                        <input type="text" name="txtTwitter" required class="form-control" placeholder="" >
                      </div>
                    </div>
                      <div class="col-md-5 pr-1">
                      <div class="form-group">
                        <label>Link do Facebook:</label>
                        <input type="text" name="txtFacebook" required class="form-control" placeholder="" >
                      </div>
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