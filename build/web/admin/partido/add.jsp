<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../cabecalho.jsp" %>

<div class="content">
    <div class="row">
        <div class="col-md-8">
            <div class="card card-user">
                <div class="card-header">
                    <h5 class="card-title">Cadastro de Partido</h5>
                </div>
                <div class="card-body">
                    <form action="UploadWS" method="POST" enctype="multipart/form-data">
                        <input type="hidden" name="urldestino" value="PartidoWS">
                        
                        <div class="custom-file">
                            <input type="file" name="txtFotoPartido" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
                            <label class="custom-file-label" for="inputGroupFile01">Escolher foto</label>
                        </div>
                        
                        <div class="row">
                            <div class="col-md-5 pr-1">
                                <div class="form-group">
                                    <label>Nome do Partido</label>
                                    <input type="text" name="txtPartido" required class="form-control" placeholder="Partido" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 pr-1">
                                <div class="form-group">
                                    <label>Numero do Partido</label>
                                    <input type="number" name="txtNumPartido" required class="form-control" placeholder="" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 pr-1">
                                <div class="form-group">
                                    <label>Resumo do Partido</label>
                                    <textarea type="text" name="txtBio" required class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                                </div>

                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 pr-1">
                                <div class="form-group">
                                    <label>Movimentos e ideais</label>
                                    <input type="text" name="txtFavoravel" required class="form-control" placeholder="" >
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-5 pr-1">
                                <div class="form-group">
                                    <label>Link para informações adicionais:</label>
                                    <input type="text" name="txtInfoAdicional" required class="form-control" placeholder="" >
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